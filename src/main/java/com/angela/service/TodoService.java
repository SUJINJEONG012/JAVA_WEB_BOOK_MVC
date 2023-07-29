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
	
	public List<TodoDto> listAll()throws Exception {

        List<TodoVo> voList = dao.selectAll();

        log.info("voList.................");
        log.info(voList);

        List<TodoDto> dtoList = voList.stream()
                .map(vo -> modelMapper.map(vo,TodoDto.class))
                .collect(Collectors.toList());

        return dtoList;
    }
	
	
	public TodoDto get(Long tno) throws Exception{
		log.info("tno :" + tno);
		TodoVo todoVo = dao.selectOne(tno);
		TodoDto todoDto = modelMapper.map(todoVo, TodoDto.class);
		return todoDto;
	}
	
	public void remove(Long tno) throws Exception {
		log.info("tno: "+ tno);
		dao.deleteedOne(tno);
	}
	
	public void modify(TodoDto todoDto) throws Exception {
		log.info("todoDto : " + todoDto);
		TodoVo todoVo = modelMapper.map(todoDto, TodoVo.class);
		dao.updateOne(todoVo);
	}
	

	
	
	
}
