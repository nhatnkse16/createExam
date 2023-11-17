package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbConnect.DBContext;
import com.entity.BankQuestion;
import com.entity.Collection;
import com.entity.CollectionConnect;

public class CreateExamDAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Collection> getCollection() {
		List<Collection> list = new ArrayList<>();
		String query = "Select * from Collection";
		try {
			conn = new DBContext().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Collection(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<BankQuestion> getBankQuestion(int CollectionID) {
		List<BankQuestion> list = new ArrayList<>();
		String query = "Select * from BankQuestion where CollectionID = ?";
		try {
			conn = new DBContext().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, CollectionID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BankQuestion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<CollectionConnect> insertCollectionConnect(int cId, int qId) {
		List<CollectionConnect> list = new ArrayList<>();
		String query = "Insert Into CollectionConnect(CollectionID,BankQuestionID) Values (?,?);";
		try {
			conn = new DBContext().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setInt(1, cId);
			ps.setInt(2, qId);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new CollectionConnect(rs.getInt(1), rs.getInt(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public List<Collection> insertCollection(String name, int examNumber, int accountID) {
		List<Collection> list = new ArrayList<>();
		String query = "Insert into Collection([Name],ExamNumber,AccountID) Values (?,?,?);";
		try {
			conn = new DBContext().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, examNumber);
			ps.setInt(3, accountID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Collection(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Collection> createExam(String name, int examNumber, int accountID) {
		List<Collection> list = new ArrayList<>();
		String query = "Insert into [Exam]([Name],[Password],[TimeLimit],[Date],[QuestionNumber],[AccountID],[CollectionID]) values (?,?, ?, ?, ?, ?, ?)";
		try {
			conn = new DBContext().getConnect();// mo ket noi voi sql
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, examNumber);
			ps.setInt(3, accountID);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Collection(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
//	public List<BankQuestion> getExam(int CollectionID, int AccountID) {
//		List<BankQuestion> list = new ArrayList<>();
//		String query = "Select * from BankQuestion where CollectionID = ? AND AccountID = ?";
//		try {
//			conn = new DBContext().getConnect();// mo ket noi voi sql
//			ps = conn.prepareStatement(query);
//			ps.setInt(1, CollectionID);
//			ps.setInt(2, AccountID);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				list.add(new BankQuestion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getInt(10)));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

	public static void main(String[] args) {
		CreateExamDAO dao = new CreateExamDAO();

		List<Collection> listC = dao.getCollection();
		for (Collection c : listC) {
			System.out.println(c);
		}
		
		int CollectionID = 2;
		List<BankQuestion> list = dao.getBankQuestion(CollectionID);
		for (BankQuestion o : list) {
			System.out.println(o);
		}

	
	}
}
