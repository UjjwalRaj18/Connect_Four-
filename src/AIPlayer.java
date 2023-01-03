import java.util.Random;
public class AIPlayer extends Player{
    String name;
    char symbol;
    char es;
    int play;
    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
        this.name=name;
        this.symbol=symbol;
    }
    static int turn=1;
    public  void validate(int column){
        if (column < 1|| column > 7){
            System.out.println("Please enter no. between 1 to 7");
        }
       
    }
    @Override
    public void makeMove(Board board) {
        System.out.print(name+ ", your move ");
        System.out.println();
        for (int f =0;f<7;f++){
            if(board.isfilled(f)){
                continue;
            }
            board.putthepiece(symbol,f);
            if(board.containsWin()){
                return;
            }

            else{
                board.delete_move(symbol,f);
            }
        }

        for (int row = 0; row <= 5; row++) {
            for (int column = 0; column < 6; column++) {
                if (board.getGrid(row,column) != ' ' && board.getGrid(row,column) != symbol)
                     es = board.getGrid(row,column);
            }

        }

        for (int f =0;f<7;f++){
            if(board.isfilled(f)){
                continue;
            }
            board.putthepiece(es,f);
            if(board.containsWin()){
                board.delete_move(es,f);
                board.putthepiece(symbol,f);
                return;
            }

            else{
                board.delete_move(es,f);
            }
        }
        play = (int) (Math.random()*7);
        turn++;
        validate(play);
        board.putthepiece(symbol,play);
        board.containsWin();
    }
}


