import java.io.*;
import java.net.*;
/**
 * Created by xumingjie on 15/9/24.
 */
public class MyRequest
{
    public static void main(String []args) throws Exception{
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("在9999上等待连接....");
        Socket s = ss.accept();
        InputStream is = s.getInputStream();
        int ch = 0;
        StringBuffer str = new StringBuffer("");
        while((ch = is.read()) != -1){
            str.append((char)ch);
        }
        System.out.println(str);
        is.close();
        s.close();
    }
}