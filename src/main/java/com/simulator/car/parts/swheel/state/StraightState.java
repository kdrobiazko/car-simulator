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
    steeringWheel.changeState(new TurnedRightState(steeringWheel));
    log.info("Turned steering wheel right");
  }

  @Override
  public void left() {
    steeringWheel.changeState(new TurnedLeftState(steeringWheel));
    log.info("Turned steering wheel left");
  }

  @Override
  public void straight() {
    log.warn("Steering wheal already in straight state");
  }

  @Override
  public SteeringWheel.State getState() {
    return SteeringWheel.State.STRAIGHT;
  }
}
