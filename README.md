# car-simulator

##### Car has next states:

- **Locked** - Assume that car is locked (driver is outside the car). Doors are locked. Engine is turned off. Transmission is on parking
- **Unlocked** - State when doors are unlocked. I assume that driver is inside the car. Engine is turned off. Transmission is on parking
- **Parked** -  Engine is turned on. Transmission is on parking.
- **Forward Moving** - in this state transmission is set to Drive. Car goes forward when press accelerator and stops when press brake
- **Reverse Moving** - in this state car has the same behaviour like in **Forward Moving**, but goes in opposite direction
___

##### Car consists of next parts. Each part also has a state:

| Car part | States |
|---|:---:|
|Engine|started, stopped|
|Door|locked, unlocked|
|Accelerator|pressed, released|
|Brake|pressed, released|
|Steering wheel|turned left, right, straight|
|Transmission|paring, drive, reverse|

##### Transition between Car states: 

|State from|State to|Conditions to change state|
|---|---|---|
|Locked|Unlocked|	Door: unlock|				
|Unlocked|Locked|Door: lock|				
|Locked|Parked|Engine: start|			
|Parked|Locked|Engine: stop|			
|Parked|Forward Moving|Engine: started, brake: pressed, accelerator: released|
|Forward Moving|Parked|Engine: started, brake: pressed, accelerator: released|
|Parked|Reverse Moving|Engine: started, brake: pressed, accelerator: released|
|Reverse Moving|Parked|Engine: started, brake: pressed, accelerator: released|
|Reverse Moving|Forward Moving|Engine: started, brake: pressed, accelerator: released|
|Forward Moving|Reverse Moving|Engine: started, brake: pressed, accelerator: released|
