package com.datastructures;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * Created by xhans on 2016/2/26.
 */
public class TestData {

    private static Logger logger = LoggerFactory.getLogger(TestData.class);

//    @Test
    public void testMyArrayList(){
        MyArrayList<Integer>  myArrayList = new MyArrayList<Integer>();

        logger.debug(String.valueOf(myArrayList.size()));
        for (int i = 0; i < 10; i++) {
            myArrayList.add(i);
        }
        logger.debug(String.valueOf(myArrayList.size()));

        Iterator<Integer> iter = myArrayList.iterator();
        while (iter.hasNext()){
            logger.debug(String.valueOf(iter.next()));
            iter.remove();
        }
        logger.debug(String.valueOf(myArrayList.size()));

    }

//    @Test
    public void testMyLinkedList(){
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
            myLinkedList.add(i);
        }
        logger.debug(String.valueOf(myLinkedList.size()));

        myLinkedList.remove(1);

        for (int i = 0; i < myLinkedList.size(); i++) {
            logger.debug(String.valueOf(myLinkedList.get(i)));
        }

    }
    @Test
    public void testBinaryHeap(){
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<Integer>( );
        int i = 37;

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            h.insert( i );
        for( i = 1; i < numItems; i++ )
            if( h.deleteMin( ) != i )
                logger.debug( "Oops! " + i );
    }
}
