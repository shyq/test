package three;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ϵ�л�ʵ�ֶ��󿽱�
 * 
 * ԭ��ͨ˵�ֽ����Ŀ�����ʵ�� ����ĸ����д���ֽ����У�������ʱ���ٴ��ֽ����ж�����
 * �����Ϳ����ؽ�һ���µĶ��󡣸��¶�����ĸ���󲻴��������빲��Ĺ�ϵ��
 * 
 * ��Ҫע�⣺
 * 1.������ڲ����Զ������ǿ�ϵ�л���
 * 2.ע�ⷽ�������Ե����η�  �磨final static transient��
 * 
 * ����ʹ��Apache��commons���߰��е�SerializableUtilsʵ��ϵ�л���ʽ����
 * @author Chain
 *
 */
public class SerializableImplObjectClone {
	public static void main(String[] args) {
		AnnimalNoClone father = new AnnimalNoClone("Զ������");
		AnnimalNoClone east = new AnnimalNoClone("��������",father);
		AnnimalNoClone west = CloneUtil.clone(east);
		west.setName("��������");
		east.getFather().setName("�Ϲ�����");
		System.out.println("����������������--->>" + east.getFather().getName());
		System.out.println("����������������--->>" + west.getFather().getName());
	}
}

class CloneUtil{
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone (T obj){
		T t = null;
		try {
			//��ȡ�����ֽ���
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();
			
			//�����ڴ�ռ䣬д��ԭʼ���������µĶ���
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			t = (T)ois.readObject();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(obj.getClass().getName() + "û���ҵ���ת��ʧ��..." );
		}
		
		return t;
	}
}

class AnnimalNoClone implements Serializable{
	private static final long serialVersionUID = 8326308131051354569L;
	private String name;
	private AnnimalNoClone father;
	
	public AnnimalNoClone(String name) {
		super();
		this.name = name;
	}
	
	public AnnimalNoClone(String name, AnnimalNoClone father) {
		super();
		this.name = name;
		this.father = father;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AnnimalNoClone getFather() {
		return father;
	}

	public void setFather(AnnimalNoClone father) {
		this.father = father;
	}
}
