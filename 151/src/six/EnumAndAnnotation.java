package six;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ACL  access control list ���ʿ����б���ư���
 * ACL��������ҪԪ��
 *  ��Դ : ����Щ��ϢʱҪ������������
 *  Ȩ�޼��� ��ͬ�ķ����߹滮�ڲ�ͬ��Ȩ�޼�����
 *  ������(��Ȩ��)�� ���Ʋ�ͬ������ʲ�ͬ��Դ
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
 * ��Ȩ��
 * 
 * @author Chain
 */
interface Identifier{
	public final static String REFUSE_WORD = "����Ȩ����";
	public boolean identity();
}

/**
 * ��enumʵ��
 * @author Chain
 *
 */
enum CommonIdentifier implements Identifier{
	//Ȩ�޼���
	READ,AUTHOR,ADMIN;
	
	//ʵ��Ȩ��
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