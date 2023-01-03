import java.util.Scanner;
public class HumanPlayer extends Player {
    String name;
    char symbol;
    Scanner in = new Scanner(System.in);
    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
        this.name=name;
        this.symbol=symbol;
    }
    @Override
    public void makeMove(Board board) {
        System.out.print(name+ ", please input your move ");
        int play = in.nextInt();
        if(play<1 || play>7){
            System.out.println("Please put an input between 1 to 7 inclusive");
            System.out.print(name+ ", please input your move ");
            play = in.nextInt();
        }
        while (board.isfilled(play-1)) {
            System.out.println("This column is already full!!");
            System.out.print(name+ ", please input your move ");
            play = in.nextInt();
        }
        board.putthepiece(symbol,play-1);
        board.containsWin();
    }
}


