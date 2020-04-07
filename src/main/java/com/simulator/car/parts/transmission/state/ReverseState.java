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
    log.info("Set transmission in drive state");
    transmission.setState(new DriveState(transmission));
  }

  @Override
  public void park() {
    log.info("Set transmission in park state");
    transmission.setState(new ParkState(transmission));
  }

  @Override
  public void reverse() {
    log.warn("Already in reverse state");
  }
}
