package com.tech.StudentManagement;
import java.util.Scanner;

//import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import java.sql.SQLException;

public class Runner {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//TableCreation.createTable();
		//DropTable.droptable();
		Scanner sc=new Scanner(System.in);
		boolean loop=true;
		
		while(loop) {
			System.out.println("1. Add Student");
			System.out.println("2. View all students");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Add Result");
			System.out.println("6. View all result");
			System.out.println("7. update result");
			System.out.println("8. delete result");
			System.out.println("9. Exit");
			System.out.print("Enter number:");
			int n= sc.nextInt();
			switch(n){
			case 1:
				System.out.print("Student id: ");
				int id=sc.nextInt();
				if(!CheckStudent.studentexists(id)) {
					System.out.print("Student name: ");
					String name=sc.next();
					System.out.print("Student course: ");
					String course = sc.next();
					AddStudent.add(id,name,course);
				}else {
					System.out.println("Student already exists in the table.");
				}
				break;
			case 2:
				ViewStudents.viewStudents();
				break;
			case 3:
				System.out.print("Id of student:"); 
				int iid=sc.nextInt();
				if(CheckStudent.studentexists(iid)) {
					System.out.println("Enter new name:");
					String name=sc.next();
					System.out.println("Enter new course:");
					String course = sc.next();
					if(!name.isEmpty()) {
						UpdateStudents.updateName(iid, name);
					}if(!course.isEmpty()) {
						UpdateStudents.updateCourse(iid, course);
					}
				}else {
					System.out.println("No student found");
				}
				break;
			case 4:
				System.out.print("ID of student you want to remove: ");
				int idd = sc.nextInt();
				if(CheckStudent.studentexists(idd)) {
					DeleteRecord.deleteStudent(idd);
				}else {
					System.out.println("Student does not exists in the table.");
				}
				break;
			case 5:
				System.out.print("ID of student: ");
				int i = sc.nextInt();
				if(CheckStudent.studentexists(i)) {
					System.out.println("Marks in subject1:");
					int s1= sc.nextInt();
					System.out.println("Marks in subject2:");
					int s2= sc.nextInt();
					System.out.println("Marks in subject3:");
					int s3= sc.nextInt();
					if(s1<=100 && s2<=100 && s3<=100) {
						int total= s1+s2+s3;
						double percentage=total/3;
						String grade;
						if(percentage>=90) grade="A";
						else if(percentage>=80) grade="B";
						else if(percentage>=70) grade="C";
						else if(percentage>=50) grade="D";
						else grade="F";
						AddResult.addResult(i,total, percentage, grade);
					}else {
						System.out.println("Invalid marks input.");
					}
				}else {
					System.out.println("Student does not exists");
				}
				break;
			case 6:
				System.out.print("ID of student: ");
				int ii = sc.nextInt();
				if(CheckStudent.studentexists(ii)) {
					ViewStudents.viewSpecificStudents(ii);
				}else {
					System.out.println("Student does not exists.");
				}
				break;
			case 7:
				System.out.print("ID of student: ");
				int iidd = sc.nextInt();
				if(CheckStudent.studentexists(iidd)) {
					System.out.println("Marks in subject1:");
					int s1= sc.nextInt();
					System.out.println("Marks in subject2:");
					int s2= sc.nextInt();
					System.out.println("Marks in subject3:");
					int s3= sc.nextInt();
					if(s1<=100 && s2<=100 && s3<=100) {
						int total= s1+s2+s3;
						double percentage=total/3;
						String grade;
						if(percentage>=90) grade="A";
						else if(percentage>=80) grade="B";
						else if(percentage>=70) grade="C";
						else if(percentage>=50) grade="D";
						else grade="F";
						UpdateStudents.updateResult(iidd,total, percentage, grade);
					}else {
						System.out.println("Invalid marks input.");
					}
				}else {
					System.out.println("Student does not exists");
				}
				break;
			case 8:
				System.out.print("ID of student: ");
				int iii = sc.nextInt();
				if(CheckStudent.studentexists(iii)) {
					DeleteRecord.deleteResult(iii);
				}else {
					System.out.println("Does not exists");
				}
				break;
			case 9:
				loop=false;
				System.out.println("Thank you!");
				break;
			}
		}
		
		sc.close();
	}
}
