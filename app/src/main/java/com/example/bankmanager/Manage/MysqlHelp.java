package com.example.bankmanager.Manage;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlHelp {
    public static int getUserSize(){
        final String CLS="com.mysql.jdbc.Driver";
        final String URL="jdbc:mysql://172.24.40.188:3306/card";
        final String USER="xxl";
        final String PWD="123456";

        int count=0;//信用卡数量

        try {
            Class.forName(CLS);
            Connection conn= DriverManager.getConnection(URL,USER,PWD);
            String sql="select count(1) as s1 from card_details";
            Statement stat=conn.createStatement();
            ResultSet rs=stat.executeQuery(sql);
            while (rs.next()){
                count=rs.getInt("s1");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
