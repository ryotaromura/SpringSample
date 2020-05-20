package com.example.demo.login.domain.repository.jdbc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository
public class UserDaoJdbcImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbc;

	// Userテーブルの件数を取得
	@Override
	public int count() throws DataAccessException {

		// Objectの取得
		// 全件取得してカウント
		int count = jdbc.queryForObject("SELECT COUNT(*) FROM m_user",Integer.class);
		return count;
	}

	// Userテーブルにデータを１件insert
	@Override
	public int insertOne(User user) throws DataAccessException {

		// insert
		// １件登録
		int rowNumber = jdbc.update("INSERT INTO m_user(user_id,"
		+ "password,"
		+ "user_name,"
		+ "birthday,"
		+ "age,"
		+ "marriage,"
		+ "role)"
		+ "VALUES(?,?,?,?,?,?,?)"
		,user.getUserId()
		,user.getPassword()
		,user.getUserName()
		,user.getBirthday()
		,user.getAge()
		,user.isMarriage()
		,user.getRole());

		return rowNumber;
	}

	// Userテーブルのデータを１件取得
	@Override
	public User selectOne(String userId) throws DataAccessException {


	// １件取得
	Map<String,Object>map = jdbc.queryForMap("SELECT*FROM m_user"
		+" WHERE user_id = ?"
		,userId);

	// 結果返却用の変数
	User user = new User();

	// 取得したデータを結果返却用の変数にセットする
	user.setUserId((String)map.get("user_id"));// ユーザーID
	user.setPassword((String)map.get("password"));// パスワード
	user.setUserName((String)map.get("user_name"));// ユーザー名
	user.setBirthday((Date)map.get("birthday"));// 誕生日
	user.setAge((Integer)map.get("age"));// 年齢
	user.setMarriage((Boolean)map.get("marriage"));// 結婚ステータス
	user.setRole((String)map.get("role"));// ロール

	return user;
}

	// Userテーブルの全データを取得
	@Override
	public List<User>selectMany() throws DataAccessException {

		// 複数件のselect
		// M_USERテーブルのデータを全件取得
		List<Map<String,Object>>getList = jdbc.queryForList("SELECT*FROM m_user");

		// 結果返却用の変数
		List<User>userList = new ArrayList<>();

		// 取得したデータを結果返却用のListに格納していく
		for(Map<String,Object>map:getList) {

			// Userインスタンスの作成
			User user = new User();

			// Userインスタンスに取得したデータをセットする
			user.setUserId((String)map.get("user_id"));// ユーザーID
			user.setPassword((String)map.get("password"));// パスワード
			user.setUserName((String)map.get("user_name"));// ユーザー名
			user.setBirthday((Date)map.get("birthday"));// 誕生日
			user.setAge((Integer)map.get("age"));// 年齢
			user.setMarriage((Boolean)map.get("marriage"));// 結婚ステータス
			user.setRole((String)map.get("role"));// ロール

			// 結果返却用のListに追加
			userList.add(user);
		}

		return userList;
	}

	// Userテーブルを１件更新
	@Override
	public int updateOne(User user) throws DataAccessException {
		return 0;
	}

	// Userテーブルを１件削除
	@Override
	public int deleteOne(String userId) throws DataAccessException {
		return 0;
	}

	// Userテーブルの全データをCSVに出力する
	@Override
	public void userCsvOut() throws DataAccessException {

	}
}