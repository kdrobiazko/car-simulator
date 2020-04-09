package com.simulator.car.state;

import com.simulator.car.parts.Car;
import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.door.Doors;
import com.simulator.car.parts.engine.Engine;
import com.simulator.car.parts.engine.state.EngineState;
import com.simulator.car.parts.swheel.SteeringWheel;
import com.simulator.car.parts.transmission.Transmission;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;

public class LockedStateTest {

  @Mock private Accelerator accelerator;
  @Mock private Brake brake;
  @Mock private Car car;
  @Mock private Doors doors;
  @Mock private Engine engine;
  @Mock private SteeringWheel steeringWheel;
  @Mock private Transmission transmission;

  @InjectMocks private LockedState unit;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    Mockito.when(car.getAccelerator()).thenReturn(accelerator);
    Mockito.when(car.getBrake()).thenReturn(brake);
    Mockito.when(car.getDoors()).thenReturn(doors);
    Mockito.when(car.getEngine()).thenReturn(engine);
    Mockito.when(car.getSteeringWheel()).thenReturn(steeringWheel);
    Mockito.when(car.getTransmission()).thenReturn(transmission);
  }

  @Test
  public void unlockDoor() {
    unit.unlockDoor();

    Mockito.verify(car, times(1)).getDoors();
    Mockito.verify(car, times(1)).changeState(isA(UnlockedState.class));
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(doors, times(1)).unlock();
    Mockito.verifyNoMoreInteractions(doors);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void lockDoor() {
    unit.lockDoor();
    Mockito.verify(car, times(1)).getDoors();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void getState() {
    Assert.assertEquals(CarState.State.LOCKED, unit.getState());
  }

  @Test
  public void pressAccelerator() {
    unit.pressAccelerator();
    Mockito.verify(car, times(1)).getAccelerator();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(accelerator, times(1)).press();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void releaseAccelerator() {
    unit.releaseAccelerator();
    Mockito.verify(car, times(1)).getAccelerator();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(accelerator, times(1)).release();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void pressBrake() {
    unit.pressBrake();
    Mockito.verify(car, times(1)).getBrake();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(brake, times(1)).press();
    Mockito.verifyNoMoreInteractions(brake);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void releaseBrake() {
    unit.releaseBrake();
    Mockito.verify(car, times(1)).getBrake();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(brake, times(1)).release();
    Mockito.verifyNoMoreInteractions(brake);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void setDrive() {
    unit.setDrive();
    verifyNoChanges();
  }

  @Test
  public void setParking() {
    unit.setParking();
    verifyNoChanges();
  }

  @Test
  public void setReverse() {
    unit.setReverse();
    verifyNoChanges();
  }

  @Test
  public void stopEngine() {
    unit.stopEngine();
    verifyNoChanges();
  }

  @Test
  public void startEngine() {
    unit.startEngine();
    verifyNoChanges();
  }

  @Test
  public void turnSteeringWheelLeft() {
    unit.turnSteeringWheelLeft();
    verifyNoChanges();
  }

  @Test
  public void turnSteeringWheelRight() {
    unit.turnSteeringWheelRight();
    verifyNoChanges();
  }

  @Test
  public void turnSteeringWheelStraight() {
    unit.turnSteeringWheelStraight();
    verifyNoChanges();
  }

  private void verifyNoChanges() {
    Mockito.verifyZeroInteractions(car);
    Mockito.verifyZeroInteractions(doors);
  }
}
