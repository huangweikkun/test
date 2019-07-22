package com.jacken.test.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author jacken
 * @date 2018/12/31
 */
public class JdbcConnectTest {

  public static void main(String[] args) {
    Connection connection = null;
    Statement statement = null;
    try {
      String url = "jdbc:mysql://47.107.146.1:3306/test";
      String user = "root";
      String password = "123456";
      // 注册驱动
      Class.forName("com.mysql.jdbc.Driver");
      // 获取数据库数据库连接
      connection = DriverManager.getConnection(url, user,password);
      // 获取statement，执行sql
//      statement = connection.createStatement();
//      statement.execute("SELECT * FROM test_tb LIMIT 1");
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM test_tb WHERE id = ? LIMIT 1");
      preparedStatement.setInt(1, 1);
      preparedStatement.execute();
      // 获取结果集
      ResultSet resultSet = preparedStatement.getResultSet();

      while (resultSet.next()) {
        System.out.println(resultSet.getInt("id"));
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      if(statement != null) {
        try {
          statement.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }

      if(connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
