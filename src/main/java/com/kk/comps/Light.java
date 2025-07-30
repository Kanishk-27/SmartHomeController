package com.kk.comps;

import org.springframework.stereotype.Component;

@Component("light")
public class Light extends Appliance {
	
	public Light() {
		super("Light");
	}

	@Override
	public void turnOn() {
		setOn(true);
		System.out.println("Light turned on");
	}

	@Override
	public void turnOff() {
		setOn(false);
		System.out.println("Light turned off");
	}

}
