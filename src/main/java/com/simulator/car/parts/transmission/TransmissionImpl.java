package com.simulator.car.parts.transmission;

import com.simulator.car.parts.transmission.state.ParkState;
import com.simulator.car.parts.transmission.state.TransmissionState;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TransmissionImpl implements Transmission {
  private TransmissionState transmissionState;

  public TransmissionImpl() {
    transmissionState = new ParkState(this);
  }

  @Override
  public void drive() {
    transmissionState.drive();
  }

  @Override
  public void park() {
    transmissionState.park();
  }

  @Override
  public void reverse() {
    transmissionState.reverse();
  }

  @Override
  public void setState(TransmissionState state) {
    log.debug(
        "Transmission state changed from {} to {}", transmissionState.getState(), state.getState());
    this.transmissionState = state;
  }

  @Override
  public State getState() {
    return transmissionState.getState();
  }
}
