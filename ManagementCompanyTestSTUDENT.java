package jkyeiasare;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany m1; 
	Property p1 ,p2,p3,p4,p5,p6, p7;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m1 = new ManagementCompany("Jeff", "555555555",6);
		
		//student add three properties, with plots, to mgmt co
		p1 = new Property ("New York", "New York", 4300, "Shalom Terra",3,1,2,2);
		p2 = new Property ("Atlanta", "Georgia", 4000, "Aaron Amos",5,2,2,2);
		p3 = new Property ("San Fran", "California", 4500, "Alexis Brown",6,3,2,2);
		p4 = new Property ("Portland", "Oregon", 4700, "Shailo Brown",2,3,1,2);
		m1.addProperty(p1);
		m1.addProperty(p2);
		m1.addProperty(p3);
		m1.addProperty(p4);
	}

	@After
	public void tearDown() {
		p1=p2=p3=p4=p5=p6=null;
		m1=null; 
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		
		p5 = new Property ("Chicago", "Illinois", 4200, "Naenae Merso");
		p6 = new Property ("Philly", "Pennsylvania", 4700, "Lem Willy",4,5,1,2);
		p7 = new Property ("Extra", "Prop", 4800, "Manny Nick",4,3,2,3);
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(m1.addProperty("Chicago", "Illinois", 4200, "Naenae Merso") , 3, 0);
		//student should add property with 8 args
		assertEquals(m1.addProperty("Philly", "Pennsylvania", 4700, "Lem Willy",4,5,1,2), 4, 0);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		assertEquals(m1.addProperty("Extra", "Prop", 4800, "Manny Nick",4,3,2,3), -1, 0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(m1.maxRentProp(),4700.0,0);
		
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m1.totalRent(),13000d,0);
	}

 }
