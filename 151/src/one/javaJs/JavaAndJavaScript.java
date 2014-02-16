package one.javaJs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class JavaAndJavaScript {

	/**
	 * jrunscript
	 * @param args
	 * @throws Exception
	 */
	
	public static void main(String[] args) throws Exception{
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		Bindings bind = engine.createBindings();
		bind.put("factor", 100);
		engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextInt()){
			int first = scanner.nextInt();
			int sec = scanner.nextInt();
			System.out.println("����Ĳ�����" +  first + "," + sec);
			engine.eval(new FileReader("c:/model.js"));
			if(engine instanceof Invocable){
				Invocable in = (Invocable)engine;
				Double result = (Double) in.invokeFunction("formule",first,sec);
				System.out.println("�������ǣ�" + result.intValue());
			}
			
		}
		
	}
	
}
