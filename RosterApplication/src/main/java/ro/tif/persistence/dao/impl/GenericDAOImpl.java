package ro.tif.persistence.dao.impl;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import ro.tif.persistence.dao.GenericDAO;


public abstract class GenericDAOImpl<E, K> implements GenericDAO<E, K> {
	private static final int ALL_RESULTS = -1;
	private static final String NO_SUITABLE_CONSTRUCTOR_FOR_CLASS = "No suitable constructor for class %s, with argSize %d";
	public static final String INVALID_QUERY_ARG_MSG_FMT = "Expecting query parameter name at argument index %d";
	public static final String INVALID_QUERY_PARAM_VAL_MSG = "Expecting a list of pairs {parameter value} but the list length is odd";

	@PersistenceContext
	protected EntityManager em;

	private Class<E> clazz;

	public GenericDAOImpl(Class<E> clazz) {
		this.clazz = clazz;
	}

	public GenericDAOImpl(EntityManager em, Class<E> clazz) {
		this.em = em;
		this.clazz = clazz;
	}

	public E getById(K id) {
		if (null == id)
			return null;
		return em.find(clazz, id);
	}

	public E merge(E entity) {
		return em.merge(entity);
	}

	public E persist(E entity) {
		em.persist(entity);		
		return entity;
	}

	public E refresh(E entity) {
		em.refresh(entity);
		return entity;
	}
	
	public void flush() {
		
		em.flush();
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	public E find(String namedQuery, Object... nameValueParams) {
		final TypedQuery<E> query = createTypedQuery(clazz, namedQuery, nameValueParams);
		return query.getSingleResult();
	}

	public <T> T find(Class<T> resultType, String namedQuery, Object... nameValueParams) {
		final TypedQuery<T> query = createTypedQuery(resultType, namedQuery, nameValueParams);
		return query.getSingleResult();
	}

	/**
	 * {@inheritDoc}
	 */
	public List<E> findAll(String namedQuery, Object... nameValueParams) {
		final TypedQuery<E> query = createTypedQuery(clazz, namedQuery, nameValueParams);
		return query.getResultList();
	}

	public <T> List<T> findAll(Class<T> resultType, String namedQuery, Object... nameValueParams) {
		final TypedQuery<T> query = createTypedQuery(resultType, namedQuery, nameValueParams);
		return query.getResultList();
	}

	public <T> List<T> findMax(Class<T> resultType, String namedQuery, int maxResults, Object... nameValueParams) {
		final TypedQuery<T> query = createTypedQuery(resultType, namedQuery, nameValueParams);
		query.setMaxResults(maxResults);
		return query.getResultList();
	}
	
	
	private <T> TypedQuery<T> createTypedQuery(Class<T> resultType, String namedQuery, Object... nameValueParams) {
		final TypedQuery<T> query = this.em.createNamedQuery(namedQuery, resultType);
		fillParameters(query, nameValueParams);

		return query;
	}

	private <T> TypedQuery<T> createTypedQueryFromString(Class<T> resultType, String queryString, Object... nameValueParams) {
		final TypedQuery<T> query = this.em.createQuery(queryString, resultType);
		fillParameters(query, nameValueParams);

		return query;
	}
	
	private <T> void fillParameters(final Query query,Object... nameValueParams) {
		if ((nameValueParams.length & 1) != 0)
			throw new IllegalArgumentException(INVALID_QUERY_PARAM_VAL_MSG);

		int paramIdx = 0;
		while (paramIdx < nameValueParams.length) {

			String paramName;
			try {
				paramName = (String) nameValueParams[paramIdx];
			} catch (ClassCastException classCastException) {
				throw new IllegalArgumentException(String.format(INVALID_QUERY_ARG_MSG_FMT, paramIdx), classCastException);
			}
			Object paramValue = nameValueParams[paramIdx + 1];
			query.setParameter(paramName, paramValue);
			
			paramIdx += 2;
		}
	}
	
	
	public <T> T executeReturningScalars(Class<T> resultType,String queryString, Object... nameValueParams) {
		final TypedQuery<T> query = createTypedQueryFromString(resultType, queryString, nameValueParams);
		return query.getSingleResult();
	}
	
	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	public <T> List<T> findAllWithQuery(Class<T> resultType,String queryString, Object... nameValueParams) {
		final TypedQuery<T> query = createTypedQueryFromString(resultType, queryString, nameValueParams);
		return query.getResultList();
	}
	
	public <T> T findWithQuery(Class<T> resultType, String queryString, Object... nameValueParams) {
		final TypedQuery<T> query = createTypedQueryFromString(resultType, queryString, nameValueParams);
		return query.getSingleResult();
	}
	/**
	 * {@inheritDoc}
	 */

    public <T> List<T> findIntervalWithQuery(Class<T> resultType,String queryString,int minResults,int maxResults,Object... nameValueParams) {
        final TypedQuery<T> query = createTypedQueryFromString(resultType, queryString, nameValueParams);
        query.setFirstResult(minResults);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }
	
	/**
	 * {@inheritDoc}
	 */
	public int execute(String commandString, Object... nameValueParams) {
		final Query command=this.em.createQuery(commandString);
		fillParameters(command, nameValueParams);
		return command.executeUpdate();
	}

}
