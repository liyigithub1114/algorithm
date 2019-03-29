package com.liyi.algorithm.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 为GFS(Google文件系统)实现一个简单的客户端，提供一下功能：
 * 1.read(文件名)，通过文件名从GFS中读取文件。
 * 2.write(文件名，内容)，通过文件名和内容写入GFS中。
 * 现在有两种已经在基础类中实现的方法：
 * 1.readChunk(文件名，块索引)，从GFS中读取一个块。
 * 2.writeChunk(文件名，块索引，块数据)，向GFS中写入一个块。
 * 为了简化这个问题，我们可以假设块大小为 chunkSize 位的(在真实的文件系统中，是64M)，GFS客户端的任务是将一个文件分为若干块(如果需要的话)并且保存在远端的GFS服务器上，chunkSize会在构造函数中给出，你需要的是实现读和写这两个private方法。
 *
 */

/**
 * GFSClient(5)
 * read("a.txt")
 * >> null
 * write("a.txt", "World")
 * >> You don't need to return anything, but you need to call writeChunk("a.txt", 0, "World") to write a 5 bytes chunk to GFS.
 * read("a.txt")
 * >> "World"
 * write("b.txt", "111112222233")
 * >> You need to save "11111" at chink 0, "22222" at chunk 1, "33" at chunk 2.
 * write("b.txt", "aaaaabbbbb")
 * read("b.txt")
 * >> "aaaaabbbbb"
 */
public class GFSClient extends  BaseGFSClient{
    private Integer chunkSize;
    //定义某个文件存于某个索引
    private Map<String,Integer> map = new HashMap<>();

    public GFSClient(Integer chunkSize){
        this.chunkSize = chunkSize;
        this.map = new HashMap<>();
    }

    public String read(String fileName){
        if(map.containsKey(fileName)){
            Integer integer = map.get(fileName);
            StringBuffer sb = new StringBuffer();
            for(int i =0;i<integer;i++){
                sb.append(readChunk(fileName,i));
            }
            return sb.toString();
        }
        return null;
    }

    public void write(String fileName,String content){
        int len = content.length();
        int num = (len - 1) / chunkSize + 1;
        //将fileName 文件分成了num断,读取的时候可通过num找出chunk上对应的断
        map.put(fileName,num);
        for(int i=0;i<num;i++){
            int start = i * chunkSize;//比如 索引0  开始是0， 到(i+1) * chunSize结束
            int end = i == num - 1 ? len : (i+1) * chunkSize;
            writeChunk(fileName,i,content.substring(start,end));
        }

    }
}



//Definition of BaseGFSClient
class BaseGFSClient {
    private Map<String, String> chunk_list;
    public BaseGFSClient() {}

    public String readChunk(String filename, int chunkIndex) {
        // Read a chunk from GFS
        return "";
    }
    public void writeChunk(String filename, int chunkIndex,
                           String content) {
        // Write a chunk to GFS
    }
}
