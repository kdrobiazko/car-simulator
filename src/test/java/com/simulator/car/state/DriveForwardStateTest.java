package com.simulator.car.state;

import com.simulator.car.parts.CarControls;
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

public class DriveForwardStateTest {

  @Mock private Accelerator accelerator;
  @Mock private Brake brake;
  @Mock private CarControls carControls;
  @Mock private Doors doors;
  @Mock private Engine engine;
  @Mock private SteeringWheel steeringWheel;
  @Mock private Transmission transmission;

  @InjectMocks private DriveForwardState unit;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    Mockito.when(carControls.getAccelerator()).thenReturn(accelerator);
    Mockito.when(carControls.getBrake()).thenReturn(brake);
    Mockito.when(carControls.getDoors()).thenReturn(doors);
    Mockito.when(carControls.getEngine()).thenReturn(engine);
    Mockito.when(carControls.getSteeringWheel()).thenReturn(steeringWheel);
    Mockito.when(carControls.getTransmission()).thenReturn(transmission);
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
    Mockito.verify(carControls, times(1)).getAccelerator();
    Mockito.verify(carControls, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(carControls);
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
    Mockito.verify(carControls, times(1)).getAccelerator();
    Mockito.verify(carControls, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(carControls);
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
    Mockito.verify(carControls, times(1)).getAccelerator();
    Mockito.verify(carControls, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(carControls);
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
    Assert.assertEquals(CarState.State.DRIVE_FORWARD, unit.getState());
  }
}
