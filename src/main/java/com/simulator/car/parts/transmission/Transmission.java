package com.simulator.car.parts.transmission;

import com.simulator.car.parts.transmission.state.TransmissionState;

public interface Transmission {

  void drive();

  void park();

  void reverse();

  void changeState(TransmissionState newState);

  State getState();

  enum State {
    PARK,
    DRIVE,
    REVERSE
  }
}
