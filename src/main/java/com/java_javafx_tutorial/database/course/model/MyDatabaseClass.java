package com.java_javafx_tutorial.database.course.model;

import java.sql.*;

public class MyDatabaseClass {
    private final String url = "jdbc:mysql://localhost:3306/students";
    private final String user = "root";
    private final String password = "2132";
    private Connection connection=null;

            private void getConnection() {
                try {
                    connection = DriverManager.getConnection(url,user,password);
                    DatabaseMetaData dbmd = connection.getMetaData();
                    ResultSet tables = dbmd.getTables(null, null, "%", new String[]{"student"});
                    while (tables.next()) {
                        System.out.println(tables.getString("COLUMN_NAME"));
                        System.out.println(tables.getString("TABLE_NAME"));
                        System.out.println(tables.getString("TABLE_TYPE"));
                        System.out.println(tables.getString("COLUMN_SIZE"));

                    }


                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                if (connection!=null) {
                    System.out.println("Connection is successful");
                }else {
                    System.out.println("Connection could not be successful");
                }
            }
    public void closeConnection() {
        if (connection!=null) {
            try {
                connection.close();
                System.out.println("Connection is closed");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else
            System.out.println("Connection could not be closed because connection is null");
    }
    //veri gönderme methodu
    public int executeUpdate(String query , Object... params) {
        getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            setParameters(ps,params);
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }finally {
            closeConnection();
        }
    }
    //veri alma methodu
    public ResultSet executeQuery(String query , Object... params ) {
        getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            setParameters(ps,params);
            ResultSet resultSet = ps.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
            //parapetrelerin preparedStatement objesine işlendiği methoddur
            private void setParameters(PreparedStatement ps , Object... params) throws SQLException {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
}
