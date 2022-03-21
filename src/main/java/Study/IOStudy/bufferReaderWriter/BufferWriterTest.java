package Study.IOStudy.bufferReaderWriter;

/**
 * @ClassName BufferWriter
 * @Description TODO
 * @Author wangaijun
 * @Date 2020/3/17 上午10:16
 * @Version 1.0
 */

import java.io.*;

/**
 * 缓冲区：BufferedReader  BufferedWriter
 * 目的：是为了提高流的操作效率，所以创建之前，必须先有流对象
 * 缓冲区的关闭就已经关闭了流对象
 *
 * LineNumberReader:getLineNumb
 * */
public class BufferWriterTest {
    public static void main(String[] args) throws Exception {
        //bufferedWriterTest();
        //bufferedReaderTest();
        lineNumberReaderTest();
    }

    public static void bufferedWriterTest() throws IOException{
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/BufferedWriter.txt";
        FileWriter fw=new FileWriter(path);

        BufferedWriter bw=new BufferedWriter(fw);

        bw.write("Hello world \n hello my son");
        bw.newLine();
        bw.write("king");

        bw.flush();
        bw.close();
    }

    public static void bufferedReaderTest() throws Exception{
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/BufferedWriter.txt";
        FileReader fr=new FileReader(path);

        BufferedReader br=new BufferedReader(fr);
        String line=null;
        //br.readLine读一行,到结尾返回null
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
    }
    public static void lineNumberReaderTest() throws Exception{
        String path="demo/src/main/resources/ResourseForIOStudy/IOStudy/BufferedWriter.txt";
        FileReader fr=new FileReader(path);

        LineNumberReader ln=new LineNumberReader(fr);
        String line=null;
        //br.readLine读一行,到结尾返回null
        while ((line=ln.readLine())!=null){
            System.out.println(ln.getLineNumber()+":"+line);
        }
    }
}
