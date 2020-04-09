package com.simulator.car.parts.swheel.state;

import com.simulator.car.parts.swheel.SteeringWheel;

public interface SteeringWheelState {

  void right();

  void left();

  void straight();

  SteeringWheel.State getState();
}
