import java.awt.Color;
/**
 * Write a description of class BlueTintFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BlueTintFilter extends Filter
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class BlueTintFilter
     */
    public BlueTintFilter(String name)
    {
        
        super(name);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void apply(OFImage picture)
    {
        int height = picture.getHeight();
        int width = picture.getWidth();
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = picture.getPixel(x,y);
                int blue = color.getBlue();
                picture.setPixel(x,y, new Color(0, 0, blue));
            }
        }
    }
}
