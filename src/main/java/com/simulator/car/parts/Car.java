package com.simulator.car.parts;

import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.door.Doors;
import com.simulator.car.parts.engine.Engine;
import com.simulator.car.parts.swheel.SteeringWheel;
import com.simulator.car.parts.transmission.Transmission;
import com.simulator.car.state.CarState;

public interface Car {

  Accelerator getAccelerator();

  Brake getBrake();

  Doors getDoors();

  Engine getEngine();

  SteeringWheel getSteeringWheel();

  Transmission getTransmission();

  void changeState(CarState newState);
}
