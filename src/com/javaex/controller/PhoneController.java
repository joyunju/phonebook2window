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
		// 코드 작성
		// System.out.println("controller");
		
		//포스트 방식일때 한글깨짐 방지
	    request.setCharacterEncoding("UTF-8");
	    
	    //action파라미터 꺼내기
		String action = request.getParameter("action");
		System.out.println(action);

//		if(action.equals("writeForm")) {
//			action.equals("writeForm") --> null 이 될 수 있으니 아래와 같이 작성하기
//			System.out.println("등록폼");
//			
//		}

		if ("list".equals(action)) { // 리스트일 때
			// 데이터 가져오기
			PhoneDao phoneDao = new PhoneDao();
			List<PersonVo> phoneList = phoneDao.getPersonList();
			System.out.println(phoneList);

			// request에 데이터 추가
			// request.setAttribute(getServletName(), phoneList);
			request.setAttribute("pList", phoneList);

			// 데이터 + html --> jsp 시킨다.
			// 포워드는 request 안에 있는 메소드
			RequestDispatcher rd = request.getRequestDispatcher("./list.jsp");
			rd.forward(request, response);

		}

		if ("writeForm".equals(action)) { // 등록폼일 때
			// System.out.println("등록폼");

			// 포워드
			RequestDispatcher rd = request.getRequestDispatcher("./writeForm.jsp");
			rd.forward(request, response);

		}else if("write".equals(action)) {	//등록 일 때
			
			//확인용
			//System.out.println("등록");
			
			//파라미터에서 값 꺼내기(name, hp, company)
			String name = request.getParameter("name");
			String hp = request.getParameter("hp");
			String company = request.getParameter("company");
			
			// Vo 만들어서 값 초기화
			PersonVo personVo = new PersonVo(name, hp, company);
			System.out.println(personVo);
			
			
			// phoneDao.personInsert()를 통해 저장하기
			PhoneDao phoneDao = new PhoneDao();
			int count =  phoneDao.personInsert(personVo);
			System.out.println(count);
			
			// 리다이렉트 list
			response.sendRedirect("/phonebook2/pbc?action=list");
			
			
		}else if("delete".equals(action)) {	//삭제일 때
			
			//파라미터에서 id 값을 꺼낸다
			int id = Integer.parseInt(request.getParameter("id"));
			
			// phoneDao.personDelete()를 통해 삭제하기
			PhoneDao phoneDao = new PhoneDao();
			int count = phoneDao.personDelete(id);
			//System.out.println(count);
			
			// 리다이렉트 list
			response.sendRedirect("./pbc?action=list");
			
		}else {
			System.out.println("action 파라미터 없음");
		}

	}

	// doPost : post 방식으로 요청시 호출 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("여기는 post");
		
		doGet(request, response);
	}

}
