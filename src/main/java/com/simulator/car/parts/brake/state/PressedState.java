package com.simulator.car.parts.brake.state;

import com.simulator.car.parts.brake.Brake;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PressedState implements BrakeState {

  private final Brake brake;

  public PressedState(Brake brake) {
    this.brake = brake;
  }

  @Override
  public void press() {
    log.warn("Brake already pressed");
  }

  @Override
  public void release() {
    log.info("Brake released");
    brake.setState(new ReleasedState(brake));
  }

  @Override
  public Brake.State getState() {
    return Brake.State.PRESSED;
  }
}
