package cg.park.algorithmpcg.mytest.ugkim;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI2 extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginUI2 frame = new LoginUI2();
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
    public LoginUI2() {
        setTitle("StudioWE");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 394, 280);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btn1 = new JButton("예약하기");
        btn1.setBounds(124, 32, 97, 23);
        contentPane.add(btn1);

        JButton btn2 = new JButton("예약조회");
        btn2.setBounds(124, 78, 97, 23);
        contentPane.add(btn2);

        JButton btn3 = new JButton("문의하기");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btn3.setBounds(124, 122, 97, 23);
        contentPane.add(btn3);

        JButton btn4 = new JButton("로그아웃");
        btn4.setBounds(124, 165, 97, 23);
        contentPane.add(btn4);
    }
}