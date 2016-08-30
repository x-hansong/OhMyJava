package com.hansong.kafka;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 *
 * @author hansong.xhs
 * @version $Id: SimplePartitioner.java, v 0.1 2016-08-27 16:45 hansong.xhs Exp $
 */
public class SimplePartitioner implements Partitioner{

    public SimplePartitioner(VerifiableProperties props) {

    }
    public int partition(Object key, int numPartitions) {
        int partition = 0;
        if (key instanceof String) {
            String keyStr=(String)key;
            int offset = keyStr.lastIndexOf('.');
            if (offset > 0) {
                partition = Integer.parseInt(keyStr.substring(offset + 1)) % numPartitions;
            }
        }else{
            partition = key.toString().length() % numPartitions;
        }

        return partition;
    }
}
