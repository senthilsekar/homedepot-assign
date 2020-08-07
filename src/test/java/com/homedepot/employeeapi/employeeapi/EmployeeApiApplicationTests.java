package com.homedepot.employeeapi.employeeapi;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.homedepot.employeeapi.employeeapi.components.Employee;
import com.homedepot.employeeapi.employeeapi.components.EmployeeController;
import com.homedepot.employeeapi.employeeapi.components.EmployeeService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeApiApplicationTests {
	
	@Autowired
	EmployeeController employeeController;
	
	@Autowired
	MockMvc mockMVC;
	
	@MockBean
	EmployeeService employeeService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetEmployees() throws Exception {
		Employee[] empArray = new Employee[1];
		empArray[0]=new Employee("EMP-1", 55, 560000, "Dept-1");
		
		Mockito.when(employeeService.getEmployees()).thenReturn(empArray);
		
		mockMVC.perform(get("http://localhost:8080/Employees")).andExpect(status().isOk());
	}
}
