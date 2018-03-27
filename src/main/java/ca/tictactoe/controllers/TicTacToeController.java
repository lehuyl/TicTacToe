package ca.tictactoe.controllers;

import ca.tictactoe.model.Board;
import ca.tictactoe.model.Move;
import ca.tictactoe.model.TicTacToe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Controller that integrates the SpringBoot Server API for Web Servers
 */
@RestController
public class TicTacToeController {

    List<TicTacToe> tictactoeGames = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong();
    private AtomicLong nextIdMoves = new AtomicLong();
//    Board board = new Board();
//    List<Move> movesList = new ArrayList<>();

    @GetMapping("/about")
    public String getHelloMessage()
    {
        return "Awesome Tic Tac Toe game written by Steven!";
    }

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public TicTacToe createNewTicTacToe(@RequestBody TicTacToe tictactoe)
    {
        tictactoe.setId(nextId.incrementAndGet());
        tictactoe.setGameState("PLAYING");
//        tictactoe.setMovesList(movesList);
//        tictactoe.setBoard(board);

        tictactoeGames.add(tictactoe);
        return tictactoe;
    }

    @GetMapping("/games")
    public List<TicTacToe> getTicTacToeGames()
    {
        return tictactoeGames;
    }


    @GetMapping("/games/{id}")
    public TicTacToe getBoardStateOfGame(@PathVariable("id") long tictactoeId)
    {
        for(TicTacToe tictactoe: tictactoeGames){
            if(tictactoe.getId() == tictactoeId) {

                return tictactoe;
            }
        }

        throw new IllegalArgumentException();
    }


    @PostMapping("/games/{id}/moves")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Move> createNewMoves(@RequestBody Move move, @PathVariable("id") long tictactoeId)
    {
//        movesList.add(move);
        for(TicTacToe ticTacToe : tictactoeGames)
        {
            if(ticTacToe.getId() == tictactoeId)
            {
                ticTacToe.incrementMove();

                //ERROR FOR O GO FIRST
                if(ticTacToe.getMoveNumber() == 1 )
                {
                    if(move.getPiece() == 'o' || move.getPiece() == 'O')
                    {
                        ticTacToe.decrementMove();
                        throw new IllegalStateException();
                    }
                }
                if(move.getPiece() != 'x' && move.getPiece() != 'X' && move.getPiece() != 'o' && move.getPiece() != 'O')
                {
                    ticTacToe.decrementMove();
                    throw new IllegalStateException();
                }
                if(move.getRow() != 0 && move.getRow() != 1 && move.getRow() != 2)
                {
                    ticTacToe.decrementMove();
                    throw new IllegalStateException();
                }
                if(move.getCol() != 0 && move.getCol() != 1 && move.getCol() != 2)
                {
                    ticTacToe.decrementMove();
                    throw new IllegalStateException();
                }
//                if(ticTacToe.getMoveNumber() > 1 && ticTacToe.getMovesList().get((int) ticTacToe.getMoveNumber()- 1).getPiece() == move.getPiece())
//                {
//                    ticTacToe.decrementMove();
//                    throw new IllegalStateException();
//                }
                move.setMoveNumber(ticTacToe.getMoveNumber());
                ticTacToe.getMovesList().add(move);
                ticTacToe.getBoard().updateRow(move.getPiece(),move.getRow(),move.getCol());

                return ticTacToe.getMovesList();
            }
        }

//        return movesList;
        throw new IllegalArgumentException();
    }

    @GetMapping("/games/{id}/moves")
    public List<Move> getMoves(@PathVariable("id") long tictactoeId)
    {
        for(TicTacToe ticTacToe : tictactoeGames)
        {
            if(ticTacToe.getId() == tictactoeId)
            {
                return ticTacToe.getMovesList();
            }
        }

        throw new IllegalArgumentException();
    }

    @GetMapping("/games/{id}/board")
    public Board getBoard(@PathVariable("id") long tictactoeId)
    {
        for(TicTacToe ticTacToe : tictactoeGames)
        {
            if(ticTacToe.getId() == tictactoeId)
            {
                return ticTacToe.getBoard();
            }
        }

        throw new IllegalArgumentException();
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(IllegalArgumentException.class)
    public void notFoundExceptionHandler() {
        // Nothing to do
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public void badRequestExceptionHandler() {
        // Nothing to do
    }
}
