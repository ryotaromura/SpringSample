/*従業員テーブル*/
CREATE TABLE IF NOT EXISTS
employee(
	employee_id INT PRIMARY KEY,
	employee_name VARCHAR(50),
	age INT
);

/* ユーザーマスタ */
CREATE TABLE IF NOT EXISTS
m_user(
	user_id VARCHAR(50) PRIMARY KEY,
	password VARCHAR(100),
	user_name VARCHAR(50),
	birthday DATE,
	age INT,
	gender BOOLEAN,
	marriage BOOLEAN,
	role VARCHAR(50)
);

/* タスクリスト */
CREATE TABLE IF NOT EXISTS
tasks(
	task_id VARCHAR(50) PRIMARY KEY,
	task_name VARCHAR(50),
	deadline DATE,
	status VARCHAR(50),
	person VARCHAR(50)
);