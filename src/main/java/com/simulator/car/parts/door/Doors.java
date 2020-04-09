package com.simulator.car.parts.door;

import com.simulator.car.parts.door.state.DoorsState;

public interface Doors {

  void lock();

  void unlock();

  void changeState(DoorsState state);

  State getState();

  enum State {
    LOCKED,
    UNLOCKED
  }
}
