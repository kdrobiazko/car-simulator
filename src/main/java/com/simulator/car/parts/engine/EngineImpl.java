package com.simulator.car.parts.engine;

import com.simulator.car.parts.engine.state.EngineState;
import com.simulator.car.parts.engine.state.EngineStoppedState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EngineImpl implements Engine {

  private EngineState state;

  public EngineImpl() {
    state = new EngineStoppedState(this);
  }

  @Override
  public void start() {
    state.start();
  }

  @Override
  public void stop() {
    state.stop();
  }

  public void changeState(EngineState newState) {
    log.debug("State is changed from {} to {}", this.state.getState(), newState.getState());
    this.state = newState;
  }

  @Override
  public EngineState.State getState() {
    return state.getState();
  }
}
