
package hashtables;

/**
 *
 * @author Dominika
 */
public class LinearProbing {
    
    private final int maxSize;
    private Long[] hashtable;
    long counter=0;
    
    
    //constructor
    public LinearProbing(int capacity){
        maxSize=capacity;
        hashtable=new Long[maxSize];
   
    }
    
    public int hashingFunc(long k, long i){
        counter++;
        return (int)((k+i)%maxSize);
    }
            
    //inserting
    public void linearInsert( long val){
        for(long i=0; i<maxSize; i++){
            int index = hashingFunc(val,i);
            if(hashtable[index]==null){
                hashtable[index]=val;
                break;
            }                
        }
    }
    
    public boolean linearSearch(long val){
        for(long i=0;i<maxSize;i++){
            int index=hashingFunc(val,i);
            if(hashtable[index]==null){
                return false;
            }
            if(hashtable[index]==val){
                return true;
            }
        }
        return false;
    }
    
}