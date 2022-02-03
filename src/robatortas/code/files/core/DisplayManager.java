package robatortas.code.files.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

public class DisplayManager {
	
	private int WIDTH = 1024;
	private int HEIGHT = 720;
	
	private final String TITLE = "OPENGL";
	
	private boolean vSync = false;
	
	public long window;
	
	public DisplayManager() {
		
	}
	
	public void create(String title, int w, int h, boolean vSync) {
		glfWindow();
	}
	
	public void glfWindow() {
		GLFW.glfwInit();
		window = GLFW.glfwCreateWindow(getWidth(), getHeight(), "OPENGL", MemoryUtil.NULL, MemoryUtil.NULL);
		
		if(!GLFW.glfwInit()) {
			try {
				throw new Exception("unable to initialize GLFW");
			} catch(Exception e) {
				
			}
		}
		
		if(window == MemoryUtil.NULL) {
			System.out.println("Unable to create GLFW window");
			GLFW.glfwTerminate();
		}
		
		if(isVSynced()) {
			GLFW.glfwSwapInterval(1);
		}
		
		GLFW.glfwMakeContextCurrent(window);
		GLFW.glfwWindowHint(GLFW.GLFW_VERSION_MAJOR, 3);
		GLFW.glfwWindowHint(GLFW.GLFW_VERSION_MAJOR, 2);
		
		GLFW.glfwSetWindowPos(window, getWidth()/2, getHeight()/2);
		
		GL.createCapabilities();
		
		GL11.glClearColor(1, 0, 0, 1);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		while(!shouldClose()) {
			update();
		}
		
		GLFW.glfwDestroyWindow(window);
		GLFW.glfwTerminate();
	}
	
	public void update() {
		GLFW.glfwPollEvents();
		GLFW.glfwSwapBuffers(window);
	}
	
	public boolean isVSynced() {
		return vSync;
	}
	
	public void setClearColor(int r, int g, int b, int a) {
		GL11.glClearColor(r, g, b, a);
	}
	
	public boolean shouldClose() {
		return GLFW.glfwWindowShouldClose(window);
	}
	
	public String getTitle() {
		return this.TITLE;
	}
	
	public int getWidth() {
		return this.WIDTH;
	}
	
	public int getHeight() {
		return this.HEIGHT;
	}
	
}
