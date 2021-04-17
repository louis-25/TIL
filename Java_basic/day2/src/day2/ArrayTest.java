package day2;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[] = new String[5];
		names[0] = "홀미미";
		names[1] = "이민정";
		names[2] = "서형준";
		names[3] = "김범근";
		names[4] = "김우일";
		
		int [][] scores = new int[5][];
		
		for(int i = 0; i<scores.length; i++) {
			scores[i] = new int[3];
			for(int j = 0; j<scores[0].length;j++) {
				scores[i][j] = (int)(Math.random()*100)+1;
			}
		}
		
		double avg[] = new double[5];
		for(int i = 0; i<scores.length; i++) {
			avg[i] = ((double)(scores[i][0]+scores[i][1]+scores[i][2]))/3;
		}
		
		for(int i =0; i<5; i++) {
			System.out.print(avg[i]+"\t");
		}
	}

}
