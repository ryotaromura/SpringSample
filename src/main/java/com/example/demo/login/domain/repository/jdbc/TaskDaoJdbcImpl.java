package com.example.demo.login.domain.repository.jdbc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Task;
import com.example.demo.login.domain.repository.TaskDao;

@Repository
public class TaskDaoJdbcImpl implements TaskDao {

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	PasswordEncoder passwordEncoder;

	// tasksテーブルの全データを取得
	@Override
	public List<Task>selectMany() throws DataAccessException {

		// 複数件のselect
		// M_USERテーブルのデータを全件取得
		List<Map<String,Object>>getList = jdbc.queryForList("SELECT*FROM tasks");

		// 結果返却用の変数
		List<Task>taskList = new ArrayList<>();

		// 取得したデータを結果返却用のListに格納していく
		for(Map<String,Object>map:getList) {

			// Userインスタンスの作成
			Task task = new Task();

			// Userインスタンスに取得したデータをセットする
			task.setTaskId((String)map.get("task_id"));// タスクID
			task.setTaskName((String)map.get("task_name"));// タスク名
			task.setDeadline((Date)map.get("deadline"));// 期限
			task.setStatus((String)map.get("status"));// タスクステータス
			task.setPerson((String)map.get("person"));// 担当者

			// 結果返却用のListに追加
			taskList.add(task);
		}

		return taskList;
	}
}