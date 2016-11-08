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
import java.io.File;

import javax.crypto.spec.RC2ParameterSpec;

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
			Scene scene = new Scene(grid, 450, 400);
			Text scenetitle = new Text("Critter World Controller");
			scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
			grid.add(scenetitle, 0, 0, 20, 2);
			
			Stage model = new Stage();
			model.setTitle("Model");
			Painter.setSize();
			Scene modelScene = new Scene(modelGrid, Params.world_width*(Painter.size+1), Params.world_height*(Painter.size+1));
			model.setScene(modelScene);
        	model.show();
			
			Label name = new Label("Critter Name:");
			grid.add(name, 1, 4, 2, 1);
			

			ObservableList<String> options = 
				    FXCollections.observableArrayList();
			ComboBox comboBox = new ComboBox(options);
			grid.add(comboBox, 5, 4, 10, 1);
			GridPane.setHalignment(comboBox, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(comboBox, VPos.BOTTOM); // To align vertically in the cell
			
			File[] files = new File("./src/assignment5").listFiles();
			for(File file: files){
				String fileName = file.getName();
				if(file.isFile() && fileName.contains(".java")){
					try{
						String[] fName = fileName.split(".java");
						String packageName = Critter.class.getPackage().toString().split(" ")[1];
						Critter c = (Critter) Class.forName(packageName + "." + fName[0]).newInstance();
						options.add(fName[0]);
					}catch(Exception exception){
					}
					
				}
			}
			
			
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
				                Critter.displayWorld();
	                		}catch(Exception exception){
	            					System.out.println("error processing");
	   
	                		}
	                	}
	                }
	                else{
	                    actiontarget.setFill(Color.FIREBRICK);
	                    actiontarget.setText("Please select number and type of critters");
	                }
	            	comboBox.getSelectionModel().clearSelection();
	            	numCritter.clear();
	            }
	        });
	        
			Label seedsNum = new Label("Seeds:");
			grid.add(seedsNum, 1, 9, 4, 1);
			TextField numSeeds = new TextField();
			grid.add(numSeeds, 5, 9, 10 ,1);
			Button buttSeed = new Button("Add Seeds");
			GridPane.setHalignment(buttSeed, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(buttSeed, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(buttSeed, 15, 9);
	        final Text actiontarget3 = new Text();
	        grid.add(actiontarget3, 5, 10, 20, 1);
			GridPane.setHalignment(actiontarget3, HPos.CENTER); // To align horizontally in the cell
			GridPane.setValignment(actiontarget3, VPos.BOTTOM); // To align vertically in the cell
			
	        buttSeed.setOnAction(new EventHandler<ActionEvent>() {
		       	 
	            @Override
	            public void handle(ActionEvent event) {
	                if((numSeeds.getText() != null && !numSeeds.getText().isEmpty())){
	                    String seedNum = numSeeds.getText();
	                	if(!(numSeeds.getText().matches("^[0-9]+$"))){
		                	actiontarget3.setFill(Color.FIREBRICK);
		                    actiontarget3.setText("Insert valid number");
	                	}
	                	else{
	                		try{
	                			actiontarget3.setText("                   ");
	                			long seedNum0 = Long.parseLong(seedNum);
				                Critter.setSeed(seedNum0);
	                		}catch(NullPointerException|NumberFormatException exception){
	            					System.out.println("error processing");
	   
	                		}
	                	}
	                }
	                else{
	                    actiontarget3.setFill(Color.FIREBRICK);
	                    actiontarget3.setText("Please select number of seeds");
	                }
	            }
	        });
	        
			Label numStep = new Label("Num of Steps:");
			grid.add(numStep, 1, 12, 4, 1);
			TextField numSteps = new TextField();
			grid.add(numSteps, 5, 12, 10, 1);
			Button buttStep = new Button("Time Steps");
			GridPane.setHalignment(buttStep, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(buttStep, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(buttStep, 15, 12);
	        final Text actiontarget1 = new Text();
	        grid.add(actiontarget1, 5, 13, 20, 1);
			GridPane.setHalignment(actiontarget1, HPos.CENTER); // To align horizontally in the cell
			GridPane.setValignment(actiontarget1, VPos.BOTTOM); // To align vertically in the cell
	       
	        
	        
	        
			Button displayButt = new Button("Display World");
			GridPane.setHalignment(displayButt, HPos.RIGHT); // To align horizontally in the cell
			GridPane.setValignment(displayButt, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(displayButt, 14, 0, 1, 1);
	        
	        displayButt.setOnAction(new EventHandler<ActionEvent>() {
		       	 
	            @Override
	            public void handle(ActionEvent event) {
                	Critter.clearWorld();
                	Critter.displayWorld();
	            }
	        });
	        
	        
	        Label times = new Label("Time: ");
	        grid.add(times, 1, 15, 2, 1);
	        GridPane.setHalignment(times, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(times, VPos.CENTER); // To align vertically in the cell
	        
	        final Text timesNum = new Text();
	        timesNum.setText(String.valueOf(steps));
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
	        
			Button statsButton = new Button("Stats");
			GridPane.setHalignment(statsButton, HPos.LEFT); // To align horizontally in the cell
			GridPane.setValignment(statsButton, VPos.BOTTOM); // To align vertically in the cell
	        grid.add(statsButton, 15, 23, 1, 1);
	        
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
				                	//Critter.clearWorld();
				                	Critter.displayWorld();
				                }
				                steps += Integer.parseInt(stepNum);
				                timesNum.setText("          ");
				                timesNum.setText(String.valueOf(steps));
	                		}catch(NullPointerException|NumberFormatException exception){
	            					System.out.println("error processing");
	   
	                		}
	                	}
	                }
	                else{
	                    actiontarget1.setFill(Color.FIREBRICK);
	                    actiontarget1.setText("Please select number of steps");
	                }
	            	numSteps.clear();
	            }
	        });
	       
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
