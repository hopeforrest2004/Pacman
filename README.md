TBD Man (Pac Man Variation)

Four Screens:

(EZ = fast task)

Start Menu
	* Music - EZ
	* Animations
	* See High Scores -EZ
	* Options (volume of music/sound effects?  Optional) 
	* Start Game - EZ (send to animations screen)
Intro video (Can we just play an mp4 file for this?)
	* Animation
	* Music -EZ
	* On Finish send to Maze Screen
Maze Screen (looped)
	* Pellets
		*Different pellets have different point values
		*Randomized?
	* PacMan Movement
		-Arrow buttons on bottom of screen
	* Maze Collision
		-Use first maze or design our own to lean into that this is our take on pacman
	* Ghost
		-Single ghost that follows the shortest path to the nearest movable space in the direction they 			are facing
	* Reset on PacMan Death
		-Pacman resets to traditional spawn, Single ghost enemy spawns at the top of the maze
		-Death is defined when the ghost touches PacMan
	* Level finish -EZ (when all pellets have been eaten)
	* Game Over -EZ (when lives equal 0)
	* Lives 
		-Life gain at point threshold
	* Scoring -EZ
	* Music -EZ
	* Sound Effects
Game Over Screen (For a fifth screen as insurance)
	* Send to high score screen
High Scores -EZ
	* Ordered List of 10 highest scores
	* Read in as a file because why the fuck not
	* If sent from Game Over Screen check to see if there is a new high score and update accordingly
	* Button to return to Main Menu
	* Music is same as Main Menu


Possible Errors:
	* Should be no errors from loading files unless we decide to use an mp4 for the intro animation
	* Trying to load High Scores if that hasn't been created yet



Collision Map Basis:
25 x 15 Map

Pac Man spawns at ~(13, 1) Ghost spawns at ~(13, 14)
