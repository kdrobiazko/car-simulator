package com.simulator.car.state;

import com.simulator.car.parts.CarControls;

public class UnlockedState extends CarState {

  public UnlockedState(CarControls carControls) {
    super(carControls);
  }

  @Override
  public void startEngine() {
    getCarControls().getEngine().start();
    getCarControls().changeState(new ParkedState(getCarControls()));
  }

  @Override
  public void unlockDoor() {
    getCarControls().getDoors().unlock();
  }

  @Override
  public void lockDoor() {
    getCarControls().getDoors().lock();
    getCarControls().changeState(new LockedState(getCarControls()));
  }

  @Override
  public State getState() {
    return State.UNLOCKED;
  }
}
