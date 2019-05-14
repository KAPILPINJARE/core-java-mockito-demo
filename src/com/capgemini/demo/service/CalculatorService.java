package com.capgemini.demo.service;

import com.capgemini.demo.excepitions.InvalidNumberException;

public interface CalculatorService
{
	public int additon(int number1, int number2);
	public int subtraction(int number1, int number2);
	public int multiplication(int number1, int number2);
	public int division(int number1, int number2);
	public long factorial(int number)throws InvalidNumberException;
	public long square(int numebr);
}
