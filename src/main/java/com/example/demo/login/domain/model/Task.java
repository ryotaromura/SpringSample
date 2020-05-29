package com.example.demo.login.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Task {

	private String taskId;// ユーザーID
	private String taskName;// パスワード
	private Date deadline;// 期限
	private String status;// タスクステータス
	private String person;// 担当者
}
