package com.simulator.car.parts.door;

import com.simulator.car.parts.door.state.DoorsState;
import com.simulator.car.parts.door.state.DoorsLockedState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoorsImpl implements Doors {

  private DoorsState state;

  public DoorsImpl() {
    state = new DoorsLockedState(this);
  }

  @Override
  public void lock() {
    state.lock();
  }

  @Override
  public void unlock() {
    state.unlock();
  }

  @Override
  public void changeState(DoorsState newState) {
    log.debug("State is changed from {} to {}", this.state.getState(), newState.getState());
    this.state = newState;
  }

  @Override
  public State getState() {
    return state.getState();
  }
}
