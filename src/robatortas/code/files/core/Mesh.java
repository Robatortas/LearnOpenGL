package robatortas.code.files.core;

import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL30;

public class Mesh {
	
	private int vertexArrayObject;
	private int vertexBufferObeject;
	
	private int vertexCount;
	
	public Mesh() {
		
	}
	
	public boolean create(float vertices[]) {
		vertexArrayObject = GL30.glGenVertexArrays();
		
		return true;
	}
}
