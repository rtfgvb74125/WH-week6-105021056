

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    //project bounds set
    private int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 900,frmH = 600;
    //object set
    private LoginFrame lgfm;
    private JTextField jtx = new JTextField();
    private JButton jbtnClose = new JButton("Close");
    private JButton jbtnRemake = new JButton("Return");
    private JButton jbtnClear = new JButton("Clear");
    private JButton jbtn[] = new JButton[10];
    private JMenuBar jmb = new JMenuBar();
    private JMenu jmF = new JMenu("File");
    private JMenu jmSet = new JMenu("Set");
    private JMenu jmGame = new JMenu("Game");
    private JMenu jmAbout = new JMenu("About");
    private JMenuItem jmiExit = new JMenuItem("Exit");
    private JMenuItem jmiLotto = new JMenuItem("Lotto");
    private JDesktopPane jdk = new JDesktopPane();
    private JInternalFrame jif = new JInternalFrame();//子視窗
    private JPanel jpnNum = new JPanel(new GridLayout(3,4,3,3));
    private int data[] = new int[10];
    private Random ran = new Random(System.currentTimeMillis());
    public MainFrame(LoginFrame lg){
        lgfm = lg;
        init();
    }
    private void init(){
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                lgfm.setVisible(true);
                dispose();
            }
        });
        Number();
        jif.setBounds(0,0,600,400);
        this.setJMenuBar(jmb);
        this.setContentPane(jdk);
        jif.setLayout(new BorderLayout(3,3));
        jif.add(jpnNum,BorderLayout.CENTER);
        jif.add(jtx,BorderLayout.NORTH);
        jif.add(jbtnClear,BorderLayout.SOUTH);
        jmb.add(jmF);
        jmb.add(jmSet);
        jmb.add(jmGame);
        jmb.add(jmAbout);
        jmF.add(jmiExit);
        jmGame.add(jmiLotto);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke('C',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jmiLotto.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        jtx.setEditable(false);
        for(int i = 0;i<10;i++){
            jbtn[i] = new JButton();
            jbtn[i].setBackground(new Color(40,143,255));
            jbtn[i].setText(Integer.toString(data[i]));
            jbtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmp = (JButton) e.getSource();
                    jtx.setText(jtx.getText() + tmp.getText());
                }
            });
            jpnNum.add(jbtn[i]);
        }
        jpnNum.add(jbtnRemake);
        jpnNum.add(jbtnClose);

        jmiExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lgfm.setVisible(true);
                dispose();
            }
        });
        jmiLotto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdk.add(jif);
                jif.setVisible(true);
            }
        });
        jbtnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jif.setVisible(false);
            }
        });
        jbtnRemake.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Number();
                for(int i = 0;i<10;i++){
                    jbtn[i].setText(Integer.toString(data[i]));
                }
            }
        });
        jbtnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtx.setText("");
            }
        });
    }
    private void Number(){
        for(int i = 0;i<10;i++){
            data[i] = ran.nextInt(10);
            for(int j = 0;j<i;j++){
                if(data[i]==data[j]){
                    i--;
                    break;
                }
            }
        }
    }
}
