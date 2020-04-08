package com.simulator.car.parts.door.state;

import com.simulator.car.parts.door.Doors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UnlockedState implements DoorState {
  private final Doors doors;

  public UnlockedState(Doors doors) {
    this.doors = doors;
  }

  @Override
  public void lock() {
    log.info("Lock doors");
    doors.setState(new LockedState(doors));
  };

  @Override
  public void unlock() {
    log.warn("Doors already unlocked");
  }
}
