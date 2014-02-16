package eight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableInterceptor.SUCCESSFUL;


/**
 * 封装异常的好处：
 * 	提高系统的友好性           >>doStuff2()
 * 	  把异常的阅读者分为两类： 开发人员和用户
 * 
 * 提高系统的可维护性 doStuff3()
 *   对异常进行分类处理，并进行封装输出
 * 
 * 解决 JAVA异常机制的自身 缺陷  doStuff4()
 *   抛出多个一异常
 * 
 * 
 * 采用异常连传递异常
 * 
 * @author Chain
 *
 */
public class EncapsulationException {

	
	public void doStuff2() throws RuntimeException{
		try{
			// DO SOMETHING 
		}catch (Exception e) {
			//为方便开发和维护人员设计的异常
			e.printStackTrace();
			//抛出业务异常
			throw new RuntimeException(e);
		}
	}
	
	public void doStuff3(){
		try {
			InputStream is = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			//处理FileNotFoundException
			//e.printStackTrace();
		}catch (SecurityException e) {
			//处理FileNotFoundException
			// TODO: handle exception
		}
	}
	
	public void doStuff4() throws MutiException{
		List<Throwable> causes = new ArrayList<Throwable>();
		try {
			InputStream is = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			causes.add(e);
		}
		try{
			
		}catch (SecurityException e) {
			causes.add(e);
		}
		
		if(causes.size() > 0)
			throw new MutiException(causes);
	}
}

class MutiException extends Exception{
	private static final long serialVersionUID = 6713930762177970476L;
	//容纳所有的异常
	private List<Throwable> causes = new ArrayList<Throwable>();
	//构造函数，传递一个异常列表
	public MutiException(List<? extends Throwable> _cause){
		causes.addAll(_cause);
	}
	public List<Throwable> getExcptions(){
		return causes;
	}
}

