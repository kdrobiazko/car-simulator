package com.simulator.car.state;

import com.simulator.car.parts.CarControls;

public class ParkedState extends CarState {

  public ParkedState(CarControls carControls) {
    super(carControls);
  }

  @Override
  public void stopEngine() {
    getCarControls().getEngine().stop();
    getCarControls().changeState(new UnlockedState(getCarControls()));
  }

  @Override
  public void startEngine() {
    getCarControls().getEngine().start();
  }

  @Override
  public void releaseBrake() {
    getCarControls().getBrake().release();
  }

  @Override
  public void pressBrake() {
    getCarControls().getBrake().press();
  }

  @Override
  public void pressAccelerator() {
    getCarControls().getAccelerator().press();
  }

  @Override
  public void releaseAccelerator() {
    getCarControls().getAccelerator().release();
  }

  @Override
  public void turnSteeringWheelLeft() {
    getCarControls().getSteeringWheel().left();
  }

  @Override
  public void turnSteeringWheelRight() {
    getCarControls().getSteeringWheel().right();
  }

  @Override
  public void turnSteeringWheelStraight() {
    getCarControls().getSteeringWheel().straight();
  }

  @Override
  public State getState() {
    return State.PARKED;
  }
}
