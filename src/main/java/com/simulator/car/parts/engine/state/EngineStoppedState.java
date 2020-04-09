package com.simulator.car.parts.engine.state;

import com.simulator.car.parts.engine.Engine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EngineStoppedState implements EngineState {

  private final Engine engine;

  public EngineStoppedState(Engine engine) {
    this.engine = engine;
  }

  public void start() {
    engine.changeState(new EngineStartedState(engine));
    log.info("Engine started");
  }

  public void stop() {
    log.warn("Engine already stopped");
  }

  @Override
  public State getState() {
    return State.STOPPED;
  }
}
