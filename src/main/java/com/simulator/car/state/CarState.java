package com.simulator.car.state;

import com.simulator.car.CarAPI;
import com.simulator.car.parts.CarControls;
import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.engine.state.EngineState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CarState implements CarAPI {

  private final CarControls carControls;

  public CarState(CarControls carControls) {
    this.carControls = carControls;
  }

  protected CarControls getCarControls() {
    return carControls;
  }

  public abstract State getState();

  public void unlockDoor() {
    log.error("Illegal operation for state: {}", getState());
  }

  public void lockDoor() {
    log.error("Illegal operation for state: {}", getState());
  }

  public void startEngine() {
    log.error("Illegal operation for state: {}", getState());
  }

  public void stopEngine() {
    log.error("Illegal operation for state: {}", getState());
  }

  public void pressAccelerator() {
    carControls.getAccelerator().press();
  }

  public void releaseAccelerator() {
    carControls.getAccelerator().release();
  }

  public void pressBrake() {
    carControls.getBrake().press();
  }

  public void releaseBrake() {
    carControls.getBrake().release();
  }

  @Override
  public void setDrive() {
    Accelerator.State accState = getCarControls().getAccelerator().getState();
    Brake.State brakeState = getCarControls().getBrake().getState();
    EngineState.State engineState = getCarControls().getEngine().getState();

    if (EngineState.State.STARTED.equals(engineState)
        && Accelerator.State.RELEASED.equals(accState)
        && Brake.State.PRESSED.equals(brakeState)) {
      getCarControls().changeState(new DriveForwardState(getCarControls()));
      getCarControls().getTransmission().drive();
      log.info("Transmission is set to Drive");
    } else {
      log.error("To change transmission to Drive, start engine, release accelerator, press brake");
    }
  }

  @Override
  public void setParking() {
    Accelerator.State accState = getCarControls().getAccelerator().getState();
    Brake.State brakeState = getCarControls().getBrake().getState();
    EngineState.State engineState = getCarControls().getEngine().getState();

    if (EngineState.State.STARTED.equals(engineState)
        && Accelerator.State.RELEASED.equals(accState)
        && Brake.State.PRESSED.equals(brakeState)) {
      getCarControls().changeState(new ParkedState(getCarControls()));
      getCarControls().getTransmission().park();
      log.info("Transmission is set to Parking");
    } else {
      log.error(
          "To change transmission to Parking, start engine, release accelerator, press brake");
    }
  }

  @Override
  public void setReverse() {
    Accelerator.State accState = getCarControls().getAccelerator().getState();
    Brake.State brakeState = getCarControls().getBrake().getState();
    EngineState.State engineState = getCarControls().getEngine().getState();

    if (EngineState.State.STARTED.equals(engineState)
        && Accelerator.State.RELEASED.equals(accState)
        && Brake.State.PRESSED.equals(brakeState)) {
      getCarControls().changeState(new DriveReverseState(getCarControls()));
      getCarControls().getTransmission().reverse();
      log.info("Transmission is set to Reverse");
    } else {
      log.error(
          "To change transmission to Reverse, start engine, release accelerator, press brake");
    }
  }

  public void turnSteeringWheelLeft() {
    carControls.getSteeringWheel().left();
  }

  public void turnSteeringWheelRight() {
    carControls.getSteeringWheel().right();
  }

  public void turnSteeringWheelStraight() {
    carControls.getSteeringWheel().straight();
  }

  enum State {
    DRIVE_FORWARD,
    DRIVE_REVERSE,
    LOCKED,
    PARKED,
    UNLOCKED
  }
}
