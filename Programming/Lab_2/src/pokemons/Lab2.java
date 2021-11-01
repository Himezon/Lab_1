package pokemons;
import pokemons.mypokemons.*;
import ru.ifmo.se.pokemon.*;

public class Lab2
{
    public static void main(String ... args)
    {
        Battle battle = new Battle();
        Hooh poke1 = new Hooh("Олег", 3);
        Shelmet poke2 = new Shelmet("Кирилл", 1);
        Accelgor poke3 = new Accelgor("Денис", 2);
        Happiny poke4 = new Happiny("Victor", 1);
        Chansey poke5 = new Chansey("Evgeniy", 2);
        Blissey poke6 = new Blissey("Anton", 3);
        battle.addAlly(poke1);
        battle.addAlly(poke2);
        battle.addAlly(poke3);
        battle.addFoe(poke4);
        battle.addFoe(poke5);
        battle.addFoe(poke6);
        battle.go();
    }
}
