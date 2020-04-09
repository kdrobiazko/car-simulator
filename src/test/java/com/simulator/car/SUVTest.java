package com.simulator.car;

import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.door.Doors;
import com.simulator.car.parts.engine.Engine;
import com.simulator.car.parts.swheel.SteeringWheel;
import com.simulator.car.parts.transmission.Transmission;
import com.simulator.car.state.CarState;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class SUVTest {

  @Mock private CarState carState;
  @Mock private Doors doors;
  @Mock private Engine engine;
  @Mock private SteeringWheel steeringWheel;
  @Mock private Accelerator accelerator;
  @Mock private Brake brake;
  @Mock private Transmission transmission;

  @InjectMocks private SUV unit;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @After
  public void tearDown() {
    Mockito.verifyNoMoreInteractions(carState);
  }

  @Test
  public void startEngine() {
    unit.startEngine();
    Mockito.verify(carState, Mockito.times(1)).startEngine();
  }

  @Test
  public void stopEngine() {
    unit.stopEngine();
    Mockito.verify(carState, Mockito.times(1)).stopEngine();
  }

  @Test
  public void turnSteeringWheelLeft() {
    unit.turnSteeringWheelLeft();
    Mockito.verify(carState, Mockito.times(1)).turnSteeringWheelLeft();
  }

  @Test
  public void turnSteeringWheelRight() {
    unit.turnSteeringWheelRight();
    Mockito.verify(carState, Mockito.times(1)).turnSteeringWheelRight();
  }

  @Test
  public void turnSteeringWheelStraight() {
    unit.turnSteeringWheelStraight();
    Mockito.verify(carState, Mockito.times(1)).turnSteeringWheelStraight();
  }

  @Test
  public void unlockDoor() {
    unit.unlockDoor();
    Mockito.verify(carState, Mockito.times(1)).unlockDoor();
  }

  @Test
  public void lockDoor() {
    unit.lockDoor();
    Mockito.verify(carState, Mockito.times(1)).lockDoor();
  }

  @Test
  public void pressAccelerator() {
    unit.pressAccelerator();
    Mockito.verify(carState, Mockito.times(1)).pressAccelerator();
  }

  @Test
  public void releaseAccelerator() {
    unit.releaseAccelerator();
    Mockito.verify(carState, Mockito.times(1)).releaseAccelerator();
  }

  @Test
  public void pressBrake() {
    unit.pressBrake();
    Mockito.verify(carState, Mockito.times(1)).pressBrake();
  }

  @Test
  public void releaseBrake() {
    unit.releaseBrake();
    Mockito.verify(carState, Mockito.times(1)).releaseBrake();
  }

  @Test
  public void setDrive() {
    unit.setDrive();
    Mockito.verify(carState, Mockito.times(1)).setDrive();
  }

  @Test
  public void setParking() {
    unit.setParking();
    Mockito.verify(carState, Mockito.times(1)).setParking();
  }

  @Test
  public void setReverse() {
    unit.setReverse();
    Mockito.verify(carState, Mockito.times(1)).setReverse();
  }

  @Test
  public void getDoors() {
    Assert.assertEquals(doors, unit.getDoors());
  }

  @Test
  public void getEngine() {
    Assert.assertEquals(doors, unit.getDoors());
  }

  @Test
  public void getSteeringWheel() {
    Assert.assertEquals(doors, unit.getDoors());
  }

  @Test
  public void getAccelerator() {
    Assert.assertEquals(accelerator, unit.getAccelerator());
  }

  @Test
  public void getBrake() {
    Assert.assertEquals(brake, unit.getBrake());
  }

  @Test
  public void getTransmission() {
    Assert.assertEquals(transmission, unit.getTransmission());
  }
}
