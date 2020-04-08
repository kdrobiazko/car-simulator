package com.simulator.car.parts.door.state;

import com.simulator.car.parts.door.Doors;

public interface DoorState {

  void lock();

  void unlock();

  Doors.State getState();
}
