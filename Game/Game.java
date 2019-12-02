package Game;

import hero.Hero;

import java.util.ArrayList;

public class Game {
    public void GameStart(ArrayList<Hero> heroes, char[][] map,ArrayList<String> moves,int numberOfRounds,
                     int numberOfHeroes){

        int round;
        int i;
        for(round=0; round<numberOfRounds; round++){

            for(i=0; i<numberOfHeroes; i++){
                if(heroes.get(i).getIsIgnited()[0] == 1){
                    heroes.get(i).setCurrentHP(heroes.get(i).getCurrentHP() - heroes.get(i).getIsIgnited()[1]);
                    heroes.get(i).getIsIgnited()[2]--;
                }
                if(heroes.get(i).getIsParalysed()[0] == 1){
                    heroes.get(i).setCurrentHP(heroes.get(i).getCurrentHP() - heroes.get(i).getIsParalysed()[1]);
                    heroes.get(i).getIsParalysed()[2]--;

                }
            }

            heroes.get(0).isAttackedBy(heroes.get(1), map[0][0]);
            heroes.get(1).isAttackedBy(heroes.get(0), map[0][0]);

            for(i=0; i<numberOfHeroes; i++){
                if(heroes.get(i).isDead()){
                    System.out.println(heroes.get(i).getType() + "dead");
                }
                else{
                    System.out.println(heroes.get(i).getType() + " " +  heroes.get(i).getCurrentHP() + " HATZ ");
                }
            }

        }
    }
}
