package pokemons.moves;
import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove
{
    public Swagger() {super(Type.NORMAL, 0, 85);}
    @Override
    protected void applyOppEffects(Pokemon poke)
    {
        poke.confuse();
        Effect rest = new Effect().stat(Stat.ATTACK,2);
        poke.addEffect(rest);
    }
    @Override
    protected String describe() {return "использует Swagger";}
}
