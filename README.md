To start with, I assure that all code here is my own and not copies/reused from somewhere else.
Each line is written from scratch and I can explain every single aspect and line of the app. 
Starting from why I did so and going further why files are in these or those folders etc.

The project is a mono repo.
It should have been two repos as they are totally separate, 
but for the task given, monorepo should just do fine.

In short, the backend project contains the DB files and scripts to generate/update 
the DB when/if needed and the springboot app for the backend.
The frontend app is a React app to interact with the backend. 

There are two files in the root directory for starting stopping the apps (both fronend and backend)
I have not tested them vigorously as I used IntelliJ and WebStorm to run the app. 
These files are more for the reference which commands are required to run which processes
(like update db, run backend, frontend)

More info can be found in each module's folder in the readme files. 
Those files will explain the ideas behind the implementation.

I am happy to walk you through the parts of the app if needed 
and explain in more details why I made a particular choice.