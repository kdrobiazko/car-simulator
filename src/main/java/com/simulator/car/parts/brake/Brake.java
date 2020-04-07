package com.simulator.car.parts.brake;

import com.simulator.car.parts.brake.state.BrakeState;

public interface Brake {

  void press();

  void release();

  void setState(BrakeState state);
}
