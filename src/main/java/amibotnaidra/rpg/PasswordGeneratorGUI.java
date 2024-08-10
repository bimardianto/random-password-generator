package amibotnaidra.rpg;

import javax.swing.*;
import java.awt.*;

public class PasswordGeneratorGUI extends JFrame {
    private final PasswordGenerator passwordGenerator;

    public PasswordGeneratorGUI() {
        super("Password Generator");
        setSize(540, 570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerator = new PasswordGenerator();
        addGuiComponents();
    }

    private void addGuiComponents() {

        JLabel tittleLabel = createTittleLabel();
        add(tittleLabel);

        JTextArea passwordOutput = createPasswordOutput();
        JScrollPane passwordOutputPane = createPasswordOutputPane(passwordOutput);
        add(passwordOutputPane);

        JLabel passwordLengthLabel = createPasswordLengthLabel();
        add(passwordLengthLabel);

        JTextArea passwordLengthInputArea = createPasswordLengthInputArea();
        add(passwordLengthInputArea);

        JToggleButton upperCaseToggle = createUpperCaseToggle();
        add(upperCaseToggle);

        JToggleButton lowerCaseToggle = createLowerCaseToggle();
        add(lowerCaseToggle);

        JToggleButton numbersToggle = createNumbersToggle();
        add(numbersToggle);

        JToggleButton symbolsToggle = createSymbolsToggle();
        add(symbolsToggle);

        JTextArea[] textAreas = {passwordOutput, passwordLengthInputArea};
        JToggleButton[] labels = {lowerCaseToggle, upperCaseToggle, numbersToggle, symbolsToggle};

        JButton generateButton = createGenerateButton(textAreas, labels);
        add(generateButton);

    }

    private JLabel createTittleLabel() {
        JLabel titleLabel = new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 540, 39);
        return titleLabel;
    }

    private JTextArea createPasswordOutput() {
        JTextArea passwordOutput = new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog", Font.BOLD, 32));
        return passwordOutput;
    }

    private JScrollPane createPasswordOutputPane(JTextArea passwordOutput) {
        JScrollPane passwordOutputPane = new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25, 97, 479, 70);
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        return passwordOutputPane;
    }

    private JLabel createPasswordLengthLabel() {
        JLabel passwordLengthLabel = new JLabel("Password Length: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25, 215, 272, 39);
        return passwordLengthLabel;
    }

    private JTextArea createPasswordLengthInputArea() {
        JTextArea passwordLengthInputArea = new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310, 215, 192, 39);
        return passwordLengthInputArea;
    }

    private JToggleButton createUpperCaseToggle() {
        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        uppercaseToggle.setBounds(25, 302, 225, 56);
        return uppercaseToggle;
    }

    private JToggleButton createLowerCaseToggle() {
        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        lowercaseToggle.setBounds(282, 302, 225, 56);
        return lowercaseToggle;
    }

    private JToggleButton createNumbersToggle() {
        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        numbersToggle.setBounds(25, 373, 225, 56);
        return numbersToggle;
    }

    private JToggleButton createSymbolsToggle() {
        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
        symbolsToggle.setBounds(282, 373, 225, 56);
        return symbolsToggle;
    }

    private JButton createGenerateButton(JTextArea[] textAreas, JToggleButton[] labels) {
        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog", Font.PLAIN, 32));
        generateButton.setBounds(155, 477, 222, 41);
        generateButton.addActionListener(e -> {
            if (textAreas[1].getText().length() <= 0) return;
            boolean anyToggleSelected = labels[0].isSelected() || labels[1].isSelected() || labels[2].isSelected() ||
                    labels[3].isSelected();
            int passwordLength = Integer.parseInt(textAreas[1].getText());
            if (anyToggleSelected) {
                String generatedPassword = passwordGenerator.generatePassword(passwordLength,
                        labels[1].isSelected(),
                        labels[0].isSelected(),
                        labels[2].isSelected(),
                        labels[3].isSelected());

                textAreas[0].setText(generatedPassword);
            }
        });
        return generateButton;
    }
}