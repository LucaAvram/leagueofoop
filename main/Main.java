package main;

import Game.Game;
import hero.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0],args[1]);
        GameInput gameInput = gameInputLoader.load();
        ArrayList<Hero> heroes = new ArrayList<>();
        Hero hero;
        int i=0;
        for(i=0; i<gameInput.getHeroes().size(); i++){
            if(gameInput.getHeroes().get(i).getType()=='W'){
                heroes.add(new Wizard('W',gameInput.getHeroes().get(i).getX(),
                        gameInput.getHeroes().get(i).getY()));

            }
            if(gameInput.getHeroes().get(i).getType()=='K'){
                heroes.add(new Knight('K',gameInput.getHeroes().get(i).getX(),
                        gameInput.getHeroes().get(i).getY()));

            }
            if(gameInput.getHeroes().get(i).getType()=='R'){
                heroes.add(new Rogue('R',gameInput.getHeroes().get(i).getX(),
                        gameInput.getHeroes().get(i).getY()));

            }
            if(gameInput.getHeroes().get(i).getType()=='P'){
                heroes.add(new Pyromancer('P',gameInput.getHeroes().get(i).getX(),
                        gameInput.getHeroes().get(i).getY()));

            }
        }
        Game game = new Game();
        game.GameStart(heroes,gameInput.getMap(),gameInput.getMoves(),gameInput.getNumberOfRounds(),
                gameInput.getNumberOfHeroes());




    }
}
