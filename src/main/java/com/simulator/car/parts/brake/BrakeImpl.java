package com.simulator.car.parts.brake;

import com.simulator.car.parts.brake.state.BrakeState;
import com.simulator.car.parts.brake.state.ReleasedState;

public class BrakeImpl implements Brake {
  private BrakeState brakeState;

  public BrakeImpl() {
    brakeState = new ReleasedState(this);
  }

  @Override
  public void press() {
    brakeState.press();
  }

  @Override
  public void release() {
    brakeState.release();
  }

  @Override
  public void setState(BrakeState brakeState) {
    this.brakeState = brakeState;
  }
}
