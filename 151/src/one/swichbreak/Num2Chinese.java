package one.swichbreak;

public class Num2Chinese {

	public static void main(String[] args) {
		System.out.println(toChineseNumber(0));
	}
	
	public static String toChineseNumber(int n){
		String chineseNum = "";
		switch (n) {
		case 0:
			chineseNum = "��";
			break;
		case 1:
			chineseNum = "Ҽ";
			break;
		case 2:
			chineseNum = "��";
			break;
		case 3:
			chineseNum = "��";
			break;
		case 4:
			chineseNum = "��";
			break;
		case 5:
			chineseNum = "��";
			break;
		case 6:
			chineseNum = "½";
			break;
		case 7:
			chineseNum = "��";
			break;
		case 8:
			chineseNum = "��";
			break;
		case 9:
			chineseNum = "��";
			break;
		default:
			break;
		}
		return chineseNum;
	}
}
