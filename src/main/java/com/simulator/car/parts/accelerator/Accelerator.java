package com.simulator.car.parts.accelerator;

import com.simulator.car.parts.accelerator.state.AcceleratorState;

public interface Accelerator {
  void press();

  void release();

  void changeState(AcceleratorState newState);

  State getState();

  enum State {
    PRESSED,
    RELEASED
  }
}
