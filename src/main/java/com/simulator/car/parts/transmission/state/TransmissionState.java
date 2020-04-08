package com.simulator.car.parts.transmission.state;

import com.simulator.car.parts.transmission.Transmission;

public interface TransmissionState {
  void drive();

  void park();

  void reverse();

  Transmission.State getState();
}
