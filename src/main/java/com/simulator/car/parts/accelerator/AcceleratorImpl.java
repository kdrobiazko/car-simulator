package com.simulator.car.parts.accelerator;

import com.simulator.car.parts.accelerator.state.AcceleratorState;
import com.simulator.car.parts.accelerator.state.ReleasedState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AcceleratorImpl implements Accelerator {

  private AcceleratorState state;

  public AcceleratorImpl() {
    state = new ReleasedState(this);
  }

  @Override
  public void press() {
    state.press();
  }

  @Override
  public void release() {
    state.release();
  }

  @Override
  public void changeState(AcceleratorState newState) {
    log.debug("State is changed from {} to {}", this.state.getState(), newState.getState());
    this.state = newState;
  }

  @Override
  public State getState() {
    return state.getState();
  }
}
