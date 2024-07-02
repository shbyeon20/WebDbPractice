<%@ page import="DBpractice2.DbService" %>
<%@ page import="DBpractice2.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% DbService dbService = new DbService();
    List<Member> members = dbService.memberList();%>

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
<h1> 회원 목록</h1>
<table>
    <thead>
    <tr>
        <th>이름</th>
        <th>이메일</th>
        <th>비밀번호</th>
    </tr>
    </thead>
    <tbody>

    <%
        for (Member member : members) {
    %>

    <tr>
        <td><%=member.getName()%></td>
        <td>
            <a href = "detail.jsp?userID=<%=member.getEmail()%>">
               <%=member.getEmail()%>
            </a>
        </td>
        <td><%=member.getPassword()%></td>
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