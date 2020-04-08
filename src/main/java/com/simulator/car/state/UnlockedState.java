package com.simulator.car.state;

import com.simulator.car.parts.Car;

public class UnlockedState extends CarState {

  private final Car car;

  public UnlockedState(Car car) {
    this.car = car;
  }

  @Override
  public void startEngine() {
    car.getEngine().start();
    car.setState(new ParkedState(car));
  }

  @Override
  public void unlockDoor() {
    car.getDoors().unlock();
  }

  @Override
  public void lockDoor() {
    car.getDoors().lock();
    car.setState(new LockedState(car));
  }

  @Override
  public State getState() {
    return State.UNLOCKED;
  }
}
