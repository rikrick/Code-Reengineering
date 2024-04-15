package Before;

public class Student {
	private int id;
    private String name;
    private String grade;
    private int feesPaid;
    private int feesTotal;
    
	public Student(int id, String name,String grade){
		 this.feesPaid=0;
		 this.feesTotal= 0;
		 if(grade.equals("Elementary")) {
			 this.feesTotal = 300000;
		 } else if(grade.equals("Junior")) {
			 this.feesTotal = 400000;
		 } else if(grade.equals("Senior")){
			 this.feesTotal = 500000;
		 }
	     this.id=id;
	     this.name=name;
	     this.grade=grade;
	}
	
    public void payFees(int fees){
        feesPaid+=fees;
        School.updateTotalMoneyEarned(fees);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public int getRemainingFees(){
	    return feesTotal-feesPaid;
	}


	public String printer(String grade) {
		if(grade.equals("Elementary")) {
			return "Grade Elementary fee : 300000 and Total fees paid so far Rp"+ feesPaid;
		 } else if(grade.equals("Junior")) {
			 return "Grade Junior fee : 400000 and Total fees paid so far Rp"+ feesPaid;
		 } else if(grade.equals("Senior")){
			 return "Grade Senior fee : 500000 and Total fees paid so far Rp"+ feesPaid;
		 }
		return "Error";
	}
}