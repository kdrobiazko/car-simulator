package com.simulator.car.state;

import com.simulator.car.CarAPI;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CarState implements CarAPI {

  public abstract State getState();

  public void unlockDoor() {
    log.error("Illegal operation for state: {}", getState());
  }

  public void lockDoor() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void startEngine() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void stopEngine() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void pressAccelerator() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void releaseAccelerator() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void pressBrake() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void releaseBrake() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void setDrive() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void setParking() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void setReverse() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void turnSteeringWheelLeft() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void turnSteeringWheelRight() {
    log.error("Illegal operation for state: {}", getState());
  };

  public void turnSteeringWheelStraight() {
    log.error("Illegal operation for state: {}", getState());
  };

  enum State {
    DRIVE_FORWARD,
    DRIVE_REVERSE,
    LOCKED,
    PARKED,
    STOPPED,
    UNLOCKED
  }
}
