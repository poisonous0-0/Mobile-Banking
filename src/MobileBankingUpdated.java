import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Users{
    String phoneNumber;
    String password;
    String name;
    String balance;

    public Users(String phoneNumber, String password, String name, String balance) {
        this.phoneNumber= phoneNumber;
        this.password = password;
        this.name = name;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return phoneNumber+" "+password+" "+name+" "+balance;
    }
}

class Login{
    String userPhoneNumber;
    String userPassword;
    String userName;
    String userBalance;

    Login(){
        JFrame loginFrame = new JFrame("Login Panel");
        loginFrame.setSize(500, 500);
        loginFrame.setDefaultCloseOperation(loginFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
        loginFrame.setResizable(true);

        JPanel loginPanel = new JPanel(null);
        loginFrame.add(loginPanel);

        JLabel phoneNumberLabel = new JLabel("Phone Number");
        phoneNumberLabel.setBounds(100, 150, 200, 20);
        loginPanel.add(phoneNumberLabel);

        JTextField phoneNumberField = new JTextField();
        phoneNumberField.setBounds(200, 150, 200, 20);
        phoneNumberField.setVisible(true);
        loginPanel.add(phoneNumberField);


        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(100, 200, 200, 20);
        loginPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 200, 200, 20);
        passwordField.setVisible(true);
        loginPanel.add(passwordField);

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

                        if((userPhoneNumber.equals(phoneNumberField.getText())) && userPassword.equals(passwordField.getText())){
                            Dashboard d1 = new Dashboard(userPhoneNumber, userPassword, userName, userBalance);
                            loginFrame.setVisible(false);
                            break;
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        loginPanel.add(login);
    }
}

class Dashboard{

    String userPhoneNumber;
    String userPassword;
    String username;
    String userBalance;


    Dashboard(String userPhoneNumber, String userPassword, String username, String userBalance){
        this.userPhoneNumber = userPhoneNumber;
        this.userPassword = userPassword;
        this.username = username;
        this.userBalance = userBalance;
        //System.out.println("from Dashboard: "+name+" "+phoneNumb+" ");

        JFrame DashBoardFrame = new JFrame("Dashboard");
        DashBoardFrame.setSize(500, 500);
        DashBoardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DashBoardFrame.setVisible(true);


        JPanel DashBoardPanel = new JPanel(null);
        DashBoardFrame.add(DashBoardPanel);

        JLabel welcomeLabel = new JLabel("Welcome " +username);
        welcomeLabel.setBounds(200, 100, 100, 50);
        welcomeLabel.setVisible(true);
        DashBoardPanel.add(welcomeLabel);

        JLabel phoneNumberLabel = new JLabel("Phone Number: " +userPhoneNumber);
        phoneNumberLabel.setBounds(150, 200, 500, 50);
        phoneNumberLabel.setVisible(true);
        DashBoardPanel.add(phoneNumberLabel);

        JLabel amountLabel= new JLabel("Amount: " +userBalance);
        amountLabel.setBounds(150, 250, 1000, 50);
        amountLabel.setVisible(true);
        DashBoardPanel.add(amountLabel);

        JButton cashOut = new JButton("Cash out");
        cashOut.setBounds(100, 350, 100, 30);
        cashOut.setVisible(true);
        cashOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CashOut c1 = new CashOut(userPhoneNumber, userPassword, username, userBalance);
                DashBoardFrame.setVisible(false);
            }
        });
        DashBoardPanel.add(cashOut);

        JButton recharge = new JButton("Recharge");
        recharge.setBounds(300, 350, 100, 30);
        recharge.setVisible(true);
        recharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Recharge c2 = new Recharge(userPhoneNumber, userPassword, username, userBalance);
                DashBoardFrame.setVisible(false);
            }
        });
        DashBoardPanel.add(recharge);

    }
}

