package com.simulator.car.parts.engine;

import com.simulator.car.parts.engine.state.EngineState;
import com.simulator.car.parts.engine.state.EngineStopped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EngineImpl implements Engine {

  private EngineState state;

  public EngineImpl() {
    state = new EngineStopped(this);
  }

  @Override
  public void start() {
    state.start();
  }

  @Override
  public void stop() {
    state.stop();
  }

  public void setState(EngineState newState) {
    log.debug("State set from {} to {}", this.state.getState(), newState.getState());
    this.state = newState;
  }

  @Override
  public EngineState.State getState() {
    return state.getState();
  }
}
