<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사 관리 시스템</title>
<style>
input {width:150px;height:100px;}
form{margin:0px;padding:0px;display:inline;}
</style>
</head>
<body>
<h1>인사관리시스템</h1>
<fieldset><legend>인사관리 메인메뉴</legend>
<form method="get" action="select.jsp">
<input type="submit" value="조회">
</form>
<input type="button" value="사원등록" onclick="location.href='insert.jsp'">
<input type="button" value="정보변경" onclick="location.href='update.jsp'">
<input type="button" value="퇴사처리" onclick="location.href='delete.jsp'">
<input type="button" value="종료" onclick="window.close()">
</fieldset>
</body>
</html>