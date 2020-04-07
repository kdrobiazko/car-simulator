package com.simulator.car.parts.accelerator;

import com.simulator.car.parts.accelerator.state.AcceleratorState;
import com.simulator.car.parts.accelerator.state.ReleasedState;

public class AcceleratorImpl implements Accelerator {

  private AcceleratorState acceleratorState;

  public AcceleratorImpl() {
    acceleratorState = new ReleasedState(this);
  }

  @Override
  public void press() {
    acceleratorState.press();
  }

  @Override
  public void release() {
    acceleratorState.release();
  }

  @Override
  public void setState(AcceleratorState acceleratorState) {
    this.acceleratorState = acceleratorState;
  }
}
