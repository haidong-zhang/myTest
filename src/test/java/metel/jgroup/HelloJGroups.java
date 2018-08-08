package metel.jgroup;

 import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
 
 /**
  * JGroups 测试
  *
  * @author hjj
  * @since //
  *
  */
 public class HelloJGroups extends ReceiverAdapter { // <-- 注意这里, HelloJGroups 即是消息的发送者又是消息的接收者
     /** 用户名称 */
     private String _userName = null;
     /** JChannel */
     private JChannel _channel = null;
 
     /**
      * 开始测试
      *
      * @throws Exception
      *
      */
     private void start() throws Exception {
         // 在这里生成用户名, User.
         this._userName = "User." + (int)(Math.random() * 100);
 
         // 创建 JChannel
         this._channel = new JChannel();
         this._channel.setReceiver(this);
         this._channel.connect("ChatCluster");
 
         // 事件循环
         this.eventLoop();
 
         // 事件循环结束之后,
         // 关闭 JChannel
         this._channel.close();
     }
 
     /**
      * 事件循环, 从终端读取文字
      *
      */
     private void eventLoop() {
         // 创建读入流
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
         while (true) {
             try {
                 // 输出提示符
                 System.out.print("~> ");
                 System.out.flush();
 
                 // 从终端读取文字
                 String ln = br.readLine();
 
                 if (ln.equalsIgnoreCase("quit") ||
                     ln.equalsIgnoreCase("exit")) {
                     // 遇到 quit / exit 时,
                     // 退出当前循环
                     break;
                 }
 
                 // 创建并发送消息,
                 // 消息内容是 "${userName} : ${ln}"
                 Message msg = new Message(null, null, this._userName + " : " + ln);
                 this._channel.send(msg);
             } catch (Exception ex) {
                 // 输出错误日志
                 ex.printStackTrace();
             }
         }
     }
 
     @Override
     public void viewAccepted(View v) {
         System.out.println("viewAccepted : " + v);
     }
 
     @Override
     public void receive(Message msg) {
         System.out.println(msg.getObject());
     }
 
     /**
      * 应用程序主函数
      *
      * @param args
      * @throws Exception
      *
      */
     public static void main(String[] args) throws Exception {
         new HelloJGroups().start();
     }
 }
