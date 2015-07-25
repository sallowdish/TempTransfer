import java.util.Random;
import static org.junit.Assert.*;

/**
 * Created by t-razhen on 7/24/2015.
 */
public class SelectionSortTest {
    /**
     * Constants and variable for testing
     */
    private final int[] kEmpty = {};
    private final int[] kNegIntegers = {-1, -3, -2};
    private final int[] kPosIntegers = {314, 234, 3, 45};
    private final int[] kMixIntegers = {314, -3, -789, 88 ,234, -97, 45};
    private final int[] kDuplicatedIntegers = {1,1,1,1,1,1,1,1,1,1};
    private final int[] kMultiDuplicatedIntegers = {1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,3,3,3,3};
    private final String[] kStrings = {"aba", "b", "sdfqewr"};
    private int[] randomIntegers;
    private int kRandomIntegersSize = 10;
    private int[] randomLongIntegers;
    private int kRandomLongIntegersSize = 100;

    /**
     * Constants for boundaries
     */
    private final int kUpperBound = 999999;
    private final int kLowerBound = -999999;

    @org.junit.Before
    public void setUp() throws Exception {
        initializeRandomIntegers();
//        System.out.println("Random Array: " + randomIntegers.toString());
    }

    @org.junit.Test
    public void testSort() throws Exception {
        assertTrue(isArraySorted(SelectionSort.sort(kEmpty)));
    }

    @org.junit.Test
    public void testSortNegIntegers() throws Exception {
        assertTrue(isArraySorted(SelectionSort.sort(kNegIntegers)));
    }

    @org.junit.Test
    public void testSortPosIntegers() throws Exception {
        assertTrue(isArraySorted(SelectionSort.sort(kPosIntegers)));
    }

    @org.junit.Test
    public void testSortMixIntegers() throws Exception {
        assertTrue(isArraySorted(SelectionSort.sort(kMixIntegers)));
    }

    @org.junit.Test
    public void testSortDuplicatedIntegers() throws Exception {
        assertTrue(isArraySorted(SelectionSort.sort(kDuplicatedIntegers)));
    }

    @org.junit.Test
    public void testSortMultiDuplicatedIntegers(){
        assertTrue(isArraySorted(SelectionSort.sort(kMultiDuplicatedIntegers)));
    }

    @org.junit.Test
    public void testSortRandomIntegers() throws Exception {
        assertTrue(isArraySorted(SelectionSort.sort(randomIntegers)));
    }

    @org.junit.Test
    public void testSortRandomLongIntegers() throws Exception {
        initializeLongRandomIntegers();
        assertTrue(isArraySorted(SelectionSort.sort(randomLongIntegers)));
    }

    private void initializeRandomIntegers(){
        Random rand = new Random();
        randomIntegers = new int[kRandomIntegersSize];
        for (int i = 0; i < kRandomIntegersSize; i++) {
            randomIntegers[i] = rand.nextInt((kUpperBound - kLowerBound) + 1) + kLowerBound;
        }
    }

    private void initializeLongRandomIntegers(){
        Random rand = new Random();
        randomLongIntegers = new int[kRandomLongIntegersSize];
        for (int i = 0; i < kRandomLongIntegersSize; i++) {
            randomLongIntegers[i] = rand.nextInt((kUpperBound - kLowerBound) + 1) + kLowerBound;
        }
    }

    private boolean isArraySorted( int[] data)
    {
        boolean isSorted = true;
        if (data.length <= 1){
        }
        else{
            for (int i = 1; i < data.length; i++) {
                if (data[i-1] > data[i]){
                    isSorted = false;
                    break;
                }
            }
        }
        return isSorted;
    }
}