package com.simulator.car.parts.door.state;

import com.simulator.car.parts.door.Doors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LockedState implements DoorState {
  private final Doors doors;

  public LockedState(Doors doors) {
    this.doors = doors;
  }

  @Override
  public void lock() {
    log.warn("Doors already locked");
  }

  @Override
  public void unlock() {
    log.info("Unlock doors");
    doors.setState(new UnlockedState(doors));
  }
}
