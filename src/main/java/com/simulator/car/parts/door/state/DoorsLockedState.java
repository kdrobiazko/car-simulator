package com.simulator.car.parts.door.state;

import com.simulator.car.parts.door.Doors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoorsLockedState implements DoorsState {
  private final Doors doors;

  public DoorsLockedState(Doors doors) {
    this.doors = doors;
  }

  @Override
  public void lock() {
    log.warn("Door is already locked");
  }

  @Override
  public void unlock() {
    doors.changeState(new DoorsUnlockedState(doors));
    log.info("Door is unlocked");
  }

  @Override
  public Doors.State getState() {
    return Doors.State.LOCKED;
  }
}
