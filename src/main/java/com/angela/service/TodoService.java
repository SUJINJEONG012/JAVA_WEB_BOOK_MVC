package com.angela.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.angela.dto.TodoDto;

public enum TodoService {

	INSTACNE;

	public void register(TodoDto todoDto) {
		System.out.println("DEBUG........." + todoDto);
	}

	public List<TodoDto> getList() {

		List<TodoDto> todoDtos = IntStream.range(0, 10).mapToObj(i ->{
		
		TodoDto dto = new TodoDto();
		dto.setTno((long)i);
		dto.setTitle("Todo.."+i);
		dto.setDueDate(LocalDate.now());
		return dto;
		}).collect(Collectors.toList());
		
		return todoDtos;
	}
}
