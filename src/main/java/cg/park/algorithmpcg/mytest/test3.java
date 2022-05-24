package cg.park.algorithmpcg.mytest;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class test3 extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField2;
    private JPanel panel;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    test3 frame = new test3();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public test3() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uAD6C\uAD6C\uB2E8\uCD9C\uB825", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(0, 21, 580, 354);
        contentPane.add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(6, 18, 116, 21);
        panel.add(textField);
        textField.setColumns(10);

        textField2 = new JTextField();
        textField2.setBounds(167, 18, 116, 21);
        panel.add(textField2);
        textField2.setColumns(10);


        JButton btn = new JButton("구구단 출력");
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea.setText(" ");
                String firdan = textField.getText();
                String secdan = textField2.getText();   //찬ㄱ뉴질문 문법 파스인트 바로 못 받나 ?

                int ifirdan = Integer.parseInt(firdan);
                int isecdan = Integer.parseInt(secdan);

//            String result="";
                for(int i=ifirdan ; i<= isecdan ; i++ ) {

                    String result="";
                    for(int j= 1; j <=9 ;j ++) {
                        result += i + "X" + j + "=" + (i*j) + "\t";
                    }
//               result +="\n";
                    textArea.append(result + "\n" );
                }

                //overwirtting
//            textArea.setText(result);
            }
        });
        btn.setBounds(295, 17, 97, 23);
        panel.add(btn);

        scrollPane =new JScrollPane();
        scrollPane.setBounds(6, 49, 562, 295);
        panel.add(scrollPane);

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
    }

}