package com.simulator.car.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CarState {

  protected String getStateName() {
    return getClass().getSimpleName();
  }

  public void unlockDoor() {
    log.error("Illegal operation for state: {}", getStateName());
  }

  public void lockDoor() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void startEngine() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void stopEngine() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void pressAccelerator() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void releaseAccelerator() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void pressBrake() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void releaseBrake() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void setDrive() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void setParking() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void setReverse() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void turnSteeringWheelLeft() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void turnSteeringWheelRight() {
    log.error("Illegal operation for state: {}", getStateName());
  };

  public void turnSteeringWheelStraight() {
    log.error("Illegal operation for state: {}", getStateName());
  };
}
