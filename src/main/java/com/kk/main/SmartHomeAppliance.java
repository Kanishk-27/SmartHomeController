package com.kk.main;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kk.comps.Appliance;
import com.kk.config.AppConfig;
import com.kk.service.ApplianceService;

public class SmartHomeAppliance {
	
	public static void printMenu() {
	    System.out.println("╔═════════════════════════════════════════════════╗");
	    System.out.println("║      🌟 Welcome to SmartHome Controller 🌟      ║");
	    System.out.println("╠═════════════════════════════════════════════════╣");
	    System.out.println("║            1. ➕ Add Appliance                  ║");
	    System.out.println("║            2. 📃 List Appliances                ║");
	    System.out.println("║            3. 🔛 Turn On Appliance              ║");
	    System.out.println("║            4. 🔌 Turn Off Appliance             ║");
	    System.out.println("║            5. ⏰ Schedule Appliance             ║");
	    System.out.println("║            6. ❌ Exit                           ║");
	    System.out.println("╚═════════════════════════════════════════════════╝");
	    System.out.print("👉 Enter your choice: ");
	}

	public static void main(String[] args) {
		//IOC container
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);){
			ApplianceService applianceService = ctx.getBean(ApplianceService.class);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				 printMenu();

		         int choice = sc.nextInt();
		         sc.nextLine();
		         
		         switch(choice) {
		         case 1 -> {
		        	 System.out.println("Enter type of appliance: (ac/fan/light/refrigerator/speaker/tv)");
	         		 String type = sc.nextLine().toLowerCase();
	         		 try {
	         			 Appliance appliance = (Appliance)ctx.getBean(type);
		         		 applianceService.addAppliance(appliance);
	         		 }
	         		 catch(Exception e) {
	         			 System.out.println("Invalid appliance type!");
	         		 }
		         }
		         
		         case 2 -> {
		        	 try {
	         			 List<Appliance> list = applianceService.listAppliances();
	         			 if(list.isEmpty()) {
	         				 System.out.println("No appliances added yet!");
	         			 }
	         			 else {
	         				 list.forEach(e -> System.out.println(e.getName() + " - "+(e.isOn() ? "ON" : "OFF")));
	         			 }
	         		 }
	         		 catch(Exception e) {
	         			 System.out.println("Invalid appliance type!");
	         		 }
		         }
		         case 3 -> {
		        	 List<String> offAppliances = applianceService.listAppliances().stream().filter(a -> !a.isOn()).map(a -> a.getName().toLowerCase()).collect(Collectors.toList());
		        	 if (offAppliances.isEmpty()) {
		        	        System.out.println("No appliances are OFF.");
		        	        break;
		        	    }
		        	 else {
		        		 System.out.println("Following appliances are OFF:");
		        		 offAppliances.forEach(e -> System.out.print(e+" "));
		        	 }
		        	 System.out.println();
		        	 System.out.print("Enter appliance name to TURN ON: ");
	                 String name = sc.nextLine();
	                 if(offAppliances.contains(name))
	                 applianceService.turnOn(name);
	                 else
	                	 System.out.println(name+" can't be turned ON");
		         }
		                 
		         case 4 -> {
		        	 List<String> onAppliances = applianceService.listAppliances().stream().filter(Appliance::isOn).map(a -> a.getName().toLowerCase()).collect(Collectors.toList());
		        	 if (onAppliances.isEmpty()) {
		        	        System.out.println("No appliances are ON.");
		        	        break;
		        	    }
		        	 else {
		        		 System.out.println("Following appliances are ON:");
		        		 onAppliances.forEach(e -> System.out.print(e+" "));
		        	 }
		        	 System.out.println();
		        	 System.out.print("Enter appliance name to TURN OFF: ");
	                 String name = sc.nextLine();
	                 if(onAppliances.contains(name))
	                 applianceService.turnOff(name);
	                 else
	                	 System.out.println(name+" can't be turned OFF");
		         }
		         case 5 -> {
		        	 	System.out.print("Enter appliance name: ");
	                    String name = sc.nextLine();
	                    System.out.print("Enter delay in seconds: ");
	                    int seconds = sc.nextInt();
	                    sc.nextLine();
	                    applianceService.scheduleAppliance(name, seconds);
		         }
		         case 6 -> {
		        	 System.out.println("Exiting SmartHome Controller.");
              		 System.exit(0);
		         }
		         default -> throw new IllegalArgumentException("Wrong choice entered!");
		         }
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
