package robatortas.code.files.core;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
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
		

		vertexBuffer();
		
		while(!shouldClose()) {
			update();
		}
		
		GLFW.glfwDestroyWindow(window);
		GLFW.glfwTerminate();
	}
	
	public void vertexBuffer() {
		float[] positions = {
				-0.5f, -0.5f,
				-0.0f,  0.5f,
				 0.5f, -0.5f
		};
		
		int buffer = 0;
		GL30.nglGenBuffers(1, buffer);
		GL30.glBindBuffer(GL30.GL_ARRAY_BUFFER, buffer);
		GL30.glBufferData(GL30.GL_ARRAY_BUFFER, positions, GL30.GL_STATIC_DRAW);
	}
	
	public void update() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		render();
		
		// Swap front and back buffers
		GLFW.glfwSwapBuffers(window);
		
		// Calls poll events for window
		GLFW.glfwPollEvents();
	}
	
	public void render() {
//		GL11.glBegin(GL11.GL_TRIANGLES);
//		GL11.glVertex2f(-0.5f, -0.5f);
//		GL11.glVertex2f(-0.0f, 0.5f);
//		GL11.glVertex2f(0.5f, -0.5f);
//		GL11.glEnd();
		GL30.glDrawArrays(GL30.GL_TRIANGLES, 0, HEIGHT);
	}
	
	public boolean isVSynced() {
		return vSync;
	}
	
	public void setClearColor(float r, float g, float b, float a) {
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
