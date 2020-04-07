package com.simulator.car.parts.swheel.state;

import com.simulator.car.parts.swheel.SteeringWheel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TurnedLeftState implements SteeringWheelState {

  private final SteeringWheel steeringWheel;

  public TurnedLeftState(SteeringWheel steeringWheel) {
    this.steeringWheel = steeringWheel;
  }

  @Override
  public void right() {
    log.info("Wheal turned right");
    steeringWheel.setState(new TurnedRightState(steeringWheel));
  }

  @Override
  public void left() {
    log.warn("Wheal already turned left");
  }

  @Override
  public void straight() {
    log.info("Wheal set to straight state");
    steeringWheel.setState(new StraightState(steeringWheel));
  }
}
