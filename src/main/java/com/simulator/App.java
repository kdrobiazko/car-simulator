package com.simulator;

import com.simulator.car.Car;
import com.simulator.car.SUV;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
  public static void main(String[] args) {
    log.info("Hello World!");
    Car car = new SUV();
    car.unlockDoor();
    car.startEngine();
    car.setDrive();
    car.pressAccelerator();
    car.releaseAccelerator();
    car.pressBrake();
    car.setParking();
    car.stopEngine();
    car.lockDoor();
  }
}
