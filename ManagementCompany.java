/*Class: CMSC203  
 * Instructor:
 * Description: Get information as a management company from people who have bought homes
 * Due: 4/4/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Geronimo Restrepo
   */
import java.util.Arrays;

public class ManagementCompany {
  private final int MAX_PROPERTY = 5;
  private double mgmFeePer;
  private String name;
  private Property[] properties;
  private String taxID;
  private int MGMT_WIDTH = 10;
  private int MGMT_DEPTH = 10;
  private Plot plot;
  int count = 0;
  
  public String getName()
  {
	  return name;
  }
  
  public void setName(String name)
  {
	  this.name = name;
  }
  
  public double getMgmFeePer()
  {
	  return mgmFeePer;
  }
  
  public void setMgmFeePer(double mgmFeePer)
  {
	  this.mgmFeePer = mgmFeePer;
  }
  
  public String getTaxID()
  {
	  return taxID; 
  }
  
  public void setTaxID(String taxID)
  {
	  this.taxID = taxID;
  }
  
  public Plot getPlot()
  {
	  return plot;
  }
  
  public Plot setPlot(int x, int y, int width, int depth)
  {
	  plot = new Plot(x, y, width, depth);
	  return plot;
  }
  
  public int getMGMT_WIDTH()
  {
	  return MGMT_WIDTH;
  }
  
  public ManagementCompany() {
    properties = new Property[MAX_PROPERTY];
    this.name = "";
    this.taxID = "";
    this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
  }


  public ManagementCompany(String name, String taxID, double mgmFeePer) {
    properties = new Property[MAX_PROPERTY];
    this.name = name;
    this.taxID = taxID;
    this.mgmFeePer = mgmFeePer;
    this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
  }

  public ManagementCompany(ManagementCompany otherCompany) {
    properties = new Property[MAX_PROPERTY];
    name = otherCompany.name;
    taxID = otherCompany.taxID;
    mgmFeePer = otherCompany.mgmFeePer;
    plot = otherCompany.plot;
  }


  public ManagementCompany(String name, String taxID, double mgmFEE, int x, int y, int width, int depth)
  {
    properties = new Property[MAX_PROPERTY];
    this.name = name;
    this.taxID = taxID;
    this.mgmFeePer = mgmFeePer;
    this.plot = new Plot(x, y, width, depth);
  }
  
  
  public int addProperty(Property property) 
  {
	  for(int a =0; a<properties.length; a++)
	  {
		if(properties[a] != null)
		{
			if(properties[a].getPlot().overlaps(property.getPlot()))
			{
				return -4;
			}
		}
		
	  }
	  if(count == MAX_PROPERTY)
	  {
		  return -1; 
	  }
	  if(property == null)
	  {
		  return -2;
	  }
	  if(!this.plot.encompasses(property.getPlot()))
	  {
		  return -3; 
	  }
	  else
		{
			properties[count] = property;
			count++; 
			return count; 
		}
	  
  }

  public int addProperty(String name, String city, int rent, String owner) {
	  return addProperty(new Property(name, city, rent, owner));

  }

  public int addProperty(String name, String city, int rent, String owner, int x, int y, int width, int depth)
  {
    int a;
    return addProperty(new Property(name, city, rent, owner, x, y, width, depth));

  }  

  public String displayPropertyAtIndex(int i) {
    String str = "";
    if (properties[i] != null) 
    {
      str = ("Owner: " + properties[i].getOwner() + "City: " + properties[i].getCity() + "Property Name: " + properties[i].getpropertyName() + "Rent Amount: " + properties[i].getRentAmount() + "Plot: " + properties[i].getPlot());
    }

    return str;
  }
  
  public int getMAX_PROPERTY() 
  {
    return MAX_PROPERTY;
  }
  
  public double maxRentProp() {
	    double maxRentAmount = 0.0;

	    maxRentAmount = properties[maxPropertyRentIndex()].getRentAmount();

	    return maxRentAmount;
	  }
  
  public int maxPropertyRentIndex() {
	    int indexOFMaxRent = 0;

	    for (int i = 0; i < count; i++) {
	      if (properties[i] != null) {
	        if (
	          properties[indexOFMaxRent].getRentAmount() <
	          properties[i].getRentAmount()
	        ) {
	          indexOFMaxRent = i;
	        }
	      }
	    }

	    return indexOFMaxRent;
	  }

  public String toString(){
      String output = "";
      for (int a = 0; a<MAX_PROPERTY;a++) {
          if(properties[a]==null){
              break;
          }
          output += properties[a].toString()+"\n";
      }
      return "List of the properties for " + name + ", taxID: " + taxID + "\n___________________________________\n"+output+"\n"
                      + "___________________________________\ntotal " + "management Fee: "+(totalRent()*mgmFeePer/100);
  }
  
  public double totalRent() {
	    double totalRent = 0;

	    for (int a = 0; a < count; a++) {
	      if (properties[a] != null) {
	        totalRent += properties[a].getRentAmount();
	      }
	    }
	    return totalRent;
	  }
}