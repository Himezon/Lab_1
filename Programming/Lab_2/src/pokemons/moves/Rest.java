package pokemons.moves;
import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove
{
    public Rest() {super(Type.PSYCHIC, 0, 100);}
    @Override
    protected void applySelfEffects(Pokemon poke)
    {
        Effect rest = new Effect().turns(2).condition(Status.SLEEP);
        poke.addEffect(rest);
        poke.restore();
    }
    @Override
    protected String describe() {return "использует Rest";}
}