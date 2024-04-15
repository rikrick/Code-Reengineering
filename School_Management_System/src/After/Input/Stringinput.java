package After.Input;

public class Stringinput extends Console<String>{
	private int min, max;
	private String subject;
	
	public Stringinput(String subject, int min, int max) {
		super();
		this.subject = subject;
		this.max = max;
		this.min = min;
	}
	
	@Override
	public String get() {
		String input;
		do{
			System.out.println("Input "+subject+" Name:");
			input = scan.nextLine();
			
		}while(input.length() < min || input.length() > max);
		
		return input;
	}
}
