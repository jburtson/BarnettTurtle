package turtleClasses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Line2D;

import turtleClasses.lib.*;

public class PathSegment {
	private Color color;
	private int width;
	private Line2D.Float segment;
	
	public PathSegment(Color color, int width, Line2D.Float segment) {
		this.color = color;
		this.width = width;
		this.segment = segment;
	}

	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(color);
		g.drawLine((int)segment.x1, (int)segment.y1, (int)segment.x2, (int)segment.y2);
		// for adding width, but this is off slightly somehow
		//g.fillRect((int)segment.x2, (int)segment.y1, (int)(segment.x1-segment.x2)+width, (int)(segment.y2-segment.y1)+width);
	}

}
