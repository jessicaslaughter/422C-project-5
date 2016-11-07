/* CRITTERS Main.java
 * EE422C Project 4 submission by
 * Gina Lu
 * gbl286
 * 16480
 * Jessica Slaughter
 * jts3329
 * 16470
 * Slip days used: <0>
 * Fall 2016
 */
package assignment5;

/**
 * This Critter only cares about eating food (Algae). It never fights, and chooses to search for more food instead.
 * If it's close to dying (energy < 10), it will run for food. Otherwise, it will just walk.
 * After each time step, this Critter will change direction by one counterclockwise turn.
 * 
 * @author jessicaslaughter
 *
 */
public class Critter1 extends Critter {
	
	@Override
	public String toString() { return "1"; }
	
	private int dir;
	private int algaeEaten;
	
	public Critter1() {
		dir = Critter.getRandomInt(8);
	}

	/**
	 * This method defines Critter1s actions during a time step.
	 * If its energy is less than 10, it runs. Otherwise, it walks.
	 * It changes direction each time step by one unit
	 * counterclockwise.
	 */
	@Override
	public void doTimeStep() {
		if (getEnergy() < 10) {
			run(dir); // need some food right now
		}
		else {
			walk(dir); // can take my time looking for food
		}
		
		// new direction that loops counterclockwise
		if (dir + 1 > 7) {
			dir = 0;
		}
		else {
			dir++;
		}
	}

	/**
	 * This method defines Critter1s actions during a fight.
	 * If its opponent is algae, it will fight. Otherwise, it will walk 
	 * away and not fight.
	 */
	@Override
	public boolean fight(String opponent) {
		if (opponent.equals("@")) {
			algaeEaten++;
			return true; // always eat algae
		}
		walk(dir);
		return false; // never fights, only cares about food
	}
	
	/**
	 * This method determines and prints the stats for
	 * all of the Critter1s currently in the population
	 * of all Critters.
	 * @param ones is the list of Critter1s in the population
	 */
	public static void runStats(java.util.List<Critter> ones) {
		int totalAlgaeEaten = 0;
		int hungryCrits = 0;
		int stuffedCrits = 0;
		for (Object obj : ones) {
			Critter1 c = (Critter1) obj;
			totalAlgaeEaten += c.algaeEaten;
			if (c.getEnergy() < 10) {
				hungryCrits++;
			}
			if (c.getEnergy() > 100) {
				stuffedCrits ++;
			}
		}
		System.out.print("" + ones.size() + " total Critter1s    ");
		System.out.print("" + totalAlgaeEaten + " algae eaten by us    ");
		System.out.print("" + hungryCrits + " hungry Critter1s    ");
		System.out.println("" + stuffedCrits + " stuffed Critter1s    ");
	}

	@Override
	public CritterShape viewShape() {
		return CritterShape.SQUARE;
	}
	
	@Override
	public javafx.scene.paint.Color viewFillColor() { return javafx.scene.paint.Color.CORAL; }
}
