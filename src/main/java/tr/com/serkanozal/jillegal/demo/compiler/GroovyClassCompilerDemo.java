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
import tr.com.serkanozal.jillegal.compiler.factory.DefaultClassCompilerFactory;
import tr.com.serkanozal.jillegal.core.Jillegal;

public class GroovyClassCompilerDemo {

	static {
		Jillegal.init();
	}
	
	public static void main(String[] args) throws ClassCompileException, InstantiationException, IllegalAccessException {
		ClassCompilerFactory classCompilerFactory = new DefaultClassCompilerFactory();
		
		String code = 
				"package tr.com.serkanozal.jillegal.compiler;"+ "\n" +
				"\n" +
				"public class SampleGroovyClass {" + "\n" +
				"\n" +
				"\t" + "public String toString() {" + "\n" +
				"\t" + "\t" + "def str = \"I am SampleGroovyClass\";" + "\n" +
				"\t" + "\t" + "return str;" + "\n" +
				"\t" + 	"}" + "\n" +
				"\n" +
				"}";

		Class<?> compiledClass = classCompilerFactory.getClassCompiler(DefaultCodeType.GROOVY).compile(code);
		System.out.println("In Memory Compiled Groovy Class: " + compiledClass.getName());
		Object obj = compiledClass.newInstance();
		System.out.println(obj.toString());
	}
	
}
