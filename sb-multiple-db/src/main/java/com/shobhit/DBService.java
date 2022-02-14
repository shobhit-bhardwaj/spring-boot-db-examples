package com.shobhit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DBService {

	@Autowired
	@Qualifier("datasource1")
	private DataSource dataSource1;

	@Autowired
	@Qualifier("datasource2")
	private DataSource dataSource2;

	public String resultDB1() {
		String result = "";

		try {
			Connection connection = dataSource1.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select user_id id, user_name name from user_tbl limit 10;");
			while(resultSet.next()) {
				String line = resultSet.getString("id") + " - " + resultSet.getString("name");
				result += line + "\n";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public String resultDB2() {
		String result = "";

		try {
			Connection connection = dataSource2.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select admin_id id, admin_name name from admin_tbl limit 10;");
			while(resultSet.next()) {
				String line = resultSet.getString("id") + " - " + resultSet.getString("name");
				result += line + "\n";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}
}