package chap07;

public class CalcBean {
	
	private int num1;
	private String operator;
	private int num2;
	
	public CalcBean() {
	}
	
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public int calculate() {
		int result = 0;
		
		if(this.operator != null) {
			
			if(this.operator.equals("+")) {
				result = this.num1 + this.num2;
			}
			else if(this.operator.equals("-")) {
				result = this.num1 - this.num2;
			}
			else if(this.operator.equals("*")) {
				result = this.num1 * this.num2;
			}
			else if(this.operator.equals("/")) {
				result = this.num1 / this.num2;
			}
		}
		
		
		
		return result;
	}

}
