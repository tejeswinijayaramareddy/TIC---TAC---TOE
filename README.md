# TIC---TAC---TOE
Class GameStart has a main method which when executed leads to an interactive sesssion of the following kind:

1. There are two players, player X and O. 
2. In first iteration, X moves first in this case, user moves first. Consequently, players alter for every iteration. 
3. Board size is accepted as user input. Board sizes 1 to 5 are supported in this application. 
   Any input from user that is out of 1 to 5 range says invalid input and asks to choose a different cell.
4. Application also supports three levels of difficulty. Level 1, Level 2 and Level 3. 
   Level 1 : computer selects random cell 
   Level 2 : computer checks if it can win in next move.
   Level 3 : Picks spots to win the game or block user from winning the game.
   Any input except 1, 2 and 3 will say invalid input and asksto chose level of difficulty again.
5. After displaying game statistics, user will be asked if user wants to play another game. 
   Y -> play another game
   N -> quit from game and say Bye!
