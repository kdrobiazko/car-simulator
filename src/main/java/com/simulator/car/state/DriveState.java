package com.simulator.car.state;

import com.simulator.car.parts.Car;
import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.swheel.SteeringWheel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class DriveState extends CarState {

  protected DriveState(Car car) {
    super(car);
  }

  @Override
  public void pressAccelerator() {
    SteeringWheel.State wheelState = getCar().getSteeringWheel().getState();
    if (SteeringWheel.State.LEFT.equals(wheelState)) {
      log.info("Car is moving left");
    } else if (SteeringWheel.State.RIGHT.equals(wheelState)) {
      log.info("Car is moving right");
    } else if (SteeringWheel.State.STRAIGHT.equals(wheelState)) {
      log.info("Car is moving straight");
    } else {
      log.error("Unsupported steering wheel state: {}", wheelState);
      return;
    }
    getCar().getAccelerator().press();
  }

  @Override
  public void releaseAccelerator() {
    getCar().getAccelerator().release();
  }

  @Override
  public void pressBrake() {
    getCar().getBrake().press();
    log.info("Car is stopped");
  }

  /*@Override
  public void setDrive() {
    Accelerator.State accState = getCar().getAccelerator().getState();
    Brake.State brakeState = getCar().getBrake().getState();

    if (Accelerator.State.RELEASED.equals(accState) && Brake.State.PRESSED.equals(brakeState)) {
      getCar().changeState(new DriveForwardState(getCar()));
      log.info("Transmission is set to Drive");
    } else {
      log.warn("To change transmission to Drive, release accelerator, press brake");
    }
  }

  @Override
  public void setParking() {
    Accelerator.State accState = getCar().getAccelerator().getState();
    Brake.State brakeState = getCar().getBrake().getState();

    if (Accelerator.State.RELEASED.equals(accState) && Brake.State.PRESSED.equals(brakeState)) {
      getCar().changeState(new ParkedState(getCar()));
      log.info("Transmission is set to Parking");
    } else {
      log.warn("To change transmission to Park, release accelerator, press brake");
    }
  }

  @Override
  public void setReverse() {
    Accelerator.State accState = getCar().getAccelerator().getState();
    Brake.State brakeState = getCar().getBrake().getState();

    if (Accelerator.State.RELEASED.equals(accState) && Brake.State.PRESSED.equals(brakeState)) {
      getCar().changeState(new DriveReverseState(getCar()));
      log.info("Transmission is set to Reverse");
    } else {
      log.warn("To change transmission to Reverse, release accelerator, press brake");
    }
  }*/

  @Override
  public void turnSteeringWheelLeft() {
    super.turnSteeringWheelLeft();
    if (Accelerator.State.PRESSED.equals(getCar().getAccelerator().getState())) {
      log.info("Car is moving left");
    }
  }

  @Override
  public void turnSteeringWheelRight() {
    super.turnSteeringWheelRight();
    if (Accelerator.State.PRESSED.equals(getCar().getAccelerator().getState())) {
      log.info("Car is moving right");
    }
  }

  @Override
  public void turnSteeringWheelStraight() {
    super.turnSteeringWheelStraight();
    if (Accelerator.State.PRESSED.equals(getCar().getAccelerator().getState())) {
      log.info("Car is moving straight");
    }
  }
}
