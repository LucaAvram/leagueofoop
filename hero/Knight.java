package hero;

public class Knight extends Hero {
    private static final float HP_LIMIT = 0.2f;
    private static final float LEVEL_MULTIPIER = 0.01f;
    private static final float EXECUTE_BASEDAMAGE = 200;
    private static final float EXECUTE_DMGPERLVL = 30;
    private static final float SLAM_BASEDAMAGE = 100;
    private static final float SLAM_DMGPERLEVEL = 40;
    private static final float IFWIZARD_EXEC = 0.8f;
    private static final float IFROGUE_EXEC = 1.15f;
    private static final float IFPYRO_EXEC = 1.1f;
    private static final float IFKNIGHT_EXEC = 1f;
    private static final float IFWIZARD_SLAM = 1.05f;
    private static final float IFROGUE_SLAM = 0.8f;
    private static final float IFKNIGHT_SLAM = 1.2f;
    private static final float IFPYRO_SLAM = 0.9f;
    private static final float LAND_BONUS = 1.15f;



    public Knight(char type, int x, int y) {
        super(type, x, y);
    }

    public int Execute(Hero hero, char land){

        float hp_limit = HP_LIMIT + this.getLevel()*LEVEL_MULTIPIER;
        if(hp_limit > 1.4f){
            hp_limit = 1.4f;
        }
        if(hero.getCurrentHP() < hp_limit){
            return hero.getCurrentHP();
        }

        float starting_damage = EXECUTE_BASEDAMAGE + this.getLevel()*EXECUTE_DMGPERLVL;
        float final_damage = 0;
        if(hero.getType() == 'W'){
            final_damage = starting_damage * IFWIZARD_EXEC;
        }
        if(hero.getType() == 'K'){
            final_damage = starting_damage * IFKNIGHT_EXEC;
        }
        if(hero.getType() == 'R'){
            final_damage = starting_damage * IFROGUE_EXEC;
        }
        if(hero.getType() == 'P'){
            final_damage = starting_damage * IFPYRO_EXEC;
        }

        if(land == 'L'){
            final_damage = final_damage * LAND_BONUS;
        }
        return Math.round(final_damage);
    }
    public int Slam(Hero hero, char land){
        float starting_damage;
        starting_damage = SLAM_BASEDAMAGE + this.getLevel()*SLAM_DMGPERLEVEL;
        float final_damage = 0;
        if(hero.getType() == 'W'){
            final_damage = starting_damage * IFWIZARD_SLAM;
        }
        if(hero.getType() == 'K'){
            final_damage = starting_damage * IFKNIGHT_SLAM;
        }
        if(hero.getType() == 'R'){
            final_damage = starting_damage * IFROGUE_SLAM;
        }
        if(hero.getType() == 'P'){
            final_damage = starting_damage * IFPYRO_SLAM;
        }
        if(land == 'L'){
            final_damage = final_damage * LAND_BONUS;
        }
        return Math.round(final_damage);
    }

    public void attack(Wizard wizard, char land){
        int damage = 0;
        damage = Execute(wizard, land) + Slam(wizard, land);
        if(damage >= wizard.getCurrentHP()){
            wizard.setDead(true);
            return;
        }
        else{
            wizard.setCurrentHP(wizard.getCurrentHP() - damage);
        }
        wizard.setIsSlammed(1);
    }
    public void attack(Rogue rogue, char land){
        int damage = 0;
        damage = Execute(rogue, land) + Slam(rogue, land);
        if(damage >= rogue.getCurrentHP()){
            rogue.setDead(true);
            return;
        }
        else{
            rogue.setCurrentHP(rogue.getCurrentHP() - damage);
        }
        rogue.setIsSlammed(1);
    }
    public void attack(Knight knight, char land){
        int damage = 0;
        damage = Execute(knight, land) + Slam(knight, land);
        if(damage >= knight.getCurrentHP()){
            knight.setDead(true);
            return;
        }
        else{
            knight.setCurrentHP(knight.getCurrentHP() - damage);
        }
        knight.setIsSlammed(1);
    }
    public void attack(Pyromancer pyromancer, char land){
        int damage = 0;
        damage = Execute(pyromancer, land) + Slam(pyromancer, land);
        if(damage >= pyromancer.getCurrentHP()){
            pyromancer.setDead(true);
            return;
        }
        else{
            pyromancer.setCurrentHP(pyromancer.getCurrentHP() - damage);
        }
        pyromancer.setIsSlammed(1);
    }
    public int BaseDamageCalculator(){
        float baseDamage = EXECUTE_BASEDAMAGE + EXECUTE_DMGPERLVL * this.getLevel();
    }


}
