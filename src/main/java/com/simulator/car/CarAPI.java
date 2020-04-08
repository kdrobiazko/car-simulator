package com.simulator.car;

public interface CarAPI {

  void unlockDoor();

  void lockDoor();

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
