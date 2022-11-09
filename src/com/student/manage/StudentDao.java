package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
    public static boolean InsertDao(Student st){
        boolean flag=false;
        try {
            Connection con = Connect.craeteconnection();
            String query="insert into students(sname,sphone,scity) values(?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
//            set the parameters
            ps.setString(1, st.getStudentName());
            ps.setString(2, st.getStudentPhone());
            ps.setString(3,st.getStudentPhone());
            ps.executeUpdate();
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;

    }

    public static boolean deleteStudent(int userId) {
        boolean flag=false;
        try{
            Connection con=Connect.craeteconnection();
            String query="delete from students where sid=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,userId);
            ps.executeUpdate();
            flag=true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void showAllStudent() {
        boolean flag=false;
        try{
            Connection con=Connect.craeteconnection();
            String query="select * from students";
            Statement ps=con.createStatement();

//            ps.setInt(1,);
            ResultSet rs =ps.executeQuery(query);
//            flag=true;

            while (rs.next()){
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String pno=rs.getString(3);
                String city=rs.getString(4);
                System.out.println("Id: "+id);
                System.out.println("Name: "+name);
                System.out.println("Phone number: "+pno);
                System.out.println("City: "+city);
                System.out.println("....................................");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

//        return flag;
    }
}
