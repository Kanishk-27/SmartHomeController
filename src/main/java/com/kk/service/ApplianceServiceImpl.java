package com.kk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.kk.comps.Appliance;

@Service
public class ApplianceServiceImpl implements ApplianceService {
	private final Map<String, Appliance> appliances = new HashMap<>();
	private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	
	@Override
	public void addAppliance(Appliance appliance) {
		appliances.put(appliance.getName().toLowerCase() , appliance);
		System.out.println(appliance.getName()+" added.");
	}

	@Override
	public List<Appliance> listAppliances() {
		return new ArrayList<>(appliances.values());
	}

	@Override
	public void turnOn(String name) {
		Appliance appliance = appliances.get(name.toLowerCase());
		if(appliance != null) {
			appliance.turnOn();
		}else {
			System.out.println("Appliance not found");
		}
	}

	@Override
	public void turnOff(String name) {
		Appliance appliance = appliances.get(name.toLowerCase());
		if(appliance!=null) {
			appliance.turnOff();
		}
		else {
			System.out.println("Appliance not found");
		}
	}

	@Override
	public void scheduleAppliance(String name, int delaySeconds) {
		Appliance appliance = appliances.get(name.toLowerCase());
        if (appliance != null) {
            scheduler.schedule(() -> {
                appliance.turnOn();
            }, delaySeconds, TimeUnit.SECONDS);
            System.out.println("Scheduled " + name + " to turn on in " + delaySeconds + " seconds.");
        } else {
            System.out.println("Appliance not found.");
        }
	}

}
