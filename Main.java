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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main extends Application{
	static GridPane grid = new GridPane();
	static int steps =0;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		try{
			primaryStage.setTitle("Set Up Critter World");
			grid.setHgap(5);
			grid.setVgap(5);
			grid.setGridLinesVisible(false);
			grid.setPadding(new Insets(10, 10, 10, 10));
			Scene scene = new Scene(grid, 500, 550);
			Text scenetitle = new Text("Critter World Controller");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			grid.add(scenetitle, 0, 0, 20, 2);
			
			Label name = new Label("Critter Name:");
			grid.add(name, 1, 4, 2, 1);
			
			ObservableList<String> options = 
				    FXCollections.observableArrayList(
				        "Craig",
				        "Algae"
				    );
			ComboBox comboBox = new ComboBox(options);
			grid.add(comboBox, 20, 4);
			GridPane.setHalignment(comboBox, HPos.CENTER); // To align horizontally in the cell
			GridPane.setValignment(comboBox, VPos.BOTTOM); // To align vertically in the cell

			Label num = new Label("Num of Critters:");
			grid.add(num, 1, 5, 2, 1);
			TextField numCritter = new TextField();
			grid.add(numCritter, 20, 5);
			Button butt = new Button("Add critters");
			GridPane.setHalignment(butt, HPos.RIGHT); // To align horizontally in the cell
			GridPane.setValignment(butt, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(butt, 20, 6);
	        
	        Label line = new Label(" ___________________________________________________________");
	        grid.add(line, 1, 10, 20, 1);
	        
			Label numStep = new Label("Num of Steps:");
			grid.add(numStep, 1, 16, 2, 1);
			TextField numSteps = new TextField();
			grid.add(numSteps, 20, 16);
			Button buttStep = new Button("Time Steps");
			GridPane.setHalignment(buttStep, HPos.RIGHT); // To align horizontally in the cell
			GridPane.setValignment(buttStep, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(buttStep, 20, 17);
	        
			Button displayButt = new Button("Display World");
			GridPane.setHalignment(displayButt, HPos.RIGHT); // To align horizontally in the cell
			GridPane.setValignment(displayButt, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(displayButt, 1, 20);
	        
	        Label times = new Label("Time: ");
	        grid.add(times, 19, 20, 2, 1);
	        GridPane.setHalignment(times, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(times, VPos.CENTER); // To align vertically in the cell
	        
			Label timesNum = new Label(String.valueOf(steps));
	        grid.add(timesNum, 20, 20, 1, 1);
	        GridPane.setHalignment(timesNum, HPos.CENTER); // To align horizontally in the cell
			GridPane.setValignment(timesNum, VPos.CENTER); // To align vertically in the cell
	        
			Button runButt = new Button("Run");
			GridPane.setHalignment(runButt, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(runButt, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(runButt, 1, 21);
	        
	        Slider slider = new Slider();
	        slider.setMin(0);
	        slider.setMax(10);
	        slider.setValue(5);
	        slider.setShowTickLabels(true);
	        slider.setShowTickMarks(true);
	        slider.setSnapToTicks(true);
	        slider.setMajorTickUnit(5);
	        slider.setMinorTickCount(5);
	        slider.setBlockIncrement(1);
	        grid.add(slider, 2, 21);
			GridPane.setHalignment(slider, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(slider, VPos.BOTTOM); // To align vertically in the cell

			Button quitButt = new Button("Quit");
			GridPane.setHalignment(quitButt, HPos.RIGHT); // To align horizontally in the cell
			GridPane.setValignment(quitButt, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(quitButt, 20, 25);
	        
			primaryStage.show();
			primaryStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
