package Frontend.Source;

import java.io.*;
import javax.swing.*;

public class test
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        JButton button = new JButton("Press me");

        button.setBounds(
            150, 200,            // Position
            220, 50     // Size
        );

        frame.add(button);

        frame.setSize(510, 620);
        frame.setLayout(null);
        frame.setVisible(true);
    }    
}
