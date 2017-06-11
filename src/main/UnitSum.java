package main;

import java.io.IOException;

import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.DoubleWritable;


/**
 * Created by caitlin.ye on 6/10/17.
 */
public class UnitSum {

    public static class PassMapper extends Mapper<Object, Text, Text, DoubleWritable>{

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
            //input: topage\tsubPR
            String[] pageSubpr = value.toString().trim().split("\\t");
            context.write(new Text(pageSubpr[0]), new DoubleWritable(Double.parseDouble(pageSubpr[1])));
        }

    }

    //reducer optional here
    public static class SumReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable>{

      //Do we need this? -->  @Override
        public void reduce(Text key, Iterable){


        }

    }


}
