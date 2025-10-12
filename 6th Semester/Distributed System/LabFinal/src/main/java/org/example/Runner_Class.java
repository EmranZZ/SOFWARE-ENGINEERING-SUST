
package org.example;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;

public class Runner_Class {
    public static void main(String[] args) throws IOException {
        JobConf conf = new JobConf(Runner_Class.class);
        conf.setJobName("WordCount");

        //set output data types
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        //set mapper and reducer classes
        conf.setMapperClass(Mapper_Class.class);
        conf.setCombinerClass(Reducer_Class.class);
        conf.setReducerClass(Reducer_Class.class);

        //Text input & output format
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        //File input & output format
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);
    }
}
