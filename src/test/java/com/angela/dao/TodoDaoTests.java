package com.angela.dao;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.angela.vo.TodoVo;

public class TodoDaoTests {
	private TodoDao todoDao;
	
	@BeforeEach
	public void ready() {
		todoDao = new TodoDao();
	}
	
	@Test
	public void testTime() throws Exception{
		System.out.println(todoDao.getTime());
	}
	
	@Test
	public void testInsert() throws Exception {
		TodoVo todoVo = TodoVo.builder()
				.title("sample Title...")
				.dueDate(LocalDate.of(2023, 7, 27))
				.build();
		todoDao.insert(todoVo);
		
	}
	

}
