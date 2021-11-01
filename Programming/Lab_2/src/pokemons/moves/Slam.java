package pokemons.moves;
import ru.ifmo.se.pokemon.*;

public class Slam extends PhysicalMove
{
    public Slam() {super(Type.NORMAL, 80, 75);}
    @Override
    protected String describe() {return "использует Slam";}
}