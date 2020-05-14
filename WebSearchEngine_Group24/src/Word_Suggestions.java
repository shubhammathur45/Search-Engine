import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word_Suggestions {
	static Hashtable<String, Integer> file_index = new Hashtable<String, Integer>();
	static ArrayList<String> key = new ArrayList<String>();
	static EditDistance ed=new EditDistance();
	SearchEngineIntialiser sei=new SearchEngineIntialiser();
	
	public static void findData(File source,int fileNumber,Matcher match,String pat) throws FileNotFoundException,ArrayIndexOutOfBoundsException
    {
    	try
    	{
    		int i = 0;
    		BufferedReader _rederObject = new BufferedReader(new FileReader(source));
    		String line = null;

              while ((line = _rederObject.readLine()) != null){
              match.reset(line);
              while (match.find()) {
            	  key.add(match.group());
                }
             }
              _rederObject.close();
              for(int p = 0; p<key.size(); p++){ 
              	  file_index.put(key.get(p), ed.editDistance(pat.toLowerCase(),key.get(p).toLowerCase()));
                }
    	}     
    	catch(Exception e)
    	{
    		System.out.println("Exception:"+e);
    	}
    	
    }
	
	public void alternativeWord(String pat) {
		try {
			
			// String to be scanned to find the pattern.
		      String line = " ";
		      String pattern3 = "[a-zA-Z0-9]+";
		      
		     
		      // Create a Pattern object
		      Pattern pattern_obj = Pattern.compile(pattern3);
		      // Now create matcher object.
		      Matcher matcher_obj = pattern_obj.matcher(line);
		      int _fileNumber=0;
				try {
					File _directory = new File("src\\ConvertedTextFiles");
					File[] _fileArray = _directory.listFiles();
					for(int i=0;i<100;i++)
					{
						findData(_fileArray[i],_fileNumber,matcher_obj,pat);
						_fileNumber++;
					}
					
			        Set keys = new HashSet();
			        Integer value =1;
			        Integer val = 0;
			        
			        System.out.println("Sorry! we were not able to find the searched word.");
			        System.out.println();
			        System.out.println("Did you mean? ");
			        System.out.println();
			        for(Map.Entry entry: file_index.entrySet()){
			        	if(val == entry.getValue()) {
			        		
			        		break;
				           
			            }
			        	else {
			        		
			        		 if(value==entry.getValue()){
					                
					            	System.out.print(entry.getKey()+"  ");
			                
			            }
			            
			        		
			        	}
			    
			        }
			        


				} catch (Exception e) {
					System.out.println("Exception:"+e);
				}
				
				System.out.println();
				System.out.println();
				System.out.println("----------------------------------------------------------------------------------------------------");
				System.out.println("Enter the word from the above suggestions : ");
				Scanner s=new Scanner(System.in);
				String alternate_input=s.nextLine();
				sei.Initialiser(alternate_input);
				
			
			
			
		}
		catch(Exception e){
			
		}
	}

}
