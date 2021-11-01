package pokemons.moves;
import ru.ifmo.se.pokemon.*;

public class NastyPlot extends StatusMove {
    public NastyPlot() {super(Type.DARK, 0, 85);}
    @Override
    protected void applyOppEffects(Pokemon poke)
    {
        Effect rest = new Effect().stat(Stat.SPECIAL_ATTACK,2);
        poke.addEffect(rest);
    }
    @Override
    protected String describe() {return "использует Nasty Plot";}
}
