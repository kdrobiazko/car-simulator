package com.simulator.car.parts.transmission.state;

import com.simulator.car.parts.transmission.Transmission;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DriveState implements TransmissionState {
  private final Transmission transmission;

  public DriveState(Transmission transmission) {
    this.transmission = transmission;
  }

  @Override
  public void drive() {
    log.warn("Already in Drive");
  }

  @Override
  public void park() {
    log.info("Transmission is set to Park");
    transmission.setState(new ParkState(transmission));
  }

  @Override
  public void reverse() {
    log.info("Transmission is set to Reverse");
    transmission.setState(new ReverseState(transmission));
  }

  @Override
  public Transmission.State getState() {
    return Transmission.State.DRIVE;
  }
}
