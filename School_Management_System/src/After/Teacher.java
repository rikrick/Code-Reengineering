package After;

public class Teacher extends Person {
    private int salary;
    private int salaryEarned;

    public Teacher(int id, String name){
    	super(id, name);
        this.salary=0;
        this.salaryEarned=0;
    }
    
    
    public int getSalaryEarned() {
		return salaryEarned;
	}

	public void setSalaryEarned(int salaryEarned) {
		this.salaryEarned = salaryEarned;
	}

    public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	public void receiveSalary(int salary){
        salaryEarned+=salary;
        School.updateTotalMoneySpent(salary);
    }

    public String toString() {
        return "Name of the Teacher: " + name
                +" Total salary earned so far Rp"
                + salaryEarned;
    }
}
