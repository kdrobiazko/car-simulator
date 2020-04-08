package com.simulator.car.parts.transmission;

import com.simulator.car.parts.transmission.state.TransmissionState;

public interface Transmission {

  void drive();

  void park();

  void reverse();

  void setState(TransmissionState state);

  State getState();

  enum State {
    PARK,
    DRIVE,
    REVERSE
  }
}
