package com.vaish.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


@Component
public class JDBCHelper {
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<TestDao> getAllEmployeesRowMapper(){
		 return jdbcTemplate.query("select * from employee", new RowMapper<TestDao>(){  
		    @Override  
		    public TestDao mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	TestDao e=new TestDao();  
		        e.setId(rs.getInt(1));  
		        e.setName(rs.getString(2));  
		        return e;  
		    }  
		    });  
}
}
