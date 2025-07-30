# SmartHome Controller – Spring Core Console App

A Java-based console application simulating smart appliance control using **Spring Core**. Demonstrates key features like IoC, Dependency Injection, annotation-driven configuration, and dynamic bean retrieval using `ApplicationContext.getBean()`.

## 🚀 Features

- Add and manage smart appliances (e.g., Light, Fan, AC)
- Turn appliances **on/off** with state filtering
- Schedule appliance operations
- Console-based interactive menu with clear navigation

## 🧠 Tech Stack

- Java 17+
- Spring Core (100% Annotation-based)
- Maven (for build and dependency management)

## 🛠 How to Run

```bash
# Compile and run
mvn clean install
java -cp target/SmartHomeController.jar com.kk.main.SmartHomeAppliance
