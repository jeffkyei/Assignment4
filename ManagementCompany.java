package jkyeiasare;
/*
 * Course Name: CMSC203 CRN 31569
 * Project Number: 4
 * Name: Jeffrey Kyei-Asare
 * Date: 3/28/23
 * Complier: Eclipse
 */

//ManagementCompany class
public class ManagementCompany {
	private final int MAX_PROPERTY = 5; //var for max prop
	  private double mgmFeePer; //var for mgm fee
	  private String name; //var for name
	  private Property[] properties; //var for properties
	  private String taxID; //var for taxID
	  private int MGMT_WIDTH = 10; //var for mgmt width
	  private int MGMT_DEPTH = 10; //var for mgmt depth
	  private Plot plot; //var for plot
	  private int count = 0; //var for count

	 //No-Arg Constructor
	  public ManagementCompany() {
	    properties = new Property[MAX_PROPERTY];
	    this.name = "";
	    this.taxID = "";
	    this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	  }

	  //getter for mgmFee
	  public double getMgmFeePer() {
		return mgmFeePer;
	}

	  //setter for mgmFee
	public void setMgmFeePer(double mgmFeePer) {
		this.mgmFeePer = mgmFeePer;
	}

	//getter for name
	public String getName() {
		return name;
	}

	//setter for name
	public void setName(String name) {
		this.name = name;
	}

	//getter for properties
	public Property[] getProperties() {
		return properties;
	}

	//setter for properties
	public void setProperties(Property[] properties) {
		this.properties = properties;
	}

	//getter for taxID
	public String getTaxID() {
		return taxID;
	}

	//setter for taxID
	public void setTaxID(String taxID) {
		this.taxID = taxID;
	}

	//getter for plot
	public Plot getPlot() {
		return plot;
	}

	//setter for plot
	public void setPlot(Plot plot) {
		this.plot = plot;
	}

	//getter for count
	public int getCount() {
		return count;
	}

	//setter for count
	public void setCount(int count) {
		this.count = count;
	}

	
	//ManagementCompany parameterized constructor 
	  public ManagementCompany(String name, String taxID, double mgmFeePer) {
	    properties = new Property[MAX_PROPERTY];
	    this.name = name;
	    this.taxID = taxID;
	    this.mgmFeePer = mgmFeePer;
	    this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	  }

	  
	  //ManagementCompany copy constructor
	  public ManagementCompany(ManagementCompany otherCompany) {
	    properties = new Property[MAX_PROPERTY];
	    name = otherCompany.name;
	    taxID = otherCompany.taxID;
	    mgmFeePer = otherCompany.mgmFeePer;
	    plot = otherCompany.plot;
	  }

	  
	  //ManagementCompany parameterized constructor
	  public ManagementCompany(String name,String taxID, double mgmFeePer, int x, int y, int width, int depth) {
	    properties = new Property[MAX_PROPERTY];
	    this.name = name;
	    this.taxID = taxID;
	    this.mgmFeePer = mgmFeePer;
	    this.plot = new Plot(x, y, width, depth);
	  }

	  //method to get maxProperty
	  public int getMAX_PROPERTY() {
	    return MAX_PROPERTY;
	  }

	
	  //method to add property with property parameter
	  public int addProperty(Property property) { 
	    if (count == MAX_PROPERTY) { //if count is same as max prop, return -1
	      return -1;
	    }
	    else if (property == null) { //if property is null, return -2
	      return -2;
	    }
	    else if ((this.plot.encompasses(property.getPlot())) == false) { //if plot is not encompassed by other plot return -3
	      return -3;
	    } 
	    else{
	    	for(int i = 0; i < count; i++) { 
	    		if(properties[i].getPlot().overlaps(property.getPlot())) { //if plot overlaps return -4
	    			return -4;
	    		}
	    	}
	    	//else add to properties
	    	properties[count] = property;
	    	int temp = count;
		    count++;
		    return temp;
	    }
	      
	  }

	  
	  //method for addProperty with four parameters
	  public int addProperty(String name, String city, double rent, String owner) {
	    
		 //create a property object.
	    Property property = new Property(name, city, rent, owner, 0, 0, 1, 1);
	    
	   
	    int result = addProperty(property);
	    return result;
	   
	  }

	  //method for addProperty with 8 parameters
	  public int addProperty(String name,String city, double rent, String owner, int x, int y, int width, int depth) {
	    int i;
	    //Creates a property object that calls the constructor of Plot.
	    Property property = new Property(name,city,rent,owner,x,y,width,depth);
	   
	    int result = addProperty(property);
	    return result;
//	    }
	  }

	  //method for total rent
	  public double totalRent() {
	    double totalRent = 0.0;
	    for (int i = 0; i < count; i++) { //for loop to iterate through count
	      if (properties[i] != null) {
	        totalRent += properties[i].getRentAmount();
	      }
	    }
	    return totalRent;
	  }

	  //method for maxRentProp
	  public double maxRentProp() {
	    double maxRentAmount = 0.0;
	    maxRentAmount = properties[maxRentPropertyIndex()].getRentAmount(); //get max Rent amount
	    return maxRentAmount;
	  }

	  //method for maxRentPropIndex
	  public int maxRentPropertyIndex() {
	    int indexOFMaxRent = 0;
	    for (int i = 0; i < count; i++) {
	      if (properties[i] != null) {
	        if (properties[i].getRentAmount() > properties[indexOFMaxRent].getRentAmount()) { //get index of max
	          indexOFMaxRent = i;
	        }
	      }
	    }

	    return indexOFMaxRent;
	  }

	  //displayPropertyAtIndex
	  public String displayPropertyAtIndex(int i) {
	    String str = "";
	    if (properties[i] != null) {
	      str =
	        (
	          "Owner: " +
	          properties[i].getOwner() + //print owner
	          "City: " +
	          properties[i].getCity() + //print city
	          "Property Name: " +
	          properties[i].getPropertyName() + //print propertyName
	          "Rent Amount: " +
	          properties[i].getRentAmount() + //print rentAmount
	          "Plot: " +
	          properties[i].getPlot() //print getPlot
	        );
	    }

	    return str;
	  }

	  public String toString() { //toString method
	    String printContent = "";
	    System.out.println("List of the properties for Alliance, taxID: " + taxID);

	    System.out.println("__________________");

	    for (int i = 0; i < count; i++) {
	      if (properties[i] != null) printContent =
	        (
	          " Property Name: " +
	          properties[i].getPropertyName() +
	          "\n" +
	          " Located in: " +
	          properties[i].getCity() +
	          "\n" +
	          " Belonging to: " +
	          properties[i].getOwner() +
	          "\n" +
	          " Rent Amount: " +
	          properties[i].getRentAmount()
	        );
	    }

	    System.out.println("__________________");
	    System.out.println("Total management Fee: " + mgmFeePer);

	    return printContent;
	  }
	}

