# The Classic Game of Pong

John Liu, Kevin Zhang, Nick Giordano 

Our project is recreating the classic game pong in Java. We wish to create a game with a UI which will ultimately open up to a main menu of the game where you can select to play either single player versus a very awful bot or can choose to play multiplayer with a local friend. We are toying with the idea also of a settings tab where you can customize paddle color and other things.

## Running the game

Use our provided run.sh with the following command in the command line to see our game: ./run.sh
Or go ahead and double click the file and choose to run with your terminal.

## Iter 1
In this iteration, we completed all the basic game functions: the ball moves, the paddles move, and the ball ricochets off of the walls and the paddles. For the next iteration, we intend to complete scoring, as well as work on an AI to allow players to play single player. We have provided a script that will run the game. 

## Iter 2
In this iteration, we added scoring so that the game would track and show the scores of the players as they play. In addition, we added a menu bar that allows the players to start a new game, exit, and eventually switch between single and multi-player. Looking forward, we will be looking to add the aformentioned single-player mode in which the player can play with an ai.

## Iter 3
We added functionality to the menu bar at the top of the game. One can now create a new game and it will reset the state of the game, exit the game and close the app, switch between single player (vs "AI") or multiplayer (vs a friend). We also went through and made an attempt to refactor some of the code for the project and make it a little more clean. Also added additional comments and tests.
