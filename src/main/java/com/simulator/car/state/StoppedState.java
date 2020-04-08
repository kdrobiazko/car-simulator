package com.simulator.car.state;

import com.simulator.car.Car;
import com.simulator.car.parts.transmission.Transmission;
import lombok.extern.slf4j.Slf4j;

import static com.simulator.car.parts.brake.Brake.State.RELEASED;

@Slf4j
public class StoppedState extends CarState {

  private final Car car;

  public StoppedState(Car car) {
    this.car = car;
  }

  @Override
  public void setParking() {
    car.getTransmission().park();
    car.setState(new ParkedState(car));
  }

  @Override
  public void setDrive() {
    car.getTransmission().drive();
  }

  @Override
  public void setReverse() {
    car.getTransmission().reverse();
  }

  @Override
  public void releaseBrake() {
    car.getBrake().release();
  }

  @Override
  public void pressAccelerator() {
    if (RELEASED.equals(car.getBrake().getState())) {}

    car.getAccelerator().press();
    Transmission.State transmissionState = car.getTransmission().getState();
    switch (transmissionState) {
      case DRIVE:
        car.setState(new DriveForwardState(car));
        break;
      case REVERSE:;
        car.setState(new DriveReverseState(car));
        break;
      default:
        log.warn("Unexpected transmission state: {}", transmissionState);
    }
  }

  @Override
  public void releaseAccelerator() {
    car.getAccelerator().release();
  }
}
