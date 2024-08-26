package com.Runner;

import org.testng.annotations.Test;

public class Grouping {

	@Test(groups="VEG")
	private void curdRice() {
		System.out.println("CurdRice");
	}
	@Test(groups="VEG")
	private void idly() {
		System.out.println("Idly");
	}
	@Test(groups="VEG")
	private void dosa() {
		System.out.println("Dosa");
	}
	@Test(groups="NONVEG")
	private void mutton() {
		System.out.println("Mutton");
	}
	@Test(groups="NONVEG")
	private void chicken() {
		System.out.println("Chicken");
	}
	@Test(groups="NONVEG")
	private void prawn() {
		System.out.println("Prawn");
	}
	
	@Test(groups="Appliance")
	private void hometheatre() {
		System.out.println("HomeTheatre");
	}
	@Test(groups="Appliance")
	private void washingMachine() {
		System.out.println("WashingMachine");
	}
	@Test(groups="Appliance")
	private void refridgerator() {
		System.out.println("Refridgerator");
	}
}
