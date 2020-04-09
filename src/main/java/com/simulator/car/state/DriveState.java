package com.simulator.car.state;

import com.simulator.car.parts.CarControls;
import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.swheel.SteeringWheel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class DriveState extends CarState {

  protected DriveState(CarControls carControls) {
    super(carControls);
  }

  @Override
  public void pressAccelerator() {
    SteeringWheel.State wheelState = getCarControls().getSteeringWheel().getState();
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
    getCarControls().getAccelerator().press();
  }

  @Override
  public void releaseAccelerator() {
    getCarControls().getAccelerator().release();
  }

  @Override
  public void pressBrake() {
    getCarControls().getBrake().press();
    log.info("Car is stopped");
  }

  @Override
  public void turnSteeringWheelLeft() {
    super.turnSteeringWheelLeft();
    if (Accelerator.State.PRESSED.equals(getCarControls().getAccelerator().getState())) {
      log.info("Car is moving left");
    }
  }

  @Override
  public void turnSteeringWheelRight() {
    super.turnSteeringWheelRight();
    if (Accelerator.State.PRESSED.equals(getCarControls().getAccelerator().getState())) {
      log.info("Car is moving right");
    }
  }

  @Override
  public void turnSteeringWheelStraight() {
    super.turnSteeringWheelStraight();
    if (Accelerator.State.PRESSED.equals(getCarControls().getAccelerator().getState())) {
      log.info("Car is moving straight");
    }
  }
}
