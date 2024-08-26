package com.Runner;

import org.testng.annotations.Test;

public class DependsOnMethods {
	
	@Test(priority =1, expectedExceptions =ArithmeticException.class)
	private void sampleOne() {
		System.out.println("SampleOne");
		int i=10/0;
		
	}
	@Test(priority =2)
private void sampleTwo() {
		System.out.println("SampleTwo");
		
	}
	@Test(dependsOnMethods="sampleOne")

private void sampleThree() {
		System.out.println("SampleThree");
	
}

}
