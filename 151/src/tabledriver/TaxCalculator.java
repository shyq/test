package tabledriver;

/**
 * 我国税法规定，公民每月工资、薪金收入总税超过1600元者应缴纳个人所得税。
 * 收入总额减去免征基数后剩余部分称为应纳税所得额，应纳税所得额按下表规定的超额累进税率计算应缴纳的个人所得税 级别 应纳税所得额 税率% 1
 * 不超过500元的 5 2 超过500元至2000元的部分 10 3 超过2000元至5000元的部分 15 4 超过5000元至20000元的部分 20
 * 5 超过20000元的部分 25 例如：张三某月总收入4300元，减去免征基数1600元，则应纳税所得额为2700元。
 * 2700元符合1,2，3级纳税标准，故张三本月总收入应纳税总额由三部分组成： 不超过500元的部分为500元，按5%税率计算应纳税25元；
 * 而500元至2000元的部分为1500元，按10%的税率计算应纳税150元；
 * 超过2000元的部分为2700－2000＝700元，按15%税率计算应纳税105元， 三者之和为25元＋150元＋105元＝280元
 * 
 * @author Chain
 */
public class TaxCalculator {

	public final static int BASE = 1600;

	/**
	 * 定义税收比例
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
			int incomeLimit = bracket[0];// 获取税收范围
			int rate = bracket[1]; //获取税率
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
