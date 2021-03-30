Program simualtes lifecycle of cells in living organisms.
Space dimension: 2D
Neighborhood type: Moore
![moore neighborhood](https://user-images.githubusercontent.com/61821034/112969928-fee71b00-914d-11eb-84dc-f9e353d1d303.PNG)

Avaible cell states: dead (0), alive (1)

Rules of transition:

-Every dead cell (state 0) which has 3 alive neighbors (cells in state 1) is "born" (changes state from 0 to 1 and becomes "alive").
-Every alive cell (state 1) which has more than 3 alive neighbors (cells in state 1) dies beacuse of overcrowd (changes state form 1 to 0 and becomes "dead").
-Every alive cell (state 1) which has 2 or 3 alive neighbors (cells in state 1) stays alive (does not change state).
-Every alive cell (state 1) which has 1 or 0 alive neighbors (cells in state 1) dies (chenges state from 1 to 0).

Program starts with one of declared initial statuses:
-constant
![constant](https://user-images.githubusercontent.com/61821034/112970449-7c129000-914e-11eb-87ce-89562fd930fc.PNG)

-glider
![glider](https://user-images.githubusercontent.com/61821034/112970474-82a10780-914e-11eb-82a3-985a53f33aae.PNG)

-oscillator
![oscillator](https://user-images.githubusercontent.com/61821034/112970519-92205080-914e-11eb-811c-e82327ad4c36.PNG)

-random definition
![random](https://user-images.githubusercontent.com/61821034/112970538-98163180-914e-11eb-9472-2f24942363fa.PNG)

-user's choice
![user choice](https://user-images.githubusercontent.com/61821034/112970580-a2383000-914e-11eb-841b-21fae8add8ea.PNG)
