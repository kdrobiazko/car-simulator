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
    log.info("Transmission is set to Drive");
    transmission.changeState(new DriveState(transmission));
  }

  @Override
  public void park() {
    log.warn("Already in Park state");
  }

  @Override
  public void reverse() {
    log.info("Set transmission in reverse state");
    transmission.changeState(new ReverseState(transmission));
  }

  @Override
  public Transmission.State getState() {
    return Transmission.State.PARK;
  }
}
