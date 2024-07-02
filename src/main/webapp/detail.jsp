<%@ page import="DBpractice2.MemberService" %>
<%@ page import="DBpractice2.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String userEmail = request.getParameter("userEmail");

    MemberService memberService = new MemberService();
    Member members = memberService.getMember(userEmail);%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        table {
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1> 회원 상세정보</h1>
<table>
    <thead>

    </thead>
    <tbody>
    <tr>
        <th>이름</th>
        <td><%=members.getName()%></td>
    </tr>
    <tr>
        <th>이메일</th>
        <td><%=members.getEmail()%></td>
    </tr>
    <tr>
        <th>핸드폰번호</th>
        <td><%=members.getMobile_no()%></td>
    </tr>
    <tr>
        <th>비밀번호</th>
        <td><%=members.getPassword()%></td>
    </tr>
    <tr>
        <th>마케팅동의</th>
        <td><%=members.getMarketing_yn()%></td>
    </tr>
    <tr>
        <th>등록일자</th>
        <td><%=members.getRegister_date()%></td>
    </tr>



    </tbody>

</table>



<br/>
<a href="list.jsp"> 리스트로 돌아가기 </a>

</body>
</html>