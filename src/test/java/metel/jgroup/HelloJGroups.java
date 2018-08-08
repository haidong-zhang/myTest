package metel.jgroup;

 import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
 
 /**
  * JGroups ����
  *
  * @author hjj
  * @since //
  *
  */
 public class HelloJGroups extends ReceiverAdapter { // <-- ע������, HelloJGroups ������Ϣ�ķ�����������Ϣ�Ľ�����
     /** �û����� */
     private String _userName = null;
     /** JChannel */
     private JChannel _channel = null;
 
     /**
      * ��ʼ����
      *
      * @throws Exception
      *
      */
     private void start() throws Exception {
         // �����������û���, User.
         this._userName = "User." + (int)(Math.random() * 100);
 
         // ���� JChannel
         this._channel = new JChannel();
         this._channel.setReceiver(this);
         this._channel.connect("ChatCluster");
 
         // �¼�ѭ��
         this.eventLoop();
 
         // �¼�ѭ������֮��,
         // �ر� JChannel
         this._channel.close();
     }
 
     /**
      * �¼�ѭ��, ���ն˶�ȡ����
      *
      */
     private void eventLoop() {
         // ����������
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
         while (true) {
             try {
                 // �����ʾ��
                 System.out.print("~> ");
                 System.out.flush();
 
                 // ���ն˶�ȡ����
                 String ln = br.readLine();
 
                 if (ln.equalsIgnoreCase("quit") ||
                     ln.equalsIgnoreCase("exit")) {
                     // ���� quit / exit ʱ,
                     // �˳���ǰѭ��
                     break;
                 }
 
                 // ������������Ϣ,
                 // ��Ϣ������ "${userName} : ${ln}"
                 Message msg = new Message(null, null, this._userName + " : " + ln);
                 this._channel.send(msg);
             } catch (Exception ex) {
                 // ���������־
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
      * Ӧ�ó���������
      *
      * @param args
      * @throws Exception
      *
      */
     public static void main(String[] args) throws Exception {
         new HelloJGroups().start();
     }
 }
