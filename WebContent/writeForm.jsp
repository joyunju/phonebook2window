<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- http://localhost:8088/phonebook2/writeForm.jsp -->
	<!-- http://localhost:8088/phonebook2/pbc?action=writeForm -->
	<h1>전화번호부</h1>
	<h2>등록폼</h2>
	
	<p>전화번호를 등록하면
	<br>
	아래 항목을 기입하고 "등록" 버튼을 클릭하세요.
	</p>
	<!-- 
	method="get" 방식은 주소창에 다 보이고
	method="post" 방식은 주소창에 안보이는데 사용할 때의 차이를 알아야한다
	-->
	<!-- <form action="./insert.jsp" method="post"> -->
	<form action="./insert.jsp" method="get">
		이름(name) : <input type="text" name="name" value="">
		<br>
		핸드폰(hp) : <input type="text" name="hp" value="">
		<br>
		회사(company) : <input type="text" name="company" value="">
		<br>
		<button type="submit">등록</button>
	</form>
</body>
</html>