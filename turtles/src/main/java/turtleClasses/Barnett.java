package turtleClasses;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import turtleClasses.lib.Turtle;
import turtleClasses.lib.World;

// The goal here is to use turtles to draw a graphical representation of any number based on it's prime factors
// The method is based on the number visualization of kid genius Jacob "Jake" Barnett

// IDEA: for large primes, instead of drawing basically a circle, break it into different more readable numbers to be added together
// ex. 107 -> (2*53)+1
//				53 -> (4*13)+1
//						13 -> (3*4)+1

public class Barnett {
	private World world;
	private Turtle turtle;
	
	public Barnett(int worldHeight, int worldWidth, int turtleX, int turtleY) {
		world = new World(1200,1200);
		turtle = new Turtle(600,600,world);
	}
	
	public static void main(String...args) {
		Barnett b = new Barnett(1200,1200,600,600);
		ArrayList<Integer> factors = new ArrayList<Integer>();
//		factors.add(2);
		factors.add(3);
//		factors.add(3);
//		factors.add(3);
//		factors.add(4);
		factors.add(5);
//		factors.add(6);
		factors.add(7);
//		factors.add(8);
//		factors.add(9);
//		factors.add(4);
		Collections.sort(factors);
		Collections.reverse(factors);
		b.visualize(1000, factors);
//	    b.drawPolygonEdge(3, 1000);
//		b.drawPolygonCorner(5, 1000);
//		b.test();
	}
	Color[] colors = {Color.BLACK,Color.BLACK,Color.RED,Color.ORANGE,Color.YELLOW,Color.GREEN,Color.BLUE,Color.MAGENTA,Color.PINK};
	double scaleDownFactor = 2;
	public void visualize(double scale,List<Integer> factors) {
		if (factors.size()>0) {
			//store old color
			Color oldColor = turtle.getPenColor();
			int factor = factors.get(0);
			/*
			// testing the concept of breaking up large primes into (prime-1) + 1
			if (factor>12) {
				factors.set(0, factor-1);
				factor = factors.get(0);
				turtle.forward((int)((scale/(factor*2))*Math.sqrt(factor)));
				turtle.backward((int)((scale/(factor*2))*Math.sqrt(factor)));
			}
			*/
			if (factor<3 || factor>=colors.length) turtle.setColor(Color.BLACK);
			else turtle.setColor(colors[factor]);
			int segment = (int) scale / factor;
			double turn = 360.0 / factor;
			
			turtle.turnLeft();
			turtle.forward(segment/2);
			for (int i=0; i < factor - 1; i++) {
				// Recursive shape
				if (factors.size()>1) {
					turtle.turnLeft();
					turtle.turn(turn/2);
					turtle.backward((int)(segment/(2*scaleDownFactor)));
					visualize(scale*scaleDownFactor/factor, factors.subList(1, factors.size()));
					turtle.forward((int)(segment/(2*scaleDownFactor)));
					turtle.turn(-turn/2);
					turtle.turnRight();
				}
				turtle.turn(turn);
				turtle.forward(segment);
			}
			if (factors.size()>1) {
				turtle.turnLeft();
				turtle.turn(turn/2);
				turtle.backward((int)(segment/(2*scaleDownFactor)));
				visualize(scale*scaleDownFactor/factor, factors.subList(1, factors.size()));
				turtle.forward((int)(segment/(2*scaleDownFactor)));
				turtle.turn(-turn/2);
				turtle.turnRight();
			}
			turtle.turn(turn);
			turtle.forward(segment/2);
			turtle.turnRight();
			//reset color
			turtle.setColor(oldColor);
		}
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
