import java.io.*;
import java.net.*;
/**
 * Created by xumingjie on 15/9/24.
 */
public class MyWebServer
{
    public static void main(String []args) throws Exception{
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("在9999上等待连接....");
        Socket s = ss.accept();
        OutputStream os = s.getOutputStream();
        BufferedReader br = new BufferedReader(new FileReader("./HelloWorld.html"));
        String buf = "";
        while((buf = br.readLine()) != null){
            System.out.println(buf);
            os.write(buf.getBytes());
        }
        br.close();
        os.close();
        s.close();
    }
}