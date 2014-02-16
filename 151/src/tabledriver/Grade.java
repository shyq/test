package tabledriver;

public class Grade {

	static final double[] SCORE = {50.0,65.0,75.0,90.0,100.0};
	static final String[] GRADE = {"F","D","C","B","A"};
	
	public static String getGrade(double score){
		String grade = "A";
		for(int i = 0; i < SCORE.length ; i++){
			if(score < SCORE[i]){
				grade = GRADE[i];
				break;
			}
		}
		return grade;
	}
	
	public static void main(String[] args) {
		System.out.println(getGrade(65));
	}
}
