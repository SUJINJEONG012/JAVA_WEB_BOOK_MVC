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
	};
	
	/* get()메서드는 특정한 번호의 TodoDto를 구현하는 기능이지만 예쩨에서는 
	 * 샘플용 TodoDto객체를 생성해서 반환해 주도록 구현 */
	
	public TodoDto get(Long tno) {
		TodoDto dto = new TodoDto();
		dto.setTno(tno);
		dto.setTitle("Sample Todo");
		dto.setDueDate(LocalDate.now());
		dto.setFinished(true);
		
		return dto;
	}
}
