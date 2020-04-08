package com.simulator.car.state;

import com.simulator.car.Car;

public class LockedState extends CarState {

  private final Car car;

  public LockedState(Car car) {
    this.car = car;
  }

  @Override
  public void unlockDoor() {
    car.getDoors().unlock();
    car.setState(new UnlockedState(car));
  }

  @Override
  public void lockDoor() {
    car.getDoors().lock();
  }
}