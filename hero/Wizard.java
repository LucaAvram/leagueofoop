package hero;

public class Wizard extends Hero {
    private static final float DR_BASEPERCENT = 1.2f;
    private static final float DR_PERLVL = 1.05f;
    private static final float BASEHP_DEFAULT = 0.3f;
    private static final float IFWIZARD_DR = 1.05f;
    private static final float IFROGUE_DR = 0.8f;
    private static final float IFPYRO_DR = 0.9f;
    private static final float IFKNIGHT_DR = 1.2f;


    public Wizard(char type, int x, int y) {
        super(type, x, y);
    }

    public int Drain(Hero hero, char land){
        float starting_total_percent =  DR_BASEPERCENT + DR_PERLVL * this.getLevel();
        float total_percent = 0;
        if(hero.getType() == 'W'){
            total_percent = starting_total_percent * IFWIZARD_DR;
        }
        if(hero.getType() == 'R'){
            total_percent = starting_total_percent * IFROGUE_DR;
        }
        if(hero.getType() == 'P'){
            total_percent = starting_total_percent * IFPYRO_DR;
        }
        if(hero.getType() == 'K'{
            total_percent = starting_total_percent * IFKNIGHT_DR;
        }
        float damage = total_percent * Math.min(BASEHP_DEFAULT * hero.getMaxHP(),
                hero.getCurrentHP());

        return Math.round(damage);
    }

}
