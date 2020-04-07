package com.simulator.car.parts.swheel.state;

import com.simulator.car.parts.swheel.SteeringWheel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TurnedRightState implements SteeringWheelState {

  private final SteeringWheel steeringWheel;

  public TurnedRightState(SteeringWheel steeringWheel) {
    this.steeringWheel = steeringWheel;
  }

  @Override
  public void right() {
    log.warn("Wheal already in turned right");
  }

  @Override
  public void left() {
    log.info("Wheal turned left");
    steeringWheel.setState(new TurnedLeftState(steeringWheel));
  }

  @Override
  public void straight() {
    log.info("Wheel set straight position");
    steeringWheel.setState(new StraightState(steeringWheel));
  }
}
