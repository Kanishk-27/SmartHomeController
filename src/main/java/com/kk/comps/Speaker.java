package com.kk.comps;

import org.springframework.stereotype.Component;

@Component("speaker")
public class Speaker extends Appliance {
	
	public Speaker() {
		super("Speaker");
	}

	@Override
	public void turnOn() {
		setOn(true);
		System.out.println("Speaker turned on");
	}

	@Override
	public void turnOff() {
		setOn(false);
		System.out.println("Speaker turned off");
	}

}
