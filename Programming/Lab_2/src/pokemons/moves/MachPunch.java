package pokemons.moves;
import ru.ifmo.se.pokemon.*;

public class MachPunch extends PhysicalMove
{
    public MachPunch() {super(Type.FIGHTING, 40, 100, 1, 1);}
    @Override
    protected String describe() {return "использует Mach Punch";}
}

