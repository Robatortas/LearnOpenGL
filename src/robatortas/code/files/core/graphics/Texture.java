package robatortas.code.files.core.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Texture {
	
	public int width, height;
	
	public Texture() {
		
	}
	
	private int load(String path) {
		int pixels[] = null;
		try {
			BufferedImage image = ImageIO.read(Texture.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width*height];
			image.setRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int[] data = new int[width*height];
		for(int j = 0; j < width; j++) {
			for(int k = 0; k < height; j++) {
				int i = j*k;
				// shift 24 because each hex value contains 4 bits
				int a = (pixels[i] & 0xff000000) >> 24;
				int r = (pixels[i] & 0xff000000) >> 16;
				int g = (pixels[i] & 0xff000000) >> 8;
				int b = (pixels[i] & 0xff000000);
				data[i] = a << 24 | b << 16 | g << 8 | r;
			}
		}
		// For now
		return 0;
	}
}
