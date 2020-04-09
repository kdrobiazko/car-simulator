package com.simulator.car.state;

import com.simulator.car.parts.Car;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DriveReverseState extends DriveState {

  public DriveReverseState(Car car) {
    super(car);
  }

  @Override
  public void pressAccelerator() {
    log.info("Car goes reverse");
    super.pressAccelerator();
  }

  @Override
  public State getState() {
    return State.DRIVE_REVERSE;
  }
}
