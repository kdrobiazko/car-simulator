package com.simulator.car.state;

import com.simulator.car.parts.Car;

public class ParkedState extends CarState {

  public ParkedState(Car car) {
    super(car);
  }

  @Override
  public void stopEngine() {
    getCar().getEngine().stop();
    getCar().changeState(new UnlockedState(getCar()));
  }

  @Override
  public void startEngine() {
    getCar().getEngine().start();
  }

  @Override
  public void releaseBrake() {
    getCar().getBrake().release();
  }

  @Override
  public void pressBrake() {
    getCar().getBrake().press();
  }

  @Override
  public void pressAccelerator() {
    getCar().getAccelerator().press();
  }

  @Override
  public void releaseAccelerator() {
    getCar().getAccelerator().release();
  }

  @Override
  public void turnSteeringWheelLeft() {
    getCar().getSteeringWheel().left();
  }

  @Override
  public void turnSteeringWheelRight() {
    getCar().getSteeringWheel().right();
  }

  @Override
  public void turnSteeringWheelStraight() {
    getCar().getSteeringWheel().straight();
  }

  @Override
  public State getState() {
    return State.PARKED;
  }
}
