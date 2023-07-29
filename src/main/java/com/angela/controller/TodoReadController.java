package com.angela.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angela.dto.TodoDto;
import com.angela.service.TodoService;

import lombok.extern.log4j.Log4j2;

@WebServlet(name="todoReadController", urlPatterns= "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet{

	private TodoService todoService = TodoService.INSTACNE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Long tno = Long.parseLong(req.getParameter("tno"));
			TodoDto todoDto = todoService.get(tno);
			//데이터 담기
			req.getRequestDispatcher("/WEB/INF/todo/read.jsp").forward(req, resp);
			
		}catch(Exception e) {
			log.info(e.getMessage());
			throw new ServletException("read error");
		}
	}

	
}
