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
    steeringWheel.changeState(new TurnedRightState(steeringWheel));
    log.info("Turned steering wheel right");
  }

  @Override
  public void left() {
    log.warn("Steering wheal already turned left");
  }

  @Override
  public void straight() {
    steeringWheel.changeState(new StraightState(steeringWheel));
    log.info("Turned steering wheal to straight state");
  }

  @Override
  public SteeringWheel.State getState() {
    return SteeringWheel.State.LEFT;
  }
}
