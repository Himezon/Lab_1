package pokemons.mypokemons;

import pokemons.moves.Blizzard;
import pokemons.moves.Slam;
import pokemons.moves.Supersonic;
import pokemons.moves.WaterPulse;
import ru.ifmo.se.pokemon.*;

public class Hooh extends Pokemon
{
    public Hooh(String name, int level) {
        super(name, level);
        setStats(106, 130, 90, 110, 154, 90);
        setType(Type.FIRE, Type.FLYING);
        setMove(new Slam(), new Supersonic(), new WaterPulse(), new Blizzard());
    }
}
