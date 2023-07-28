package com.angela.service;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.angela.dto.TodoDto;

public class TodoServiceTests {
	
	private TodoService todoService;
	
	@BeforeEach
	public void ready() {
		todoService= TodoService.INSTACNE;
	}
	
	@Test
	public void testRegister() throws Exception{
		TodoDto todoDto = TodoDto.builder()
		.title("JDBC Test Title")
		.dueDate(LocalDate.now())
		.build();
		todoService.register(todoDto);
	}

}
