package robatortas.code.files.core;

import org.lwjgl.opengl.GL11;

public class MainApp {
	
	private static DisplayManager display;
	
	public static void main(String[] args) {
		System.out.println("OPENGL!");
		display = new DisplayManager();
		display.create(display.getTitle(), display.getWidth(), display.getHeight(), false);
	}
}
