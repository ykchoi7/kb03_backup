package com.itskb.myapp.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InterestCalculatorService {
	
	@Autowired
	@Qualifier("loanCalcator")
	InterestCalculator loanInterestCalculator;
	
	
	@Autowired
	@Qualifier("savingCalcator")
	InterestCalculator savingInterestCalculator;
	
	public double calculateLoanInterest(int amount) {
		return loanInterestCalculator.calculate(amount);
	}
	
	public double calculateSavingInterest(int amount) {
		return savingInterestCalculator.calculate(amount);
	}
}
