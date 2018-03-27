package ca.tictactoe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to keep a visual and backend representation of the TicTacToe board.
 */
public class Board
{
    public static final String INIT_EMPTY = "     ";
    public static final int LAST_COL_INDEX = 4;
    public static final int MIDDLE_COL_INDEX = 2;
    public static final int FIRST_COL_INDEX = 0;
    public static final int FIRST_ROW_INDEX = 0;
    public static final int MIDDLE_ROW_INDEX = 1;
    public static final int LAST_ROW_INDEX = 2;
    @JsonProperty("row1")
    public String row1;
    @JsonProperty("row2")
    public String row2;
    @JsonProperty("row3")
    public String row3;
    @JsonIgnore
    private boolean isWin;

    public Board()
    {
        this.row1 = INIT_EMPTY;
        this.row2 = INIT_EMPTY;
        this.row3 = INIT_EMPTY;
    }

    public String getRow1()
    {
        return row1;
    }

    public void setRow1(String row1)
    {
        this.row1 = row1;
    }

    public String getRow2()
    {
        return row2;
    }

    public void setRow2(String row2)
    {
        this.row2 = row2;
    }

    public String getRow3()
    {
        return row3;
    }

    public void setRow3(String row3)
    {
        this.row3 = row3;
    }

    public void updateRow(char piece, int row, int col)
    {
        //5 spaces is length of row
        char[] copy = new char[5];
        if(row == FIRST_ROW_INDEX)
        {
            copy = row1.toCharArray();
        }
        else if(row == MIDDLE_ROW_INDEX)
        {
            copy = row2.toCharArray();
        }
        else if(row == LAST_ROW_INDEX)
        {
            copy = row2.toCharArray();
        }
        if(col == FIRST_ROW_INDEX)
        {
            copy[FIRST_COL_INDEX] = piece;
        }
        else if(col == MIDDLE_ROW_INDEX)
        {
            copy[MIDDLE_COL_INDEX] = piece;
        }
        else if(col == LAST_ROW_INDEX)
        {
            copy[LAST_COL_INDEX] = piece;
        }



        if(row == FIRST_ROW_INDEX)
        {
            row1 = new String(copy);
        }

        else if(row == MIDDLE_ROW_INDEX)
        {
            row2 = new String(copy);
        }
        else if(row == LAST_ROW_INDEX)
        {
            row3 = new String(copy);
        }
    }

//    public boolean isWin()
//    {
////        @JsonIgnore
//        isWin = false;
//
//        //check rows
//        char[] copyRow1 = row1.toCharArray();
//        char[] copyRow2 = row2.toCharArray();
//        char[] copyRow3 = row3.toCharArray();
//
//        if(copyRow1[0] == 'x' && copyRow1[2] == 'x' && copyRow1[4] == 'x')
//        {
//            isWin = true;
//        }
//
//        return isWin;
//    }
}
