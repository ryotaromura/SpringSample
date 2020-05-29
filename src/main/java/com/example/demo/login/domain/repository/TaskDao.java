package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.Task;

public interface TaskDao {

	// Tasksテーブルの全データを取得
	public List<Task>selectMany() throws DataAccessException;
}