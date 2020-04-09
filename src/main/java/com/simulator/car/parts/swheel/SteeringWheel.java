package com.simulator.car.parts.swheel;

import com.simulator.car.parts.swheel.state.SteeringWheelState;

public interface SteeringWheel {
  void left();

  void right();

  void straight();

  void changeState(SteeringWheelState state);

  State getState();

  enum State {
    LEFT,
    RIGHT,
    STRAIGHT
  }
}
