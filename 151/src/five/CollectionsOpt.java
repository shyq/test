package five;

import java.util.ArrayList;
import java.util.List;

public class CollectionsOpt {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		l1.add("A");
		l1.add("B");
		
		List<String> l2 = new ArrayList<String>();
		l2.add("C");
		l2.add("D");
		l2.add("A");
	//	l1.addAll(l2);//����
		
	//	l1.retainAll(l2);//���� ɾ��l1��û�г�����l2�е�Ԫ��
		
//		l1.removeAll(l2);//���ɾ��l1�г�����l2�е�Ԫ��
		
		/**
		 * ���ظ��Ĳ���
		 * ��ɾ��������l1�е�Ԫ��
		 * ��ʣ���l2�е�Ԫ�ؼӵ�l1
		 * 
		 */
//		l2.removeAll(l1);
//		l1.addAll(l2);
		
		System.out.println(l1.size());
		
	}
	
	
}
