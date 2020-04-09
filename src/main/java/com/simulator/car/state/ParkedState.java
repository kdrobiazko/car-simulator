package com.simulator.car.state;

import com.simulator.car.parts.Car;

public class ParkedState extends CarState {
  private final Car car;

  public ParkedState(Car car) {
    this.car = car;
  }

  @Override
  public void stopEngine() {
    car.getEngine().stop();
    car.changeState(new UnlockedState(car));
  }

  @Override
  public void startEngine() {
    car.getEngine().start();
  }

  @Override
  public void setDrive() {
    car.getTransmission().drive();
    car.changeState(new DriveForwardState(car));
  }

  @Override
  public void setReverse() {
    car.getTransmission().reverse();
    car.changeState(new DriveReverseState(car));
  }

  @Override
  public void releaseBrake() {
    car.getBrake().release();
  }

  @Override
  public void pressBrake() {
    car.getBrake().press();
  }

  @Override
  public State getState() {
    return State.PARKED;
  }
}
