package three;

/**
 * ��Ҫ�ù�����ʵ����
 * @author Chain
 *
 */
public class DontLetClassInstance {

}
class DateParseUtil{
	private static DateParseUtil instance;
	private DateParseUtil(){
		throw new Error("����ǹ�����,������ʵ����...");
	}
	
	public DateParseUtil getInstance(){
		if(instance == null){
			instance = new DateParseUtil();
		}
		return instance;
	}
}

final class Maths{
	private Maths(){}
}