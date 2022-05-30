<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!-- ■Java 클래스를 import하는 JSP 코드 -->	
<%@ page import="java.util.List"%>
<%@ page import="com.javaex.dao.PhoneDao"%>
<%@ page import="com.javaex.vo.PersonVo"%>
   
<%
	List<PersonVo> personList = (List<PersonVo>)request.getAttribute("pList");
	//List<PersonVo> personList = (object 받을 수 있게 형변환)request.getAttribute("pList");
	
	//PhoneDao phoneDao = new PhoneDao();
	//List<PersonVo> personList = phoneDao.getPersonList();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
	<!-- http://localhost:8088/phonebook2/list.jsp -->
	<h1>전화번호부</h1>
	<h2>리스트</h2>

	<p>입력한 정보 내역입니다.</p> 
	
	<%for(int i = 0; i<personList.size(); i++){ %>
		<table border="1">
			<tr>
				<td>이름(name)</td>
				<!-- <td>이효리</td> -->
				<td><%=personList.get(1).getName() %></td>
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td><%=personList.get(1).getHp() %></td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td><%=personList.get(1).getCompany() %></td>
			</tr>
		</table>
		<br>
	<%} %>
	
</body>
</html>