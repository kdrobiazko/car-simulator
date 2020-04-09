package com.simulator.car.parts.engine.state;

import com.simulator.car.parts.engine.Engine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EngineStartedState implements EngineState {

  private final Engine engine;

  public EngineStartedState(Engine engine) {
    this.engine = engine;
  }

  public void start() {
    log.warn("Engine is already started");
  }

  public void stop() {
    engine.changeState(new EngineStoppedState(engine));
    log.info("Engine stopped");
  }

  @Override
  public State getState() {
    return State.STARTED;
  }
}
