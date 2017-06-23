package com.ralph.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtil
{
	static String CLASS_NAME;
	static String DB_URL;
	static String DB_USER;
	static String DB_PWD;
	static
	{
		ResourceBundle rb = ResourceBundle.getBundle("com.ralph.util.db");
		CLASS_NAME = rb.getString("class_name");
		DB_URL = rb.getString("db_url");
		DB_USER = rb.getString("db_user");
		DB_PWD = rb.getString("db_pwd");
	}

	public static Connection getConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName(CLASS_NAME);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll(PreparedStatement ps, Connection conn)
	{
		closePreparedStatement(ps);
		closeConnection(conn);
	}

	public static void closeAll(PreparedStatement ps, ResultSet rs, Connection conn)
	{
		closePreparedStatement(ps);
		closeResultSet(rs);
		closeConnection(conn);
	}

	public static void closePreparedStatement(PreparedStatement ps)
	{

		try
		{
			if (ps != null)
				ps.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void closeConnection(Connection conn)
	{
		try
		{
			if (conn != null)
				conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet rs)
	{
		try
		{
			if (rs != null)
				rs.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
