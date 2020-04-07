package com.simulator.car.parts.engine;

import com.simulator.car.parts.engine.state.EngineState;
import com.simulator.car.parts.engine.state.EngineStopped;

public class EngineImpl implements Engine {

  private EngineState engineState;

  public EngineImpl() {
    engineState = new EngineStopped(this);
  }

  @Override
  public void start() {
    engineState.start();
  }

  @Override
  public void stop() {
    engineState.stop();
  }

  public void setEngineState(EngineState engineState) {
    this.engineState = engineState;
  }
}
