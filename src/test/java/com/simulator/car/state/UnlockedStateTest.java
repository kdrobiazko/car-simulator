package com.simulator.car.state;

import com.simulator.car.parts.Car;
import com.simulator.car.parts.door.Doors;
import com.simulator.car.parts.engine.Engine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.mockito.Mockito.times;

public class UnlockedStateTest {

  @Mock private Car car;
  @Mock private Doors doors;
  @Mock private Engine engine;

  @InjectMocks private UnlockedState unit;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    Mockito.when(car.getDoors()).thenReturn(doors);
    Mockito.when(car.getEngine()).thenReturn(engine);
  }

  @Test
  public void startEngine() {
    unit.startEngine();
    Mockito.verify(car, times(1)).getEngine();
    Mockito.verify(car, Mockito.times(1)).changeState(Matchers.isA(ParkedState.class));
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(engine, times(1)).start();
    Mockito.verifyNoMoreInteractions(engine);
    Mockito.verifyZeroInteractions(doors);
  }

  @Test
  public void lockDoor() {
    unit.lockDoor();
    Mockito.verify(car, times(1)).getDoors();
    Mockito.verify(car, Mockito.times(1)).changeState(Matchers.isA(LockedState.class));
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(doors, times(1)).lock();
    Mockito.verifyNoMoreInteractions(doors);
    Mockito.verifyZeroInteractions(engine);
  }

  @Test
  public void unlockDoor() {
    unit.unlockDoor();
    Mockito.verify(car, times(1)).getDoors();
    Mockito.verifyNoMoreInteractions(car);
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
    verifyNoChanges();
  }

  @Test
  public void releaseAccelerator() {
    unit.releaseAccelerator();
    verifyNoChanges();
  }

  @Test
  public void pressBrake() {
    unit.pressBrake();
    verifyNoChanges();
  }

  @Test
  public void releaseBrake() {
    unit.releaseBrake();
    verifyNoChanges();
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
    Mockito.verifyZeroInteractions(engine);
  }
}
