package com.simulator.car.state;

import com.simulator.car.parts.Car;
import com.simulator.car.parts.door.Doors;
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

  @Mock private Car car;
  @Mock private Doors doors;

  @InjectMocks private LockedState unit;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    Mockito.when(car.getDoors()).thenReturn(doors);
  }

  @Test
  public void unlockDoor() {
    unit.unlockDoor();

    Mockito.verify(car, times(1)).getDoors();
    Mockito.verify(car, times(1)).changeState(isA(UnlockedState.class));
    Mockito.verifyNoMoreInteractions(car);
    Mockito.verify(doors, times(1)).unlock();
    Mockito.verifyNoMoreInteractions(doors);
  }

  @Test
  public void lockDoor() {
    unit.lockDoor();
    Mockito.verify(car, times(1)).getDoors();
    Mockito.verifyNoMoreInteractions(car);
  }

  @Test
  public void getState() {
    Assert.assertEquals(CarState.State.LOCKED, unit.getState());
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
