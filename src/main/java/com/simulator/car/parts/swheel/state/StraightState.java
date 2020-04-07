package com.simulator.car.parts.swheel.state;

import com.simulator.car.parts.swheel.SteeringWheel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StraightState implements SteeringWheelState {

  private final SteeringWheel steeringWheel;

  public StraightState(SteeringWheel steeringWheel) {
    this.steeringWheel = steeringWheel;
  }

  @Override
  public void right() {
    log.info("Turn wheel right");
    steeringWheel.setState(new TurnedRightState(steeringWheel));
  }

  @Override
  public void left() {
    log.info("Turn wheel left");
    steeringWheel.setState(new TurnedLeftState(steeringWheel));
  }

  @Override
  public void straight() {
    log.warn("Wheal already in straight state");
  }
}
