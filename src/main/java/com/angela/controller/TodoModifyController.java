package com.angela.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import lombok.extern.log4j.Log4j2;

@WebServlet(name="todoModifyController", value="/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet{

	@Override
	protected void doGet() {
		
	}
}
