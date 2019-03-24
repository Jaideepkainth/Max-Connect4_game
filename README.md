# Max-Connect4 game
* Used Depth-Limited Minmax algorithm with Alpha-Beta pruning.
* Game runs in two modes: Interactive (human vs computer) and One-Move (selects next best move from current game state).
* Eval function is calculated as the difference between the Game score of the Max player and the Min Player. The game score is calculated on the basis of the Game state when moves till the given depth are made. At the given depth all the Game states are checked and the Difference between the Max Player Score and the Min player is used as an Eval Function.

Code Structure: 
This Code has Three Classes:maxconnect4.java, AiPlayer.java, GameBoard.java
maxconnect4.java: This is the main class(that has the main function).This class controls the game play for the Max Connect-Four game. This Class contols the flow whether the Game is One-move or Interactive and whether its Computer Turn or Human Turn.
AiPlayer.java: This is the class that simulates a minimax player for the max connect four game. This class has the code for Computer turn that decides on the basis of Depth Limited minmax with Alpha-Beta Pruning.
GameBoard.java: This Class implements a two Dimensional array that represenst a connect four gameboard. It keeps track of the next play made by player on the basis of number of pieces on the game board. It provides all of the methods such as getScore, getCurrentTurn, getPieceCount, etc needed to implement the playing of mas Connect four game.

Running the Code:
Compile the code using command "javac maxconnect4.java"
To Run the Game in "one-move" mode: java maxconnect4 one-move [Input_file] [Output_file] [Depth]
To Run the Game in "interactive" mode: java maxconnect4 interactive [Input_file] [computer-next/human-next] [Depth]