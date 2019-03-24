import java.util.*;

/**
 * This is the AiPlayer class.  It simulates a minimax player for the max
 * connect four game.
 * The constructor essentially does nothing. 
 * 
 * @author james spargo
 *
 */

public class AiPlayer 
{
    /**
     * The constructor essentially does nothing except instantiate an
     * AiPlayer object.
     *
     */
    public int depthLevel;
    public int playChoice = 100;
    public int alpha = -1000;
    public int beta = 1000;
    public int h_number=0;
    public int c_number=0;
    public AiPlayer(int depthLevel) 
    {
	this.depthLevel = depthLevel;
    }

    /**
     * This method plays a piece randomly on the board
     * @param currentGame The GameBoard object that is currently being used to
     * play the game.
     * @return an integer indicating which column the AiPlayer would like
     * to play in.
     */
    public int max(GameBoard game, int depthlevel, int alpha, int beta)
    {
        if (game.getPieceCount()<42 && depthlevel!= 0)
        {
           int a=-1000;
           for(int i=0;i<7;i++)
            {
                if(game.isValidPlay(i))
                {
                    GameBoard maxGame = new GameBoard(game.getGameBoard());
                    maxGame.playPiece(i);
                    int minValue = min(maxGame, depthlevel-1, alpha, beta);
                    if(a<minValue)
                    {
                        a=minValue;
                    }
                    if(a>=beta)
                    {
                        return a;
                    }
                    if(alpha<a)
                    {
                        alpha=a;
                    }
                }
            }
           return a;
        }
        else
        {
            int eval=game.getScore(h_number) - game.getScore(c_number);
            return eval;
        }
    }
    public int min(GameBoard game, int depthlevel, int alpha, int beta)
    {
        if (game.getPieceCount()<42 && depthlevel!= 0)
        {
           int a=1000;
           for(int i=0;i<7;i++)
            {
                if(game.isValidPlay(i))
                {
                    GameBoard minGame = new GameBoard(game.getGameBoard());
                    minGame.playPiece(i);
                    int maxValue = max(minGame, depthlevel-1, alpha, beta);
                    if(a>maxValue)
                    {
                        a=maxValue;
                    }
                    if(a<=alpha)
                    {
                        return a;
                    }
                    if(beta>a)
                    {
                        beta=a;
                    }
                }
            }
           return a;
        }
        else
        {
            int eval=game.getScore(h_number) - game.getScore(c_number);
            return eval;
        }
    }
    public int findBestPlay( GameBoard currentGame ) 
    {
	h_number=currentGame.h_number;
        c_number=currentGame.c_number;
            int a=1000;
            for(int i=0;i<7;i++)
            {
                if(currentGame.isValidPlay(i))
                {
                    GameBoard p_next = new GameBoard(currentGame.getGameBoard());
                    p_next.playPiece(i);
                    int maxValue = max(p_next, depthLevel, alpha, beta);
                    if(a>maxValue)
                    {
                        playChoice=i;
                        a=maxValue;
                    }
                }
            }
	return playChoice;
    }
}
