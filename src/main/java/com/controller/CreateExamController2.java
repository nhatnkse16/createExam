package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateExamController2
 */
@WebServlet("/CreateExamController2")
public class CreateExamController2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Trong controller của bạn
        String[] selectedIds = request.getParameterValues("selectedIds");

        if (selectedIds != null && selectedIds.length > 0) {
            for (String id : selectedIds) {
            	System.out.println("*************************");
                System.out.println("Selected ID: " + id);
            }
        }
        response.sendRedirect("index.jsp");
}
}