package one.swichbreak;

public class Num2Chinese {

	public static void main(String[] args) {
		System.out.println(toChineseNumber(0));
	}
	
	public static String toChineseNumber(int n){
		String chineseNum = "";
		switch (n) {
		case 0:
			chineseNum = "Áã";
			break;
		case 1:
			chineseNum = "Ò¼";
			break;
		case 2:
			chineseNum = "·¡";
			break;
		case 3:
			chineseNum = "Èş";
			break;
		case 4:
			chineseNum = "ËÁ";
			break;
		case 5:
			chineseNum = "Îé";
			break;
		case 6:
			chineseNum = "Â½";
			break;
		case 7:
			chineseNum = "Æâ";
			break;
		case 8:
			chineseNum = "°Æ";
			break;
		case 9:
			chineseNum = "¾Á";
			break;
		default:
			break;
		}
		return chineseNum;
	}
}
