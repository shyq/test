package one.dynamiccompile;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 动态编译
 * 
 * @author Chain
 */
public class Client {

	public static void main(String[] args) throws Exception {
		String sourceStr = "public class Hello{public String sayHello(String name)"
				+ "{return \"hello\" + name + \"--compile\";}}";
		String clsName = "Hello";
		String mtmName = "sayHello";
		// 当前编译器
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		// java标准文件管理器
		StandardJavaFileManager fm = jc
				.getStandardFileManager(null, null, null);
		// java文件对象
		JavaFileObject jfo = new StringJavaObject(clsName, sourceStr);
		// 编译参数 类似于javadoc<options> 中的options
		List<String> optionList = new ArrayList<String>();
		// 编译文件存放的地方，此处为eclipse工具设定
		optionList.addAll(Arrays.asList("-d", "./bin"));
		// 要编译的 单元
		List<JavaFileObject> jfos = Arrays.asList(jfo);
		// 设置编译环境
		JavaCompiler.CompilationTask task = jc.getTask(null, fm, null,
				optionList, null, jfos);
		// 编译成功
		if (task.call()) {
			Object obj = Class.forName(clsName).newInstance();
			Class<? extends Object> cls = obj.getClass();
			Method m = cls.getMethod(mtmName, String.class);
			String result = (String) m.invoke(obj, "Dynamic Compilation");
			System.out.println(result);
		}
	}

}

class StringJavaObject extends SimpleJavaFileObject {
	private String content = "";

	protected StringJavaObject(String _javaFileName, String _content) {
		super(createStringJavaObjectURI(_javaFileName), Kind.SOURCE);
		content = _content;
	}

	private static URI createStringJavaObjectURI(String name) {
		return URI.create("String:///" + name + Kind.SOURCE.extension);
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
			throws IOException {
		return content;
	}
}