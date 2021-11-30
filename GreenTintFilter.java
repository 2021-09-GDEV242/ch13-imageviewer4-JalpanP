import java.awt.Color;
/**
 * Write a description of class GreenTintFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GreenTintFilter extends Filter
{
    /**
     * Constructor for objects of class GreenTintFilter
     */
    public GreenTintFilter(String name)
    {
        super(name);
    }

    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = image.getPixel(x,y);
                int green = color.getGreen();
                image.setPixel(x,y, new Color(0,green,0));
            }
        }
    }
}
