package pokemons.mypokemons;

import pokemons.moves.Bulldoze;
import pokemons.moves.DoubleTeam;
import pokemons.moves.Rest;
import ru.ifmo.se.pokemon.*;

public class Shelmet extends Pokemon
{
    public Shelmet(String name, int level) {
        super(name, level);
        setStats(50, 40, 85, 40, 65, 25);
        setType(Type.BUG);
        setMove(new Rest(), new DoubleTeam(), new Bulldoze());
    }
}
