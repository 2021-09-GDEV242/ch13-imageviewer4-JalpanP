import java.awt.Color;
/**
 * Write a description of class FlipWarholFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FlipWarholFilter extends Filter
{
    /**
     * Constructor for objects of class FlipWarholFilter
     */
    public FlipWarholFilter(String name)
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
        OFImage small = new OFImage(width,height);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                small.setPixel(x,y, image.getPixel(x*2,y*2));
            }
        }

        OFImage red =new OFImage(width,height);
        OFImage blue =new OFImage(width,height);
        OFImage green =new OFImage(width,height);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = small.getPixel(x,y);
                int r = color.getRed();
                red.setPixel(x,y, new Color(r,0,0));
            }
        }
        flipHorizonImage(red);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = small.getPixel(x,y);
                int g = color.getGreen();
                green.setPixel(x,y, new Color(0,g,0));
            }
        }
        flipVertiImage(green);
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color color = small.getPixel(x,y);
                int b = color.getBlue();
                blue.setPixel(x,y, new Color(0,0,b));
            }
        }
        flipVertiImage(blue);
        flipHorizonImage(blue);
        
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
    
    public void flipVertiImage(OFImage image)
    {
       int height = image.getHeight();
       int width = image.getWidth();
       
       OFImage newImage = new OFImage(width,height);
       
       for(int y = 0; y < height; y++){
           for(int x = 0; x < width; x++){
               newImage.setPixel(x,y, image.getPixel(x, height - y -1));
           }
       }
    
       for(int y = 0; y < height; y++){
           for(int x = 0; x < width; x++){
               newImage.setPixel(x,y, newImage.getPixel(x,y));
           }
       }
    }
    
    public void flipHorizonImage(OFImage image){
        int height = image.getHeight();
        int width = image.getWidth();
        
        OFImage newImage = new OFImage(width, height);
        
        for(int y = 0; y < height; y++){
           for(int x = 0; x < width; x++){
               newImage.setPixel(x,y, image.getPixel(width - x - 1, y));
           }
       }
       
       for(int y = 0; y < height; y++){
           for(int x = 0; x < width; x++){
               newImage.setPixel(x,y, newImage.getPixel(x,y));
           }
       }
    }
}
