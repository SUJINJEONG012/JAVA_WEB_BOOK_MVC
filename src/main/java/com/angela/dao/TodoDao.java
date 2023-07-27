package com.angela.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.angela.vo.TodoVo;

import lombok.Cleanup;

public class TodoDao {

	public String getTime() {

		String now = null;

		try (Connection connection = ConnectionUtil.INSTANCE.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("select now()");
				ResultSet resultSet = preparedStatement.executeQuery();) {
			resultSet.next();
			now = resultSet.getString(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	
	public void insert(TodoVo vo) throws Exception {
		String sql = "insert into tbl_todo (title, dueDate, finished) values (?,?,?)";
		
		@Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement preparedStatement = connection.prepareCall(sql);
		
		preparedStatement.setString(1, vo.getTitle());
		preparedStatement.setDate(2, Date.valueOf(vo.getDueDate()));
		preparedStatement.setBoolean(3, vo.isFinished());
		preparedStatement.executeUpdate();
		
	}
	
	
	public List<TodoVo> selectAll() throws Exception{
		String sql = "select * from tbl_todo";
		
		@Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup PreparedStatement preparedStatement = connection.prepareStatement(sql);
		@Cleanup ResultSet resultSet = preparedStatement.executeQuery();
		
		List<TodoVo> list = new ArrayList<>();
		while(resultSet.next()) {
			TodoVo vo = TodoVo.builder()
					.tno(resultSet.getLong("tno"))
					.title(resultSet.getString("title"))
					.dueDate(resultSet.getDate("dueDate").toLocalDate())
					.finished(resultSet.getBoolean("finished"))
					.build();
			
			list.add(vo);
		}
		return list;		  
	}
	
	
	
}