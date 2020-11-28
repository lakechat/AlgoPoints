package StringMatch;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "AABAACAADAABAABA"; 
        String pattern = "AABA"; 
        
        KMP kmp = new KMP();
        //kmp.kmpMatch(text, pattern);
        kmp.bruteforce(text, pattern);
	}
	
	private void bruteforce(String text, String pattern) {
		int m = text.length();
		int n = pattern.length();
		
		for(int i=0;i<=m-n;i++) {
			int j=0;
			for(;j<n;j++) {
				if(text.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			if(j==n)
				System.out.println("match found from "+i+" to "+(i+j-1));
		}
	}
	
	private void kmpMatch(String text, String pattern) {
		int[] lpsArray = getLongestPrefixSurfixArray(pattern);
		
		int i=0,j=0;
		int m = text.length();
		int n = pattern.length();
		
		while(i<m) {
			if(text.charAt(i)==pattern.charAt(j) && j==n-1) {
				System.out.println("match found from "+(i-j)+" to "+i);
				j=lpsArray[j];
			}
			if(text.charAt(i)==pattern.charAt(j)) {
				i++;
				j++;
			}
			else {
				j=lpsArray[j];
				if(j==-1) {
					i++;
					j++;
				}
			}
		}
		
	}
	
	private int[] getLongestPrefixSurfixArray(String pattern) {
		int n = pattern.length();
		int[] lpsArray = new int[n];
		
		lpsArray[0]=0;
		int len=0;
		int i=1;
		while(i<n) {
			if(pattern.charAt(i)==pattern.charAt(len)) {
				len++;
			
				lpsArray[i]=len;
				i++;
			}
			else {
				if(len>0) {
					len = lpsArray[len-1];
				}else {
					lpsArray[i]=len;
					i++;
				}
				
			}
		}
		
		// shift psArray to right 1 position, fill psArray[0] with -1
		for(i=n-1;i>0;i--) {
			lpsArray[i]=lpsArray[i-1];
		}
		lpsArray[0]=-1;
		return lpsArray;
	}

}
