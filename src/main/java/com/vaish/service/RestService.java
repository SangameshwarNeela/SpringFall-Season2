package com.vaish.service;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.vaish.service.dao.JDBCHelper;

@Component
@Path(value = "service")
public class RestService {
	
	@Autowired
	ApplicationContext applicationContext;
	
	@Autowired
	JDBCHelper jdbcHelper;
	
	@GET
	@Produces("Appliaction/json")
	@Path(value = "method")
	public String firstMethod() throws JsonGenerationException, JsonMappingException, IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		jdbcHelper =  (JDBCHelper) applicationContext.getBean("JDBCHelper");
		
		return mapper.writeValueAsString(jdbcHelper.getAllEmployeesRowMapper());
	}
	
}
