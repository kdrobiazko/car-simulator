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

public class ParkedStateTest {

  @Mock private Accelerator accelerator;
  @Mock private Brake brake;
  @Mock private Car car;
  @Mock private Doors doors;
  @Mock private Engine engine;
  @Mock private SteeringWheel steeringWheel;
  @Mock private Transmission transmission;

  @InjectMocks private ParkedState unit;

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
  public void stopEngine() {
    unit.stopEngine();
    Mockito.verify(engine, times(1)).stop();
    Mockito.verifyNoMoreInteractions(engine);
    Mockito.verify(car, times(1)).getEngine();
    Mockito.verify(car, times(1)).changeState(isA(UnlockedState.class));
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void startEngine() {
    unit.startEngine();
    Mockito.verify(car, times(1)).getEngine();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(engine, times(1)).start();
    Mockito.verifyNoMoreInteractions(engine);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void setDrive() {
    Mockito.when(accelerator.getState()).thenReturn(Accelerator.State.RELEASED);
    Mockito.when(brake.getState()).thenReturn(Brake.State.RELEASED);
    Mockito.when(engine.getState()).thenReturn(EngineState.State.STOPPED);

    unit.setDrive();

    Mockito.verify(accelerator, times(1)).getState();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verify(brake, times(1)).getState();
    Mockito.verifyNoMoreInteractions(brake);
    Mockito.verify(engine, times(1)).getState();
    Mockito.verifyNoMoreInteractions(engine);
  }

  @Test
  public void setReverse() {
    Mockito.when(accelerator.getState()).thenReturn(Accelerator.State.RELEASED);
    Mockito.when(brake.getState()).thenReturn(Brake.State.RELEASED);
    Mockito.when(engine.getState()).thenReturn(EngineState.State.STOPPED);

    unit.setReverse();

    Mockito.verify(accelerator, times(1)).getState();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verify(brake, times(1)).getState();
    Mockito.verifyNoMoreInteractions(brake);
    Mockito.verify(engine, times(1)).getState();
    Mockito.verifyNoMoreInteractions(engine);
  }

  @Test
  public void pressBrake() {
    unit.pressBrake();
    Mockito.verify(car, times(1)).getBrake();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(brake, times(1)).press();
    Mockito.verifyNoMoreInteractions(brake);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(doors);
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
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void pressAccelerator() {
    unit.pressAccelerator();
    Mockito.verify(car, times(1)).getAccelerator();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(accelerator, times(1)).press();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(doors);
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
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
    Mockito.verifyZeroInteractions(steeringWheel);
  }

  @Test
  public void setParking() {
    Mockito.when(accelerator.getState()).thenReturn(Accelerator.State.RELEASED);
    Mockito.when(brake.getState()).thenReturn(Brake.State.RELEASED);
    Mockito.when(engine.getState()).thenReturn(EngineState.State.STOPPED);

    unit.setParking();

    Mockito.verify(accelerator, times(1)).getState();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verify(brake, times(1)).getState();
    Mockito.verifyNoMoreInteractions(brake);
    Mockito.verify(engine, times(1)).getState();
    Mockito.verifyNoMoreInteractions(engine);
  }

  @Test
  public void getState() {
    Assert.assertEquals(CarState.State.PARKED, unit.getState());
  }

  @Test
  public void turnSteeringWheelLeft() {
    unit.turnSteeringWheelLeft();
    Mockito.verify(car, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(steeringWheel, times(1)).left();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  @Test
  public void turnSteeringWheelRight() {
    unit.turnSteeringWheelRight();
    Mockito.verify(car, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(steeringWheel, times(1)).right();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  @Test
  public void turnSteeringWheelStraight() {
    unit.turnSteeringWheelStraight();
    Mockito.verify(car, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(steeringWheel, times(1)).straight();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  @Test
  public void lockDoor() {
    unit.lockDoor();
    verifyNoChanges();
  }

  @Test
  public void unlockDoor() {
    unit.unlockDoor();
    verifyNoChanges();
  }

  private void verifyNoChanges() {
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(car);
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(steeringWheel);
    Mockito.verifyZeroInteractions(transmission);
  }
}
