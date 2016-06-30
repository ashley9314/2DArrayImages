import java.awt.*;
import javax.imageio.*; 
class TestImage {

   public static void main(String args[])
      throws Exception {
      
      Frame frame = new Frame("Test Image");
      frame.setSize(1024,768);
      frame.setVisible(true);
      Graphics gc = frame.getGraphics();
       
      
      try {
         
          
         Image img = new Image("Horse.jpg");
         
         img.draw(gc,10,40);
         /*
         // Flip the image across y axis
         img.flipY();
         //write and draw flipped image
         img.draw(gc,20+img.getWidth(),40);
         img.write("HorseFlippedY.jpg");
         
         //change image to black and white
         img.toBw();
         // Display the black and white image.
         img.draw(gc,20+img.getWidth(),40);
         img.write("HorseBW.jpg");
         
         //change image intensity by giving percentage
         img.chgInt(.5); 
         // Display the black and white image.
         img.draw(gc,20+img.getWidth(),40);
         img.write("HorseInt.jpg");
         
         //rotate the image 90 degrees clockwise
         img.rot90(); 
         img.draw(gc,20+img.getWidth(),40);
         img.write("HorseRot90.jpg");
          
         // Flip the image across y axis
         img.flipX();
         //write and draw flipped image
         img.draw(gc,20+img.getWidth(),40);
         img.write("HorseFlippedX.jpg");*/
        
      } 
      
      catch (Exception e) 
      {
         System.out.println("Exception in main() "+e.toString());
      }
   }
}