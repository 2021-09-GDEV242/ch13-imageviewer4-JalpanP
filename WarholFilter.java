import java.awt.Color;
/**
 * Write a description of class WarholFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WarholFilter extends Filter
{
    /**
     * Constructor for objects of class WarholFilter
     */
    public WarholFilter(String name)
    {
        super(name);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight() / 2;
        int width = image.getWidth() / 2;
        OFImage small = new OFImage(height,width);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                small.setPixel(x,y,image.getPixel(x*2,y*2));
            }
        }
        
        
        OFImage red = new OFImage(width, height);
        OFImage green = new OFImage(width, height);
        OFImage blue = new OFImage(width, height);
        
        for(int y = 0; y < height; y++) {
            for(int x=0 ; x < width; x++) {
                Color color = small.getPixel(x,y);
                int r = color.getRed();
                red.setPixel(x,y, new Color(r,0,0));
            }
        }
        
        
        for(int y = 0; y < height; y++) {
            for(int x=0 ; x < width; x++) {
                Color color = small.getPixel(x,y);
                int g = color.getGreen();
                green.setPixel(x,y, new Color(0,g,0));
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x=0 ; x < width; x++) {
                Color color = small.getPixel(x,y);
                int b = color.getBlue();
                blue.setPixel(x,y, new Color(0,0,b));
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x=0 ; x < width; x++) {
                image.setPixel(x,y, small.getPixel(x,y));
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x=0 ; x < width; x++) {
                image.setPixel(x + width, y, red.getPixel(x,y));
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x=0 ; x < width; x++) {
                image.setPixel(x, y + height, green.getPixel(x,y));
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x=0 ; x < width; x++) {
                image.setPixel(x + width, y + height, blue.getPixel(x,y));
            }
        }
    }
}