package com.supermarket.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.monitoring.MonitoredObject;
import com.supermarket.model.SupermMarketModel;

public class Addusers {

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/supermarket"; // Database Credentials
	private final String USER = "root123";
	private final String PASS = "root123";
	int result1 = 0;

	public int adduser(SupermMarketModel mobj) {
		Connection conn = null;
		Statement stmt = null;
		String EmpID = mobj.getEmpno();
		String EmployeeName = mobj.getUsername();
		String DeptCode = mobj.getDeptid();
		String DateOfJoin = mobj.getDoj();
		String Password = mobj.getPwd();

		try {
			Class.forName(JDBC_DRIVER);// regestering the driver
			conn = DriverManager.getConnection(DB_URL, USER, PASS);// getting the connection
			stmt = conn.createStatement();
			String query = "INSERT INTO userdetails(EmpID,UserName,DeptID,DateOfJoining,Password)VALUES('" + EmpID
					+ "','" + EmployeeName + "','" + DeptCode + "','" + DateOfJoin + "','" + Password + "')";

			System.out.println(query);
			result1 = stmt.executeUpdate(query);
			System.out.println(result1);

		} catch (Exception E) {
			System.out.println(E.getMessage());
		}

		finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
		return 0;

	}

	public List<SupermMarketModel> fetchdata()

	{
		Connection conn = null;
		Statement stmt = null;
		int execute = 0;
		List<SupermMarketModel> ls = new ArrayList<SupermMarketModel>(); // Super Market is Model Class name
		// Registering the Driver
		try {
			// Registering the driver here
			Class.forName(JDBC_DRIVER);
			// getting the connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// creating the statement
			stmt = conn.createStatement();
			// writing the query by using the statement
			String query = "SELECT * FROM userdetails";
			ResultSet rs = stmt.executeQuery(query);
			SupermMarketModel fetchinguser = null;
			while (rs.next()) {
				fetchinguser = new SupermMarketModel();
				fetchinguser.setEmpno(rs.getString("EmpID"));
				fetchinguser.setUsername(rs.getString("UserName"));
				fetchinguser.setDeptid(rs.getString("DepID"));
				fetchinguser.setDoj(rs.getString("DateOfJoining"));
				fetchinguser.setPwd(rs.getString("Password"));
				ls.add(fetchinguser);
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return ls;
	}

}
