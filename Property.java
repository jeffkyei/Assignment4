package jkyeiasare;
/*
 * Course Name: CMSC203 CRN 31569
 * Project Number: 4
 * Name: Jeffrey Kyei-Asare
 * Date: 3/28/23
 * Complier: Eclipse
 */

//property class
public class Property {
	private String city; //string var for city
	private String owner; //string var for owner
	private String propertyName; //string var for propertyName
	private double rentAmount; //double var for rent Amount
	private Plot plot; //plot object


	//No-Arg constructor (default val)
	public Property(){
		this.city = "";
	    this.owner = "";
	    this.propertyName = "";
	    this.rentAmount = 0;
	    this.plot = new Plot(0,0,1,1);
	}
	   
	//copy constructor (set equal to each other)
	   public Property (Property p) {
	       this.city = p.city;
	       this.owner = p.owner;
	       this.propertyName = p.propertyName;
	       this.rentAmount = p.rentAmount;
	       this.plot = new Plot(p.plot);
	   }

	   //parameterized construcor with no plot
	   public Property(String propertyName, String city, double rentAmount, String owner) {
	       this.propertyName = propertyName;
	       this.city = city;
	       this.owner = owner;
	       this.rentAmount = rentAmount;
	       this.plot = new Plot();
	   }


	   //parameterized constructor with plot
	   public Property(String propertyName, String city, double rentAmount, String owner,
	           int x, int y, int width, int depth) {
	       this.propertyName = propertyName;
	       this.city = city;
	       this.owner = owner;
	       this.rentAmount = rentAmount;
	       this.plot = new Plot(x, y, width, depth);
	   }
	   
	  //propertyName getter
	   public String getPropertyName()
	   {
	       return propertyName;
	   }
	  
	   //propertyName setter
	   public void setPropertyName(String propertyName)
	   {
	       this.propertyName = propertyName;
	   }
	   //city getter
	   public String getCity()
	   {
	       return city;
	   }
	   //set city
	   public void setCity(String city)
	   {
	       this.city = city;
	   }
	   
	   //getter for owner
	   public String getOwner()
	   {
	       return owner;
	   }
	   //set owner
	   public void setOwner(String owner)
	   {
	       this.owner = owner;
	   }
	  //get rental amount
	   public double getRentAmount()
	   {
	       return rentAmount;
	   }
	 
	   //set rental amount
	   public void setRentAmount(double rentAmount)
	   {
	       this.rentAmount = rentAmount;
	   }
	   
	   //get plot
	   public Plot getPlot()
	   {
	       return plot;
	   }
	  //set plot 
	   public Plot setPlot(int x, int y, int width, int depth)
	   {
	       return new Plot(x, y, width, depth);
	   }
	  
	   //toString method
	   public String toString()
	   {
	       return "Property Name: " + propertyName + "\nLocated in city: " + city + "\nBelonging to: " + owner + "\nRent Amount: " + rentAmount;
	   }
	  
	}