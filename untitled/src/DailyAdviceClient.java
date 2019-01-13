import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {
    String displayMessage;

    public void go(){
        try{
            Socket s = new Socket("104.243.20.178",4242);

            InputStreamReader streamReader = new InputStreamReader(s.getInputStream(),"UTF-8");
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            displayMessage = advice;

//          displayMessage = new String(advice.getBytes("UTF-8"));

            System.out.println("Today you should:" + advice);
            reader.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public String getDisplayMessage(){
        if(displayMessage != null){
            return displayMessage;
        }else{
            return "没有获取到服务器信息";
        }

    }

//    public static void main(String[] args){
//        DailyAdviceClient client = new DailyAdviceClient();
//        client.go();
//    }
}
