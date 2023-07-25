package com.angela.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angela.dto.TodoDto;
import com.angela.service.TodoService;

@WebServlet(name="todoReadController", urlPatterns= "/todo/read")
public class TodoReadController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("/todo/read");
		
		// todo/read?tno=123
		Long tno = Long.parseLong(req.getParameter("tno"));
		
		TodoDto dto = TodoService.INSTACNE.get(tno);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req, resp);
		
		
	}
	
}
