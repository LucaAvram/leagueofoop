package main;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import fileio.FileSystem;
import hero.Hero;

public class GameInputLoader {
    // DO NOT MODIFY
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }

    public GameInput load() {
        int lines=0;
        int columns=0;
        char[][] map = null;
        int numberOfHeroes=0;
        ArrayList<Hero> heroes = new ArrayList<>();
        int numberOfRounds=0;
        ArrayList<String> moves = new ArrayList<>();


        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            lines = fs.nextInt();
            columns = fs.nextInt();
            map = new char[lines][columns];
            int i;
            int j;
            for(i=0; i<lines; i++){
                String word = fs.nextWord();

                for(j=0; j<columns; j++){

                    map[i][j]= word.charAt(j);
                }
            }
            numberOfHeroes = fs.nextInt();
            for(i=0; i<numberOfHeroes; i++){
                heroes.add(new Hero(fs.nextWord().charAt(0),fs.nextInt(),fs.nextInt()));
            }
            numberOfRounds = fs.nextInt();
            for(i=0; i<numberOfHeroes; i++){
                moves.add(fs.nextWord());
            }



            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(lines,columns,map,numberOfHeroes,heroes,numberOfRounds,moves);
    }
}
