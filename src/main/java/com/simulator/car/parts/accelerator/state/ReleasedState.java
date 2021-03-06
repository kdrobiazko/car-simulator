package com.simulator.car.parts.accelerator.state;

import com.simulator.car.parts.accelerator.Accelerator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReleasedState implements AcceleratorState {
  private final Accelerator accelerator;

  public ReleasedState(Accelerator accelerator) {
    this.accelerator = accelerator;
  }

  @Override
  public void press() {
    accelerator.changeState(new PressedState(accelerator));
    log.info("Accelerator pressed");
  }

  @Override
  public void release() {
    log.warn("Accelerator already released");
  }

  @Override
  public Accelerator.State getState() {
    return Accelerator.State.RELEASED;
  }
}
