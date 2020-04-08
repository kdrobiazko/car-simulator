package com.simulator.car;

import com.simulator.car.parts.Car;
import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.accelerator.AcceleratorImpl;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.brake.BrakeImpl;
import com.simulator.car.parts.door.Doors;
import com.simulator.car.parts.door.DoorsImpl;
import com.simulator.car.parts.engine.Engine;
import com.simulator.car.parts.engine.EngineImpl;
import com.simulator.car.parts.swheel.SteeringWheel;
import com.simulator.car.parts.swheel.SteeringWheelImpl;
import com.simulator.car.parts.transmission.Transmission;
import com.simulator.car.parts.transmission.TransmissionImpl;
import com.simulator.car.state.CarState;
import com.simulator.car.state.LockedState;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SUV implements CarAPI, Car {

  @Getter private final Doors doors;
  @Getter private final Engine engine;
  @Getter private final SteeringWheel steeringWheel;
  @Getter private final Accelerator accelerator;
  @Getter private final Brake brake;
  @Getter private final Transmission transmission;

  private CarState carState;

  public SUV() {
    doors = new DoorsImpl();
    engine = new EngineImpl();
    steeringWheel = new SteeringWheelImpl();
    accelerator = new AcceleratorImpl();
    brake = new BrakeImpl();
    transmission = new TransmissionImpl();

    carState = new LockedState(this);
    log.info("SUV created");
  }

  @Override
  public void changeState(CarState newState) {
    log.debug("State is changed from {} to {}", this.carState.getState(), newState.getState());
    this.carState = newState;
  }

  @Override
  public void startEngine() {
    carState.startEngine();
  }

  @Override
  public void stopEngine() {
    carState.stopEngine();
  }

  @Override
  public void turnSteeringWheelLeft() {
    carState.turnSteeringWheelLeft();
  }

  @Override
  public void turnSteeringWheelRight() {
    carState.turnSteeringWheelRight();
  }

  @Override
  public void turnSteeringWheelStraight() {
    carState.turnSteeringWheelStraight();
  }

  @Override
  public void unlockDoor() {
    carState.unlockDoor();
  }

  @Override
  public void lockDoor() {
    carState.lockDoor();
  }

  @Override
  public void pressAccelerator() {
    carState.pressAccelerator();
  }

  @Override
  public void releaseAccelerator() {
    carState.releaseAccelerator();
  }

  @Override
  public void pressBrake() {
    carState.pressBrake();
  }

  @Override
  public void releaseBrake() {
    carState.releaseBrake();
  }

  @Override
  public void setDrive() {
    carState.setDrive();
  }

  @Override
  public void setParking() {
    carState.setParking();
  }

  @Override
  public void setReverse() {
    carState.setReverse();
  }
}
