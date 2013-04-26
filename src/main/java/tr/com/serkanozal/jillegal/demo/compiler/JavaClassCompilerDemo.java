/**
 * @author SERKAN OZAL
 *         
 *         E-Mail: <a href="mailto:serkanozal86@hotmail.com">serkanozal86@hotmail.com</a>
 *         GitHub: <a>https://github.com/serkan-ozal</a>
 */

package tr.com.serkanozal.jillegal.demo.compiler;

import tr.com.serkanozal.jillegal.compiler.domain.model.DefaultCodeType;
import tr.com.serkanozal.jillegal.compiler.exception.ClassCompileException;
import tr.com.serkanozal.jillegal.compiler.factory.ClassCompilerFactory;
import tr.com.serkanozal.jillegal.compiler.factory.ClassCompilerFactoryProvider;
import tr.com.serkanozal.jillegal.core.Jillegal;

public class JavaClassCompilerDemo {

	static {
		Jillegal.init();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, ClassCompileException, InstantiationException, IllegalAccessException {
		ClassCompilerFactory classCompilerFactory = ClassCompilerFactoryProvider.getClassCompilerFactory();
		
		String code = 
				"package tr.com.serkanozal.jillegal.compiler;"+ "\n" +
				"\n" +
				"public class SampleJavaClass {" + "\n" +
				"\n" +
				"\t" + "public String toString() {" + "\n" +
				"\t" + "\t" + "return \"I am SampleJavaClass\";" + "\n" +
				"\t" + 	"}" + "\n" +
				"\n" +
				"}";

		Class<?> compiledClass = classCompilerFactory.getClassCompiler(DefaultCodeType.JAVA).compile(code);
		System.out.println("In Memory Compiled Java Class: " + compiledClass.getName());
		Object obj = compiledClass.newInstance();
		System.out.println(obj.toString());
	}
	
}
