package com.angela.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	

}
