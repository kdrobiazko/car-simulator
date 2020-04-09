package com.simulator;

import com.simulator.car.CarAPI;
import com.simulator.car.SUV;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {
  public static void main(String[] args) {
    CarAPI car = new SUV();

    car.unlockDoor();
    car.startEngine();
    car.setDrive();
    car.pressBrake();
    car.setDrive();
    car.pressAccelerator();
    car.turnSteeringWheelLeft();
    car.releaseAccelerator();
    car.turnSteeringWheelStraight();
    car.pressBrake();
    car.setParking();
    car.releaseBrake();
    car.setReverse();
    car.pressAccelerator();
    car.releaseAccelerator();
    car.pressBrake();
    car.setParking();
    car.stopEngine();
    car.lockDoor();
  }
}
