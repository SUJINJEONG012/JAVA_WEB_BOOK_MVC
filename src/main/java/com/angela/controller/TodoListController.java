package com.angela.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.angela.service.TodoService;

import lombok.extern.log4j.Log4j2;

@WebServlet(name="todoController", urlPatterns="/todo/list")
@Log4j2
public class TodoListController extends HttpServlet{

	private TodoService todoService = TodoService.INSTACNE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws Exception, IOException {
		log.info("todo list....................");
	}

}
