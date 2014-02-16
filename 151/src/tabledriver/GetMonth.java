package tabledriver;

/**
 * ���ñ���������ȡ����
 * 
 * ����������Ҫ���滻case��� ��һЩ��ѯ�㷨�У���������������Ϊһ�֡��Կռ任ʱ�䡱�ķ���
 * 
 * @author Chain
 * 
 */
public class GetMonth {

	/**
	 * ����table
	 */
	static final int[] DAY_TABLE = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,30, 31 };

	/**
	 * �����·ݼ��Ƿ��������ȡ��ǰ�·ݵ�����
	 * @param month �·�
	 * @param isLeapYear �Ƿ�Ϊ����
	 * @return
	 */
	public static int getDayCount(int month, boolean isLeapYear) {
		int diff = (isLeapYear && (month == 2)) ? 1 : 0;
		return DAY_TABLE[month - 1] + diff;
	}

	public static void main(String[] args) {
		System.out.println(getDayCount(2,true));
	}
}
