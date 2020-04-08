package com.simulator.car.parts;

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
}
