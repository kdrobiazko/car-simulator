package com.simulator.car.parts.door.state;

import com.simulator.car.parts.door.Doors;

public interface DoorsState {

  void lock();

  void unlock();

  Doors.State getState();
}
