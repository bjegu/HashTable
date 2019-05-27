
package hashtables;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Dominika
 */


public class mainclass {

  
    public static void main(String[] args) {
        
//        linearTest();
        doubleTest();
        
    }
        
    public static void linearTest(){
        //creating a table with capacity given in the instruction 
        int capacity = (int)(1050000 / 0.8);
        System.out.println("Max size: "+capacity);
        LinearProbing hashtableCap = new LinearProbing(capacity);
        
        //reading values from file and inserting it to the hashtable using linear insert method;
        List<Long> initialList = Arrays.asList(readHits());
        initialList.forEach(hashtableCap::linearInsert);
        
        //chosing 10% of the values in initial list
        //searching for this values
        hashtableCap.counter = 0;
        for(int i = 0; i < initialList.size(); i++){
            if(i%10==0){
               Long elementValue= initialList.get(i);
               hashtableCap.linearSearch(elementValue);
            }
        }
        
//        list.forEach(table2::linearSearch);
        System.out.println("Counter hits: "+hashtableCap.counter);
        System.out.println("Load factor:"+(1050000*100/capacity));
        
        List<Long> missList = Arrays.asList(readMiss());
        hashtableCap.counter = 0;
        for(int i = 0; i < missList.size(); i++){
            if(i%10==0){
               Long elementValue= missList.get(i);
               hashtableCap.linearSearch(elementValue);
            }
        }
        
        System.out.println("Counter miss: "+hashtableCap.counter);
        System.out.println("Load factor:"+(1050000*100/capacity));
    }
    
    public static void doubleTest(){
        
//        doubleHashing table = new doubleHashing(10);
//        table.doubleInsert(1);
//        table.doubleInsert(5);
//        table.doubleInsert(2);
//        table.doubleInsert(1);
//        
//        System.out.println(table.doubleSearch(1));
//        System.out.println(table.doubleSearch(5));
//        System.out.println(table.doubleSearch(2));
//        System.out.println(table.doubleSearch(1));
//        System.out.println(table.doubleSearch(62));
        
        //creating a table with capacity given in the instruction 
        int capacity = (int)(1050000 / 0.8);
        System.out.println("Max size: "+capacity);
        doubleHashing hashtableCap = new doubleHashing(capacity);
        
        //reading values from file and inserting it to the hashtable using linear insert method;
        List<Long> initialList = Arrays.asList(readHits());
        initialList.forEach(hashtableCap::doubleInsert);
        
                //chosing 10% of the values in initial list
        //searching for this values
        hashtableCap.counter = 0;
        for(int i = 0; i < initialList.size(); i++){
            if(i%10==0){
               Long elementValue= initialList.get(i);
               hashtableCap.doubleSearch(elementValue);
            }
        }
        
//        list.forEach(table2::linearSearch);
        System.out.println("Counter hits: "+hashtableCap.counter);
        System.out.println("Load factor:"+(1050000*100/capacity));
        
        List<Long> missList = Arrays.asList(readMiss());
        hashtableCap.counter = 0;
        for(int i = 0; i < missList.size(); i++){
            if(i%10==0){
               Long elementValue= missList.get(i);
               hashtableCap.doubleSearch(elementValue);
            }
        }
        
        System.out.println("Counter miss: "+hashtableCap.counter);
        System.out.println("Load factor:"+(1050000*100/capacity));
    }
    
    public static Long[] ReadFromTXT(String path){
        Long[] out = new Long[1050000];
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(path));
			String line = reader.readLine();
                        int i=0;
			while (line != null) {
				
                                out[i] = Long.parseLong(line);
                                i++;
                                // read next line
                                line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
        }
    return out;
    }
    
    public static Long[] readHits(){
       return ReadFromTXT("C:\\Users\\Dominika\\Documents\\set_of_1050000_random_numbers.txt");
    }
    
    public static Long[] readMiss(){
       return ReadFromTXT("C:\\Users\\Dominika\\Documents\\set_of_1050000_random_numbers_for_search_miss.txt");
    }
}
