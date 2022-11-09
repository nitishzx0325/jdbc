package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student management App");
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        while(true){

            System.out.println("Press 1 to Add Student");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to Display Student");
            System.out.println("Press 4 to exit app");
            int c=Integer.parseInt(br.readLine());

            if(c==1){
//                add students
                System.out.println("Enter user name: ");
                String name=br.readLine();
                System.out.println("Enter user phone: ");
                String phone=br.readLine();
                System.out.println("Enter user city: ");
                String city=br.readLine();
                Student st=new Student(name,phone,city);

                boolean ans=StudentDao.InsertDao(st);
                if(ans) {
                    System.out.println(st);
                }
                else{
                    System.out.println("Some thing went wrong");
                }

            }
            else if(c==2){
//                delte students
                System.out.println("Enter student Id to delete");
                int userId=Integer.parseInt(br.readLine());
               boolean ans= StudentDao.deleteStudent(userId);
               if(ans){
                   System.out.println("Student delete SuccessFully ");
               }
               else{
                   System.out.println("Some thing went wrong");
               }
            }
            else if(c==3){
//                display student
                StudentDao.showAllStudent();

            }
            else if(c==4){
                break;
            }

        }
        System.out.println("Thanks for using app");

    }
}
