package com.rays.junit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccoutService {

	public static long add(AccountDto dto) throws Exception, CommanException {
		long pk = dto.getId();
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibearnate", "root", "root");
			conn.setAutoCommit(false);
			PreparedStatement psmt = conn.prepareStatement("INSERT INTO acCountdto values(?,?,?)");

			psmt.setLong(1, dto.getId());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getBalance());

			psmt.executeUpdate();

			conn.commit();

		} catch (Exception e) {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new CommanException("Exception come for rollback:" + e1.getMessage());
			}

			throw new CommanException("exception in add method" + e.getMessage());

		} finally {
			conn.close();
		}

		return pk;

	}

	public static void update(AccountDto dto) throws Exception, CommanException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibearnate", "root", "root");
			conn.setAutoCommit(false);
			PreparedStatement psmt = conn.prepareStatement("UPDATE acCountdto SET NAME=?,BALANCE=? WHERE ID=? ");

			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getBalance());
			psmt.setLong(3, dto.getId());

			psmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {

			try {
				conn.rollback();
			} catch (Exception e1) {
				throw new CommanException("Exception get in update method rollback:" + e1.getMessage());
			}

			throw new CommanException("Exception get in update method :" + e.getMessage());

		} finally {
			conn.close();
		}

	}

	public static void delete(AccountDto dto) throws Exception, CommanException {

		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibearnate", "root", "root");
			conn.setAutoCommit(false);
			PreparedStatement psmt = conn.prepareStatement("DELETE FROM acCountdto WHERE Id=?");
			psmt.setLong(1, dto.getId());

			psmt.executeUpdate();
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				throw new CommanException("Exception get in delete method rollback:" + e1.getMessage());
			}

			throw new CommanException("Exception get in delete method :" + e.getMessage());
		} finally {
			
		}

	}

	public static AccountDto findByPk(long id) throws Exception, CommanException {
		Connection conn = null;
		AccountDto dto = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibearnate", "root", "root");

			PreparedStatement psmt = conn.prepareStatement("SELECT * FROM acCountdto WHERE ID=?");
			psmt.setLong(1, id);

			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				dto=new AccountDto();
				
				
				dto.setId(rs.getLong(1));
				dto.setName(rs.getString(2));
				dto.setBalance(rs.getString(3));
				

			}
		} catch (Exception e) {
			throw new CommanException("Exception get in findByPk method :" + e.getMessage());
		}

		return dto;

	}

}
