package com.simulator.car.parts.swheel;

import com.simulator.car.parts.swheel.state.SteeringWheelState;
import com.simulator.car.parts.swheel.state.StraightState;

public class SteeringWheelImpl implements SteeringWheel {

  private SteeringWheelState state;

  public SteeringWheelImpl() {
    this.state = new StraightState(this);
  }

  @Override
  public void left() {
    state.left();
  }

  @Override
  public void right() {
    state.right();
  }

  @Override
  public void straight() {
    state.straight();
  }

  @Override
  public void setState(SteeringWheelState state) {}
}
