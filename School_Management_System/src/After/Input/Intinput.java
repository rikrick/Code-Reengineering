package After.Input;

public class Intinput extends Console<Integer> {
	private int min, max;

	public Intinput(int min, int max) {
		super();
		this.max = max;
		this.min = min;
	}
	
	@Override
	public Integer get(){
		int input;
		do{
			try {
				input = scan.nextInt();
			} catch (Exception e) {
				input = -26;
			} finally {
				scan.nextLine();
			}
		}while(input < min || input > max);
		return input;
	}

}
