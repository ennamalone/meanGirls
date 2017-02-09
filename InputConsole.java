import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/* Written by Brian Finlay

  Program to take input and print it to a console style jtext area as name suggests

*/

public class InputConsole extends JPanel{

    public static void main(String[] args){

      JButton button = new JButton("Enter"); // Creates a new button called enter
      JPanel panel_0 = new JPanel(); // create a new panel
      panel_0.add(button); //we add the button to the  Jpanel so that later on we can arrange the panel

      TextArea inputArea = new TextArea(); // new text area called input area, to take.....input, who would've guessed?
      inputArea.setColumns(62); // we set it to have 62 columns
      inputArea.setRows(1); // and 1 row
      inputArea.setEditable(true); // we allow this area to be edited
      JPanel panel_1 = new JPanel(); // we create another Jpanel
      panel_1.add(inputArea); // and add the text area to that, once again for layout purposes


      TextArea textArea = new TextArea(); // new text area to display inputted text
      textArea.setColumns(62); // we set it to 62 columns for uniformity with the input section
      textArea.setRows(17); // but give it more rows as eventually it will display more data (sprint 2)
      textArea.setEditable(false); // we cannot edit this area
      JPanel panel_2 = new JPanel(); // create yet another jpanel
      panel_2.add(textArea); // you know the score with this by now


      JPanel container = new JPanel(); // we create a jpanel to contain the others so we can organise them
      container.setSize(590, 370); // set it to the same size as the jframe
      GridBagLayout layout = new GridBagLayout(); // we create a new gribag layout
      container.setLayout(layout); // we set this layout to the container panel

      GridBagConstraints containerConstraints = new GridBagConstraints(); // we create new constraints

      containerConstraints.gridx = 4;
      containerConstraints.gridy = 5;
      container.add(panel_0, containerConstraints);

      containerConstraints.gridwidth = 3;
      containerConstraints.gridx = 1;
      containerConstraints.gridy = 5;
      container.add(panel_1, containerConstraints);

      containerConstraints.gridwidth = 3;
      containerConstraints.gridx = 1;
      containerConstraints.gridy = 0;
      container.add(panel_2, containerConstraints);

      JFrame frame = new JFrame("Enter Instructions"); // this is the jframe on which all the panels will be laid
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(590, 370);
      frame.add(container); // we add the container to this
      frame.setVisible(true);

       button.addActionListener(new ActionListener() { // we create a new actionlistener for our button

         int i = 0;

        public void actionPerformed(ActionEvent e) { // when it is pressed

          ArrayList<String> list = new ArrayList<String>();

          if(!(inputArea.getText().equals(null))) // if the input isn't null
          {

              list.add(inputArea.getText());// we add the text entered to an arraylist
              textArea.setText(list.toString()); // we put this into the text area
              inputArea.setText("");// we clear the input area
              i++; // we increment i

          }

        }
      });

      }

    }
