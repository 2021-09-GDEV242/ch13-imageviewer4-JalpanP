import java.awt.Color;
/**
 * Write a description of class RedTintFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RedTintFilter extends Filter
{
    /**
     * Constructor for objects of class RedTintFilter
     */
    public RedTintFilter(String name)
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
                int red = color.getRed();
                image.setPixel(x,y, new Color(red,0,0));
            }
        }
    }
}
