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
    log.warn("Steering wheal already in turned right");
  }

  @Override
  public void left() {
    steeringWheel.changeState(new TurnedLeftState(steeringWheel));
    log.info("Turned steering wheal left");
  }

  @Override
  public void straight() {
    steeringWheel.changeState(new StraightState(steeringWheel));
    log.info("Turned steering wheel to straight position");
  }

  @Override
  public SteeringWheel.State getState() {
    return SteeringWheel.State.RIGHT;
  }
}
