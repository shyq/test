package tabledriver;

/**
 * 利用表驱动法获取日期
 * 
 * 表驱动法主要是替换case语句 在一些查询算法中，表驱动法可以作为一种“以空间换时间”的方案
 * 
 * @author Chain
 * 
 */
public class GetMonth {

	/**
	 * 定义table
	 */
	static final int[] DAY_TABLE = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,30, 31 };

	/**
	 * 根据月份及是否是闰年获取当前月份的天数
	 * @param month 月份
	 * @param isLeapYear 是否为闰年
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
