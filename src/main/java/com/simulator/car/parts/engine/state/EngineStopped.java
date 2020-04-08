package com.simulator.car.parts.engine.state;

import com.simulator.car.parts.engine.Engine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EngineStopped implements EngineState {

  private Engine engine;

  public EngineStopped(Engine engine) {
    this.engine = engine;
  }

  public void start() {
    log.info("Engine started");
    engine.changeState(new EngineStarted());
  }

  public void stop() {
    log.warn("Engine already stopped");
  }

  @Override
  public State getState() {
    return State.STOPPED;
  }
}
