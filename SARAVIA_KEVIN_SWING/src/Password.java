import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Password extends JFrame implements ActionListener {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    public static final int NUMBER_OF_CHAR = 30;
    String user, password, passWord = "Password.txt";
    private JTextField req;

    public static void main(String[] args){
        Password gui = new Password();
        gui.setVisible(true);
    }

    public Password() {
        super();
        setSize(WIDTH, HEIGHT);
        setTitle("GridLayout Demonstration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        Scanner passW = null;

        try{
            passW = new Scanner(new FileInputStream(passWord));
        }
        catch(FileNotFoundException f){
            System.out.println("File not found.");
            System.exit(0);
        }

        while(passW.hasNext()){
            user = passW.next();
            password = passW.next();
        }
        passW.close();

        JLabel bal = new JLabel("Your current password is: ");
        add(bal);

        JLabel bala = new JLabel(password);
        add(bala);

        JLabel request = new JLabel("Please enter new password: ");
        add(request);

        req = new JTextField(NUMBER_OF_CHAR);
        req.addActionListener(this);
        add(req);

        JLabel confirm = new JLabel("Please press to confirm.");
        add(confirm);

        JButton conf = new JButton("Confirm");
        conf.addActionListener(this);
        add(conf);
    }

    public void actionPerformed(ActionEvent e){
        String typed = req.getText();
        password = typed;

        PrintWriter acctWrite = null;
        try{
            acctWrite = new PrintWriter(new FileOutputStream(passWord));
        }
        catch(FileNotFoundException f){
            System.out.println("File not found.");
            System.exit(0);
        }

        acctWrite.println(user);
        acctWrite.print(password);

        acctWrite.close();
        dispose();
    }
}
