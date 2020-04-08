package com.simulator.car.parts.accelerator.state;

import com.simulator.car.parts.accelerator.Accelerator;

public interface AcceleratorState {

  void press();

  void release();

  Accelerator.State getState();
}
