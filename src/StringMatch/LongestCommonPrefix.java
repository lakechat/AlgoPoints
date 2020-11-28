package StringMatch;
/**
 * Leetcode 14
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Example 1:

	Input: ["flower","flow","flight"]
	Output: "fl"
	Example 2:

	Input: ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.
 * 
 * @author lakec
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {"flower","flow","flight"};
	//	String[] strs = {"dog","dogs","racecar","car"};
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println("longest common prefix is: "+lcp.lcp2(strs));

	}
	
	// using indexOf() method
	private String lcp(String[] strs) {
		
		if(strs==null || strs.length==0)
			return "";
		int n = strs.length;
		
		String result = strs[0];
		
		for(int i=1;i<strs.length;i++) {
			String s = strs[i];
			while(s.indexOf(result)!=0) {
				result = result.substring(0, result.length()-1);
				if(result.length()==0)
					break;
			}
		}
		
		return result;
	}
	
	// vertical scan
	private String lcp2(String[] strs) {
		if(strs==null || strs.length==0)
			return "";
		int n = strs.length;
		
		String s0 = strs[0];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s0.length();i++) {
			int j=1;
			for(;j<n;j++) {
				if(i>=strs[j].length() || s0.charAt(i)!=strs[j].charAt(i))
					break;
			}
			if(j==n)
				sb.append(s0.charAt(i));
			else
				break;
		}
		
		return sb.toString();
	}

}
