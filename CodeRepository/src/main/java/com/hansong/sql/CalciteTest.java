package com.hansong.sql;

import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class CalciteTest {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from EMPS";
        String model = "/model.json";

        Properties info = new Properties();
        info.put("model", CalciteTest.class.getResource(model).getPath());
        try (Connection connection = DriverManager.getConnection("jdbc:calcite:", info)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int empno = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int deptno = resultSet.getInt(3);
                String gender = resultSet.getString(4);
                String city = resultSet.getString(5);
                int empid = resultSet.getInt(6);
                int age = resultSet.getInt(7);
                boolean slacker = resultSet.getBoolean(8);
                boolean manager = resultSet.getBoolean(9);
                Date joinDate = resultSet.getDate(10);

                String txt = String.format("empno=%d,name=%s,deptno=%d,gender=%s,city=%s,empid=%d,age=%d,slacker=%b,manager=%b,joinDate=%tF",empno,name,deptno,gender,city,empid,age,slacker,manager,joinDate);
                System.out.println(txt);
            }
        }
    }
}
