package com.simulator.car.state;

import com.simulator.car.parts.CarControls;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DriveForwardState extends DriveState {

  public DriveForwardState(CarControls carControls) {
    super(carControls);
  }

  @Override
  public void pressAccelerator() {
    log.info("Car goes forward");
    super.pressAccelerator();
  }

  @Override
  public State getState() {
    return State.DRIVE_FORWARD;
  }
}
