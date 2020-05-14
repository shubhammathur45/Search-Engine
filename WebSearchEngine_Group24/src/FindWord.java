import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;

public class FindWord {
	
	public static int search1(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();

		for (int i = 0; i <= N - M; i++) {
			int j;
			for (j = 0; j < M; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == M)
				return i; // found at offset i
		}
		return N; // not found
	}
	
	
	public int Word_Search(File filePath, String pat) {
		int count=0;
		String data="";
		try
    	{
    		BufferedReader Object = new BufferedReader(new FileReader(filePath));
    		String line = null;
    		
              while ((line = Object.readLine()) != null){
              
            	  data= data+line;
             
             }
              Object.close();
      		
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception:"+e);
    	}
		
			
			
			String txt = data;

			int offset1a = 0;

				for (int loc = 0; loc <= txt.length(); loc += offset1a + pat.length()) {

					offset1a = search1(pat, txt.substring(loc)); 
					if ((offset1a + loc) < txt.length()) {
	
						count++;
						System.out.println(pat + " found at position " + (offset1a + loc)+" in file "+filePath.getName());   //printing position of word
					}
				}

				return count;
	}

}