class CashOut {
    String userPhoneNumb;
    String userPas;
    String username;
    String userBalance;
    CashOut(String userPhoneNumb, String userPas, String username, String userBalance) {
        this.userPhoneNumb = userPhoneNumb;
        this.userPas = userPas;
        this.username = username;
        this.userBalance = userBalance;

        JFrame frame3 = new JFrame("Cashout");
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
                        ArrayList<String> listOfLines = new ArrayList<>();

                        try{
                            BufferedReader br = new BufferedReader(new FileReader("src/Users.txt"));
                            String line = br.readLine() ;
                            while (line != null){
                                String temp = line.trim();
                                listOfLines.add(temp);
                                line = br.readLine();
                            }
                            br.close();
                        }catch(Exception exception){
                            exception.printStackTrace();
                        }

                        for(int i=0; i< listOfLines.size(); i++){
                            System.out.println(listOfLines.get(i));
                        }

                        for(int i=0; i< listOfLines.size(); i++){
                            System.out.println(listOfLines.get(i));
                        }

                        try{
                            FileWriter fw = new FileWriter("src/Users.txt", false);
                            PrintWriter pw = new PrintWriter(fw, false);
                            pw.flush();
                            pw.close();
                            fw.close();
                        }catch(Exception exp){exp.printStackTrace();}

                        try{
                            FileWriter wr = new FileWriter("src/Users.txt", true);
                            BufferedWriter pw = new BufferedWriter(wr);
                            pw.write(userPhoneNumb+" "+userPas+" "+username+" "+reduce);

                            for (int i=0; i< listOfLines.size(); i++){
                                pw.newLine();
                                pw.write(listOfLines.get(i));

                            }
                            pw.close();
                            wr.close();

                        }catch (Exception exp){
                            exp.printStackTrace();
                        }
                        Dashboard d1 = new Dashboard(userPhoneNumb, userPas, username, reduce+"");
                        frame3.setVisible(false);
                    }
                }
            }
        });
        panel3.add(done);

    }
}

class Recharge {
    String userPhoneNumb;
    String userPas;
    String username;
    String userBalance;
    Recharge(String userPhoneNumb, String userPas, String username, String userBalance) {
        this.userPhoneNumb = userPhoneNumb;
        this.userPas = userPas;
        this.username = username;
        this.userBalance = userBalance;

        JFrame frame3 = new JFrame("Recharge");
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
                        int reduce = Integer.parseInt(userBalance) + Integer.parseInt(amount.getText());
                        ArrayList<String> listOfLines = new ArrayList<>();

                        try{
                            BufferedReader br = new BufferedReader(new FileReader("src/Users.txt"));
                            String line = br.readLine() ;
                            while (line != null){
                                String temp = line.trim();
                                listOfLines.add(temp);
                                line = br.readLine();
                            }
                            br.close();
                        }catch(Exception exception){
                            exception.printStackTrace();
                        }

                        for(int i=0; i< listOfLines.size(); i++){
                            System.out.println(listOfLines.get(i));
                        }

                        for(int i=0; i< listOfLines.size(); i++){
                            System.out.println(listOfLines.get(i));
                        }

                        try{
                            FileWriter fw = new FileWriter("src/Users.txt", false);
                            PrintWriter pw = new PrintWriter(fw, false);
                            pw.flush();
                            pw.close();
                            fw.close();
                        }catch(Exception exp){exp.printStackTrace();}

                        try{
                            FileWriter wr = new FileWriter("src/Users.txt", true);
                            BufferedWriter pw = new BufferedWriter(wr);
                            pw.write(userPhoneNumb+" "+userPas+" "+username+" "+reduce);

                            for (int i=0; i< listOfLines.size(); i++){
                                pw.newLine();
                                pw.write(listOfLines.get(i));

                            }
                            pw.close();
                            wr.close();

                        }catch (Exception exp){
                            exp.printStackTrace();
                        }
                        Dashboard d1 = new Dashboard(userPhoneNumb, userPas, username, reduce+"");
                        frame3.setVisible(false);
                    }
                }
            }
        });
        panel3.add(done);

    }
}

public class MobileBankingUpdated {
    public static void main(String[] args) {
        Login l1 = new Login();
    }
}
