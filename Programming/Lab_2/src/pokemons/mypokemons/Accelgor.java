package pokemons.mypokemons;

import pokemons.moves.Bulldoze;
import pokemons.moves.DoubleTeam;
import pokemons.moves.MachPunch;
import pokemons.moves.Rest;
import ru.ifmo.se.pokemon.*;

public class Accelgor extends Pokemon
{
    public Accelgor(String name, int level) {
        super(name, level);
        setStats(80, 70, 40, 100, 60, 145);
        setType(Type.BUG);
        setMove(new Rest(), new DoubleTeam(), new Bulldoze(), new MachPunch());
    }
}
