package com.register.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supermarket.businesslogic.BusinessLogic;
import com.supermarket.dao.Addusers;
import com.supermarket.model.SupermMarketModel;

/**
 * Servlet implementation class RegisterServlet
 */
// @WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("Details entered are successfully captured");
		String empno = request.getParameter("empid");
		String username = request.getParameter("empname");
		String deptid = request.getParameter("deptcode");
		String doj = request.getParameter("dateofjoining");
		String pwd = request.getParameter("userpassword");
		System.out.println(empno);
		System.out.println(username);
		System.out.println(deptid);
		System.out.println(doj);
		System.out.println(pwd);

		SupermMarketModel mobj = new SupermMarketModel();
		BusinessLogic lobj = new BusinessLogic();

		mobj.setEmpno(empno);
		mobj.setUsername(username);
		mobj.setDeptid(deptid);
		mobj.setDoj(doj);
		mobj.setPwd(pwd);
		
		boolean result = lobj.Logic(mobj);
		
		if (result == true) {
			System.out.println("Data addded Successfully");
			Addusers addobj=new Addusers();
			addobj.adduser(mobj);
			
		} else {
			System.out.println("Response Redirected to 'https:www.makemytrip.com.'");
			response.sendRedirect("https:www.makemytrip.com");
		}

	}

}
