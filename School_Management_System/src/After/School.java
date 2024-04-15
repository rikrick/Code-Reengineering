package After;

import java.util.List;

public class School {

    private List<Person> teachers;
    private List<Person> students;
    private static int  totalMoneyEarned;
    private static int totalMoneySpent;

    public School(List<Person> teachers, List<Person> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned=0;
        totalMoneySpent=0;
    }

    public List<Person> getTeachers() {
        return teachers;
    }

   
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Person> getStudents() {
        return students;
    }

   
    public void addStudent(Student student) {
        students.add(student);
    }

   
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public static void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }
   
    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneyEarned-=moneySpent;
     }
}