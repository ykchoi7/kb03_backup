package com.multicampus.kb03.dto;

public class MultiCalcDto {
	private int n1, n2, answer;

	public MultiCalcDto(int n1, int n2, int answer) {
		super();
		this.n1 = n1;
		this.n2 = n2;
		this.answer = answer;
	}

	public int getN1() {
		return n1;
	}

	public void setN1(int n1) {
		this.n1 = n1;
	}

	public int getN2() {
		return n2;
	}

	public void setN2(int n2) {
		this.n2 = n2;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "n1=" + n1 + ", n2=" + n2 + ", answer=" + answer;
	}
		
}
