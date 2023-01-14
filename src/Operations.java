
public class Operations {

	private double firstNumber;
	private double secondNumber;
	private String signs;
	private double total;
	
	public Operations(double firstNumber, double secondNumber){
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		total = 0; 

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
		
		return total = firstNumber + secondNumber;
		
	}
//	public boolean checkFirst() {
//		while(true) {
//		if(firstNumber==0) {
//			return false;	
//		}
//		else {
//			total = total+firstNumber;
//			return true;
//		}
//		}
//	}
//	
//	public double getTotal() {
//		return total;
//	}
//	public void setTotal(double totalIn) {
//		total = totalIn;
//	}
	
	
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
