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
package assignment5; // cannot be in default package
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.stage.Stage;
/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main extends Application{
	static GridPane grid = new GridPane();
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		try{
			Scene scene = new Scene(grid, 300, 300);
			primaryStage.setScene(scene);
			primaryStage.show();
			Painter.paint();
			Stage secondStage = new Stage(); secondStage.setTitle("Second Stage");
			// Stackpane is a controller 
			StackPane pane = new StackPane(); 
			Button butt = new Button("OK"); 
			pane.getChildren().add(butt);
			Scene secondScene = new Scene(pane, 200, 50); 
			secondStage.setScene(secondScene); 
			secondStage.show();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
/*
    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console


    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
    }

    *//**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     *//*
    public static void main(String[] args) { 
    	launch(args);
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }

         Do not alter the code above for your submission. 
         Write your code below. 
       
        while(true) {
        	System.out.print("critters> ");
        	String input = kb.nextLine();
        	String[] in= input.split(" ");

        	switch(in[0]){
        		case "quit":
        			if (in.length > 1) {
        				System.out.println("error processing: " + input);
        			}
        			else {
        				System.exit(0);
        			}
        		case "show":
        			if (in.length > 1) {
        				System.out.println("error processing: " + input);
        			}
        			else {
        				Critter.displayWorld();
        			}
        			continue;
        		case "step":
        			if (in.length > 2) {
        				System.out.println("error processing: " + input);
        			}
        			else {
        				try{
        					if(in.length > 1){
        						int numOfSteps = Integer.parseInt(in[1]);
        						for(int i=0; i < numOfSteps-1; i+=1){
        							Critter.worldTimeStep();
        						}	
        					}
        					Critter.worldTimeStep();
        				}
        				catch(NullPointerException|NumberFormatException exception){
        					System.out.println("error processing: " + input);
        				}
        			}
        			continue;
        		case "seed":
        			if (in.length > 2) {
        				System.out.println("error processing: " + input);
        			}
        			else {
        				try{
        					long seedNum = Long.parseLong(in[1]);
        					Critter.setSeed(seedNum);
        				}
        				catch(NullPointerException|NumberFormatException exception){
        					System.out.println("error processing: " + input);
        				}
        			}
        			continue;
        		case "make":
        			if (in.length > 3) {
        				System.out.println("error processing: " + input);
        			}
        			else {
        				try{
        					if(in.length > 2){
        						int numOfMake = Integer.parseInt(in[2]);
        						if (numOfMake < 0) {
        							System.out.println("error processing: " + input);
        						}
        						for(int i=0; i < numOfMake-1; i+=1){
        							Critter.makeCritter(in[1]);
        						}	
        					}
        					Critter.makeCritter(in[1]);
        				}
        				catch(InvalidCritterException|NullPointerException|NumberFormatException exception){
        					System.out.println("error processing: " + input);
        				}
        			}
        			continue;
        		case "stats":
        			if (in.length != 2) {
        				System.out.println("error processing: " + input);
        			}
        			else {
        				String inputClass = in[1];
        				List<Critter> crits = null;
        				try {
        					crits = Critter.getInstances(inputClass);
        				}
        				catch (InvalidCritterException e) {
        					System.out.println("error processing: " + input);
        				}
        				Class<?> critClass = null;
        				Class<?>[] types = {List.class};
        				try {
        					critClass = Class.forName(myPackage + "." + inputClass);
        					java.lang.reflect.Method runStats = critClass.getMethod("runStats", types);
        					runStats.invoke(critClass, crits);
        				}
        				catch (Exception e) {
        					System.out.println("error processing: " + input);
        				}
        			}
        			continue;
        		default:
        			System.out.println("invalid command: " + input);
        	}
        }
         Write your code above 


    }*/
}
