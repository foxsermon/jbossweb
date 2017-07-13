package sermon.db.generic.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import sermon.db.generic.dao.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	@Autowired
	private JdbcTemplate jdbc;
	
	@Override
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public T find(String table, String field, Object id, RowMapper<T> rowMapper) {
		System.out.println("GenericDAOImpl -> find(..) -> " + table + "." + field + " = " + id);
		List<T> users = jdbc.query("select * from " + table + " where " + field + " = " + id, rowMapper);
		if (users.isEmpty()) {
			System.out.println("Lista vacia para : " + table + " -> " + field + " = " + id);
			return null;
		}
		/*
		try {
			jdbc.getDataSource().getConnection().close();
		} catch (SQLException e) {
			System.out.println("Unable to close connection :");
			System.out.println(e.getMessage());
		}
		*/
		return users.get(0);
	}
	
	@Override
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public List<T> getAll(String table, RowMapper<T> rowMapper) {		
		System.out.println("GenericDAOImpl --> getAll(..) -> " + table);
		List<T> elementos = jdbc.query("select * from " + table, rowMapper);
		/*
		try {
			jdbc.getDataSource().getConnection().close();
		} catch (SQLException e) {
			System.out.println("Unable to close connection :");
			System.out.println(e.getMessage());
		}
		*/
		return elementos;
	}
	
	@Override
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public List<T> getByField(String table, String field, Object id, RowMapper<T> rowMapper) {
		System.out.println("GenericDAOImpl -> getByField(..) -> " + table + "." + field + " = " + id);
		List<T> elementos = jdbc.query("select * from " + table + " where " + field + " = " + id, rowMapper);
		/*
		try {
			jdbc.getDataSource().getConnection().close();
		} catch (SQLException e) {
			System.out.println("Unable to close connection :");
			System.out.println(e.getMessage());
		}
		*/
		return elementos;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor={Exception.class})
	public boolean save(T object) throws Exception {		
		boolean flag = false;
		flag = jdbc.update(object.toString()) > 0;
		if (object.toString().indexOf("marcos") > -1) {
			throw new Exception("Metiste \"marcos\" en la description, por lo tanto ERROR !! ");			
		}
		return flag;
	}
	
	@Override
	public String imprime() {		
		return null;
	}
	
	public boolean checkDBConnection() {
		try {
			return ! jdbc.getDataSource().getConnection().isClosed();
		} catch (SQLException e) {
			System.out.println("Error for checkDBConnection() -> " + e.getMessage());
		}
		return false;
	}
	
}
