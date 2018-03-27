package ca.tictactoe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Base Logic class for the TicTacToe game
 */
public class TicTacToe {
    public static final String PLAYING = "PLAYING";
    private long id;
    private String description;
    private String gameState;
    @JsonProperty("moves")
    private List<Move> movesList;
    @JsonProperty("board")
    private Board board;
    @JsonIgnore
    private long moveNumber;

    //dummy constructor
    public TicTacToe()
    {
        this.movesList = new ArrayList<>();
        this.board = new Board();
        moveNumber = 0;
    }
//    public TicTacToe(long id, String description, List<Move> movesList)
    public TicTacToe(long id, String description)
    {
        this.id = id;
        this.description = description;
//        this.movesList = movesList;

    }

    public void setBoard(Board board)
    {
        this.board = board;
    }

    public Board getBoard()
    {
        return board;
    }

    public long getId()
    {
        return this.id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getGameState()
    {
        return this.gameState;
    }

    public void setGameState(String gameState)
    {
        this.gameState = gameState;
    }

    public List<Move> getMovesList()
    {
        return this.movesList;
    }

    public void setMovesList(List<Move> movesList)
    {
        this.movesList = movesList;
    }

    public void incrementMove()
    {
        moveNumber++;
    }

    public void decrementMove()
    {
        moveNumber--;
    }

    public long getMoveNumber()
    {
        return moveNumber;
    }
}
