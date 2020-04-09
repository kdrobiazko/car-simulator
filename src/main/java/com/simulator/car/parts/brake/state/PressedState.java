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
    log.warn("Brake is already pressed");
  }

  @Override
  public void release() {
    brake.changeState(new ReleasedState(brake));
    log.info("Brake released");
  }

  @Override
  public Brake.State getState() {
    return Brake.State.PRESSED;
  }
}
