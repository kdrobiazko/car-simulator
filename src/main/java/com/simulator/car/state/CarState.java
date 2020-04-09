package com.simulator.car.state;

import com.simulator.car.CarAPI;
import com.simulator.car.parts.Car;
import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.engine.state.EngineState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class CarState implements CarAPI {

  private final Car car;

  public CarState(Car car) {
    this.car = car;
  }

  protected Car getCar() {
    return car;
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
    car.getAccelerator().press();
  }

  public void releaseAccelerator() {
    car.getAccelerator().release();
  }

  public void pressBrake() {
    car.getBrake().press();
  }

  public void releaseBrake() {
    car.getBrake().release();
  }

  @Override
  public void setDrive() {
    Accelerator.State accState = getCar().getAccelerator().getState();
    Brake.State brakeState = getCar().getBrake().getState();
    EngineState.State engineState = getCar().getEngine().getState();

    if (EngineState.State.STARTED.equals(engineState)
        && Accelerator.State.RELEASED.equals(accState)
        && Brake.State.PRESSED.equals(brakeState)) {
      getCar().changeState(new DriveForwardState(getCar()));
      log.info("Transmission is set to Drive");
    } else {
      log.warn("To change transmission to Drive, start engine, release accelerator, press brake");
    }
  }

  @Override
  public void setParking() {
    Accelerator.State accState = getCar().getAccelerator().getState();
    Brake.State brakeState = getCar().getBrake().getState();
    EngineState.State engineState = getCar().getEngine().getState();

    if (EngineState.State.STARTED.equals(engineState)
        && Accelerator.State.RELEASED.equals(accState)
        && Brake.State.PRESSED.equals(brakeState)) {
      getCar().changeState(new ParkedState(getCar()));
      log.info("Transmission is set to Parking");
    } else {
      log.warn("To change transmission to Parking, start engine, release accelerator, press brake");
    }
  }

  @Override
  public void setReverse() {
    Accelerator.State accState = getCar().getAccelerator().getState();
    Brake.State brakeState = getCar().getBrake().getState();
    EngineState.State engineState = getCar().getEngine().getState();

    if (EngineState.State.STARTED.equals(engineState)
        && Accelerator.State.RELEASED.equals(accState)
        && Brake.State.PRESSED.equals(brakeState)) {
      getCar().changeState(new DriveReverseState(getCar()));
      log.info("Transmission is set to Reverse");
    } else {
      log.warn("To change transmission to Reverse, start engine, release accelerator, press brake");
    }
  }

  public void turnSteeringWheelLeft() {
    car.getSteeringWheel().left();
  }

  public void turnSteeringWheelRight() {
    car.getSteeringWheel().right();
  }

  public void turnSteeringWheelStraight() {
    car.getSteeringWheel().straight();
  }

  enum State {
    DRIVE_FORWARD,
    DRIVE_REVERSE,
    LOCKED,
    PARKED,
    UNLOCKED
  }
}
