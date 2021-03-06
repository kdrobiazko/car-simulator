package com.simulator.car;

import com.simulator.car.parts.CarControls;
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
public class SUV implements CarAPI, CarControls {

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

  public SUV(
      CarState carState,
      Doors doors,
      Engine engine,
      SteeringWheel steeringWheel,
      Accelerator accelerator,
      Brake brake,
      Transmission transmission) {
    this.carState = carState;
    this.doors = doors;
    this.engine = engine;
    this.steeringWheel = steeringWheel;
    this.accelerator = accelerator;
    this.brake = brake;
    this.transmission = transmission;
  }

  @Override
  public void changeState(CarState newState) {
    log.debug("State is changed from {} to {}", this.carState.getState(), newState.getState());
    this.carState = newState;
  }

  @Override
  public void startEngine() {
    log.info("Start engine");
    carState.startEngine();
  }

  @Override
  public void stopEngine() {
    log.info("Stop engine");
    carState.stopEngine();
  }

  @Override
  public void turnSteeringWheelLeft() {
    log.info("Turn steering wheel left");
    carState.turnSteeringWheelLeft();
  }

  @Override
  public void turnSteeringWheelRight() {
    log.info("Turn steering wheel right");
    carState.turnSteeringWheelRight();
  }

  @Override
  public void turnSteeringWheelStraight() {
    log.info("Turn steering wheel straight");
    carState.turnSteeringWheelStraight();
  }

  @Override
  public void unlockDoor() {
    log.info("Unlock door");
    carState.unlockDoor();
  }

  @Override
  public void lockDoor() {
    log.info("Lock door");
    carState.lockDoor();
  }

  @Override
  public void pressAccelerator() {
    log.info("Press accelerator");
    carState.pressAccelerator();
  }

  @Override
  public void releaseAccelerator() {
    log.info("Release accelerator");
    carState.releaseAccelerator();
  }

  @Override
  public void pressBrake() {
    log.info("Press brake");
    carState.pressBrake();
  }

  @Override
  public void releaseBrake() {
    log.info("Release brake");
    carState.releaseBrake();
  }

  @Override
  public void setDrive() {
    log.info("Set transmission to Drive");
    carState.setDrive();
  }

  @Override
  public void setParking() {
    log.info("Set transmission to Parking");
    carState.setParking();
  }

  @Override
  public void setReverse() {
    log.info("Set transmission to Reverse");
    carState.setReverse();
  }
}
