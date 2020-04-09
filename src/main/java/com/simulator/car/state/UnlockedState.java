package com.simulator.car.state;

import com.simulator.car.parts.Car;

public class UnlockedState extends CarState {

  public UnlockedState(Car car) {
    super(car);
  }

  @Override
  public void startEngine() {
    getCar().getEngine().start();
    getCar().changeState(new ParkedState(getCar()));
  }

  @Override
  public void unlockDoor() {
    getCar().getDoors().unlock();
  }

  @Override
  public void lockDoor() {
    getCar().getDoors().lock();
    getCar().changeState(new LockedState(getCar()));
  }

  @Override
  public State getState() {
    return State.UNLOCKED;
  }
}
