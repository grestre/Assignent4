public class Plot {
	private int x; 
	private int y; 
	private int width; 
    private int depth;  
    
    public Plot()
    {
    	x = 0; 
    	y = 0;
    	width = 1;
    	depth = 1;
    }
    
    public Plot(int x, int y, int depth, int width)
    {
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.depth = depth;
    }
    
    public int getX()
    {
    	return x; 
    }
    public void setX(int x)
    {
    	this.x=x; 
    }
    public int getY()
    {
    	return y; 
    }
    public void setY(int y)
    {
    	this.y=y; 
    }
    public int getDepth()
    {
    	return depth;
    }
    public void setDepth(int depth)
    {
    	this.depth = depth;
    }
    
    public int getWidth()
    {
    	return width;
    }
    public void setWidth(int Width)
    {
    	this.width = width;
    }
    public String toString()
    {
        return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
    }
    public boolean overlaps(Plot plot)
    {
    	if(((plot.x>=x && plot.x >= (x+width)) && (plot.y<=y && plot.y >= (y+depth))) &&
    			(((plot.x+ plot.width) <= x &&(plot.x + plot.width) >= (x+width)) && (plot.y <= y && plot.y >= (y+depth))))
    		return true; 
    	return false; 
    }
    public boolean encompasses(Plot plot)

    {

          if(((plot.x>= x && plot.x <= (x+width)) && (plot.y >= y && plot.y <= (y+depth))) &&

                        (((plot.x + plot.width)>= x && (plot.x+plot.width) <= (x+width)) && (plot.y >= y && plot.y <= ( y+depth))) )

                 return true;

          return false;

    }

}