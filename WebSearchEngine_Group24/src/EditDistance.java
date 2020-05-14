
public class EditDistance {
	
	public static int editDistance(String text, String pattern) {
		int length1 = text.length();
		int length2 = pattern.length();
	 
		
		int[][] dp = new int[length1 + 1][length2 + 1];
	 
		for (int i = 0; i <= length1; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= length2; j++) {
			dp[0][j] = j;
		}
	 
		//iterate though, and check last char
		for (int i = 0; i < length1; i++) {
			char char1 = text.charAt(i);
			for (int j = 0; j < length2; j++) {
				char char2 = pattern.charAt(j);
	 
				//if last two chars equal
				if (char1 == char2) {
					//update dp value for +1 length1
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
	 
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
	 
		return dp[length1][length2];
	}

}
