
package hashtables;

/**
 *
 * @author Dominika
 */
public class doubleHashing {
    
    private final int maxSize;
    private Long[] hashtable;
    long counter=0;
    int Prime = 653363;
    
    //constructor
    public doubleHashing(int capacity){
        maxSize=capacity;
        hashtable=new Long[maxSize];
    }
    
    public int hashingFunc(long k, long i){
        counter++;
        long h1 = (long)(k%maxSize);
        long h2 = (long)(i*(Prime-(k%Prime)));
        return (int)(( h1 + h2) % maxSize);
    }
            
    //inserting
    public void doubleInsert( long val){
        for(long i=0; i<maxSize; i++){
            int index = hashingFunc(val,i);
            if(hashtable[index]==null){
                hashtable[index]=val;
                break;
            }                
        }
    }
    
    public boolean doubleSearch(long val){
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
