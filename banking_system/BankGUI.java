package banking_system;

import java.awt.Font;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankGUI extends JFrame {
    public static void main(String[] args) {
        new BankGUI().setVisible(true);
    }

    // initialize GUI frame
    public BankGUI() {
        super("Bank GUI");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        addGUIComponents();
    }

    // add components
    private void addGUIComponents() {
        Bank TokyoChuo = new Bank(); // bank object we will use for the duration of the program
        BankAccount[] HanzawaSan = new BankAccount[1]; // placeholder for logged-in user

        // title
        JLabel bankTitle = new JLabel("Bank GUI");
        bankTitle.setBounds(15, 15, 167, 40);
        bankTitle.setFont(new Font("Baskerville", Font.PLAIN, 32));
        add(bankTitle);

        // text field
        JTextField textField = new JTextField();
        textField.setBounds(15, 55, 320, 36);
        textField.setFont(new Font("Dialog", Font.PLAIN, 16));
        add(textField);

        // program output
        JLabel programOutput = new JLabel("Please enter a value");
        programOutput.setBounds(15, 100, 320, 20);
        programOutput.setFont(new Font("Baskerville", Font.PLAIN, 16));
        programOutput.setForeground(Color.decode("#1770e8"));
        add(programOutput);

        // login button
        JButton loginButton = new JButton("Login");
        loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginButton.setBounds(15, 130, 152, 50);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent error) {
                String userInput = textField.getText();
                textField.setText("");

                // validate input - remove whitespace to ensure non-empty text
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                    return;
                }

                try {
                    int PIN = Integer.parseInt(userInput);
                    BankAccount[] accountList = TokyoChuo.getAccountList();

                    for (int i = 0; i < accountList.length; i++) {
                        BankAccount currentAccount = accountList[i];
                        if (currentAccount.login(PIN)) {
                            HanzawaSan[0] = currentAccount;
                            programOutput.setText("Successfully logged in!");
                        }
                    }

                    if (HanzawaSan[0] == null) {
                        programOutput.setText("ERROR: Incorrect PIN");
                    }
                } catch (NumberFormatException e) {
                    programOutput.setText("ERROR: Value provided is not a PIN");
                }
            }
        });
        add(loginButton);

        // newAccount button
        JButton newAccountButton = new JButton("New Account");
        newAccountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        newAccountButton.setBounds(182, 130, 152, 50);
        newAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent error) {
                String userInput = textField.getText();
                textField.setText("");

                // validate input - remove whitespace to ensure non-empty text
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                    return;
                }

                try {
                    int PIN = Integer.parseInt(userInput);

                    BankAccount account = new BankAccount(PIN);
                    TokyoChuo.newAccount(account);
                    account.login(PIN); // log the user into the newly made account
                    HanzawaSan[0] = account;
                    programOutput.setText("Account successfully created!");
                } catch (NumberFormatException e) {
                    programOutput.setText("ERROR: Invalid PIN");
                }
            }
        });
        add(newAccountButton);

        // deposit button
        JButton depositButton = new JButton("Deposit");
        depositButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        depositButton.setBounds(15, 195, 152, 50);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent error) {
                String userInput = textField.getText();
                textField.setText("");

                // validate input - remove whitespace to ensure non-empty text
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                    return;
                }

                if (HanzawaSan[0] != null) {
                    try {
                        long amount = Long.parseLong(userInput);

                        HanzawaSan[0].deposit(amount);
                        programOutput.setText(String.format("Deposit successful! Your balance is now $%d.\n", HanzawaSan[0].getBalance()));
                    } catch (NumberFormatException e) {
                        programOutput.setText("ERROR: Invalid value");
                    }
                } else {
                    programOutput.setText("ERROR: Not signed in");
                }
            }
        });
        add(depositButton);

        // withdraw button
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        withdrawButton.setBounds(182, 195, 152, 50);
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent error) {
                String userInput = textField.getText();
                textField.setText("");

                // validate input - remove whitespace to ensure non-empty text
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                    return;
                }

                if (HanzawaSan[0] != null) {
                    try {
                        long amount = Long.parseLong(userInput);

                        if (HanzawaSan[0].getBalance() > amount) {
                            HanzawaSan[0].withdraw(amount);
                            programOutput.setText(String.format("Withdrawal successful! Balance is now $%d.\n", HanzawaSan[0].getBalance()));
                        } else {
                            programOutput.setText("ERROR: Insufficient balance");
                        }
                    } catch (NumberFormatException e) {
                        programOutput.setText("ERROR: Invalid value");
                    }
                } else {
                    programOutput.setText("ERROR: Not signed in");
                }
            }
        });
        add(withdrawButton);

        // copyright
        JLabel copyright = new JLabel("Copyright © Yang Yi Shen 2024");
        copyright.setBounds(49, 337, 252, 20);
        copyright.setFont(new Font("Baskerville", Font.PLAIN, 16));
        add(copyright);
    }
}