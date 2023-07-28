package com.angela.dao;

import java.time.LocalDate;
import java.util.List;
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
	
	//생성
	@Test
	public void testInsert() throws Exception {
		TodoVo todoVo = TodoVo.builder()
				.title("sample Title...")
				.dueDate(LocalDate.of(2023, 7, 27))
				.build();
		todoDao.insert(todoVo);
	}
//	
//	//목록
//	@Test
//	public void testList() throws Exception{	
//		List<TodoVo> list = todoDao.selectAll();
//		list.forEach(vo -> System.out.println(vo));
//	}
	
	//조회기능
//	@Test
//	public void testSelectOne() throws Exception{
//		Long tno = 1L;
//		TodoVo vo = todoDao.selectOne(tno);
//		System.out.println(vo);
//	}
//	
//	@Test
//	public void testUpdateOne() throws Exception{
//		TodoVo todoVo = TodoVo.builder()
//				.tno(1L)
//				.title("Sample title")
//				.dueDate(LocalDate.of(2023, 07, 28))
//				.build();
//				
//				todoDao.updateOne(todoVo);
//	}
		

}
