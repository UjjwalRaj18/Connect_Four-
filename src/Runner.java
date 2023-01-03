public class Runner {
    public static void main(String args[]) {
        Board board = new Board();
        ConnectFour game = new ConnectFour(board);
        game.setPlayer2(new HumanPlayer('B', board, "Bob"));
        game.setPlayer1(new AIPlayer('R', board, "Alice"));
        game.playGame();
    }

}
