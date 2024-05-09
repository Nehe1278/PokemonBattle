import java.util.Scanner; //
import java.util.Random; // picks a number betwwen a set and randomizes it.

public class PokemonBATTLE {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is your base hp: "); // asks the user for the base hp of the pokemon
        double baseHp = scan.nextDouble();          

        System.out.println("What is the level: "); //this code aks the user for the level of the pokemon
        double level1 = scan.nextDouble();

        double leveledHp = pokemon(baseHp, level1); // this is setting the called method into a variable to be printed
        System.out.println("This is your leveled hp: " + leveledHp);// this just prints the leveled hp of the pokemon

        System.out.println("What is the Attack stat of your Pokemon: "); // asks for the attack stat of the pokemon
        double attack = scan.nextDouble();

        double leveledAttack = otherStat(attack, level1);
        System.out.println("This is your leveled attack stat: " + leveledAttack); // this code prints the leveled attack of the pokemon

        System.out.println("What is the hp of the first pokemon: "); // asks for pok1 hp
        int pokeOneHp = scan.nextInt();

        System.out.println("What is the hp of the second pokemon: "); // asks for pok2 hp
        int pokeTwoHp = scan.nextInt();

        System.out.println("What is the Attack stat of the first pokemon: "); // asks for pok1 attac
        int pokeOneAttack = scan.nextInt();

        System.out.println("What is the Attack stat of the second pokemon: "); //asks for pok2 attack
        int pokeTwoAttack = scan.nextInt();

        System.out.println("What is the Defense stat of the first pokemon: ");// asks for pok 1 defense
        int pokeOneDefenseStat = scan.nextInt();

        System.out.println("What is the Defense stat of the second pokemon: "); // asks for pok2 defense
        int pokeTwoDefenseStat = scan.nextInt();

        System.out.println("What is the level of the attacker: "); //asks for attackers level
        int level2 = scan.nextInt();

        battle(pokeOneHp, pokeTwoHp, pokeOneAttack, pokeTwoAttack, pokeOneDefenseStat, pokeTwoDefenseStat, level2); // calls the method, asking the user for all components of the method 

        // Print Pokemon Card
        printPokemonCard("Charmander", "fire", (int) level1, (int) leveledHp, (int) leveledAttack); // this is just a simulation of the pokemon card
    }
   
    /**
     * 
     *returns the leveld hp of the pokemon
     * 
     * @param hp - this is the hp of the pokemon being leveled
     * @param level - level is the level of the pokemon
     */
     
    public static double pokemon(double hp, double level) {
        double finalHp = 0;

        if (level == 1) {
            return 11;
        }

        while (level > 1) {
            finalHp += (1.02 * hp) + 1;
            level = level - 1;
        }

        return (int) finalHp;
    }
    
    /**
     * 
     * rerturn the attack leveld of the pokemon its a similiar to the first method just a minor change
     * 
     * @param attack - the attack stat of the pokemon to be updated
     * @param level - the level of the pokemon about tp be leveled
     * 
     */

    public static double otherStat(double attack, double level) {
        if (level == 1) {
            return 5;
        }

        while (level > 1) {
            attack += (attack * 1.02);
            level = level - 1;
        }

        return attack;
    }

    public static double randomMultiplier() {
        Random rand = new Random();

        return rand.nextDouble() * 0.15 + 0.85;
    }
    /**
     * 
     * Simulates a battle between two pokemons taking turn attacking eachother till the other one losses
     * 
     * @param  pokeOneHp - the hp of the first pokemon
     * @param  pokeTwoHp - the hp of the second pokemon
     * @param  pokeOneAttack - the attack stat of the first pokemon
     * @param  pokeTwoAttack - the attack stat of the second pokemon
     * @param  pokeOneDefenseStat - the defense stat of the first pokemon
     * @param  pokeTwoDefenseStat - the defense stat of the second pokemon
     * @param  level - the level of the attacker
     * 
     */

    public static void battle(int pokeOneHp, int pokeTwoHp, int pokeOneAttack, int pokeTwoAttack,
            int pokeOneDefenseStat, int pokeTwoDefenseStat, int level) {

        while (pokeOneHp > 0 && pokeTwoHp > 0) {
            int damagePokeOne = (int) (randomMultiplier() * ((2 * level + 10) / 250 + (pokeOneAttack / pokeTwoDefenseStat) + 2)); // this code calculates the damage of poke1 one attack against poke 2 defense 
            int damagePokeTwo = (int) (randomMultiplier() * ((2 * level + 10) / 250 + (pokeTwoAttack / pokeOneDefenseStat) + 2)); //this code calculatesthe damage poke2 attack against poke1 defense
                                                                                                                                    // both these lines ultimatley simulate both pokemons taking turns attacking each other
            System.out.println("Pokemon 1 attacks Pokemon 2 and deals " + damagePokeOne + " damage."); // this code is kind of like comentary to let the user know how much damage was done to the other pokemon
            pokeTwoHp -= damagePokeOne; // pokemon 2 hp subtarcted by the damage of pokemon 1 then set to a new value

            if (pokeTwoHp <= 0) { //if pokemon 2 hp is less than 0 or baiscally it dies
                System.out.println("Pokemon 2 loses,  Pokemon 1 wins!"); //  pokemon one wins
                break;
            }

            System.out.println("Pokemon 2 attacks Pokemon 1 and deals " + damagePokeTwo + " damage.");
            pokeOneHp -= damagePokeTwo; //pokemon 1 hp subtracted by the damage of pokemon 2 then set to a new value

            if (pokeOneHp <= 0) { // if the hp of pokemon 1 is less then 0 meaning it lost, 
                System.out.println("Pokemon 1 losses, Pokemon 2 wins!"); // pokemon 2 wins
                break; // 
            }
        }
    }
    /**
     * prints out the pokemon card
     * 
     * @param name - this is the name of the pokemon.
     * @param type - the type of pokemon. electric, earth, etc.
     * @param level - the level of the pokemon.
     * @param hp - current hp of the pokemon.
     * @param attck - the attack stat of the pokemon.
     * 
     */ 

    public static void printPokemonCard(String name, String type, int level, int hp, int attack) {
        System.out.println("+====================+");
        System.out.println("| pokemon: " + name);
        System.out.println("|--------------------|");           // this is the pokemon card  :)
        System.out.println("| type:     " + type);              
        System.out.println("| level:    " + level);
        System.out.println("| hp:       " + hp);
        System.out.println("| attack:   " + attack);
        System.out.println("+====================+");
    }
}