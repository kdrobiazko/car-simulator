package com.simulator.car.parts.door;

import com.simulator.car.parts.door.state.DoorState;
import com.simulator.car.parts.door.state.LockedState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoorsImpl implements Doors {

  private DoorState state;

  public DoorsImpl() {
    state = new LockedState(this);
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
  public void setState(DoorState newState) {
    log.debug("State set from {} to {}", this.state.getState(), newState.getState());
    this.state = newState;
  }

  @Override
  public State getState() {
    return state.getState();
  }
}
