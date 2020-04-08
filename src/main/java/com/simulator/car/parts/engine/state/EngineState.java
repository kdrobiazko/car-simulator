package com.simulator.car.parts.engine.state;

public interface EngineState {

  void start();

  void stop();

  State getState();

  enum State {
    STARTED,
    STOPPED
  }
}
