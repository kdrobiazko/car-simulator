package com.simulator.car.parts.transmission.state;

import com.simulator.car.parts.transmission.Transmission;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParkState implements TransmissionState {
  private final Transmission transmission;

  public ParkState(Transmission transmission) {
    this.transmission = transmission;
  }

  @Override
  public void drive() {
    transmission.changeState(new DriveState(transmission));
    log.info("Transmission is set to Drive");
  }

  @Override
  public void park() {
    log.warn("Already in Park");
  }

  @Override
  public void reverse() {
    transmission.changeState(new ReverseState(transmission));
    log.info("Transmission is set to Reverse");
  }

  @Override
  public Transmission.State getState() {
    return Transmission.State.PARK;
  }
}
