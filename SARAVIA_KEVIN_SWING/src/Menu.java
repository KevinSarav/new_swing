import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;

    public static void main(String[] args){
        Menu gui = new Menu(2, 3);
        gui.setVisible(true);
    }

    public Menu(int rows, int columns) {
        super();
        setSize(WIDTH, HEIGHT);
        setTitle("GridLayout Demonstration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(rows, columns));

        JButton depButt = new JButton("Deposit");
        depButt.addActionListener(this);
        add(depButt);

        JButton withButt = new JButton("Withdraw");
        withButt.addActionListener(this);
        add(withButt);

        JButton balButt = new JButton("Check Balance");
        balButt.addActionListener(this);
        add(balButt);

        JButton transButt = new JButton("Make a Transfer");
        transButt.addActionListener(this);
        add(transButt);

        JButton passButt = new JButton("Change Password");
        passButt.addActionListener(this);
        add(passButt);

        JButton logButt = new JButton("Logout");
        logButt.addActionListener(this);
        add(logButt);
    }

    public void actionPerformed(ActionEvent e){
        String choice = e.getActionCommand();

        switch(choice) {
            case "Deposit":
                Deposit dep = new Deposit();
                dep.setVisible(true);
                break;
            case "Withdraw":
                Withdraw with = new Withdraw();
                with.setVisible(true);
                break;
            case "Check Balance":
                Balance bal = new Balance();
                bal.setVisible(true);
                break;
            case "Make a Transfer":
                Transfer trans = new Transfer();
                trans.setVisible(true);
                break;
            case "Change Password":
                Password pass = new Password();
                pass.setVisible(true);
                break;
            case "Logout":
                dispose();
                Login GUI = new Login();
                GUI.setVisible(true);
                break;
        }
    }
}
