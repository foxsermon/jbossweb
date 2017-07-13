package sermon.db.generic.dao;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;
/**
 * Generic DAO
 * @author mserrano
 *
 * @param <T>
 */
public interface GenericDAO<T> {
	/**
	 * Returns one single object
	 * @param id
	 * @return
	 */
	T find(String table, String field, Object id, RowMapper<T> rowMapper);
	/**
	 * Returns all objects
	 * @return
	 */
	List<T> getAll(String table, RowMapper<T> rowMapper);
	/**
	 * Returns all objects by Id
	 * @param table
	 * @param field
	 * @param id
	 * @param rowMapper
	 * @return
	 */
	List<T> getByField(String table, String field, Object id, RowMapper<T> rowMapper); 
	/**
	 * Save Object
	 * @param object
	 * @return
	 */
	boolean save(T object) throws Exception;
	/**
	 * Imprime informacion acerca de la clase
	 * @return String
	 */
	String imprime();
	/**
	 * Check DB Connection
	 * @return boolean
	 */
	boolean checkDBConnection();
}
