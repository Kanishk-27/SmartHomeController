package com.kk.comps;

public abstract class Appliance {
	private String name;
	private boolean isOn;
	
	public Appliance(String name) {
		this.name = name;
		this.isOn = false;
	}
	
	//features to implement in subclass
	public abstract void turnOn();
    public abstract void turnOff();
    
    //getters
    public boolean isOn() {
    	return isOn;
    }
    
    public String getName() {
    	return name;
    }
    
    //helper method
    protected void setOn(boolean state) {
    	this.isOn = state;
    }
}
