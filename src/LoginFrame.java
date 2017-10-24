import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{
    //project Bound set
    private int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int frmW = 300,frmH = 150;
    //object set
    private Container cp ;
    private JButton jbtnExit = new JButton("Exit");
    private JButton jbtnLogin = new JButton("Login");
    private JTextField jtx = new JTextField();
    private JPasswordField jPW = new JPasswordField();
    private JLabel jlabID = new JLabel("ID :");
    private JLabel jlabPW = new JLabel("Password :");
    //ID & Password
    private String ID = "h304";
    private String Password = "23323456";
    public LoginFrame(){
        init();
    }
    private void init(){
        this.setBounds(screenW/2-frmW/2,screenH/2-frmH/2,frmW,frmH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(3,2,1,1));
        jlabID.setHorizontalAlignment(SwingConstants.RIGHT);
        jlabPW.setHorizontalAlignment(SwingConstants.RIGHT);
        cp.add(jlabID);
        cp.add(jtx);
        cp.add(jlabPW);
        cp.add(jPW);
        cp.add(jbtnExit);
        cp.add(jbtnLogin);

        //control
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jbtnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtx.getText().equals(ID) && (new String(jPW.getPassword())).equals(Password)){
                        MainFrame mf = new MainFrame(LoginFrame.this);
                        mf.setVisible(true);
                        LoginFrame.this.setVisible(false);
                        jtx.setText("");
                        jPW.setText("");
                }else{
                    if(!jtx.getText().equals(ID)){
                        JOptionPane.showMessageDialog(LoginFrame.this,"your ID is wrong");
                    }else if(!(new String(jPW.getPassword())).equals(Password)){
                        JOptionPane.showMessageDialog(LoginFrame.this,"your Password is wrong");
                    }
                }
            }
        });

    }
}
