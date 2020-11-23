<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리조회화면</title>
</head>
<body>
<h1>인사관리조회화면</h1>
<fieldset><legend>인사관리 조회</legend>
<form method="get" action="SelectAction">
<label>
<input type="radio" value="id" name="check"> 사원 번호로 조회 <input type="text" name="id">
</label>
<input type="radio" value="dept" name="check"> 부서명으로 조회
<select name="dept">
<option value="인사부">인사부</option>
<option value="기획부">기획부</option>
<option value="홍보부">홍보부</option>
<option value="영업부">영업부</option>
<option value="경리부">경리부</option>
</select>
<input value="조회" type="submit"/><input value="취소" type="button" onclick="location.href='index.jsp'"/>
</form>
</fieldset>
</body>
</html>