import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

class Login{
    String userName;
    String userPhoneNumber;
    String userBalance;
    String userPassword;

    Login(){
        JFrame frame1 = new JFrame("Login Panel");
        frame1.setSize(500, 500);
        frame1.setDefaultCloseOperation(frame1.EXIT_ON_CLOSE);
        frame1.setVisible(true);
        frame1.setResizable(true);

        JPanel panel1 = new JPanel(null);
        frame1.add(panel1);

        JLabel phoneNumber = new JLabel("Phone Number");
        phoneNumber.setBounds(100, 150, 200, 20);
        panel1.add(phoneNumber);

        JTextField phone = new JTextField();
        phone.setBounds(200, 150, 200, 20);
        phone.setVisible(true);
        panel1.add(phone);


        JLabel password = new JLabel("Password");
        password.setBounds(100, 200, 200, 20);
        panel1.add(password);

        JPasswordField pass = new JPasswordField();
        pass.setBounds(200, 200, 200, 20);
        pass.setVisible(true);
        panel1.add(pass);

        JButton login = new JButton("Login");
        login.setBounds(200, 250, 100, 20);
        login.setVisible(true);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    File f = new File("src/Users.txt");
                    Scanner sc = new Scanner(f);
                    while(sc.hasNext()){
                        userPhoneNumber = sc.next();
                        userPassword = sc.next();
                        userName = sc.next();
                        userBalance = sc.next();

//                        name = userName;
//                        phoneNumb = userPhoneNumber;
//                        balance = userBalance;
//                        pas = userPassword;
                        //sc.close();
                        if((userPhoneNumber.equals(phone.getText())) && userPassword.equals(pass.getText())){
                            //System.out.println("From Login: "+name+" "+phoneNumb);
                            Dashboard d1 = new Dashboard(userName, userPhoneNumber, userBalance, userPassword);
                            frame1.setVisible(false);
                            break;
                        }

                    }
                }catch (Exception ex){
                    ex.getMessage();
                }




            }

        });
        panel1.add(login);
    }

}

class Dashboard{

    String username;
    String userPhoneNumb;
    String userBalance;
    String userPas;


    Dashboard(String username, String userPhoneNumb, String userBalance, String userPas){
        this.username = username;
        this.userPhoneNumb = userPhoneNumb;
        this.userBalance = userBalance;
        this.userPas = userPas;
        //System.out.println("from Dashboard: "+name+" "+phoneNumb+" ");

        JFrame frame2 = new JFrame("Dashboard");
        frame2.setSize(500, 500);
        frame2.setDefaultCloseOperation(frame2.EXIT_ON_CLOSE);
        frame2.setVisible(true);


        JPanel panel2 = new JPanel(null);
        frame2.add(panel2);

        JLabel welcome = new JLabel("Welcome " +username);
        welcome.setBounds(200, 100, 100, 50);
        welcome.setVisible(true);
        panel2.add(welcome);

        JLabel phone = new JLabel("Phone Number: " +userPhoneNumb);
        phone.setBounds(150, 200, 500, 50);
        phone.setVisible(true);
        panel2.add(phone);

        JLabel amount= new JLabel("Amount: " +userBalance);
        amount.setBounds(150, 250, 1000, 50);
        amount.setVisible(true);
        panel2.add(amount);


        JButton cashOut = new JButton("Cash out");
        cashOut.setBounds(100, 350, 100, 30);
        cashOut.setVisible(true);
        cashOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashOut c1 = new CashOut(username, userPhoneNumb, userBalance, userPas);
                frame2.setVisible(false);
            }
        });
        panel2.add(cashOut);


        JButton recharge = new JButton("Recharge");
        recharge.setBounds(300, 350, 100, 30);
        recharge.setVisible(true);
        recharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashOut c2 = new CashOut(username, userPhoneNumb, userBalance, userPas);
                frame2.setVisible(false);
            }
        });
        panel2.add(recharge);

    }
}

class CashOut {
    String username;
    String userPhoneNumb;
    String userBalance;
    String userPas;
    CashOut(String username, String userPhoneNumb, String userBalance, String userPas) {

        this.username = username;
        this.userPhoneNumb = userPhoneNumb;
        this.userBalance = userBalance;
        this.userPas = userPas;

        JFrame frame3 = new JFrame("Dashboard");
        frame3.setSize(500, 500);
        frame3.setDefaultCloseOperation(frame3.EXIT_ON_CLOSE);
        frame3.setVisible(true);

        JPanel panel3 = new JPanel(null);
        frame3.add(panel3);

        JLabel yPhone = new JLabel("Phone Number ");
        yPhone.setBounds(100, 100, 200, 20);
        panel3.add(yPhone);

        JTextField phone = new JTextField();
        phone.setBounds(200, 100, 200, 20);
        phone.setVisible(true);
        panel3.add(phone);

        JLabel yAmount = new JLabel("Amount ");
        yAmount.setBounds(100, 150, 200, 20);
        panel3.add(yAmount);

        JTextField amount = new JTextField();
        amount.setBounds(200, 150, 200, 20);
        amount.setVisible(true);
        panel3.add(amount);

        JLabel yPass = new JLabel("Password ");
        yPass.setBounds(100, 200, 200, 20);
        panel3.add(yPass);

        JPasswordField password = new JPasswordField();
        password.setBounds(200, 200, 200, 20);
        password.setVisible(true);
        panel3.add(password);


        JCheckBox sure = new JCheckBox();
        sure.setBounds(200, 295, 30, 30);
        sure.setVisible(true);
        panel3.add(sure);

        JLabel are = new JLabel("Are you sure ?");
        are.setBounds(230, 300, 200, 20);
        panel3.add(are);

        JButton done = new JButton("Done");
        done.setBounds(200, 350, 100, 30);
        done.setVisible(true);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(sure.isSelected()){
                    if((userPhoneNumb.equals(phone.getText())) && (userPas.equals(password.getText()))) {
                        int reduce = Integer.parseInt(userBalance) - Integer.parseInt(amount.getText());
                        try {
                            FileWriter wr = new FileWriter("src/Users.txt");
                            BufferedWriter bf = new BufferedWriter(wr);
                            bf.write(userPhoneNumb+" "+userPas+" "+username+" "+reduce);
                            bf.newLine();
                            bf.close();

                        }
                        catch(Exception exp){
                            exp.printStackTrace();
                        }
                        Dashboard d1 = new Dashboard(username, userPhoneNumb, reduce+"", userPas);
                        frame3.setVisible(false);
                    }
                }
            }
        });
        panel3.add(done);

    }
}


public class MobileBanking{
    public static void main(String[] args) {
        Login l1= new Login();
    }
}
