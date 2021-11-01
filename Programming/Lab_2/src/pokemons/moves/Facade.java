package pokemons.moves;
import ru.ifmo.se.pokemon.*;

public class Facade extends PhysicalMove
{
    public Facade() {super(Type.FIGHTING, 70, 100);}
    @Override
    protected void applyOppDamage(Pokemon poke, double damage)
    {
        if (poke.getCondition()==Status.BURN
            || poke.getCondition()==Status.POISON
            || poke.getCondition()==Status.PARALYZE)
        {
            poke.setMod(Stat.HP, (int) Math.round(damage)*2);
        }
        else
        {
            poke.setMod(Stat.HP, (int) Math.round(damage));
        }
    }
    @Override
    protected String describe() {return "использует Facade";}
}
