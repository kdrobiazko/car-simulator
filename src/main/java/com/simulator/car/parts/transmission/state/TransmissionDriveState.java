package com.simulator.car.parts.transmission.state;

import com.simulator.car.parts.transmission.Transmission;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransmissionDriveState implements TransmissionState {
  private final Transmission transmission;

  public TransmissionDriveState(Transmission transmission) {
    this.transmission = transmission;
  }

  @Override
  public void drive() {
    log.warn("Already in Drive");
  }

  @Override
  public void park() {
    transmission.changeState(new TransmissionParkState(transmission));
    log.info("Transmission is set to Park");
  }

  @Override
  public void reverse() {
    transmission.changeState(new TransmissionReverseState(transmission));
    log.info("Transmission is set to Reverse");
  }

  @Override
  public Transmission.State getState() {
    return Transmission.State.DRIVE;
  }
}
