import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColorPickerApp extends JFrame implements ActionListener {
    private JButton colorButton;
    private Color selectedColor = Color.BLACK;

    public ColorPickerApp() {
        setTitle("Color Picker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        colorButton = new JButton("Pick a Color");
        colorButton.addActionListener(this);
        add(colorButton);

        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorButton) {
            Color newColor = JColorChooser.showDialog(this, "Choose a Color", selectedColor);
            if (newColor != null) {
                selectedColor = newColor;
                colorButton.setBackground(selectedColor);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorPickerApp());
    }
}
