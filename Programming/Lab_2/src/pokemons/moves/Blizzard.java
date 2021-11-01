package pokemons.moves;
import ru.ifmo.se.pokemon.*;

public class Blizzard extends SpecialMove
{
    public Blizzard() {super(Type.ICE, 110, 70);}
    @Override
    protected void applyOppEffects(Pokemon poke)
    {
        if (Math.random() < 0.1)
        {
            Effect.freeze(poke);
        }
    }
    @Override
    protected String describe() {return "использует Blizzard";}
}
