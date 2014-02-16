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
 * ��̬����
 * 
 * @author Chain
 */
public class Client {

	public static void main(String[] args) throws Exception {
		String sourceStr = "public class Hello{public String sayHello(String name)"
				+ "{return \"hello\" + name + \"--compile\";}}";
		String clsName = "Hello";
		String mtmName = "sayHello";
		// ��ǰ������
		JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
		// java��׼�ļ�������
		StandardJavaFileManager fm = jc
				.getStandardFileManager(null, null, null);
		// java�ļ�����
		JavaFileObject jfo = new StringJavaObject(clsName, sourceStr);
		// ������� ������javadoc<options> �е�options
		List<String> optionList = new ArrayList<String>();
		// �����ļ���ŵĵط����˴�Ϊeclipse�����趨
		optionList.addAll(Arrays.asList("-d", "./bin"));
		// Ҫ����� ��Ԫ
		List<JavaFileObject> jfos = Arrays.asList(jfo);
		// ���ñ��뻷��
		JavaCompiler.CompilationTask task = jc.getTask(null, fm, null,
				optionList, null, jfos);
		// ����ɹ�
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