package org.example.problem1;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
import java.util.Iterator;

public class Reducer_Class1 extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
    private String maxWord = "";
    private int maxLength = 0;
    public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, IntWritable> output,
                       Reporter reporter) throws IOException {
        int length = key.getLength();
        if(length > maxLength && length >= 17){
            maxLength = length;
            maxWord = key.toString();
            output.collect(key, new IntWritable(maxLength));
        }
    }
}
