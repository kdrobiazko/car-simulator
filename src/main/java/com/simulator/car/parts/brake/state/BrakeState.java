package com.simulator.car.parts.brake.state;

import com.simulator.car.parts.brake.Brake;

public interface BrakeState {

  void press();

  void release();

  Brake.State getState();
}
