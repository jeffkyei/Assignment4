package jkyeiasare;
/*
 * Course Name: CMSC203 CRN 31569
 * Project Number: 4
 * Name: Jeffrey Kyei-Asare
 * Date: 3/28/23
 * Complier: Eclipse
 */

public class Plot {

	private int x; //var for x
	private int y; //var for y
	private int width; //var for width
	private int depth; //var for depth

	//no-arg constructor
	public Plot() {
		this.x = 0; //x for this constructor
		this.y = 0; //y for this constructor
		this.width = 1; //width for this constructor
		this.depth = 1; //depth for this constructor
	}

	//copy constructor
	public Plot(Plot p) {
		this.x = p.x; //set x in copy constructor
		this.y = p.x; //set y in copy constructor
		this.width = p.width; //set width in copy constructor
		this.depth = p.depth; //set depth in copy constructor

	}

	//parameterized constructor
	public Plot(int x, int y, int width, int depth) {
		this.x = x; //set x in parameterized constructor
		this.y = y; //set y in parameterized constructor
		this.width = width; //set width in parameterized constructor
		this.depth = depth; //set depth in parameterized constructor
	}

	public void setX(int x) { //set X
		this.x = x;
	}
	
	public int getX() { //get X
		return x;
	}

	public void setY(int y) { //set Y
		this.y = y;
	}
	
	public int getY() { //get Y
		return y;
	}

	public void setWidth(int width) { //set width
		this.width = width;
	}
	
	public int getWidth() { //get width
		return width;
	}

	public void setDepth(int depth) { //set depth
		this.depth = depth;
	}


	public int getDepth() { //get depth
		return depth;
	}

	// method to check if plot overlaps
	public boolean overlaps(Plot plot) {

		boolean overlap = false; //boolean var for overlap
		double plotX = plot.x + plot.width; //double for plotX
		double xSide = x + width; //double for xSide
		double plotY = plot.y + plot.depth; //double for plotY
		double ySide = y + depth; //double for ySide

		if((x < plotX) && (xSide > plot.x) && (y < plotY) && (ySide > plot.y)) { //check if overlap
			overlap = true; //set overlap to true
		}
		return overlap; //return overlap or not

	}

	// method to check if plot encompasses
	public boolean encompasses(Plot plot) {
		
		boolean encompass = false; //boolean var for encompass
		double xSide = x + width; //double for xSide
		double plotX = plot.getX() + plot.getWidth(); //double for plotX
		double ySide = y + depth; //double for ySide
		double plotY = plot.getY() + plot.getDepth(); //double for plotY
		boolean smallerX = (this.x<=plot.getX()); //boolean for smallerX
		boolean smallerWidth = (plot.getX()<=xSide); //boolean for smallerWidth
		boolean smallerY = (this.y<=plot.getY()); //boolean for smallerY
		boolean smallerDepth = (plot.getY()<=ySide); //boolean for smallerDepth
		
		//check if encompass each other
		if ((smallerX) && (smallerWidth) && (smallerY) && (smallerDepth) && (this.x<=xSide) && (plotX <= xSide) && (this.y<=plotY) && (plotY <= ySide)) {
			encompass = true;
		}
		return encompass; //return whether or not encompass
	}
 
	//toString method
	public String toString() {
		String str = "Upper left: (" + getX() + "," + getY() + "); Width: " + getWidth() + " Depth: " + getDepth();
		return str;
	}

}


