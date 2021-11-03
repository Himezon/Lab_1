package pokemons;
import pokemons.mypokemons.*;
import ru.ifmo.se.pokemon.*;

public class Lab2
{
    public static void main(String... args)
    {
        Battle battle = new Battle();
        Hooh poke1 = new Hooh("Ally1", 3);
        Shelmet poke2 = new Shelmet("Ally2", 2);
        Accelgor poke3 = new Accelgor("Ally3", 1);
        Happiny poke4 = new Happiny("Foe1", 1);
        Chansey poke5 = new Chansey("Foe2", 2);
        Blissey poke6 = new Blissey("Foe3", 3);
        battle.addAlly(poke1);
        battle.addAlly(poke2);
        battle.addAlly(poke3);
        battle.addFoe(poke4);
        battle.addFoe(poke5);
        battle.addFoe(poke6);
        battle.go();
    }
}
