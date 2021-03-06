package com.hadoop.hdfs.hdfs_api;

import com.hadoop.hdfs.common.GetFileSystemClass;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

/**
 * @Auther 陈郑游
 * @Data 2017/8/30 0030
 * @Description:
 * @CSDN:http://blog.csdn.net/javawebrookie
 * @GITHUB:https://github.com/AndyCZY
 */
public class HdfsCreateTest {


    public static void main(String[] args) throws Exception{
        absolutePath();   //绝对路径
//        relativePath();   //相对路径
//        appendContent();  //追加内容
//        bufferedContent(); //添加内容
    }




    //指定绝对路径Absolute path
    private static void absolutePath() throws Exception{
        // get filesystem
        FileSystem fileSystem = GetFileSystemClass.getFileSystem();
        boolean b = fileSystem.createNewFile(new Path("/chenzy/mapreduce/wordcount/input/test.txt"));
        System.out.println(b ? "成功":"失败");
        fileSystem.close();
    }



    //指定相对路径relative path   路径：/user/Administrator/文件名
    private static void relativePath() throws Exception{
        // get filesystem
        FileSystem fileSystem = GetFileSystemClass.getFileSystem();
        boolean b = fileSystem.createNewFile(new Path("relative.txt"));
        System.out.println(b);
        fileSystem.close();
    }


    //追加内容
    private static void appendContent() throws Exception{
        // get filesystem
        FileSystem fileSystem = GetFileSystemClass.getFileSystem();

        Path path = new Path("/chenzy/mapreduce/wordcount/input/test.txt");
        FSDataOutputStream append = fileSystem.append(path);
        append.write("this is append content ! 追加内容 ！".getBytes());
        append.close();
        fileSystem.close();
    }


    //添加内容
    private static void bufferedContent() throws Exception{
        // get filesystem
        FileSystem fileSystem = GetFileSystemClass.getFileSystem();

        Path path = new Path("/chenzy/mapreduce/wordcount/input/test.txt");
        FSDataOutputStream append = fileSystem.append(path);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(append));
        bufferedWriter.newLine();
        bufferedWriter.write("this is append content ! 内容 ！");
        bufferedWriter.newLine();
        bufferedWriter.write("这是换行的内容！");
        bufferedWriter.newLine();

        bufferedWriter.close();
        fileSystem.close();
    }
}
