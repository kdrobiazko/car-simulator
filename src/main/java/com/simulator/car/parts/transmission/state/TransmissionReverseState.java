package com.simulator.car.parts.transmission.state;

import com.simulator.car.parts.transmission.Transmission;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransmissionReverseState implements TransmissionState {
  private final Transmission transmission;

  public TransmissionReverseState(Transmission transmission) {
    this.transmission = transmission;
  }

  @Override
  public void drive() {
    transmission.changeState(new TransmissionDriveState(transmission));
    log.info("Transmission is set to Drive");
  }

  @Override
  public void park() {
    transmission.changeState(new TransmissionParkState(transmission));
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
