package com.alejandro.acedemy.academyproject;

import com.alejandro.acedemy.academyproject.controller.StudentController;
import com.alejandro.acedemy.academyproject.entity.Student;
import com.alejandro.acedemy.academyproject.service.StudentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

@SpringBootTest
@WebMvcTest(StudentController.class)
class AcademyRestApplicationTests {

	@MockBean
	private StudentService sc;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(sc).isNotNull();
	}

	/*@Test
	void testGet() throws Exception{

		Optional<Student> s = sc.getStudentById(1);
		when(sc.getStudentById(1)).thenReturn(s);
	
		//this.mockMvc.perform(get("/1")).andDo(print()).andExpect(status().isOk());
				//.andExpect(content().string(containsString("Hello, Mock")));
	}
*/


}
