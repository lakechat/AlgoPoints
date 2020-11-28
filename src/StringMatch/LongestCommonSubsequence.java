package StringMatch;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "AGGTABCFK"; 
	    String s2 = "GXTXAYBK"; 
	    
	    System.out.println("lcs is: "+lcs2(s1,s2));
	    printLCS(s1, s2);
	}
	
	// time O(m*n), space O((m+1)*(n+1))
	public static int lcs(String match, String pattern) {
		int m = match.length();
		int n = pattern.length();
		
		int[][] lcs = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0) {
					lcs[i][j]=0;
				}
				else if(match.charAt(i-1)==pattern.charAt(j-1)) {
					lcs[i][j]=1+lcs[i-1][j-1];
				}
				else
					lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		return lcs[m][n];
	}
	
	// optimized space O(2*n)
	
	public static int lcs2(String match, String pattern) {
		int m = match.length();
		int n = pattern.length();
		
		int[][] lcs = new int[2][n+1];
		int bi=0;
		for(int i=0;i<=m;i++) {
			bi = i&1;
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					lcs[bi][j]=0;
				else if(match.charAt(i-1)==pattern.charAt(j-1))
					lcs[bi][j]=lcs[1-bi][j-1]+1;
				else
					lcs[bi][j]=Math.max(lcs[1-bi][j], lcs[bi][j-1]);
			}
		}
		return lcs[bi][n];
	}
	
	// print lcs
	
	public static void printLCS(String match, String pattern) {
		int m = match.length();
		int n = pattern.length();
		
		int[][] lcs = new int[2][n+1];
		
		int bi=0;
		for(int i=0;i<=m;i++) {
			bi = i&1;
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					lcs[bi][j]=0;
				else if (match.charAt(i-1)==pattern.charAt(j-1)) {
					lcs[bi][j]=1+lcs[1-bi][j-1];
				}
				else
					lcs[bi][j]=Math.max(lcs[1-bi][j], lcs[bi][j-1]);
			}
		}
		
		int index = lcs[bi][n];
		int tmp = index;
		char[] result = new char[index+1];
		int i=m;
		int j=n;
		bi=0;
		while(i>0 && j>0) {
			bi=i&1;
			if(match.charAt(i-1)==pattern.charAt(j-1)) {
				result[index-1]=match.charAt(i-1);
				i--;
				j--;
				index--;
			}
			else if(lcs[1-bi][j]>lcs[bi][j-1])
				i--;
			else
				j--;
		}
		for(int k=0;k<=tmp;k++) 
            System.out.print(result[k]); 
	}

}
