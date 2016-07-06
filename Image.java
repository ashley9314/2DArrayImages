import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.*;

public class Image 
{
	private int width, height; 
	private int[][] pixels;
   
	public Image(String filename) throws Exception 
	{ 
		this.read(filename); 
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
   
	public void read(String filename) throws Exception 
	{
		File fileImage = new File(filename);
        
        BufferedImage bufImage = ImageIO.read(fileImage);
		this.width = bufImage.getWidth();
		this.height = bufImage.getHeight();
         
        //complete the remainder of this method
        this.pixels = new int[this.height][this.width];
         
        for (int row = 0; row < height; row++)
        {
        	for (int col = 0; col < width; col++)
            {
                this.pixels[row][col] = bufImage.getRGB(col, row);
            }
        }
   }
   
   private BufferedImage createBufferedImage() 
   	{ 
      	BufferedImage bufImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
  
      	for (int row = 0; row < this.height; row++)
      	{
         	for (int col = 0; col < this.width; col++)
         	{
         		bufImage.setRGB(col, row, this.pixels[row][col]);
         	}
        }
         
      	return bufImage;
	}
   
   public void write(String filename) throws Exception 
   {
        File fileImage = new File(filename);
        String ext = filename.substring(filename.indexOf('.') + 1);
        BufferedImage bufImage = createBufferedImage();
        ImageIO.write(bufImage, ext, fileImage);
   }
   
   
	public void draw(Graphics gc, int x, int y)
	{
   		BufferedImage bufImage = createBufferedImage();
      	gc.drawImage(bufImage, x, y, null);
   	}

	// Below methods are to be created by students
   	public void flipX() 
   	{
      	for (int row = 0; row < this.height/2; row++)
      	{
         	for (int col = 0; col < this.width; col++) 
         	{
            	int s = this.pixels[row][col];
            	this.pixels[row][col] = this.pixels[this.height - row - 1][col];
            	this.pixels[this.height - row - 1][col] = s;
         	}
        }
   	}
   	
   	public void flipY() 
   	{
      	for (int row = 0; row < this.height; row++)
      	{
         	for (int col = 0; col < this.width/2; col++) 
         	{
            	int s = this.pixels[row][col];
            	this.pixels[row][col] = this.pixels[row][this.width - col - 1];
            	this.pixels[row][this.width - col - 1] = s;
         	}
        }
   	}
   
  
   	public void toBw()
   	{
		for (int row = 0; row < this.height; row++)
      	{
         	for (int col = 0; col < this.width; col++)
         	{
         		int rgb = this.pixels[row][col];
            	int r = (rgb >> 16) & 0xFF;
        		int g = (rgb >> 8) & 0xFF;
        		int b = (rgb & 0xFF);

        		int grayLevel = (r + g + b) / 3;
        		int gray = (grayLevel << 16) + (grayLevel << 8) + grayLevel; 
         		this.pixels[row][col] = gray;
         	}
        }
	}
} 