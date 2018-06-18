package com.tictactoe;

public class Main {

    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.start();
    }
}
//javac -d bin -sourcepath src src/main/java/com/tictactoe/Main.java && java -ea -cp bin com.tictactoe.Main
//java -cp src/ com.checkers.Main