import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;


public class SearchEngineIntialiser {
	
static Scanner sc = new Scanner(System.in);
	
	public SearchEngineIntialiser()
	{
		try {
			HTMLtoTextConverter.convertHtmlToText();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		

	public static void main(String[] args) {
		
		//Scanner s = new Scanner (System.in);
		System.out.println("######################################################     WEB SEARCH ENGINE     ######################################################");
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("Enter the string to be searched:");
		String p= sc.nextLine();
	Initialiser(p);

}
	
	public static void Initialiser(String p)
	{
		FindWord bruteforce = new FindWord();
		Word_Suggestions ws=new Word_Suggestions();
		Page_Sorting ps=new Page_Sorting();
		
		Hashtable<String,Integer> filesearch_index = new Hashtable<String,Integer>();
		
		
		long fileNumber = 0;
		int occurrance=0;
		int page=0;
		try {
			
			File dir = new File("src\\ConvertedTextFiles");
			
			File[] fileArray = dir.listFiles();
			for(int i=0;i<102;i++)
			{
				
				occurrance=bruteforce.Word_Search(fileArray[i],p);
				
				filesearch_index.put(fileArray[i].getName(), occurrance);
				if(occurrance!=0) {
					page++;
					System.out.println("----------------------------"+fileArray[i].getName()+"----------------------------");
				}
							
				fileNumber++;
			}
			//System.out.println(filesearch_index.get("XPath and XQuery Functions and Operators 3.0.txt"));
			
			if(page==0) {
				
				System.out.println("------------------------------------------------------------------------------------------------");
		        System.out.println("Searching the pages for the word");
		        
				ws.alternativeWord(p);
				
			}
			System.out.println("----------------------------------------------------------------------------------------------------");
			System.out.println("----------------------------------------------------------------------------------------------------");
			
			
			System.out.println("Do you want your search result to be sorted? Enter (Y/N)");
			//Scanner s=new Scanner(System.in);
			String option=sc.nextLine();
			
			if(option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("Yes"))
			{
				Page_Sorting.sortValue(filesearch_index,page);
				System.out.println();
				System.out.println("These are the top pages which have the desired word along with the number of occurrances.\nThankyou for using our Web Search Engine.");
			}
			
			else if(option.equalsIgnoreCase("N") || option.equalsIgnoreCase("No"))
				System.out.println("Alright! Thankyou for using our web search engine.");
			
			else
				System.out.println("Enter a correct choice!");
		
		}
		catch (Exception e) {
			System.out.println("Exception:"+e);
		}
		finally
		{
				
		} 
		
		}
	}
	
