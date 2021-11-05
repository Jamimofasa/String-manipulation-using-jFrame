import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameStringManipulation implements ActionListener {


    //run program
    public void run(){
        new JFrameStringManipulation();
    }

    private final JTextField textField1, textFieldResult;
    private final JButton button1, button2;
    private final JLabel lable1,lable2;

        //Constructor
    JFrameStringManipulation()
    {


    JFrame frame = new JFrame("String Manipulation");


    //Lables
    lable1 = new JLabel();
    lable1.setText("Enter a String:");
    lable1.setVisible(true);
    lable1.setBounds(10, 50, 150, 20);
    lable2 = new JLabel("String is now:");
    lable2.setVisible(true);
    lable2.setBounds(10, 100, 150, 20);


    //TextFields
    textField1 = new JTextField();
    textField1.setBounds(110, 50, 150, 20);
    textFieldResult = new JTextField();
    textFieldResult.setBounds(110, 100, 150, 20);
    textFieldResult.setEditable(false);

    //Buttons
    button1 = new JButton("Reverse String");
    button1.setBounds(20, 200, 130, 50);
    button1.addActionListener(this);
    button2 = new JButton("Remove Spaces");
    button2.setBounds(170, 200, 130, 50);
    button2.addActionListener(this);

    //add textfeilds and buttons to jframe
    frame.add(lable1);
    frame.add(lable2);
    frame.add(textField1);
    frame.add(textFieldResult);
    frame.add(button1);
    frame.add(button2);

    //set perimeters of frame


    frame.setSize(400, 400);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String name = textField1.getText();

        // When reverse button is pressed print String in reverse
        if (e.getSource().equals(button1))
            textFieldResult.setText(reverseRecursion(name));

        // When removes Spaces button is pressed print String without spaces
        if (e.getSource().equals(button2))
            textFieldResult.setText(removeSpaces(name));

    }


    //Reverse using recursion
    private String reverseRecursion(String string )
    {

     if (string.length() <1)
         return string;
     else
        return string.charAt(string.length()-1) + reverseRecursion(string.substring(0,string.length()-1));

    }

    //Remove white spaces using recursion
    private String removeSpaces(String string)
    {
        int index = 0;
        if (index == string.length())
            return string;
        else if (string.charAt(index) == ' ')
            return removeSpaces(string.substring(++index));
        else
            return string.charAt(index) + removeSpaces(string.substring(++index));

    }


}
