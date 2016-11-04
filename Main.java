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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
	static GridPane modelGrid = new GridPane();
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
			Scene scene = new Scene(grid, 400, 400);
			Text scenetitle = new Text("Critter World Controller");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			grid.add(scenetitle, 0, 0, 20, 2);
			
			Stage model = new Stage();
			model.setTitle("Model");
			Scene modelScene = new Scene(modelGrid, 500, 500);
			model.setScene(modelScene);
        	model.show();
			
			Label name = new Label("Critter Name:");
			grid.add(name, 1, 4, 2, 1);
			
			ObservableList<String> options = 
				    FXCollections.observableArrayList(
				        "Craig",
				        "Algae"
				    );
			ComboBox comboBox = new ComboBox(options);
			grid.add(comboBox, 5, 4, 10, 1);
			GridPane.setHalignment(comboBox, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(comboBox, VPos.BOTTOM); // To align vertically in the cell
			
			

			Label num = new Label("Num of Critters:");
			grid.add(num, 1, 5, 4, 1);
			TextField numCritter = new TextField();
			grid.add(numCritter, 5, 5, 10 ,1);
			Button butt = new Button("Add critters");
			GridPane.setHalignment(butt, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(butt, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(butt, 15, 5);
	        final Text actiontarget = new Text();
	        grid.add(actiontarget, 5, 6, 20, 1);
			GridPane.setHalignment(actiontarget, HPos.CENTER); // To align horizontally in the cell
			GridPane.setValignment(actiontarget, VPos.BOTTOM); // To align vertically in the cell
	        butt.setOnAction(new EventHandler<ActionEvent>() {
	       	 
	            @Override
	            public void handle(ActionEvent event) {
	                if((comboBox.getValue() != null && 
	                        !comboBox.getValue().toString().isEmpty()) && (numCritter.getText() != null && !numCritter.getText().isEmpty())){
	                    String number = numCritter.getText();
	                    String type = comboBox.getValue().toString();
	                	if(!(numCritter.getText().matches("^[0-9]+$"))){
		                	actiontarget.setFill(Color.FIREBRICK);
		                    actiontarget.setText("Insert valid number");
	                	}
	                	else{
	                		try{
	                			actiontarget.setText("                   ");
				                for(int i=0; i < Integer.parseInt(number); i+=1){
	        							Critter.makeCritter(type);
				                }
	                		}catch(InvalidCritterException|NullPointerException|NumberFormatException exception){
	            					System.out.println("error processing");
	   
	                		}
	                	}
	                }
	                else{
	                    actiontarget.setFill(Color.FIREBRICK);
	                    actiontarget.setText("Please select number and type of critters");
	                }
	            }
	        });
	        
			Label numStep = new Label("Num of Steps:");
			grid.add(numStep, 1, 10, 4, 1);
			TextField numSteps = new TextField();
			grid.add(numSteps, 5, 10, 10, 1);
			Button buttStep = new Button("Time Steps");
			GridPane.setHalignment(buttStep, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(buttStep, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(buttStep, 15, 10);
	        final Text actiontarget1 = new Text();
	        grid.add(actiontarget1, 5, 11, 20, 1);
			GridPane.setHalignment(actiontarget1, HPos.CENTER); // To align horizontally in the cell
			GridPane.setValignment(actiontarget1, VPos.BOTTOM); // To align vertically in the cell
	        
	        buttStep.setOnAction(new EventHandler<ActionEvent>() {
		       	 
	            @Override
	            public void handle(ActionEvent event) {
	                if((numSteps.getText() != null && !numSteps.getText().isEmpty())){
	                    String stepNum = numSteps.getText();
	                	if(!(numSteps.getText().matches("^[0-9]+$"))){
		                	actiontarget1.setFill(Color.FIREBRICK);
		                    actiontarget1.setText("Insert valid number");
	                	}
	                	else{
	                		try{
	                			actiontarget1.setText("                   ");
				                for(int i=0; i < Integer.parseInt(stepNum); i+=1){
				                	Critter.worldTimeStep();
				                }
	                		}catch(NullPointerException|NumberFormatException exception){
	            					System.out.println("error processing");
	   
	                		}
	                	}
	                }
	                else{
	                    actiontarget.setFill(Color.FIREBRICK);
	                    actiontarget.setText("Please select number and type of critters");
	                }
	            }
	        });
	        
	        
	        
			Button displayButt = new Button("Display World");
			GridPane.setHalignment(displayButt, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(displayButt, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(displayButt, 5, 15);
	        
	        displayButt.setOnAction(new EventHandler<ActionEvent>() {
		       	 
	            @Override
	            public void handle(ActionEvent event) {
	                Critter.displayWorld();
	            }
	        });
	        
	        
	        Label times = new Label("Time: ");
	        grid.add(times, 1, 15, 2, 1);
	        GridPane.setHalignment(times, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(times, VPos.CENTER); // To align vertically in the cell
	        
			Label timesNum = new Label(String.valueOf(steps));
	        grid.add(timesNum, 2, 15, 1, 1);
	        GridPane.setHalignment(timesNum, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(timesNum, VPos.CENTER); // To align vertically in the cell
			
	        Label speedL = new Label("Speed: ");
	        grid.add(speedL, 1, 23);
	        GridPane.setHalignment(speedL, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(speedL, VPos.CENTER); // To align vertically in the cell
	        
			Button runButt = new Button("Run");
			GridPane.setHalignment(runButt, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(runButt, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(runButt, 13, 23, 1, 1);
	        
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
	        grid.add(slider, 2, 23, 10, 2);
			GridPane.setHalignment(slider, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(slider, VPos.BOTTOM); // To align vertically in the cell

			Button quitButt = new Button("Quit");
			GridPane.setHalignment(quitButt, HPos.RIGHT); // To align horizontally in the cell
			GridPane.setValignment(quitButt, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(quitButt, 15, 0, 1, 1);
	       
	        quitButt.setOnAction(new EventHandler<ActionEvent>() {
		       	 
	            @Override
	            public void handle(ActionEvent event) {
	                System.exit(0);
	            }
	        });
	        
			primaryStage.show();
			primaryStage.setScene(scene);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
