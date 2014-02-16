package three;

/**
 * 不要让工具类实例化
 * @author Chain
 *
 */
public class DontLetClassInstance {

}
class DateParseUtil{
	private static DateParseUtil instance;
	private DateParseUtil(){
		throw new Error("这个是工具类,不允许实例化...");
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