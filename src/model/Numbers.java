package model;

public class Numbers {
	private double number1 = 0;
	private double number2 = 0;
	private double number3 = 0;
	private double biggestNumber = 0;

	
	public void setNumber1(double num) {
		this.number1 = num;
	}

	public void setNumber2(double num) {
		this.number2 = num;
	}

	public void setNumber3(double num) {
		this.number3 = num;
	}

	public double getNumber1() {
		return this.number1;
	}

	public double getNumber2() {
		return this.number2;
	}

	public double getNumber3() {
		return this.number3;
	}

	public double getBiggestNumber() {
		if (this.number1 > this.number2) {
			if (this.number1 > this.number3) {
				this.biggestNumber = this.number1;
			} else {
				this.biggestNumber = this.number3;
			}
		} else {
			if (this.number2 > this.number3) {
				this.biggestNumber = this.number2;
			} else {
				this.biggestNumber = this.number3;
			}
		}
		return this.biggestNumber;
	}
}
