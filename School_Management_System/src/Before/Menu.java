package Before;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	List<Teacher> teacherList = new ArrayList<>();
	List<Student> studentList = new ArrayList<>();
	School Binus;
	Scanner scan;
	
	public Menu() {
		scan = new Scanner(System.in);
		studentList.add(new Student(1, "Evan Wilbert", "Senior"));
		studentList.add(new Student(2, "Chris Kusuma", "Junior"));
		studentList.add(new Student(3, "Giordano", "Elementary"));
		Binus = new School(teacherList,studentList);
		teacherList.add(new Teacher(1, "Melissa"));
		teacherList.add(new Teacher(2, "Elisabeth"));
		teacherList.add(new Teacher(3, "Catherine"));
		Printmenu();
	}
	
	public void Printmenu(){
		System.out.println("Login");
		System.out.println("1. School");
		System.out.println("2. Teacher");
		System.out.println("3. Student");
		System.out.println("4. Exit");
		System.out.print(">>");
		int input = 0;
		do{
			try {
				input = scan.nextInt();
			} catch (Exception e) {
				input = 26;
			} finally {
				scan.nextLine();
			}
		}while(input < 1 || input > 4);
		
		
		switch(input) {
			case 1:
				School();
				break;
			case 2:
				Teacher();
				break;
			case 3:
				Student();
				break;
			case 4:
				System.exit(0);
				break;
		}
	}
	
	public void Teacher(){
		String name;
		boolean end = false;
		do{
			end = false;
		do{
			System.out.println("Input Teacher Name:");
			name = scan.nextLine();
			
		}while(name.length() < 5 || name.length() > 20);
		
		for (Teacher teacher : teacherList) {
			if(teacher.getName().equals(name)){
				System.out.println(teacher);
				end = true;
			}
		}
		}while(!end);
		Printmenu();
	}
	
	public void Student() {
		String name;
		int pays;
		boolean end = false;
		do{
		end = false;
		do{
			System.out.println("Input Student Name:");
			name = scan.nextLine();
	
		}while(name.length() < 5 || name.length() > 20);
		
		
		for (Student student : studentList) {
			if(student.getName().equals(name)){
				do{
					System.out.println(student.printer(student.getGrade()));
					System.out.println("Remaining Fees: Rp"+student.getRemainingFees());
					System.out.println("Input how much you want to pay");
					pays = scan.nextInt();
					
				}while(pays < 0 || pays > student.getFeesTotal());
				student.payFees(pays);
				System.out.println(student.printer(student.getGrade()));
				System.out.println("Remaining Fees: Rp"+student.getRemainingFees());
				end = true;
			}
		}
		}while(!end);
		
		Printmenu();
	}
	
	
	public void School() {
		
		System.out.println("~~School Menu~~");
		System.out.println("1. Money Earn");
		System.out.println("2. Money Spend");
		System.out.println("3. Back");
		System.out.print(">>");
		int input;
		do{
			try {
				input = scan.nextInt();
			} catch (Exception e) {
				input = 26;
			} finally {
				scan.nextLine();
			}
		}while(input < 1 || input > 3);
		
		switch(input) {
		case 1:
			Earn();
			break;
		case 2:
			Spend();
			break;
		case 3:
			Printmenu();
			break;
		}
	}
	
	public void Earn(){
		
		 System.out.println("Binus has earned Rp"+ Binus.getTotalMoneyEarned());
		 School();
	}
	
	public void Spend(){
		String name;
		int pays;
		boolean end;
		do{
			end = false;
			
			do{
				System.out.println("Input Teacher Name:");
				name = scan.nextLine();
		
			}while(name.length() < 5 || name.length() > 20);
			
			
			for (Teacher teacher : teacherList) {
				if(teacher.getName().equals(name)){
					do{
						System.out.println("Input how much you want to pay" + teacher.getName());
						pays = scan.nextInt();
						
					}while(pays < 0 || pays > Binus.getTotalMoneyEarned());
					teacher.receiveSalary(pays);
					System.out.println("Binus has spent for salary to " + teacher.getName()
	                +" and now has Rp" + Binus.getTotalMoneyEarned());
					end = true;
				}
			}
			}while(!end);
		School();
	}
	
	public static void main(String[] args) {
		new Menu();
		
	}
}
