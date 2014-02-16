package six;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ACL  access control list 访问控制列表设计案例
 * ACL的三种重要元素
 *  资源 : 有哪些信息时要被控制起来的
 *  权限级别： 不同的访问者规划在不同的权限级别中
 *  控制器(鉴权人)： 控制不同级别访问不同资源
 * 
 * 
 * @author Chain
 *
 */

public class EnumAndAnnotation {

	public static void main(String[] args) {
		Administrator admin = new Administrator();
		Access access = admin.getClass().getAnnotation(Access.class);
		if(access == null || !access.level().identity()){
			access.level();
			System.out.println(CommonIdentifier.REFUSE_WORD);
		}
	}
}

/**
 * 鉴权人
 * 
 * @author Chain
 */
interface Identifier{
	public final static String REFUSE_WORD = "你无权访问";
	public boolean identity();
}

/**
 * 用enum实现
 * @author Chain
 *
 */
enum CommonIdentifier implements Identifier{
	//权限级别
	READ,AUTHOR,ADMIN;
	
	//实现权限
	public boolean identity() {
		return true;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Access{
	CommonIdentifier level() default CommonIdentifier.ADMIN;
}

@Access(level=CommonIdentifier.ADMIN)
class Administrator{
	
}