package com.simulator.car.parts.transmission.state;

import com.simulator.car.parts.transmission.Transmission;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReverseState implements TransmissionState {
  private final Transmission transmission;

  public ReverseState(Transmission transmission) {
    this.transmission = transmission;
  }

  @Override
  public void drive() {
    transmission.changeState(new DriveState(transmission));
    log.info("Transmission is set to Drive");
  }

  @Override
  public void park() {
    transmission.changeState(new ParkState(transmission));
    log.info("Transmission is set to Park");
  }

  @Override
  public void reverse() {
    log.warn("Already in Reverse");
  }

  @Override
  public Transmission.State getState() {
    return Transmission.State.REVERSE;
  }
}
