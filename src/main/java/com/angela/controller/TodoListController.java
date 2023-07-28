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

import lombok.extern.log4j.Log4j2;

@WebServlet(name="todoController", urlPatterns="/todo/list")
@Log4j2
public class TodoListController extends HttpServlet{

	private TodoService todoService = TodoService.INSTACNE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("todo list....................");
		
		try {
            List<TodoDto> dtoList = todoService.listAll();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req,resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("list error");
        }
		
	}

}
