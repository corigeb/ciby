package ro.tif.persistence.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;

public interface GenericDAO<E, K> {

	E getById(K id);

	public E merge(E entity);

	public E persist(E entity);

	public E refresh(E entity);

	/**
	 * Force an {@link EntityManager#flush()}
	 * 
	 * Check EntityManager#flush for thrown Exceptions.
	 * 
	 */
	void flush();

	/**
	 * This method executes a named query that is expected to return a single
	 * result of type E.
	 * 
	 * @param namedQuery
	 *            The name of the {@link NamedQuery}
	 * @param nameValueParams
	 *            A list of name-value pairs(i.e.: parameter name and parameter
	 *            value) to be provided to the named query.
	 * @return
	 */
	E find(String namedQuery, Object... nameValueParams);

	/**
	 * This method executes a named query that is expected to return a single
	 * result of provided type T.
	 * 
	 * @param namedQuery
	 *            The name of the {@link NamedQuery}
	 * @param nameValueParams
	 *            A list of name-value pairs(i.e.: parameter name and parameter
	 *            value) to be provided to the named query.
	 * @return
	 */
	<T> T find(Class<T> resultType, String namedQuery,
			Object... nameValueParams);

	/**
	 * This method executes a named query that is expected to return a list of
	 * type E.
	 * 
	 * @param namedQuery
	 *            The name of the {@link NamedQuery}
	 * @param nameValueParams
	 *            A list of name-value pairs(i.e.: parameter name and parameter
	 *            value) to be provided to the named query.
	 * @return
	 */
	List<E> findAll(String namedQuery, Object... nameValueParams);

	/**
	 * This method executes a named query that is expected to return a list of
	 * provided type T.
	 * 
	 * @param namedQuery
	 *            The name of the {@link NamedQuery}
	 * @param nameValueParams
	 *            A list of name-value pairs(i.e.: parameter name and parameter
	 *            value) to be provided to the named query.
	 * @return
	 */
	<T> List<T> findAll(Class<T> resultType, String namedQuery,
			Object... nameValueParams);

	/**
	 * This method executes a named query that is expected to return a list of
	 * provided type T. At most maxResults number of records will be returned
	 * back.
	 * 
	 * @param namedQuery
	 *            The name of the {@link NamedQuery}
	 * @param nameValueParams
	 *            A list of name-value pairs(i.e.: parameter name and parameter
	 *            value) to be provided to the named query.
	 * @param maxResults
	 *            The max number records to be returned back.
	 * 
	 * @return
	 */
	<T> List<T> findMax(Class<T> resultType, String namedQuery, int maxResults,
			Object... nameValueParams);

	/**
	 * This method will executed the provided query and is expecting that the
	 * query will return scalar types. (e.g.: SELECT SUM(c.value),AVG(c.value)
	 * FROM Entity c WHERE....)
	 * 
	 * @param query
	 *            The JPA query string to be executed
	 * @param nameValueParams
	 *            A list of name-value pairs(i.e.: parameter name and parameter
	 *            value) to be provided to the query.
	 * 
	 * @return An object array with all the scalar values or Null, if no records
	 *         existed.
	 */
	<T> T executeReturningScalars(Class<T> resultType, String queryString,
			Object... nameValueParams);

	/**
	 * Same semantic as {@code #find(Class, String, Object...)}, but a JPA query
	 * is provided, instead of a {@link NamedQuery}
	 * 
	 * 
	 * @param resultType
	 * @param queryString
	 * @param nameValueParams
	 * @return
	 * 
	 * @throws NoResultException
	 * @throws NonUniqueResultException
	 */
	<T> T findWithQuery(Class<T> resultType, String queryString,
			Object... nameValueParams);

	/**
	 * Same semantic as {@code #findAll(Class, String, Object...)}, but a JPA
	 * query is provided, instead of a {@link NamedQuery}
	 * 
	 * 
	 * @param resultType
	 * @param queryString
	 * @param nameValueParams
	 * @return
	 */
	<T> List<T> findAllWithQuery(Class<T> resultType, String queryString,
			Object... nameValueParams);

	/**
	 * Retrieve a list of T objects, within the specified limits.
	 *
	 *
	 * @param resultType
	 * @param queryString
	 * @param minResults
	 * @param maxResults
	 * @param nameValueParams
	 * @return
	 */
	<T> List<T> findIntervalWithQuery(Class<T> resultType, String queryString,
			int minResults, int maxResults, Object... nameValueParams);

	/**
	 * This method executes the provided command and returns the number of
	 * affected records.
	 * 
	 * @param commandString
	 *            a JPA command(e.g.: UPDATE, DELETE, etc...)
	 * @param nameValueParams
	 * @return
	 */
	int execute(String commandString, Object... nameValueParams);

}
