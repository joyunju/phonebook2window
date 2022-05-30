package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

//@WebServlet("/PhoneController")
@WebServlet("/pbc")
// http://localhost:8088/phonebook2/pbc
public class PhoneController extends HttpServlet {

	// 필드
	private static final long serialVersionUID = 1L;
	
	// 생성자 (기본 생성자 사용)
//	public PhoneController() {
//		super();
//
//	}

	// 메소드 - gs

	// 메소드 - 일반
	// doGet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//코드 작성
		//System.out.println("controller");
		
		String action = request.getParameter("action");
		System.out.println(action);
		
//		if(action.equals("writeForm")) {
//			action.equals("writeForm") --> null 이 될 수 있으니 아래와 같이 작성하기
//			System.out.println("등록폼");
//			
//		}
		
		if("writeForm".equals(action)) {	//등록폼
			//System.out.println("등록폼");
			
			//포워드
			RequestDispatcher rd = request.getRequestDispatcher("./writeForm.jsp");
			rd.forward(request, response);
			
			
		}
		
		// 데이터 가져오기
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> phoneList = phoneDao.getPersonList();
		System.out.println(phoneList);
		
		// request에 데이터 추가
		//request.setAttribute(getServletName(), phoneList);
		request.setAttribute("pList", phoneList);
		
		// 데이터  + html --> jsp 시킨다. 
		// 포워드는 request 안에 있는 메소드
		RequestDispatcher rd = request.getRequestDispatcher("./list.jsp");
		rd.forward(request, response);
		
	}

	
	//doPost
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
