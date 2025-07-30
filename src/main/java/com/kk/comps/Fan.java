package com.kk.comps;

import org.springframework.stereotype.Component;

@Component("fan")
public class Fan extends Appliance {
	
	public Fan() {
		super("Fan");
	}

	@Override
	public void turnOn() {
		setOn(true);
		System.out.println("Fan turned on");
	}

	@Override
	public void turnOff() {
		setOn(false);
		System.out.println("Fan turned off");
	}

}
