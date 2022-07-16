
public interface Ishape {
	
	
	
	Renderer renderer = new Renderer();                       // Implementing Composition: Shape has a Renderer.

	public double calculateArea();
	
	public double calculatePerimeter();

	
}

//**********RENDERER CLASS************Renderer is a class that contains draw methods.

class Renderer  
{
	

	public void draw()                                      // COMPILE TIME POLYMORPHISM
	{
		System.out.println("This shape is ");
	}
	
	public void draw(String message)
	{
		System.out.println(message);
	}
	
}

// **********MAIN CLASS************

class MainClass{
    public static void main(String[] args) {
    	
    	Circle cir= new Circle("red", 20);
        Square sq = new Square("orange", 10);
        Rectangle rect = new Rectangle("blue", 10, 20);
        Triangle tri = new Triangle ("green", 5, 10);
        
        
        rect.renderer.draw();
        rect.renderer.draw("RECTANGLE");
        
        System.out.printf("AREA: %.1f,\nPERIMETER: %.1f \nCOLOR: %s \n\n",rect.calculateArea(), rect.calculatePerimeter(), rect.color);
        
        
        
        sq.renderer.draw();
        sq.renderer.draw("SQUARE");
        
        System.out.printf("AREA: %.1f,\nPERIMETER: %.1f \nCOLOR: %s \n\n",sq.calculateArea(), sq.calculatePerimeter(), sq.color);
        
        tri.renderer.draw();
        tri.renderer.draw("TRIANGLE");
        
        System.out.printf("AREA: %.1f,\nPERIMETER: %.1f \nCOLOR: %s \n\n",tri.calculateArea(), tri.calculatePerimeter(), tri.color);
        
        cir.renderer.draw();
        cir.renderer.draw("CIRCLE");
        
        System.out.printf("AREA: %.1f,\nPERIMETER: %.1f \nCOLOR: %s \n\n",cir.calculateArea(), cir.calculatePerimeter(), cir.color);
    }
    }

//**********RECTANGLE CLASS************


  class Rectangle implements Ishape
{
	  int length, width;
	  String color;
	  
	  public double calculateArea()
	    {
	    return (length*width);
	    }


	    public double calculatePerimeter()
	    {
	    return (2*(length+width));
	    }
	   
	     

	    public Rectangle(String color, int length, int width)
	    {
		 
	    this.color = color;	
		this.length = length;
	    this.width = width;
	    
	    }
	  
	     
		
		 
		 
	}
  
//**********SQUARE CLASS************

  class Square extends Rectangle
  {
	  public Square(String color, int side) 
	  {
			super(color, side, side);
			// TODO Auto-generated constructor stub
	  }
			public double calculateArea()                 /// RUN TIME POLYMORPHISM
		    {
				
				
		    return (this.length*this.width);                       // here super.length and this.length works in the same way
		    }
	  
  }
		   
  
//**********CIRCLE CLASS************

  
  class Circle implements Ishape
  {
      int radius;
      String color;
      final double PI = 3.14;
      
      public double calculateArea()
      {
      return (PI*radius*radius);
      }

  public double calculatePerimeter()
      {
      return (2*PI*radius);
      }
  
      
      
      public Circle(String color, int radius)
      {
      	this.color = color;
      	this.radius = radius;
       
      }
  }
  
  
//**********TRIANGLE CLASS************

  class Triangle implements Ishape
  {
      int height, base;
      String color;
      
      public double calculateArea()
      {
      return ((base*height)/2);
      }


      public double calculatePerimeter()
      {
      return ((base+height)+ Math.sqrt(base^2 + height^2));
      }
       
      
      public Triangle(String color, int height, int base)
      {
      	this.color = color;
      	this.height = height;
        this.base = base;
      
      }
  }