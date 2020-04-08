package com.simulator.car.state;

import com.simulator.car.Car;

public class ParkedState extends CarState {
  private final Car car;

  public ParkedState(Car car) {
    this.car = car;
  }

  @Override
  public void stopEngine() {
    car.getEngine().stop();
    car.setState(new UnlockedState(car));
  }

  @Override
  public void startEngine() {
    car.getEngine().start();
  }

  @Override
  public void setDrive() {
    car.getTransmission().drive();
    car.setState(new StoppedState(car));
  }

  @Override
  public void setReverse() {
    car.getTransmission().reverse();
    car.setState(new StoppedState(car));
  }
}
