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
    transmission.changeState(new ParkState(transmission));
    log.info("Transmission is set to Park");
  }

  @Override
  public void reverse() {
    transmission.changeState(new ReverseState(transmission));
    log.info("Transmission is set to Reverse");
  }

  @Override
  public Transmission.State getState() {
    return Transmission.State.DRIVE;
  }
}
