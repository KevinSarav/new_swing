import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ActionListener {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    public static final int NUMBER_OF_CHAR = 30;
    public String acctNum, firstName, lastName, balance, access,
            account = "AccountInformation.txt";

    private JTextField acct, pass;

    public static void main(String[] args) {
        Login gui = new Login();
        gui.setVisible(true);
    }

    public Login() {
        super("Text Field Demo");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2));

        JLabel acctNum = new JLabel("Account Number: ");
        add(acctNum);

        acct = new JTextField(NUMBER_OF_CHAR);
        add(acct);

        JLabel passw = new JLabel("Password: ");
        add(passw);

        pass = new JTextField(NUMBER_OF_CHAR);
        add(pass);

        JLabel request = new JLabel("Please press to log in.");
        add(request);

        JButton log = new JButton("Login");
        log.addActionListener(this);
        add(log);
    }

    public void actionPerformed(ActionEvent e){
        Scanner password = null;
        Scanner accessing = null;
        String accountNum, passWord, passFile = "Password.txt";
        String inputAcct = acct.getText();
        String inputPass = pass.getText();

        try{
            password = new Scanner(new FileInputStream(passFile));
            accessing = new Scanner(new FileInputStream(account));
        }
        catch(FileNotFoundException f){
            System.out.println("File not found.");
            System.exit(0);
        }

        accountNum = password.next();
        passWord = password.next();
        password.close();

        while(accessing.hasNextLine()){
            acctNum = accessing.nextLine();
            firstName = accessing.nextLine();
            lastName = accessing.nextLine();
            balance = accessing.nextLine();
            access = accessing.nextLine();
        }

        if(accountNum.equals(inputAcct) && passWord.equals(inputPass) && access.equals("Active")) {
            dispose();
            Menu gui = new Menu(2, 3);
            gui.setVisible(true);
        }

        password.close();
    }
}