
public class Operations {

	private double firstNumber;
	private double secondNumber;
	private String signs;
	// private static double total;
	
	public Operations(double firstNumber, double secondNumber){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;

	}

	public void setFirst(double firstn) {
		firstNumber = firstn;
	}
	
	public void setSign(String sign) {
		signs = sign;
	}
	
	public String getSign() {
		return signs;
	}
	
	public void setSecond(double secondn) {
		secondNumber = secondn;
		
	}
	
	public double getFirst() {
		return firstNumber;
	}
	
	
	public double getSecond() {
		return secondNumber;
	}
	
	public double addition() {	
		return firstNumber + secondNumber;
		
	}
	
	public double subtraction() {
		return firstNumber - secondNumber;
	}
	
	public double multiplication() {
		
		return firstNumber * secondNumber;
	}
	
	public double division() {
		return firstNumber / secondNumber;
	}
	
	
	public double equalOps(String sign) {
//		signs = sign;
		double result= 0;
		switch(sign) {
		case "+": result = addition();
		break;
		case "-": result = subtraction();
		break;
		case "*":result = multiplication(); 
		break;
		case "/": result = division(); 
		break;
		default: System.out.println("No such case");
		}
		return result;
		
	}
}
