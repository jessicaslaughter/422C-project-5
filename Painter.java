package assignment5;

import javafx.scene.paint.*;
import javafx.scene.shape.*;

public class Painter {
	
	/* Returns a square or a circle  *  */ 
	static int size = 10;
	static Shape getIcon(Critter.CritterShape shape) {
		Shape s = null;
		switch(shape) { 
			case SQUARE: s = new Rectangle(size, size); 
				break; 
			case CIRCLE: s = new Circle(size/2); 
				break;
		default:
			break;
		} 
		return s;
	}
	
	public static int getSize() {
		// scale grid
		if (Params.world_width <= 30 || Params.world_height <= 30) {
			size = 20;
		}
		else if (Params.world_width <= 50 || Params.world_height <= 50) {
			size = 12;
		}
		else if (Params.world_width <= 75 || Params.world_height <= 75) {
			size = 8;
		}
		else if (Params.world_width <= 100 || Params.world_height <= 100) {
			size = 6;
		}
		else if (Params.world_width <= 150 || Params.world_height <= 150) {
			size = 4;
		}
		else {
			size = 3;
		}
		return size;
	}
	/* Paints the shape on a grid. */ 
	public static void paint() { 
		Main.modelGrid.getChildren().clear();
		paintGrid();
	}
	
	/**
	 * This method paints a Critter on the grid.
	 * @param x is the critter's x coordinate
	 * @param y is the critter's y coordinate
	 * @param shape is the critter's shape
	 * @param color is the critter's color
	 * @param outline is the critter's outline color
	 * @param fill is the critter's fill color
	 */
	public static void paintCritter(int x, int y, Critter.CritterShape shape, Color color, Color outline, Color fill) {
		Shape s = getIcon(shape);
		if (color.equals(fill)) {
			s.setFill(fill);
		}
		else if (color.equals(Color.WHITE)) {
			s.setFill(fill);
		}
		else {
			s.setFill(color);
		}
		s.setStroke(outline);
		Main.modelGrid.add(s, x, y);
	}
	
	private static void paintGrid() {
		for (int i = 0; i <= Main.grid.getWidth()/size; i++) {
			for (int j = 0; j <= Main.grid.getHeight()/size; j++) {
				Shape s = new Rectangle(size, size); 
				s.setFill(null);
				s.setStroke(Color.BLACK); 
				Main.modelGrid.add(s, i, j);
			}
		}
	}
}
