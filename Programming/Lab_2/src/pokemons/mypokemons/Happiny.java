package pokemons.mypokemons;

import pokemons.moves.Facade;
import pokemons.moves.Swagger;
import ru.ifmo.se.pokemon.*;

public class Happiny extends Pokemon
{
    public Happiny(String name, int level) {
        super(name, level);
        setStats(100, 5, 5, 15, 65, 30);
        setType(Type.NORMAL);
        setMove(new Facade(), new Swagger());
    }
}
