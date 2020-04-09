package com.simulator.car.parts.door.state;

import com.simulator.car.parts.door.Doors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoorsUnlockedState implements DoorsState {
  private final Doors doors;

  public DoorsUnlockedState(Doors doors) {
    this.doors = doors;
  }

  @Override
  public void lock() {
    doors.changeState(new DoorsLockedState(doors));
    log.info("Door is locked");
  }

  @Override
  public void unlock() {
    log.warn("Doors already unlocked");
  }

  @Override
  public Doors.State getState() {
    return Doors.State.UNLOCKED;
  }
}
