package After;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import After.Input.*;

public class Menu {
	List<Person> studentList = new ArrayList<>();
	List<Person> teacherList = new ArrayList<>();
	School Binus;
	Scanner scan;
	
	public Menu(){
		scan = new Scanner(System.in);
		studentList.add(new Student(1, "Evan Wilbert", "Senior"));
		studentList.add(new Student(2, "Chris Kusuma", "Junior"));
		studentList.add(new Student(3, "Giordano", "Elementary"));
		teacherList.add(new Teacher(1, "Melissa"));
		teacherList.add(new Teacher(2, "Elisabeth"));
		teacherList.add(new Teacher(3, "Catherine"));
		Binus = new School(teacherList, studentList);
		Inputmenu();
	}
	
	public void Inputmenu() {
		int input = Printmenu("Main");
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
	
	public int Printmenu(String name) {
		if(name.equals("Main")){
		System.out.println("Login");
		System.out.println("1. School");
		System.out.println("2. Teacher");
		System.out.println("3. Student");
		System.out.println("4. Exit");
		System.out.print(">>");
		return new Intinput(1, 4).get();
		}else if(name.equals("School")) {
			System.out.println("~~School Menu~~");
			System.out.println("1. Money Earn");
			System.out.println("2. Money Spend");
			System.out.println("3. Back");
			System.out.print(">>");
			return new Intinput(1, 3).get();
		}
		return -1;
		
	}
	
	public void Teacher(){
		String name;
		boolean end = false;
		do{
			end = false;
			name = new Stringinput("teacher", 5, 20).get();
			for (Person person : teacherList) {
				if(person instanceof Teacher) {
					if(person.getName().equals(name)){
						System.out.println((Teacher)person);
						end = true;
					}
				}
			}
		}while(!end);
		Inputmenu();
	}
	
	public void Student(){
		String name;
		int pays;
		boolean end = false;
		do{
		end = false;
		name = new Stringinput("student", 5, 20).get();
		
		
		for (Person person : studentList) {
			if(person instanceof Student) {
				if(person.getName().equals(name)){
					do{
						System.out.println(((Student)person));
						System.out.println("Remaining Fees: Rp"+((Student)person).getRemainingFees());
						System.out.println("Input how much you want to pay");
						pays = scan.nextInt();
						
					}while(pays < 0 || pays > ((Student)person).getFeesTotal());
					((Student)person).payFees(pays);
					System.out.println(((Student)person));
					System.out.println("Remaining Fees: Rp"+((Student)person).getRemainingFees());
					end = true;
				}
				
			}
		}
		}while(!end);
		
		Inputmenu();
	}
	
	public void School() {
		int input = Printmenu("School");
		switch(input) {
		case 1:
			Earn();
			break;
		case 2:
			Spend();
			break;
		case 3:
			Inputmenu();
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
			name = new Stringinput("teacher", 5, 20).get();	
			for (Person person: teacherList) {
				if(((Teacher)person).getName().equals(name)){
					do{
						System.out.println("Input how much you want to pay "+((Teacher)person).getName());
						pays = scan.nextInt();
						
					}while(pays < 0 || pays > Binus.getTotalMoneyEarned());
					((Teacher)person).receiveSalary(pays);
					System.out.println("Binus has spent for salary to " + ((Teacher)person).getName()
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