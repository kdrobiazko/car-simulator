package com.simulator.car.state;

import com.simulator.car.parts.Car;

public abstract class DriveState extends CarState {
  private final Car car;

  protected DriveState(Car car) {
    this.car = car;
  }

  @Override
  public void pressAccelerator() {
    car.getAccelerator().press();
  }

  @Override
  public void releaseAccelerator() {
    car.getAccelerator().release();
  }

  @Override
  public void pressBrake() {
    car.getBrake().press();
    car.changeState(new StoppedState(car));
  }

  @Override
  public void releaseBrake() {
    car.getBrake().release();
  }

  protected Car getCar() {
    return car;
  }
}
