package com.angela.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angela.dto.TodoDto;
import com.angela.service.TodoService;

@WebServlet(name="todoController", urlPatterns="/todo/list")
public class TodoListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/todo/list");
		
		List<TodoDto> dtoList = TodoService.INSTACNE.getList();
		req.setAttribute("list", dtoList);
		req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
	}
}
