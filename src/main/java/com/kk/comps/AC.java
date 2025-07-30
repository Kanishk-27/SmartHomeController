package com.kk.comps;

import org.springframework.stereotype.Component;

@Component("ac")
public class AC extends Appliance {
	
	public AC() {
		super("AC");
	}

	@Override
	public void turnOn() {
		setOn(true);
		System.out.println("AC turned on");
	}

	@Override
	public void turnOff() {
		setOn(false);
		System.out.println("AC turned off");
	}

}
