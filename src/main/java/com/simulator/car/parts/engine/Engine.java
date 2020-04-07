package com.simulator.car.parts.engine;

import com.simulator.car.parts.engine.state.EngineState;

public interface Engine {
  void start();

  void stop();

  void setEngineState(EngineState engineState);
}
