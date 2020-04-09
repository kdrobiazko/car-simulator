package com.simulator.car.state;

import com.simulator.car.parts.CarControls;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LockedState extends CarState {

  public LockedState(CarControls carControls) {
    super(carControls);
  }

  @Override
  public void unlockDoor() {
    getCarControls().getDoors().unlock();
    getCarControls().changeState(new UnlockedState(getCarControls()));
  }

  @Override
  public void lockDoor() {
    getCarControls().getDoors().lock();
  }

  @Override
  public State getState() {
    return State.LOCKED;
  }

  @Override
  public void setDrive() {
    log.error("Illegal operation for state: {}", getState());
  }

  @Override
  public void setParking() {
    log.error("Illegal operation for state: {}", getState());
  }

  @Override
  public void setReverse() {
    log.error("Illegal operation for state: {}", getState());
  }

  @Override
  public void turnSteeringWheelLeft() {
    log.error("Illegal operation for state: {}", getState());
  }

  @Override
  public void turnSteeringWheelRight() {
    log.error("Illegal operation for state: {}", getState());
  }

  @Override
  public void turnSteeringWheelStraight() {
    log.error("Illegal operation for state: {}", getState());
  }
}
