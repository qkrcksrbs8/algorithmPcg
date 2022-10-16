package cg.park.algorithmpcg.mytest;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class test5 extends JFrame {

    private JPanel contentPane;
    private JTextField tf;
    private JTextArea textArea;
    private JPanel panel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    test5 frame = new test5();
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
    public test5() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "\uC6B0\uD3B8\uBC88\uD638 \uCC3E\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        panel.setBounds(6, 21, 438, 46);
        contentPane.add(panel);
        panel.setLayout(null);

        tf = new JTextField();
        tf.setBounds(6, 18, 317, 21);
        panel.add(tf);
        tf.setColumns(10);

        JButton btn = new JButton("주소 검색");
        btn.setBounds(335, 17, 97, 23);
        panel.add(btn);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) throws IndexOutOfBoundsException{
                Workbook workbook = null;

                try {
                    workbook = Workbook.getWorkbook(new File("./zipcode_seoul_euckr_type2.xls"));
                    Sheet sheet = workbook.getSheet(0);
                    String add = tf.getText();

                    StringBuilder sb = new StringBuilder();
                    for(int i=0; i<sheet.getRows(); i++) {
//                        for(int i=0; i<100; i++) {
                        Cell dong = sheet.getCell(3,i);
                        if( dong.getContents().contains(add) ) {
                            for (int j = 0 ; j < 6; j++) {
                                sb.append(sheet.getCell(j,i).getContents() + " ");
                            }
                            sb.append("\n");
                        }
                    }
                    textArea.setText(sb.toString());
                } catch (BiffException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }finally {
                    if(workbook != null) workbook.close();
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 95, 430, 395);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
    }

}
