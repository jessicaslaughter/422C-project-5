package assignment5;

import javafx.scene.paint.*; import javafx.scene.shape.*;
public class Painter {
/* Returns a square or a circle  *  */ 
	static int size = 100;
	static Shape getIcon(int shapeIndex) {
		Shape s = null;
		switch(shapeIndex) { 
		case 0: s = new Rectangle(size, size); 
		s.setFill(Color.RED); break; 
		case 1: s = new Circle(size/2); 
		s.setFill(Color.GREEN); } // set the outline 
		s.setStroke(Color.BLUE); 
		return s;
	}
	/* Paints the shape on a grid. */ 
	public static void paint() { 
		Main.grid.getChildren().clear();
		paintGrid(); for (int i = 0; i <=1 ; i++) { 
			Shape s = getIcon(i);
			Main.grid.add(s, i, i); // add along the diagonal
		}
	}
	private static void paintGrid() { 
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j <= 1; j++) {
				Shape s = new Rectangle(size, size); 
				s.setFill(null); s.setStroke(Color.LIGHTYELLOW); 
				Main.grid.add(s, i, j);
			}
		}
	}
}