
public class Board {
    private char[][] c4_table;
    private final int NUM_OF_COLUMNS = 7;
    private final int NUM_OF_ROW = 6;


    /*
     * The board object must contain the board state in some manner.
     * You must decide how you will do this.
     *
     * You may add addition private/public methods to this class is you wish.
     * However, you should use best OO practices. That is, you should not expose
     * how the board is being implemented to other classes. Specifically, the
     * Player classes.
     *
     * You may add private and public methods if you wish. In fact, to achieve
     * what the assignment is asking, you'll have to
     *
     */

    public Board() {
        c4_table = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
        reset();
    }
    public void printBoard() {
        for (int row = 0; row < NUM_OF_ROW; row++) {
            System.out.print("|");
            for (int column = 0; column < NUM_OF_COLUMNS; column++) {
                System.out.print(c4_table[row][column] + "|");
            }
            System.out.println();
        }
        System.out.print("");
        System.out.println("---------------");
    }
    public boolean containsWin() {
        //check for 4 across
        for (int row = 0; row < NUM_OF_ROW; row++) {
            for (int column = 0; column < NUM_OF_COLUMNS - 3; column++) {
                if(c4_table[row][column] == ' '){
                    continue;
                }
                if (c4_table[row][column] == c4_table[row][column + 1]){
                    if(c4_table[row][column + 1] == c4_table[row][column + 2]){
                        if(c4_table[row][column + 2] == c4_table[row][column + 3]){
                            return true;
                        }
                    }
                }

                }
            }
        for (int row = 0; row < NUM_OF_ROW - 3; row++) {
            for (int column = 0; column < NUM_OF_COLUMNS; column++) {
                if(c4_table[row][column] == ' '){
                    continue;
                }
                if (c4_table[row][column] == c4_table[row + 1][column]){
                    if(c4_table[row + 1][column] == c4_table[row + 2][column]){
                        if(c4_table[row + 2][column] == c4_table[row + 3][column]){
                            return true ;
                        }
                    }
                }

                }
            }
        for (int row = 3; row < NUM_OF_ROW; row++) {
            for (int column = 0; column < NUM_OF_COLUMNS - 3; column++) {
                if(c4_table[row][column] == ' '){
                    continue;
                }
                if (c4_table[row][column] == c4_table[row - 1][column + 1]){
                    if(c4_table[row - 1][column + 1] == c4_table[row - 2][column + 2]){
                        if(c4_table[row - 2][column + 2] == c4_table[row - 3][column + 3]){
                            return true ;
                        }
                    }
                }
                }
            }

        for (int row = 0; row < NUM_OF_ROW - 3; row++) {
            for (int column = 0; column < NUM_OF_COLUMNS - 3; column++) {
                if(c4_table[row][column] == ' '){
                    continue;
                }
                if (c4_table[row][column] == c4_table[row + 1][column + 1]){
                    if(c4_table[row + 1][column + 1] == c4_table[row + 2][column + 2]){
                        if(c4_table[row + 2][column + 2] == c4_table[row + 3][column + 3]){
                            return true ;
                        }
                    }
                }
                }
            }
        return false;
    }
    public boolean isTie() {
        for (int f = 0; f < 7; f++) {
            if (isfilled(f)==false&&containsWin()==false){
                return false;
            }
        }
        return true;
    }

    public void reset() {
        for (int row = 0; row < NUM_OF_ROW; row++) {
            for (int column = 0; column < NUM_OF_COLUMNS; column++) {
                c4_table[row][column] = ' ';
            }
        }
    }
    public char getGrid(int row,int column) {
        return c4_table[row][column];

    }
    public boolean isfilled(int player) {
        if (c4_table[0][player] != ' ') {
            return true;
        }
        return false;
    }
    public void putthepiece(char symbol, int play) {
        for (int row = 5; row >= 0; row--) {
            if (c4_table[row][play] == ' ') {
                c4_table[row][play] = symbol;
                break;
            }
        }
    }
    public void delete_move(char symbol, int play) {
        for (int row = 0; row <= 5; row++) {
            if (c4_table[row][play] == symbol) {
                c4_table[row][play] = ' ';
                break;
            }
        }
    }
}
