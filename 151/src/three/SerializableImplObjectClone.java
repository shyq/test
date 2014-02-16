package three;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 系列化实现对象拷贝
 * 
 * 原理：通说字节流的拷贝来实现 ，把母对象写到字节流中，拷贝的时候再从字节流中读出来
 * 这样就可以重建一个新的对象。改新对象与母对象不存在引用与共享的关系。
 * 
 * 需要注意：
 * 1.对象的内部属性都必须是可系列化的
 * 2.注意方法和属性的修饰符  如（final static transient）
 * 
 * 可以使用Apache的commons工具包中的SerializableUtils实现系列化方式拷贝
 * @author Chain
 *
 */
public class SerializableImplObjectClone {
	public static void main(String[] args) {
		AnnimalNoClone father = new AnnimalNoClone("远古神龙");
		AnnimalNoClone east = new AnnimalNoClone("东方巨龙",father);
		AnnimalNoClone west = CloneUtil.clone(east);
		west.setName("西方巨龙");
		east.getFather().setName("上古神龙");
		System.out.println("东方巨龙的祖先是--->>" + east.getFather().getName());
		System.out.println("西方巨龙的祖先是--->>" + west.getFather().getName());
	}
}

class CloneUtil{
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone (T obj){
		T t = null;
		try {
			//读取对象字节数
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			oos.close();
			
			//分配内存空间，写入原始对象，生成新的对象
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			t = (T)ois.readObject();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(obj.getClass().getName() + "没有找到，转换失败..." );
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
