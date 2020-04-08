package com.simulator.car.state;

import com.simulator.car.parts.Car;

public class DriveForwardState extends CarState {

  private final Car car;

  public DriveForwardState(Car car) {
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
    car.setState(new StoppedState(car));
  }

  /* @Override
  public void releaseBrake() {
    car.getBrake().release();
  }*/

  @Override
  public State getState() {
    return State.DRIVE_FORWARD;
  }
}
