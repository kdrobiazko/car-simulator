package com.simulator.car.state;

import com.simulator.car.parts.CarControls;
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
import org.mockito.*;

import static org.mockito.Mockito.times;

public class DoorUnlockedStateTest {

  @Mock private Accelerator accelerator;
  @Mock private Brake brake;
  @Mock private CarControls carControls;
  @Mock private Doors doors;
  @Mock private Engine engine;
  @Mock private SteeringWheel steeringWheel;
  @Mock private Transmission transmission;

  @InjectMocks private UnlockedState unit;

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
  public void startEngine() {
    unit.startEngine();
    Mockito.verify(carControls, times(1)).getEngine();
    Mockito.verify(carControls, Mockito.times(1)).changeState(Matchers.isA(ParkedState.class));
    Mockito.verifyNoMoreInteractions(carControls);
    Mockito.verify(engine, times(1)).start();
    Mockito.verifyNoMoreInteractions(engine);
    Mockito.verifyZeroInteractions(doors);
  }

  @Test
  public void lockDoor() {
    unit.lockDoor();
    Mockito.verify(carControls, times(1)).getDoors();
    Mockito.verify(carControls, Mockito.times(1)).changeState(Matchers.isA(LockedState.class));
    Mockito.verifyNoMoreInteractions(carControls);
    Mockito.verify(doors, times(1)).lock();
    Mockito.verifyNoMoreInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
  }

  @Test
  public void unlockDoor() {
    unit.unlockDoor();
    Mockito.verify(carControls, times(1)).getDoors();
    Mockito.verifyNoMoreInteractions(carControls);
    Mockito.verify(doors, times(1)).unlock();
    Mockito.verifyNoMoreInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
  }

  @Test
  public void getState() {
    Assert.assertEquals(CarState.State.UNLOCKED, unit.getState());
  }

  @Test
  public void pressAccelerator() {
    unit.pressAccelerator();
    Mockito.verify(carControls, times(1)).getAccelerator();
    Mockito.verifyNoMoreInteractions(carControls);
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
    Mockito.verify(carControls, times(1)).getAccelerator();
    Mockito.verifyNoMoreInteractions(carControls);
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
    Mockito.verify(carControls, times(1)).getBrake();
    Mockito.verifyNoMoreInteractions(carControls);
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
    Mockito.verify(carControls, times(1)).getBrake();
    Mockito.verifyNoMoreInteractions(carControls);
    Mockito.verify(brake, times(1)).release();
    Mockito.verifyNoMoreInteractions(brake);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
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
  public void stopEngine() {
    unit.stopEngine();
    verifyNoChanges();
  }

  @Test
  public void turnSteeringWheelLeft() {
    unit.turnSteeringWheelLeft();
    Mockito.verify(carControls, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(carControls);
    Mockito.verify(steeringWheel, times(1)).left();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  @Test
  public void turnSteeringWheelRight() {
    unit.turnSteeringWheelRight();
    Mockito.verify(carControls, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(carControls);
    Mockito.verify(steeringWheel, times(1)).right();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  @Test
  public void turnSteeringWheelStraight() {
    unit.turnSteeringWheelStraight();
    Mockito.verify(carControls, times(1)).getSteeringWheel();
    Mockito.verifyNoMoreInteractions(carControls);
    Mockito.verify(steeringWheel, times(1)).straight();
    Mockito.verifyNoMoreInteractions(steeringWheel);
    Mockito.verifyZeroInteractions(accelerator);
    Mockito.verifyZeroInteractions(brake);
    Mockito.verifyZeroInteractions(engine);
    Mockito.verifyZeroInteractions(transmission);
  }

  private void verifyNoChanges() {
    Mockito.verifyZeroInteractions(carControls);
    Mockito.verifyZeroInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
  }
}
