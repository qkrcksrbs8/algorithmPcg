package cg.park.algorithmpcg.mytest.ugkim;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginUI extends JFrame  {

    private JPanel contentPane;
    private JTextField textField;
    private JButton btn2;
    private JButton btnNewButton;
    private JPanel panel;
    private JPasswordField passwordField;
    private Connection conn;
    LoginUI2 UI2 =new LoginUI2();
    static LoginUI frame = new LoginUI();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
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
    public LoginUI() {
        setTitle("StudioWe");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 597, 322);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uACF5\uAC04\uB300\uC5EC WeStudio", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(6, 10, 563, 263);
        contentPane.add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(157, 70, 178, 21);
        panel.add(textField);
        textField.setColumns(10);



        JButton btn1 = new JButton("로그인");
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String idstr = textField.getText();
                String pwstr = passwordField.getText();
                LoginUI2 UI2 =new LoginUI2();


                if(idstr.length() >= 2 && pwstr.length()>=2) {
                    PreparedStatement pstmt =null;
                    ResultSet rs=null;

                    ArrayList<StudioRentDAO> lists = new ArrayList<>();

                    String sql = "select id, password from account where id = ?";
                    Connection conn = null;
                    String connurl ="jdbc:mysql://localhost:3306/project";
                    String connuser ="project" ;
                    String connpassword ="!123456";
                    try {
                        Class.forName("org.mariadb.jdbc.Driver");
                        conn = DriverManager.getConnection(connurl, connuser, connpassword);
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, idstr);

                        rs = pstmt.executeQuery();
                        System.out.println(rs.getRow());
                        while(rs.next()) {
                            String id = rs.getString("id");
                            String password = rs.getString("password");
                            System.out.println(id);
                            System.out.println(password);
                            if(pwstr.equals(password));{
                                UI2.setVisible(true);
                                UI2.setDefaultCloseOperation(LoginUI2.DISPOSE_ON_CLOSE);
                                frame.setVisible(false);
                            }

                        }
                        if (!rs.next()) {
                            System.out.println("계정 정보가 일치하지 않습니다.");
                        }

                    } catch (SQLException e0) {
                        // TODO Auto-generated catch block
                        e0.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    } finally {
                        if(rs != null) try {rs.close();} catch (SQLException e1) {}
                        if(pstmt != null) try {pstmt.close();} catch (SQLException e2) {}
                        if(conn != null) try {conn.close();} catch (SQLException e3) {}
                    }


//                    UI2.setVisible(true);
//                    UI2.setDefaultCloseOperation(LoginUI2.DISPOSE_ON_CLOSE);
//                    frame.setVisible(false);

                }
            }

        });
        btn1.setBounds(364, 108, 97, 23);
        panel.add(btn1);

        JLabel lblNewLabel = new JLabel("아이디");
        lblNewLabel.setBounds(109, 73, 57, 15);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("비밀번호");
        lblNewLabel_1.setBounds(97, 112, 57, 15);
        panel.add(lblNewLabel_1);

        btn2 = new JButton("회원가입");
        btn2.setBounds(140, 173, 97, 23);
        panel.add(btn2);

        btnNewButton = new JButton("문의하기");
        btnNewButton.setBounds(249, 173, 97, 23);
        panel.add(btnNewButton);

        passwordField = new JPasswordField();
        passwordField.setBounds(157, 109, 178, 21);
        panel.add(passwordField);
    }
}