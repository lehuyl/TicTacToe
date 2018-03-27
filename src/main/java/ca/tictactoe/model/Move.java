package ca.tictactoe.model;

/**
 * Class to keep the properties of a Move
 */
public class Move
{
    long moveNumber;
    char piece;
    int row;
    int col;

    public Move(long moveNumber, char piece, int row, int col)
    {
        this.moveNumber = moveNumber;
        this.piece = piece;
        this.row = row;
        this.col = col;
    }


    public Move()
    {
    }

    public long getMoveNumber()
    {
        return moveNumber;
    }

    public void setMoveNumber(long moveNumber)
    {
        this.moveNumber = moveNumber;
    }

    public char getPiece()
    {
        return piece;
    }

    public void setPiece(char piece)
    {
        this.piece = piece;
    }

    public int getRow()
    {
        return row;
    }

    public void setRow(int row)
    {
        this.row = row;
    }

    public int getCol()
    {
        return col;
    }

    public void setCol(int col)
    {
        this.col = col;
    }
}
