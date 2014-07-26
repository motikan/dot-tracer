
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sample{
	static int COLOR_X = 47;
	static int RED_Y = 675;
	static int GREEN_Y = RED_Y + 15;
	static int BLUE_Y = RED_Y + 30;
	
    public static void main(String[] args) throws IOException {
        File f = new File("test.png");
        BufferedImage read = ImageIO.read(f);
        int w = read.getWidth(), h = read.getHeight();
        Robot rb;
		int mouseX = 170;
		int mouseY = 382;
		try {
			rb = new Robot();
			rb.setAutoDelay(20);
			rb.mouseMove(mouseX, mouseY);
			rb.mousePress(InputEvent.BUTTON1_MASK);
			rb.mouseRelease(InputEvent.BUTTON1_MASK);
			Thread.sleep(500);
			
	        for(int y=0;y<h;y++){
	            for(int x=0;x<w;x++){
	                int c = read.getRGB(x, y);
    				
	                rb.mouseMove(Math.round(r(c) / 3) + COLOR_X, RED_Y);
	                rb.mousePress(InputEvent.BUTTON1_MASK);
    				rb.mouseRelease(InputEvent.BUTTON1_MASK);
	                
	                rb.mouseMove(Math.round(g(c) / 3) + COLOR_X, GREEN_Y);
	                rb.mousePress(InputEvent.BUTTON1_MASK);
    				rb.mouseRelease(InputEvent.BUTTON1_MASK);
	                
	                rb.mouseMove(Math.round(b(c) / 3) + COLOR_X, BLUE_Y);
	                rb.mousePress(InputEvent.BUTTON1_MASK);
    				rb.mouseRelease(InputEvent.BUTTON1_MASK);
    				
	                rb.mouseMove(mouseX, mouseY);
	                rb.mousePress(InputEvent.BUTTON1_MASK);
	    			rb.mouseRelease(InputEvent.BUTTON1_MASK);
	                mouseX += 1;
	            }
	            mouseX = 170;
	            mouseY += 1;
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}

    }
    
    public static int a(int c){
        return c>>>24;
    }
    public static int r(int c){
        return c>>16&0xff;
    }
    public static int g(int c){
        return c>>8&0xff;
    }
    public static int b(int c){
        return c&0xff;
    }
    public static int rgb
    (int r,int g,int b){
        return 0xff000000 | r <<16 | g <<8 | b;
    }
    public static int argb
    (int a,int r,int g,int b){
        return a<<24 | r <<16 | g <<8 | b;
    }
    
}