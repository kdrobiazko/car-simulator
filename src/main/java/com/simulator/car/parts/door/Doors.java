package com.simulator.car.parts.door;

import com.simulator.car.parts.door.state.DoorState;

public interface Doors {

  void lock();

  void unlock();

  void setState(DoorState state);
}
