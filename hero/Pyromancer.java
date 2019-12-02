package hero;

public class Pyromancer extends Hero {
    private static final float FIREBLAST_BASEDAMAGE = 350;
    private static final float FIREBLAST_DMGPERLVL = 50;
    private static final float IGNITE_BASEDAMAGE = 150;
    private static final float IGNITE_DMGPERLEVEL = 20;
    private static final float IGNITE_OVERTIME = 50;
    private static final float IGNITE_OVRPERLVL = 30;
    private static final float IFWIZARD_FB = 1.05f;
    private static final float IFROGUE_FB = 0.8f;
    private static final float IFPYRO_FB = 0.9f;
    private static final float IFKNIGHT_FB = 1.2f;
    private static final float IFWIZARD_IGN = 1.05f;
    private static final float IFROGUE_IGN = 0.8f;
    private static final float IFKNIGHT_IGN = 1.2f;
    private static final float IFPYRO_IGN = 0.9f;
    private static final float LAND_BONUS = 1.25f;
    private static final int IGNITE_ROUNDS = 2;

    public Pyromancer(char type, int x, int y) {
        super(type, x, y);
    }

    public int FireBlast(Hero hero, char land){
        float starting_damage;
        starting_damage = FIREBLAST_BASEDAMAGE + this.getLevel() * FIREBLAST_DMGPERLVL;
        float final_damage = 0;
        if(hero.getType() == 'W'){
            final_damage = starting_damage * IFWIZARD_FB;
        }
        if(hero.getType() == 'K'){
            final_damage = starting_damage * IFKNIGHT_FB;
        }
        if(hero.getType() == 'R'){
            final_damage = starting_damage * IFROGUE_FB;
        }
        if(hero.getType() == 'P'){
            final_damage = starting_damage * IFPYRO_FB;
        }
        if(land == 'V'){
            final_damage = final_damage * LAND_BONUS;
        }

        return Math.round(final_damage);
    }
    public int Ignite(Hero hero, char land){
        float starting_damage;
        starting_damage = IGNITE_BASEDAMAGE + this.getLevel() * IGNITE_DMGPERLEVEL;
        float final_damage = 0;
        if(hero.getType() == 'W'){
            final_damage = starting_damage * IFWIZARD_IGN;
        }
        if(hero.getType() == 'K'){
            final_damage = starting_damage * IFKNIGHT_IGN;
        }
        if(hero.getType() == 'R'){
            final_damage = starting_damage * IFROGUE_IGN;
        }
        if(hero.getType() == 'P'){
            final_damage = starting_damage * IFPYRO_IGN;
        }
        if(land == 'V'){
            final_damage = final_damage * LAND_BONUS;
        }

        return Math.round(final_damage);
    }
    public void attack(Wizard wizard, char land){
        int damage = 0;
        damage = FireBlast(wizard, land) + Ignite(wizard, land);
        if(damage >= wizard.getCurrentHP()){
            wizard.setDead(true);
        }
        else{
            wizard.setCurrentHP(wizard.getCurrentHP() - damage);
        }
        int[] igniteSet = new int[3];
        igniteSet[0] = 1;
        igniteSet[1] = Math.round(IGNITE_OVERTIME + IGNITE_OVRPERLVL * this.getLevel());
        igniteSet[2] = IGNITE_ROUNDS;
        wizard.setIsIgnited(igniteSet);
    }
    public void attack(Rogue rogue, char land){
        int damage = 0;
        damage = FireBlast(rogue, land) + Ignite(rogue, land);
        if(damage >= rogue.getCurrentHP()){
            rogue.setDead(true);
        }
        else{
            rogue.setCurrentHP(rogue.getCurrentHP() - damage);
        }
        int[] igniteSet = new int[3];
        igniteSet[0] = 1;
        igniteSet[1] = Math.round(IGNITE_OVERTIME + IGNITE_OVRPERLVL * this.getLevel());
        igniteSet[2] = IGNITE_ROUNDS;
        rogue.setIsIgnited(igniteSet);
    }
    public void attack(Knight knight, char land){
        int damage = 0;
        damage = FireBlast(knight, land) + Ignite(knight, land);
        if(damage >= knight.getCurrentHP()){
            knight.setDead(true);
        }
        else{
            knight.setCurrentHP(knight.getCurrentHP() - damage);
        }
        int[] igniteSet = new int[3];
        igniteSet[0] = 1;
        igniteSet[1] = Math.round(IGNITE_OVERTIME + IGNITE_OVRPERLVL * this.getLevel());
        igniteSet[2] = IGNITE_ROUNDS;
        knight.setIsIgnited(igniteSet);
    }
    public void attack(Pyromancer pyromancer, char land){
        int damage = 0;
        damage = FireBlast(pyromancer, land) + Ignite(pyromancer, land);
        if(damage >= pyromancer.getCurrentHP()){
            pyromancer.setDead(true);
        }
        else{
            pyromancer.setCurrentHP(pyromancer.getCurrentHP() - damage);
        }
        int[] igniteSet = new int[3];
        igniteSet[0] = 1;
        igniteSet[1] = Math.round(IGNITE_OVERTIME + IGNITE_OVRPERLVL * this.getLevel());
        igniteSet[2] = IGNITE_ROUNDS;
        pyromancer.setIsIgnited(igniteSet);
    }


}
