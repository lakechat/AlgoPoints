package RepeatedStringMatch;

/**
 * leetcode 459 
 * 
 * Given a non-empty string check if it can be constructed by taking a substring of it 
 * and appending multiple copies of the substring together. You may assume the given string 
 * consists of lowercase English letters only and its length will not exceed 10000.
	Example 1:

	Input: "abab"
	Output: True
	Explanation: It's the substring "ab" twice.
	
	Example 2:

	Input: "aba"
	Output: False
	
	Example 3:

	Input: "abcabcabcabc"
	Output: True
	Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * @author lakec
 *
 */

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abab";
		RepeatedSubstringPattern rsp = new RepeatedSubstringPattern();
		
		boolean result = rsp.useKMP(s);
		
		System.out.println("\nis repeated substring: "+result);
	}
	
	
	private boolean useKMP(String s) {
		int[] lps = getLPS(s);
		int n = s.length();
		int l = lps[n-1];
		
		return l!=0 && n%(n-l)==0;
	}
	// using KMP
	private int[] getLPS(String s) {
		int n = s.length();
		int[] lps = new int[n];
		
		int len=0;
		int i=1;
		while(i<n) {
			
			if(s.charAt(i)==s.charAt(len)) {
				len++;
				lps[i]=len;
				i++;
			}
			else {
				if(len>0) {
					len = lps[len-1];
				}
				else {
					lps[i]=len;
					i++;
				}
			}
			
		}
		for(int j : lps)
			System.out.print(j+" ");
		return lps;
	}
	
	
}
