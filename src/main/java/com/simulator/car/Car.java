package com.simulator.car;

public interface Car {
  void openDoor();

  void closeDoor();

  void startEngine();

  void stopEngine();

  void pressAccelerator();

  void releaseAccelerator();

  void pressBrake();

  void releaseBrake();

  void setDrive();

  void setParking();

  void setReverse();

  void turnSteeringWheelLeft();

  void turnSteeringWheelRight();

  void turnSteeringWheelStraight();
}
