import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Map;

public class Page_Sorting {
	 public static void sortValue(Hashtable<?, Integer> file_register,int occurrance){
			

	       //Transfer as List and sort it
	       ArrayList<Map.Entry<?, Integer>> list = new ArrayList(file_register.entrySet());
	       
	      
	       
	       Collections.sort(list, new Comparator<Map.Entry<?, Integer>>(){

	         public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
	            return o1.getValue().compareTo(o2.getValue());
	        }});
	      
	       Collections.reverse(list);
	       
	      
	       if(occurrance!=0) {
		       System.out.println("\n------TOP 10 pages for the searched word are : ------\n");
		       System.out.println("Rank-------------------------------------Page Name-------------------------------------Occurrances\n");
		       int n = 10;
		       int j = 0;
				while (list.size() > j && n>0){
					//System.out.println(list.get(j).getKey());
					System.out.println("("+(j+1)+")------------"+list.get(j).getKey()+"---------------"+list.get(j).getValue()+" times ");
					j++;
					n--;
				}
	       }else {
	    	   
	       }  
	       
	    }

}
