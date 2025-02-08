import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SpeedDetectorGUI {
private JFrame frame;
private JTextField initialPositionField;
private JTextField finalPositionField;
private JTextField timeTakenField;
private JLabel resultLabel;
public SpeedDetectorGUI() {
frame = new JFrame("Speed Detector");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(400, 200);
frame.setLayout(new FlowLayout());
JLabel initialPositionLabel = new JLabel("Enter initial position (in
meters):");
initialPositionField = new JTextField(10);
JLabel finalPositionLabel = new JLabel("Enter final position (in meters):");
finalPositionField = new JTextField(10);
JLabel timeTakenLabel = new JLabel("Enter time taken (in seconds):");
timeTakenField = new JTextField(10);
JButton calculateButton = new JButton("Calculate Speed");
resultLabel = new JLabel("");
frame.add(initialPositionLabel);
frame.add(initialPositionField);
frame.add(finalPositionLabel);
frame.add(finalPositionField);
frame.add(timeTakenLabel);
frame.add(timeTakenField);
frame.add(calculateButton);
frame.add(resultLabel);
calculateButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
calculateSpeed();
}
});
frame.setVisible(true);
}
private void calculateSpeed() {
try {
double initialPosition =

Double.parseDouble(initialPositionField.getText());
double finalPosition = Double.parseDouble(finalPositionField.getText());
double timeTaken = Double.parseDouble(timeTakenField.getText());
double speedInMetersPerSecond = (finalPosition - initialPosition) /
timeTaken;
double speedInKilometersPerHour = speedInMetersPerSecond * 3.6;
resultLabel.setText("The vehicle's speed is " + speedInKilometersPerHour
+ " kilometers per hour.");
} catch (NumberFormatException e) {
resultLabel.setText("Invalid input. Please enter valid numbers.");
}
}
public static void main(String[] args) {
SwingUtilities.invokeLater(new Runnable() {
@Override
public void run() {
new SpeedDetectorGUI();
}
});
}
}