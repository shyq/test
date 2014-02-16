package eight;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.omg.PortableInterceptor.SUCCESSFUL;


/**
 * ��װ�쳣�ĺô���
 * 	���ϵͳ���Ѻ���           >>doStuff2()
 * 	  ���쳣���Ķ��߷�Ϊ���ࣺ ������Ա���û�
 * 
 * ���ϵͳ�Ŀ�ά���� doStuff3()
 *   ���쳣���з��ദ�������з�װ���
 * 
 * ��� JAVA�쳣���Ƶ����� ȱ��  doStuff4()
 *   �׳����һ�쳣
 * 
 * 
 * �����쳣�������쳣
 * 
 * @author Chain
 *
 */
public class EncapsulationException {

	
	public void doStuff2() throws RuntimeException{
		try{
			// DO SOMETHING 
		}catch (Exception e) {
			//Ϊ���㿪����ά����Ա��Ƶ��쳣
			e.printStackTrace();
			//�׳�ҵ���쳣
			throw new RuntimeException(e);
		}
	}
	
	public void doStuff3(){
		try {
			InputStream is = new FileInputStream("a.txt");
		} catch (FileNotFoundException e) {
			//����FileNotFoundException
			//e.printStackTrace();
		}catch (SecurityException e) {
			//����FileNotFoundException
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
	//�������е��쳣
	private List<Throwable> causes = new ArrayList<Throwable>();
	//���캯��������һ���쳣�б�
	public MutiException(List<? extends Throwable> _cause){
		causes.addAll(_cause);
	}
	public List<Throwable> getExcptions(){
		return causes;
	}
}

