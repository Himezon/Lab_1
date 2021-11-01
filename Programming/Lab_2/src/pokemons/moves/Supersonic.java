package pokemons.moves;
import ru.ifmo.se.pokemon.*;

public class Supersonic extends StatusMove
{
    public Supersonic() {super(Type.NORMAL, 0, 55);}
    @Override
    protected void applyOppEffects(Pokemon poke) {poke.confuse();}
    @Override
    protected String describe() {return "использует Supersonic";}
}
