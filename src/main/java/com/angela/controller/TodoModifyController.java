package com.angela.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angela.dto.TodoDto;
import com.angela.service.TodoService;

import lombok.extern.log4j.Log4j2;

@WebServlet(name="todoModifyController", value="/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet{

	private TodoService todoService = TodoService.INSTACNE;
	private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long tno = Long.parseLong(req.getParameter("tno"));
			TodoDto todoDto = todoService.get(tno);
			//데이터 담기
			req.setAttribute("dto", todoDto);
			req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
		}catch(Exception e) {
			log.error(e.getMessage());
			throw new ServletException("Modify get.........error");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String finishedStr = req.getParameter("finished");
		
		TodoDto todoDto = TodoDto.builder()
				.tno(Long.parseLong(req.getParameter("tno")))
				.title(req.getParameter("title"))
				.dueDate(LocalDate.parse(req.getParameter("dueDate"),DATEFORMATTER))
				.finished(finishedStr != null && finishedStr.equals("on"))
				.build();
		
		log.info("/todo/modify Post......");
		log.info(todoDto);
		try {
			todoService.modify(todoDto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("/todo/list");
	}
	
}
