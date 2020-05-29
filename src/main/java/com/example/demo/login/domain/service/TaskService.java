package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.domain.model.Task;
import com.example.demo.login.domain.repository.TaskDao;

// @Transactional
@Transactional
@Service
public class TaskService {

	@Autowired
	TaskDao dao;

	// 全件取得用メソッド
	public List<Task>selectMany() {
		// 全件取得
		return dao.selectMany();
	}
}