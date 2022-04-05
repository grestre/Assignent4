public class Property {

   private String propertyName, city, owner;
   private double rentAmount;
   private Plot plot; 

   public Property() 
   {

       this.propertyName = "";
       this.city = "";
       this.owner = "";
       this.rentAmount = 0;
       this.plot = new Plot(); 
   }

   public Property(Property p)
   {
	   this.propertyName = p.propertyName;
	   this.city = p.city;
	   this.owner = p.owner; 
	   this.rentAmount  = p.rentAmount; 
	   this.plot = p.plot;
   }
   
   public Property(String propertyName, String city, double rentAmount, String owner)
   {
	   this.propertyName = propertyName; 
	   this.city = city; 
	   this.owner = owner;
	   this.rentAmount = rentAmount; 
	   this.plot = new Plot();
   }
   
   public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
   {
	   this.propertyName = propertyName;
	   this.city = city; 
	   this.owner = owner; 
	   this.rentAmount = rentAmount;
	   this.plot = new Plot(x, y, width, depth);
   }



public String getCity() 
   {
       return city;
   }
   public String getOwner() 
   {
       return owner;
   }

   public String getpropertyName() 
   {
       return propertyName;
   }

   public double getRentAmount() 
   {
       return rentAmount;
   }
   
   public Plot getPlot()
   {
	   return plot; 
   }
   public void setCity(String city) 
   {
       this.city = city;
   }
   public void setOwner(String owner) 
   {
       this.owner = owner;
   }
   void setpropertyName(String propertyName) 
   {
       this.propertyName = propertyName;
   }
   void setRentAmount(double rentAmount) 
   {
  	  this.rentAmount = rentAmount;
   }    
   public Plot setPlot(int x, int y, int width, int depth)
   {
	  return new Plot(x, y, width, depth); 
   }

   public String toString() {
       return "\nProperty Name: " + propertyName + "\nLocated in: " + city + "\nBelonging to: " + owner
               + "\nRent Amount: " + rentAmount + "";
   }

}