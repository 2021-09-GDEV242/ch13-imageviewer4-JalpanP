import java.awt.Color;
/**
 * Write a description of class BlueChFliter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlueChFilter extends Filter
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class BlueChFliter
     */
    public BlueChFilter( String name)
    {
        // initialise instance variables
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
        int height = image.getHeight();
        int width = image.getWidth();
        
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color color = image.getPixel(x,y);
                int blue = color.getBlue();
                image.setPixel(x, y, new Color(blue,blue,blue));
            }
        }
    }

}
