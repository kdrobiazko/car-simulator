package com.simulator.car.parts.brake;

import com.simulator.car.parts.brake.state.BrakeState;
import com.simulator.car.parts.brake.state.ReleasedState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BrakeImpl implements Brake {
  private BrakeState state;

  public BrakeImpl() {
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
  public void changeState(BrakeState newState) {
    log.debug("State is changed from {} to {}", state.getState(), newState.getState());
    this.state = newState;
  }

  @Override
  public State getState() {
    return state.getState();
  }
}
