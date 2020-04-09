package com.simulator.car.parts.accelerator.state;

import com.simulator.car.parts.accelerator.Accelerator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PressedState implements AcceleratorState {

  private final Accelerator accelerator;

  public PressedState(Accelerator accelerator) {
    this.accelerator = accelerator;
  }

  @Override
  public void press() {
    log.warn("Accelerator already pressed");
  }

  @Override
  public void release() {
    accelerator.changeState(new ReleasedState(accelerator));
    log.info("Accelerator released");
  }

  @Override
  public Accelerator.State getState() {
    return Accelerator.State.PRESSED;
  }
}
