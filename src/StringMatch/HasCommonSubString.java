package StringMatch;

import java.util.ArrayList;
import java.util.List;

public class HasCommonSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String s1 = "hitl";
		String s2 = "all";
		
		HasCommonSubString hcs = new HasCommonSubString();
		/*
		List<String> result = hcs.getCommonSubString(s1, s2);
		
		for(String s : result)
			System.out.println("common string is: "+s);
			*/
		System.out.println(hcs.hasCommonSubString(s1, s2));
	}
	
	private List<String> getCommonSubString(String s1, String s2) {
		
		List<String> list = new ArrayList<>();
		for(int i=0;i<s1.length();i++) {
			char c1 = s1.charAt(i);
			for(int j=0;j<s2.length();j++) {
				char c2 = s2.charAt(j);
				if(c1==c2) {
					int ii = i+1;
					int jj = j+1;
					while(ii<s1.length() && jj <s2.length() && s1.charAt(ii)==s2.charAt(jj)) {
						ii++;
						jj++;
					}
					System.out.println("comon substring, s1 from  "+i+" to "+(ii-1));
					System.out.println("comon substring, s2 from  "+j+" to "+(jj-1));
					list.add(s1.substring(i,ii));
				}
			}
		}
		
		return list;
	}
	
	private boolean hasCommonSubString(String s1, String s2) {
		
		int CHAR_MAX = 256;
		
		boolean v[] = new boolean[CHAR_MAX];
		
		for(int i=0;i<s1.length();i++)
			v[s1.charAt(i)-'a']=true;
		
		for(int i=0;i<s2.length();i++)
			if(v[s2.charAt(i)-'a'])
				return true;
		
		return false;
	}
	

}
