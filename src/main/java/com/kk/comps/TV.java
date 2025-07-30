package com.kk.comps;

import org.springframework.stereotype.Component;

@Component("tv")
public class TV extends Appliance {
	
	public TV() {
		super("TV");
	}

	@Override
	public void turnOn() {
		setOn(true);
		System.out.println("TV turned on");
	}

	@Override
	public void turnOff() {
		setOn(false);
		System.out.println("TV turned off");
	}

}
