package After;

public class Student extends Person{
	 private String grade;
	 private int feesPaid;
	 private int feesTotal;
	 
	 public Student(int id, String name, String grade){
		 super(id, name);
	     this.grade=grade;
	     this.feesPaid=0;
		 this.feesTotal= 0;
		 if(grade.equals("Elementary")) {
			 this.feesTotal = 300000;
		 } else if(grade.equals("Junior")) {
			 this.feesTotal = 400000;
		 } else if(grade.equals("Senior")){
			 this.feesTotal = 500000;
		 }
	}
		
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public int getFeesPaid() {
		return feesPaid;
		
	}

	public void setFeesPaid(int feesPaid) {
		this.feesPaid = feesPaid;
	}

	public int getFeesTotal() {
		return feesTotal;
	}

	public void setFeesTotal(int feesTotal) {
		this.feesTotal = feesTotal;
	}
	
	public void payFees(int fees){
		feesPaid+=fees;
		School.updateTotalMoneyEarned(fees);
	}
	
	public int getRemainingFees(){
	    return feesTotal-feesPaid;
	}
	
	public String toString() {
		return "Grade " +grade+ " fee :"+ feesTotal +" and Total fees paid so far Rp"+ feesPaid;
		 
	}
}