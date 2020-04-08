package com.simulator.car;

import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.door.Doors;
import com.simulator.car.parts.engine.Engine;
import com.simulator.car.parts.transmission.Transmission;
import com.simulator.car.state.CarState;

public interface Car {

  Engine getEngine();

  Doors getDoors();

  Transmission getTransmission();

  Accelerator getAccelerator();

  Brake getBrake();

  void setState(CarState state);

  void unlockDoor();

  void lockDoor();

  void startEngine();

  void stopEngine();

  void pressAccelerator();

  void releaseAccelerator();

  void pressBrake();

  void releaseBrake();

  void setDrive();

  void setParking();

  void setReverse();

  void turnSteeringWheelLeft();

  void turnSteeringWheelRight();

  void turnSteeringWheelStraight();
}
