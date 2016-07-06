import java.awt.*;
import javax.imageio.*; 

class TestImage 
{
	public static void main(String args[]) throws Exception 
	{
    	Frame frame = new Frame("My Images");
      	frame.setSize(1024,768);
      	frame.setVisible(true);
      	Graphics gc = frame.getGraphics();
      
      	try 
      	{
         	//Image img = new Image("animals.jpg");
         	//img.draw(gc, 10, 40);
         
         	// Flip the image across y axis
         	//img.flipY();
         	//img.draw(gc, 20 + img.getWidth(), 40);
         	//img.write("AnimalsFlipY.jpg");
         	
         
         	//change image to black and white
         	/* img.toBw();
         	img.draw(gc, 20 + img.getWidth(), 40);
         	img.write("AnimalsBW.jpg"); */
          
         	// Flip the image across y axis
         	/* img.flipX();
         	img.draw(gc, 20 + img.getWidth(), 40);
         	img.write("AnimalsFlipX.jpg"); */
         	
		} 
		catch (Exception e)
		{
         	e.printStackTrace();
      	}
	}
}