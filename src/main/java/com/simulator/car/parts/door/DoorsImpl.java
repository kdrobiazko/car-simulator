package com.simulator.car.parts.door;

import com.simulator.car.parts.door.state.DoorState;
import com.simulator.car.parts.door.state.LockedState;

public class DoorsImpl implements Doors {

  private DoorState doorState;

  public DoorsImpl() {
    doorState = new LockedState(this);
  }

  @Override
  public void lock() {
    doorState.lock();
  }

  @Override
  public void unlock() {
    doorState.unlock();
  }

  @Override
  public void setState(DoorState state) {
    this.doorState = state;
  }
}
