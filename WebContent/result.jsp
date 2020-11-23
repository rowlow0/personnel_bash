<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회결과</title>
<style>
td,table{border:1px solid;}
</style>
</head>
<body>
<h1>직원 정보 조회 결과</h1>
<hr>
<c:if test="${list eq null}"><p>결과가 없습니다.<p></c:if>
<table>
<tr><td>성명</td><td>사번</td><td>직급</td><td>직책</td><td>연락처</td><td>소속부서</td></tr>
<c:forEach var="l" items="${list }" >
<tr><td>${l.getName()}</td><td>${l.getId() }</td><td>${l.getDept() }</td><td>${l.getDuty() }</td>
<td>${l.getPhone() }</td><td>${l.getPosition()}</td></tr>
</c:forEach>
</table>
<input type="button" value="확인" onclick="location.href='index.jsp'"/>
</body>
</html>
