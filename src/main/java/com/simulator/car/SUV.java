package com.simulator.car;

import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.accelerator.AcceleratorImpl;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.brake.BrakeImpl;
import com.simulator.car.parts.engine.Engine;
import com.simulator.car.parts.engine.EngineImpl;
import com.simulator.car.parts.swheel.SteeringWheel;
import com.simulator.car.parts.swheel.SteeringWheelImpl;
import com.simulator.car.parts.transmission.Transmission;
import com.simulator.car.parts.transmission.TransmissionImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SUV implements Car {
  private final Engine engine;
  private final SteeringWheel steeringWheel;
  private final Accelerator accelerator;
  private final Brake brake;
  private final Transmission transmission;

  public SUV() {
    engine = new EngineImpl();
    steeringWheel = new SteeringWheelImpl();
    accelerator = new AcceleratorImpl();
    brake = new BrakeImpl();
    transmission = new TransmissionImpl();
    log.info("SUV created");
  }

  @Override
  public void startEngine() {
    engine.start();
  }

  @Override
  public void stopEngine() {
    engine.stop();
  }

  @Override
  public void turnSteeringWheelLeft() {
    steeringWheel.left();
  }

  @Override
  public void turnSteeringWheelRight() {
    steeringWheel.right();
  }

  @Override
  public void turnSteeringWheelStraight() {
    steeringWheel.straight();
  }

  @Override
  public void openDoor() {}

  @Override
  public void closeDoor() {}

  @Override
  public void pressAccelerator() {
    accelerator.press();
  }

  @Override
  public void releaseAccelerator() {
    accelerator.release();
  }

  @Override
  public void pressBrake() {
    brake.press();
  }

  @Override
  public void releaseBrake() {
    brake.release();
  }

  @Override
  public void setDrive() {
    transmission.drive();
  }

  @Override
  public void setParking() {
    transmission.park();
  }

  @Override
  public void setReverse() {
    transmission.reverse();
  }
}
