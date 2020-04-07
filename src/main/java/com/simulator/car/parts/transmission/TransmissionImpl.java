package com.simulator.car.parts.transmission;

import com.simulator.car.parts.transmission.state.ParkState;
import com.simulator.car.parts.transmission.state.TransmissionState;

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
    this.transmissionState = state;
  }
}
