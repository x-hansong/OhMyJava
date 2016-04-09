package com.algorithm;

import com.algorithm.math.Divisor;
import com.algorithm.math.PrimeNumber;
import com.algorithm.searching.BinarySearch;
import com.algorithm.sorting.MergeSort;
import com.algorithm.sorting.QuickSort;
import com.contest.Forbidden;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xhans on 2016/3/1.
 */
public class MyTest {

    Logger logger = LoggerFactory.getLogger(MyTest.class);
//    @Test
    public void testQuickSort(){
        QuickSort<Integer> quickSort = new QuickSort<Integer>();


        quickSort.sort0(new Integer[]{1});
        quickSort.sort0(new Integer[]{1,2});
        quickSort.sort0(new Integer[]{1,2,0});
        quickSort.sort0(new Integer[]{1,2,0,5});
        quickSort.sort0(new Integer[]{1,2,3,4,5,6,7,8});
        quickSort.sort0(new Integer[]{1,2,0,5,2,1,4,6,3,0});
    }

//    @Test
    public void testBinaryTest(){
        BinarySearch<Integer> binarySearch = new BinarySearch<Integer>();

        logger.debug(String.valueOf(binarySearch.binarySearch(new Integer[]{0}, 0)));
        logger.debug(String.valueOf(binarySearch.binarySearch(new Integer[]{}, 0)));
        logger.debug(String.valueOf(binarySearch.binarySearch(new Integer[]{1,2,4,6,8}, 8)));
        logger.debug(String.valueOf(binarySearch.binarySearch(new Integer[]{1,1,3,4,4,4,4}, 4)));
    }

//    @Test
    public void testMergeSort(){
        MergeSort<Integer> mergeSort = new MergeSort<Integer>();

        mergeSort.mergeSort(new Integer[]{0, 1});
        mergeSort.mergeSort(new Integer[]{1,3,5,3,1,1,0});
        mergeSort.mergeSort(new Integer[]{3,5,3,1,1,0});
    }

//    @Test
    public void testPermutation(){
        Permutation permutation = new Permutation();

        permutation.permutation(new char[] {'a','b','c'});
        permutation.permutation(new char[] {'a','b','b'});
    }

//    @Test
    public void testQueen(){
        Queen queen = new Queen();

        logger.debug(String.valueOf(queen.queens(new int[1], 0)));
        logger.debug(String.valueOf(queen.queens(new int[2], 0)));
        logger.debug(String.valueOf(queen.queens(new int[3], 0)));
        logger.debug(String.valueOf(queen.queens(new int[4], 0)));
        logger.debug(String.valueOf(queen.queens(new int[8], 0)));
    }

//    @Test
    public void testPrime(){
        PrimeNumber primeNumber = new PrimeNumber();

        logger.debug(String.valueOf(primeNumber.primeNumbers(1)));
        logger.debug(String.valueOf(primeNumber.primeNumbers(2)));
        logger.debug(String.valueOf(primeNumber.primeNumbers(4)));
        logger.debug(String.valueOf(primeNumber.primeNumbers(10)));
        logger.debug(String.valueOf(primeNumber.primeNumbers(100)));
    }

//    @Test
    public void testPrimeDivisors(){
        logger.debug(String.valueOf(Divisor.primeDivisorAndCounts(10)));
        logger.debug(String.valueOf(Divisor.primeDivisorAndCounts(100)));
        logger.debug(String.valueOf(Divisor.primeDivisorAndCounts(1000)));
        logger.debug(String.valueOf(Divisor.primeDivisorAndCounts(1223000)));
    }

//    @Test
    public void testDivisors(){
        int i=100;
        String binStr=Integer.toBinaryString(i);
        String otcStr=Integer.toOctalString(i);
        String hexStr=Integer.toHexString(i);
        System.out.println(binStr);

        logger.debug(String.valueOf(Divisor.divisors(10)));
        logger.debug(String.valueOf(Divisor.divisors(100)));
        logger.debug(String.valueOf(Divisor.divisors(1000)));
    }

    @Test
    public void testHiho1014(){
//        Hiho1014.Trie trie = new Hiho1014.Trie();
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            trie.insert(RandomStringUtils.randomAlphabetic(26).toLowerCase());
//        }
//        for (int i = 0; i < Integer.MAX_VALUE; i++) {
//            System.out.println(trie.getPrefixNum(RandomStringUtils.randomAlphabetic(26).toLowerCase()));
//        }
        logger.debug(String.valueOf(0xffffffff >>> 31));
        logger.debug(String.valueOf(Integer.MAX_VALUE >> 31));
        logger.debug(Integer.toBinaryString(Forbidden.toInt("1.1.1.1")));
        logger.debug(Integer.toBinaryString(Forbidden.toInt("255.255.255.255")).length() + "");
    }
}
