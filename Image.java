import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;

public class Image {


   public int width,height; 
   public int[][] pixels;
   public int[][] newPixels;
   public final static int WHITE = 0; 
   public final static int BLACK = 255; 
   public final static int MID_POINT = WHITE/2;   
    
   
   public Image(String filename)
      throws Exception { read(filename); }
   
   public int getWidth() 
   { 
      return width; 
   }
   
   public int getHeight() 
   { 
      return height; 
   }
   
   public void read(String filename)
      throws Exception {
        
         String ext = filename.substring
         (filename.indexOf('.')+1);
         
         File fileImage = new File(filename);
        
         Iterator imageReaders = ImageIO.getImageReadersBySuffix(ext);
         ImageReader imageReader;
        
         if (imageReaders.hasNext())
            imageReader = (ImageReader)imageReaders.next();
         
         else throw new IIOException
            ("Unsupported image format");
        
         FileImageInputStream imageInputStream = new FileImageInputStream(fileImage);
         
         imageReader.setInput(imageInputStream);
         
         this.width = imageReader.getWidth(0);
         this.height = imageReader.getHeight(0);
         
         BufferedImage bufImage = imageReader.read(0);
         imageInputStream.close();
         
         WritableRaster wRaster = bufImage.getRaster();
         
         //complete the remainder of this method
         this.pixels = new int[this.height][this.width];
         
         for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
               pixels[row][col] = wRaster.getSample(col,row,0);
        
   }
   
   
   public void write(String filename)
      throws Exception {
         String ext = filename.substring(filename.indexOf('.')+1);
         
         File fileImage = new File(filename);
         
         Iterator imageWriters = ImageIO.getImageWritersBySuffix(ext);
         ImageWriter imageWriter;
         
         if (imageWriters.hasNext())
            imageWriter = (ImageWriter)imageWriters.next();
            
         else throw new IIOException
            ("Unsupported image format");
         
         FileImageOutputStream imageOutputStream = new FileImageOutputStream(fileImage);
         
         imageWriter.setOutput(imageOutputStream);
         
         BufferedImage bufImage = createBufferedImage();
         
         imageWriter.write(bufImage);
         imageOutputStream.close();
   }
   
   
   public void draw(Graphics gc,int x,int y){
      BufferedImage bufImage = createBufferedImage();
      gc.drawImage(bufImage,x,y,null);
   }
   

   private BufferedImage createBufferedImage() {
     
      BufferedImage bufImage = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
 
      WritableRaster wRaster = bufImage.getRaster();
 
      for (int row = 0; row < this.height; row++)
         for (int col = 0; col < this.width; col++){
         wRaster.setSample(col,row,0,pixels[row][col]);
         }
         
      return bufImage;
}

   public void flipX() 
   {
      for (int row = 0; row < this.height/2; row++)
         for (int col = 0; col < this.width; col++) 
         {
            int s = pixels[row][col];
            pixels[row][col] = pixels[this.height-row-1][col];
            pixels[this.height-row-1][col] = s;
         }
   }
   
   public void chgInt(double pct) 
   {
      for (int row = 0; row < height; row++)
         for (int col = 0; col < width; col++) 
         {
            int s = (int)(pixels[row][col] * pct);
            
            if (s < 0) 
               s = WHITE;
               
            else if (s > 255) 
               s = BLACK;
              
            pixels[row][col] = s;
         }
   }
   
   public void flipY() 
   {
      for (int row = 0; row < this.height; row++)
         for (int col = 0; col < this.width/2; col++) 
         {
            int s = pixels[row][col];
            pixels[row][col] = pixels[row][this.width-col-1];
            pixels[row][this.width-col-1] = s;
         }
   }
   
   public void toBw()
   {
      for(int row = 0; row<this.height; row++)
         for(int col = 0; col<this.width; col++)
         {
            if(pixels[row][col] < MID_POINT)
               pixels[row][col] = WHITE; 
            else 
               pixels[row][col] = BLACK; 
         
         }
   }
   
  public void rot90()
  {
      newPixels = new int [this.height][this.width]; 
      int count; 
      
      for(int row = 0; row<this.width; row++)
         for(int col = 0; col<this.height; col++)
         {
               newPixels[row][col] = pixels[row][col];
         }
         
      for(int row = 0; row<this.width; row++)
      {
         count = pixels[row].length-1; 
         
         for(int col = 0; col<this.height; col++)
         {
               pixels[row][col] = newPixels[count][row];
               count--; 
         }
      }
      
  }
 
} // End of Class Image