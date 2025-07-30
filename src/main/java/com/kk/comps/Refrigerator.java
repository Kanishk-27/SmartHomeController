package com.kk.comps;

import org.springframework.stereotype.Component;

@Component("refrigerator")
public class Refrigerator extends Appliance {
	
	public Refrigerator() {
		super("Refrigerator");
	}

	@Override
	public void turnOn() {
		setOn(true);
		System.out.println("Refrigerator turned on");
	}

	@Override
	public void turnOff() {
		setOn(false);
		System.out.println("Refrigerator turned off");
	}

}
