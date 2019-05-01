package turtleClasses;

import turtleClasses.lib.Turtle;
import turtleClasses.lib.World;

// The goal here is to use turtles to draw a graphical representation of any number based on it's prime factors
// The method is based on the number visualization of kid genius Jacob "Jake" Barnett
public class Barnett {
	private World world;
	private Turtle turtle;
	
	public Barnett(int worldHeight, int worldWidth, int turtleX, int turtleY) {
		world = new World(1200,1200);
		turtle = new Turtle(600,600,world);
	}
	
	public static void main(String...args) {
		Barnett b = new Barnett(1200,1200,600,600);
		b.visualize(12, 1000);
//	    b.drawPolygonEdge(3, 1000);
//		b.drawPolygonCorner(5, 1000);
//		b.test();
	}
	
	public void visualize(int number, double scale) {
		drawPolygonEdge(number,scale);
	}
	
	// turtle draws polygon of parameter sides, and returns to origin
	// turtle rests at corner of shape
	public void drawPolygonCorner(int sides, double scale) {
		if (sides>0) {
			int segment = (int) scale/sides;
			double turn = 360.0/sides;
			
			turtle.turnLeft();
			turtle.turn((-turn/2));
			for (int i=0; i<sides; i++) {
				turtle.turn(turn);
				turtle.forward(segment);
			}
			turtle.turn((turn/2));
			turtle.turnRight();
		}
	}
	// turtle draws polygon of parameter sides, and returns to origin
	// turtle rests centered in the middle of an edge
	public void drawPolygonEdge(int sides, double scale) {
		if (sides>0) {
			int segment = (int) scale/sides;
			double turn = 360.0/sides;
			
			turtle.turnLeft();
			turtle.forward(segment/2);
			for (int i=0; i<sides-1; i++) {
				turtle.turn(turn);
				turtle.forward(segment);
			}
			turtle.turn(turn);
			turtle.forward(segment/2);
			turtle.turnRight();
		}
	}
	
	public void test() {
		turtle.forward();
		turtle.turn(60);
		turtle.forward();
	}

}
