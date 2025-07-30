package com.kk.service;

import java.util.List;

import com.kk.comps.Appliance;

public interface ApplianceService {
	void addAppliance(Appliance appliance);
	List<Appliance> listAppliances();
	void turnOn(String appliance);
	void turnOff(String appliance);
	void scheduleAppliance(String name,int delaySeconds);
}
