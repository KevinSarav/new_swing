import java.io.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    public static final int NUMBER_OF_CHAR = 30;
    public String acctNum, firstName, lastName, access,
            acct = "AccountInformation.txt";
    public int balance;
    private JTextField req;

    public static void main(String[] args){
        Deposit gui = new Deposit();
        gui.setVisible(true);
    }

    public Deposit() {
        super();
        setSize(WIDTH, HEIGHT);
        setTitle("GridLayout Demonstration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        Scanner acctInfo = null;
        try{
            acctInfo = new Scanner(new FileInputStream(acct));
        }
        catch(FileNotFoundException f){
            System.out.println("File not found.");
            System.exit(0);
        }

        while(acctInfo.hasNext()) {
            acctNum = acctInfo.nextLine();
            firstName = acctInfo.nextLine();
            lastName = acctInfo.nextLine();
            balance = Integer.parseInt(acctInfo.nextLine());
            access = acctInfo.nextLine();
        }
        acctInfo.close();

        JLabel bal = new JLabel("Your account number is: " + acctNum);
        add(bal);

        JLabel bala = new JLabel("Your balance is: $" + balance);
        add(bala);

        JLabel request = new JLabel("Please enter amount to deposit: ");
        add(request);

        req = new JTextField(NUMBER_OF_CHAR);
        add(req);

        JLabel entering = new JLabel("Please press to confirm.");
        add(entering);

        JButton enter = new JButton("Confirm");
        enter.addActionListener(this);
        add(enter);
    }

    public void actionPerformed(ActionEvent e){
        int typed = Integer.parseInt(req.getText());
        balance += typed;

        PrintWriter acctWrite = null;
        try{
            acctWrite = new PrintWriter(new FileOutputStream(acct));
        }
        catch(FileNotFoundException f){
            System.out.println("File not found.");
            System.exit(0);
        }

        acctWrite.println(acctNum);
        acctWrite.println(firstName);
        acctWrite.println(lastName);
        acctWrite.println("" + balance);
        acctWrite.print(access);

        acctWrite.close();
        dispose();
    }
}