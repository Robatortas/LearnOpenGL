package robatortas.code.files.core.utils;

import static org.lwjgl.opengl.GL30.*;

public class ShaderUtils {
	
	private ShaderUtils() {
		
	}
	
	public static int load(String vertexPath, String fragmentPath) {
		String vert = FileUtils.loadAsString(vertexPath);
		String frag = FileUtils.loadAsString(fragmentPath);
		return create(vert, frag);
		
	}
	
	// On strings because those string contain the shader's source code
	public static int create(String vertex, String fragment) {
		// Creates program
		int program = glCreateProgram();
		
		// Creates both shaders
		int vertID = glCreateShader(GL_VERTEX_SHADER);
		int fragID = glCreateShader(GL_FRAGMENT_SHADER);
		
		// Passes source code to OpenGL
		glShaderSource(vertID, vertex);
		glShaderSource(fragID, fragment);
		// Compiles shader
		glCompileShader(vertID);
		glCompileShader(fragID);
		// For error handling
		if(glGetShaderi(vertID, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Vertex shader colcnt compile!");
			System.err.println(glGetShaderInfoLog(vertID, 2048));
		}
		if(glGetShaderi(fragID, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Fragment shader colcnt compile!");
			System.err.println(glGetShaderInfoLog(fragID, 2048));
		}
		// Attaches shaders to program
		glAttachShader(program, vertID);
		glAttachShader(program, fragID);
		// Links the program
		glLinkProgram(program);
		// Validates the program
		// Checks to see wether the executables contained in program can execute
		glValidateProgram(program);
		return program;
	}
}
