
package org.example.problem1;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.example.Reducer_Class;

import java.io.IOException;

public class Runner_Class1 {
    public static void main(String[] args) throws IOException {
        JobConf conf = new JobConf(Runner_Class1.class);
        conf.setJobName("WordCount");

        //set output data types
        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        //set mapper and reducer classes
        conf.setMapperClass(Mapper_Class1.class);
        conf.setCombinerClass(Reducer_Class1.class);
        conf.setReducerClass(Reducer_Class1.class);
        conf.setNumReduceTasks(1);

        //Text input & output format
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        //File input & output format
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));

        JobClient.runJob(conf);
    }
}
