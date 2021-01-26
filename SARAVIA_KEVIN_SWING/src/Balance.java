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

public class Balance extends JFrame implements ActionListener {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    public String acctNum, firstName, lastName, balance, access,
            acct = "AccountInformation.txt";
    private JTextField req;

    public static void main(String[] args){
        Balance gui = new Balance();
        gui.setVisible(true);
    }

    public Balance() {
        super();
        setSize(WIDTH, HEIGHT);
        setTitle("GridLayout Demonstration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        Scanner acctInfo = null;
        try{
            acctInfo = new Scanner(new FileInputStream("AccountInformation.txt"));
        }
        catch(FileNotFoundException f){
            System.out.println("File not found.");
            System.exit(0);
        }

        while(acctInfo.hasNext()) {
            acctNum = acctInfo.nextLine();
            firstName = acctInfo.nextLine();
            lastName = acctInfo.nextLine();
            balance = acctInfo.nextLine();
            access = acctInfo.nextLine();
        }
        acctInfo.close();

        JLabel bal = new JLabel("Your account number is: " + acctNum);
        add(bal);

        JLabel request = new JLabel("Your balance is: $" + balance);
        add(request);

        JButton enter = new JButton("Press to close.");
        enter.addActionListener(this);
        add(enter);
    }
    public void actionPerformed(ActionEvent e){
        dispose();
    }
}