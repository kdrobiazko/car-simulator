package com.simulator.car.parts.swheel;

import com.simulator.car.parts.swheel.state.SteeringWheelState;

public interface SteeringWheel {
  void left();

  void right();

  void straight();

  void setState(SteeringWheelState state);
}
