package DBpractice2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberService {

    public void Dbdelete() {
        String url = "jdbc:mariadb://localhost:3306/test1";
        String user = "testuser1";
        String DBpassword = "!tkdghk6226";

        String sql = "Delete from zerobase_member1 where email = ?  And password = ?;";
        String email = "jjh@gmail.com";
        String password = "1234";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
                Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, DBpassword);
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("삭제성공");
            } else {
                System.out.println("삭제실패");
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public void DbUpdate() {
        String url = "jdbc:mariadb://localhost:3306/test1";
        String user = "testuser1";
        String DBpassword = "!tkdghk6226";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String email = "bsh6226@gmail(4).com";
        String password = "4321";
        String newpassword = "1234";


        String sql = "update zerobase_member1 set password = ? where email = ? and password = ?;";

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            connection = DriverManager.getConnection(url, user, DBpassword);
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, newpassword);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);



            int affected = preparedStatement.executeUpdate();

            if (affected > 0) {
                System.out.println("수정성공");
            } else {
                System.out.println("수정실패");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (preparedStatement != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public void DbInsert() {
        String url = "jdbc:mariadb://localhost:3306/test1";
        String user = "testuser1";
        String DBpassword = "!tkdghk6226";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");

            connection = DriverManager.getConnection(url, user, DBpassword);

            String name = "조정해";
            String email = "jjh@gmail.com";
            String phone = "01065009238";
            String password = "1234";
            int Marketing = 0;

            String sql = "insert into zerobase_member1 (name, email, mobile_no, password, marketing_yn, register_date) \n" +
                    "values (?,?,?,?,?,NOW());";


            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, phone);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, Marketing);
            int affected = preparedStatement.executeUpdate();
            if (affected > 0) {
                System.out.println("저장성공");
            } else {
                System.out.println("저장실패");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    public List<Member> memberList() {

        List<Member> memberList = new ArrayList<Member>();

        String url = "jdbc:mariadb://localhost:3306/test1";
        String user = "testuser1";
        String DBpassword = "!tkdghk6226";

        String marketingValue = "1";
        String nameValue = "변상화";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, user, DBpassword);

            String sql = "select name, email, marketing_yn,register_date\n" +
                    "from zerobase_member1 zm \n" +
                    "where marketing_yn = ? " +
                    ";";

            preparedStatement = connection.prepareStatement(sql); // sql String을 url에서 조작하는 것을 방지하기 위해서 조건절값 코드 내 숨기기
            preparedStatement.setString(1, marketingValue); // 1. sql문의 ?에 해당 값이 입력됨


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String register_date = resultSet.getString("register_date");

                Member member = new Member();
                member.setName(name);
                member.setEmail(email);
                member.setRegister_date(register_date);
                memberList.add(member);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        return memberList;
    }

    public Member getMember(String userEmail) {

        Member selectedMember = null;

        String url = "jdbc:mariadb://localhost:3306/test1";
        String user = "testuser1";
        String DBpassword = "!tkdghk6226";

        String marketingValue = "1";
        String nameValue = "변상화";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection(url, user, DBpassword);

            String sql = "select name, email,mobile_no ,password, marketing_yn,register_date \n" +
                    "from zerobase_member1 zm \n" +
                    "where email = ?";

            preparedStatement = connection.prepareStatement(sql); // sql String을 url에서 조작하는 것을 방지하기 위해서 조건절값 코드 내 숨기기
            preparedStatement.setString(1, userEmail); // 1. sql문의 ?에 해당 값이 입력됨


            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                selectedMember = new Member();
                selectedMember.setName(resultSet.getString("name"));
                selectedMember.setEmail(resultSet.getString("email"));
                selectedMember.setPassword(resultSet.getString("password"));
                selectedMember.setMobile_no(resultSet.getString("mobile_no"));
                selectedMember.setRegister_date(resultSet.getString("register_date"));
                selectedMember.setMarketing_yn(resultSet.getBoolean("marketing_yn"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (resultSet != null && !resultSet.isClosed()) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
        return selectedMember;

    }
}

