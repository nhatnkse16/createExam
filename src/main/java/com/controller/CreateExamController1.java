package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CreateExamDAO;
import com.entity.BankQuestion;
import com.entity.Collection;

/**
 * Servlet implementation class CreateExamController1
 */
@WebServlet("/CreateExamController1")
public class CreateExamController1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CreateExamDAO dao = new CreateExamDAO();

		List<Collection> listC = dao.getCollection();
//		for (Collection c : listC) {
//			System.out.println(c);
//		}
		
		request.setAttribute("listC", listC);
		request.getRequestDispatcher("createExam1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String collection = request.getParameter("collection");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String time = request.getParameter("time");
		String qnum = request.getParameter("qnum");
		
		System.out.println(collection);
//		System.out.println(name);
//		System.out.println(pass);
//		System.out.println(time);
//		System.out.println(qnum);
		
		CreateExamDAO dao = new CreateExamDAO();
		
		int CollectionID = Integer.parseInt(collection);
		List<BankQuestion> listB = dao.getBankQuestion(CollectionID);
		for (BankQuestion o : listB) {
			System.out.println(o);
		}
		
		int maxAllowed = Integer.parseInt(qnum);
		
		
		
		request.setAttribute("maxAllowed", maxAllowed);
		request.setAttribute("listB", listB);
		request.getRequestDispatcher("createExam2.jsp").forward(request, response);
	}

}
