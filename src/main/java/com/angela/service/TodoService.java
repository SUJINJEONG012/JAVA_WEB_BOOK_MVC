package com.angela.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.angela.dao.TodoDao;
import com.angela.dto.TodoDto;
import com.angela.util.MapperUtil;
import com.angela.vo.TodoVo;

import lombok.extern.log4j.Log4j2;

@Log4j2
public enum TodoService {
	INSTACNE;

	
	private TodoDao dao;
	private ModelMapper modelMapper;
	
	TodoService(){
		dao = new TodoDao();
		modelMapper= MapperUtil.INSTANCE.get();
	}
	
	/*
	 * register는 TodoDto를 파라미터로 받아서 TodoVo로 변환하는 과정이 필요
	 * 
	 * */
	public void register(TodoDto todoDto) throws Exception{
		TodoVo todoVo = modelMapper.map(todoDto, TodoVo.class);
		//System.out.println("todoVo : " + todoVo);
		log.info(todoVo);
		
		dao.insert(todoVo);
	}
	

	
	
	
}
