package com.simulator.car.parts.brake.state;

import com.simulator.car.parts.brake.Brake;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReleasedState implements BrakeState {
  private final Brake brake;

  public ReleasedState(Brake brake) {
    this.brake = brake;
  }

  @Override
  public void press() {
    brake.changeState(new PressedState(brake));
    log.info("Brake is pressed");
  }

  @Override
  public void release() {
    log.warn("Brake is already released");
  }

  @Override
  public Brake.State getState() {
    return Brake.State.RELEASED;
  }
}
