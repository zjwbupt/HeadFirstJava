import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainGui {
    private JPanel panel1;
    private JTextField textField1;
    private JButton 点这里Button;
    private static String displayMessage;
    DailyAdviceClient DailyAdviceClient;

    public mainGui() {
        点这里Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DailyAdviceClient client = new DailyAdviceClient();
                client.go();
                displayMessage = client.getDisplayMessage();
                textField1.setText(displayMessage);
            }
        });
    }

    public static void main(String[] args) {


        JFrame frame = new JFrame("mainGui");
        frame.setTitle("爱杨莹~");
        frame.setContentPane(new mainGui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
