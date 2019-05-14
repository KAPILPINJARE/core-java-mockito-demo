package com.capgemini.demo.test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.demo.MathApplication;
import com.capgemini.demo.excepitions.InvalidNumberException;
import com.capgemini.demo.service.CalculatorService;

//@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTest
{
	@Mock
	private CalculatorService service;

	@InjectMocks
	MathApplication application = new MathApplication(service);

	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testPerformAdditionWithTwoPositiveIntegers()
	{
		when(service.additon(6, 4)).thenReturn(10);
		assertEquals(10, service.additon(6, 4));
	}
	
	@Test
	public void testPerformAdditionWithOnePositiveAndOneNegativeInteger()
	{
		when(service.additon(6, -4)).thenReturn(2);
		assertEquals(2, service.additon(6, -4));
	}
	
	@Test
	public void testPerformAdditionWithTwoNegativeIntegers()
	{
		when(service.additon(-4, -4)).thenReturn(-8);
		assertEquals(-8, service.additon(-4, -4));
	}
	
	@Test
	public void testPerformSubstractionWithTwoPositiveIntegers()
	{
		when(service.subtraction(6, 4)).thenReturn(2);
		assertEquals(2, service.subtraction(6, 4));
	}
	
	@Test
	public void testPerformSubstractionWithTwoNegativeIntegers()
	{
		when(service.subtraction(-6, -4)).thenReturn(-2);
		assertEquals(-2, service.subtraction(-6, -4));
	}

	@Test
	public void testPerformSubstractionWithOnePositiveAndOneNegativeInteger()
	{
		when(service.subtraction(6, -4)).thenReturn(10);
		assertEquals(10, service.subtraction(6, -4));
	}
	@Test
	public void testPerformMultiplicationWithTwoPositiveIntegers()
	{
		when(service.multiplication(6, 4)).thenReturn(24);
		assertEquals(24, service.multiplication(6, 4));
	}
	
	@Test
	public void testPerformDivisionWithTwoPositiveIntegers()
	{
		when(service.division(6, 2)).thenReturn(3);
		assertEquals(3, service.division(6, 2));
	}
	
	@Test(expected = ArithmeticException.class)
	public void testPerformDivisionWithDivisorZero()
	{
		doThrow(new ArithmeticException("/ by zero")).when(service).division(10, 0);
		application.performDivision(10, 0); 
	}
	
	@Test
	public void testFindFactorialWithPositiveInteger() throws InvalidNumberException 
	{
		when(service.factorial(5)).thenReturn(120L);
		assertEquals(120, application.findFactorial(5));
	}
	
	@Test(expected = InvalidNumberException.class)
	public void testFindFactorialWithNumberLessThanOne() throws InvalidNumberException 
	{
		doThrow(new InvalidNumberException("number should be greater than zero")).when(service).factorial(-1);
		application.findFactorial(-1);
	}

	@Test
	public void testFindSquareWithPositiveInteger() 
	{
		when(service.square(5)).thenReturn(25L);
		assertEquals(25, application.findSquare(5));
	}
	
	@Test
	public void testFindSquareWithNegativeInteger() 
	{
		when(service.square(-5)).thenReturn(25L);
		assertEquals(25, application.findSquare(-5));
	}
}
