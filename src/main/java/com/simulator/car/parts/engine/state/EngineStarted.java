package com.simulator.car.parts.engine.state;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EngineStarted implements EngineState {
  public void start() {
    log.warn("Engine already started");
  }

  public void stop() {
    log.info("Engine stopped");
  }
}
