<%@ page import="DBpractice2.MemberService" %>
<%@ page import="DBpractice2.Member" %>
<%@ page import="java.util.List" %>
<%@ page import="DBpractice2.MemberService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% MemberService memberService = new MemberService();
    List<Member> members = memberService.memberList();%>

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
<h1>마케팅 수신동의 회원목록</h1>
<table>
    <thead>
    <tr>
        <th>이름</th>
        <th>이메일</th>
        <th>가입일자</th>
    </tr>
    </thead>
    <tbody>

    <%
        for (Member member : members) {
    %>

    <tr>
        <td><%=member.getName()%></td>
        <td>
            <a href = "detail.jsp?userEmail=<%=member.getEmail()%>">
               <%=member.getEmail()%>
            </a>
        </td>
        <td><%=member.getRegister_date()%></td>
    </tr>
    <%
        }
    %>
    </tbody>

</table>


<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>