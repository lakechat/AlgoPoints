package StringMatch;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "GeeksforGeeks";
		String s2 = "eeQuiz";
		
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		
		/*
		long start = System.currentTimeMillis();
		String result = lcs.longestCommonSubString(s2, s1);
		long end = System.currentTimeMillis();
		System.out.println("lcs is: "+result+", total time is: "+(end-start));
		*/
		
		System.out.println("the length of longest common substring is: "+lcs.lcs(s1, s1.length(),s2,s2.length()));
		System.out.println("longest common substring is: "+lcs.printLCS(s1, s1.length(),s2,s2.length()));
		System.out.println("longest common substring is: "+lcs.printLCS2(s1, s1.length(),s2,s2.length()));
	}
	
	// brute force
	// time complexity O(n^2*m)
	// n = s1.length(), m=s2.length(); so let s1 be the longer string, s2 be the shorter string
	private String longestCommonSubString(String s1, String s2) {
		
		String result = "";
		int count=0;
		int count2=0;
		for(int i=0;i<s1.length();i++) {
			char c1 = s1.charAt(i);
			for(int j=0;j<s2.length();j++) {
				char c2 = s2.charAt(j);
				count++;
				if(c1==c2) {
					int ii = i+1;
					int jj = j+1;
					while(ii<s1.length() && jj <s2.length() && s1.charAt(ii)==s2.charAt(jj)) {
						ii++;
						jj++;
						count++;
						count2++;
					}
					System.out.println("comon substring, s1 from  "+i+" to "+(ii-1));
					System.out.println("comon substring, s2 from  "+j+" to "+(jj-1));
					String tmp = s1.substring(i,ii);
					if(tmp.length()>result.length())
						result = tmp;
				}
			}
		}
		System.out.println("total count: "+count+", internal count: "+count2);
		return result;
	}
	
	/**
	 * https://www.geeksforgeeks.org/longest-common-substring-dp-29/?ref=rp The
	 * longest common suffix has following optimal substructure property.
	 * 
	 * If last characters match, then we reduce both lengths by 1 LCSuff(X, Y, m, n)
	 * = LCSuff(X, Y, m-1, n-1) + 1 if X[m-1] = Y[n-1] If last characters do not
	 * match, then result is 0, i.e., LCSuff(X, Y, m, n) = 0 if (X[m-1] != Y[n-1])
	 * 
	 * Now we consider suffixes of different substrings ending at different indexes.
	 * The maximum length Longest Common Suffix is the longest common substring.
	 * LCSubStr(X, Y, m, n) = Max(LCSuff(X, Y, i, j)) where 1 <= i <= m and 1 <= j
	 * <= n
	 */
	// time O(m*n), space O(m*n)
	private int lcs(String s1, int m, String s2, int n) {
		
		int[][] LCSStuff = new int[m+1][n+1];
		int result = 0;
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					LCSStuff[i][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					LCSStuff[i][j]=LCSStuff[i-1][j-1]+1;
					result = Math.max(result, LCSStuff[i][j]);
				}
				else
					LCSStuff[i][j]=0;
			}
		}
		return result;
	}
	
	// print out the string
	
	private String printLCS(String s1, int m, String s2, int n) {
		int[][] LCSStuff = new int[m+1][n+1];
		int result = 0;
		int row=0;
		int col=0;
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					LCSStuff[i][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					LCSStuff[i][j]=LCSStuff[i-1][j-1]+1;
					if(result<LCSStuff[i][j]){
						result=LCSStuff[i][j];
						row=i;
						col=j;
					}
				}
				else
					LCSStuff[i][j]=0;
			}
		}
		/* build with using StringBuilder
		String resultStr = ""; 
		  
        // traverse up diagonally form the (row, col) cell 
        // until LCSuff[row][col] != 0 
        while (LCSuff[row][col] != 0) { 
            resultStr = X.charAt(row - 1) + resultStr; // or Y[col-1] 
  
            // move diagonally up to previous cell 
            row--; 
            col--; 
        } 
		*/
		if(result>0) {
			StringBuilder sb = new StringBuilder();
			while(LCSStuff[row][col]!=0) {
				sb.append(s1.charAt(row-1));
				row--;
				col--;
			}
			return sb.reverse().toString();
		}
		return "";
	}
	
	// space O(2*n)
	
	private String printLCS2(String s1, int m, String s2, int n) {
		int[][] len = new int[2][n+1];
		int maxLen = 0;
		int currentRow=0;
		int end=0;
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					len[currentRow][j]=0;
				else if(s1.charAt(i-1)==s2.charAt(j-1)) {
					len[currentRow][j]=len[1-currentRow][j-1]+1;
					if(len[currentRow][j]>maxLen) {
						maxLen=len[currentRow][j];
						end=i-1;
					}
				}
			}
			currentRow = 1-currentRow;
		}
		if(maxLen>0)
			return s1.substring(end-maxLen+1, end+1);
		else
			return "";
		
	}
	

}
