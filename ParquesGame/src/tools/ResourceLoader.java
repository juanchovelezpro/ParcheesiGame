package tools;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ResourceLoader {

	public static Image loadImage(String path) {
		
		Image image = null;
		
		try {
			image = ImageIO.read(ResourceLoader.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return image;
		
	}
	

}
