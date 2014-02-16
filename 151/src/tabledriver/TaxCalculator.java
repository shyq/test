package tabledriver;

/**
 * �ҹ�˰���涨������ÿ�¹��ʡ�н��������˰����1600Ԫ��Ӧ���ɸ�������˰��
 * �����ܶ��ȥ����������ʣ�ಿ�ֳ�ΪӦ��˰���öӦ��˰���ö�±�涨�ĳ����۽�˰�ʼ���Ӧ���ɵĸ�������˰ ���� Ӧ��˰���ö� ˰��% 1
 * ������500Ԫ�� 5 2 ����500Ԫ��2000Ԫ�Ĳ��� 10 3 ����2000Ԫ��5000Ԫ�Ĳ��� 15 4 ����5000Ԫ��20000Ԫ�Ĳ��� 20
 * 5 ����20000Ԫ�Ĳ��� 25 ���磺����ĳ��������4300Ԫ����ȥ��������1600Ԫ����Ӧ��˰���ö�Ϊ2700Ԫ��
 * 2700Ԫ����1,2��3����˰��׼������������������Ӧ��˰�ܶ�����������ɣ� ������500Ԫ�Ĳ���Ϊ500Ԫ����5%˰�ʼ���Ӧ��˰25Ԫ��
 * ��500Ԫ��2000Ԫ�Ĳ���Ϊ1500Ԫ����10%��˰�ʼ���Ӧ��˰150Ԫ��
 * ����2000Ԫ�Ĳ���Ϊ2700��2000��700Ԫ����15%˰�ʼ���Ӧ��˰105Ԫ�� ����֮��Ϊ25Ԫ��150Ԫ��105Ԫ��280Ԫ
 * 
 * @author Chain
 */
public class TaxCalculator {

	public final static int BASE = 1600;

	/**
	 * ����˰�ձ���
	 */
	private static final int[][] TAX_BRACKETS = { 
		{ 500, 5 },
		{ 2000, 10 },
		{ 5000, 15 }, 
		{ 20000, 20 }, 
		{ Integer.MAX_VALUE, 25 },
	};

	public static double calTax(int rawIncome){
		if(rawIncome <= BASE || rawIncome < 0)
			return 0;
		int income = rawIncome - BASE;
		double tax = 0;
		int pre = 0;
		for(int[] bracket : TAX_BRACKETS){
			int incomeLimit = bracket[0];// ��ȡ˰�շ�Χ
			int rate = bracket[1]; //��ȡ˰��
			tax += (min(incomeLimit,income) - pre)*(rate / 100.00);
			if(income < incomeLimit)
				break;
			pre = incomeLimit;
		}
		return tax;
	}
	
	private static int min(int x ,int y){
		return x > y ? y : x;
	}
	
	public static void main(String[] args) {
		System.out.println(calTax(1700));
	}
}
