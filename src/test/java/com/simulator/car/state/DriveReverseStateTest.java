package com.simulator.car.state;

import com.simulator.car.parts.Car;
import com.simulator.car.parts.accelerator.Accelerator;
import com.simulator.car.parts.brake.Brake;
import com.simulator.car.parts.door.Doors;
import com.simulator.car.parts.engine.Engine;
import com.simulator.car.parts.swheel.SteeringWheel;
import com.simulator.car.parts.transmission.Transmission;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;

public class DriveReverseStateTest {

  @Mock private Accelerator accelerator;
  @Mock private Brake brake;
  @Mock private Car car;
  @Mock private Doors doors;
  @Mock private Engine engine;
  @Mock private SteeringWheel steeringWheel;
  @Mock private Transmission transmission;

  @InjectMocks private DriveReverseState unit;

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
  public void pressAcceleratorWhenWheelIsLeft() {
    Mockito.when(steeringWheel.getState()).thenReturn(SteeringWheel.State.LEFT);

    unit.pressAccelerator();

    Mockito.verify(steeringWheel, times(1)).getState();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verify(accelerator, times(1)).press();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  @Test
  public void pressAcceleratorWhenWheelIsRight() {
    Mockito.when(steeringWheel.getState()).thenReturn(SteeringWheel.State.RIGHT);

    unit.pressAccelerator();

    Mockito.verify(steeringWheel, times(1)).getState();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verify(accelerator, times(1)).press();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  @Test
  public void pressAcceleratorWhenWheelIsStraight() {
    Mockito.when(steeringWheel.getState()).thenReturn(SteeringWheel.State.STRAIGHT);

    unit.pressAccelerator();

    Mockito.verify(steeringWheel, times(1)).getState();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verify(accelerator, times(1)).press();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  @Test
  public void turnSteeringWheelLeft() {
    Mockito.when(accelerator.getState()).thenReturn(Accelerator.State.PRESSED);
    unit.turnSteeringWheelLeft();
    Mockito.verify(car, times(1)).getAccelerator();
    Mockito.verify(car, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(steeringWheel, times(1)).left();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verify(accelerator, times(1)).getState();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
  }

  @Test
  public void turnSteeringWheelRight() {
    Mockito.when(accelerator.getState()).thenReturn(Accelerator.State.PRESSED);
    unit.turnSteeringWheelRight();
    Mockito.verify(car, times(1)).getAccelerator();
    Mockito.verify(car, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(steeringWheel, times(1)).right();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verify(accelerator, times(1)).getState();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
  }

  @Test
  public void turnSteeringWheelStraight() {
    Mockito.when(accelerator.getState()).thenReturn(Accelerator.State.PRESSED);
    unit.turnSteeringWheelStraight();
    Mockito.verify(car, times(1)).getAccelerator();
    Mockito.verify(car, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(steeringWheel, times(1)).straight();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verify(accelerator, times(1)).getState();
    Mockito.verifyNoMoreInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  @Test
  public void getState() {
    Assert.assertEquals(CarState.State.DRIVE_REVERSE, unit.getState());
  }
}
