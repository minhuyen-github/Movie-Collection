package numberlist;

/**
 * This class throws an exception if the user used an invalid index which is 
 * defined "out of range of the array/list".
 * @author Uyen Hoang
 */
public class InvalidIndexException extends Exception{
    private int minIndex;
    private int maxIndex;
    private int indexUsed;
    
    /**
     * This is the constructor which contains the range for each ArrayList methods,
     * and is called if the user input an index that is out of range.
     * @param minIndex This is the minimum or the lower bound for the index.
     * @param maxIndex This is the maximum or the upper bound for the index.
     * @param indexUsed This is the index that the user has used.
     */
    public InvalidIndexException(int minIndex, int maxIndex, int indexUsed) {
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
        this.indexUsed = indexUsed;
    }
    
    /**
     * This method will get the minimum value allowed for the index.
     * @return the minimum value.
     */
    public int getMinIndex() {
        return minIndex;
    }
    
    /**
     * This method will get the maximum value allowed for the index.
     * @return the maximum value.
     */
    public int getMaxIndex() {
        return maxIndex;
    }
    
    /**
     * This method will get the index that the user has used.
     * @return the index which the user used.
     */
    public int getIndexUsed() {
        return indexUsed;
    }
}
