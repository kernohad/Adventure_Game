
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
/*************************************************************
 * GUI for a Text Based Adventure game
 * 
 * @author Dylan Kernohan
 * @version 12-8-15
 ************************************************************/
public class gameGUI extends JFrame implements ActionListener{

    /** the analyzer that does all the real work */
    Game adventureGame;

    /** Define Buttons */
    //Direction Buttons
    JButton upButton;
    JButton downButton;
    JButton leftButton;
    JButton rightButton;

    //Action Buttons
    JButton helpButton;
    JButton pickupButton;
    JButton dropButton;
    JButton eatButton;
    JButton readButton;
    JButton lookButton;
    JButton listButton;
    JButton mapButton;

    /** Results */
    JTextArea results;

    /** menu items */
    JMenuBar menus;
    JMenu fileMenu;
    JMenuItem quitItem;
    JMenuItem newGameItem;  

    /*****************************************************************
     * Main Method
     ****************************************************************/ 
    public static void main(String args[]){
        gameGUI gui = new gameGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Adventure Game");
        gui.pack();
        gui.setVisible(true);
    }

    /*****************************************************************
     * constructor installs all of the GUI components
     ****************************************************************/    
    public gameGUI(){

        // instantiate the analyzer   
        adventureGame = new Game();

        // set the layout to GridBag
        setLayout(new GridBagLayout());
        GridBagConstraints loc = new GridBagConstraints();

        // create results area 
        results = new JTextArea(20,60);
        JScrollPane scrollPane = new JScrollPane(results);
        loc.gridx = 0;
        loc.gridy = 0;
        loc.gridheight = 20;
        loc.gridwidth = 60;
        loc.insets.left = 5;
        loc.insets.right = 5;
        loc.insets.bottom = 5;
        loc.insets.top = 5;
        add(scrollPane, loc);
        loc = new GridBagConstraints();

        // create Actions label
        loc.gridx = 0;
        loc.gridy = 21;
        loc.gridheight = 1;
        loc.gridwidth = 1;
        loc.insets = new Insets(5,5,5,5);
        add(new JLabel("Actions:"), loc);

        // create Directions label
        loc.gridx = 62;
        loc.gridy = 0;
        add(new JLabel("Directions"), loc);
        loc = new GridBagConstraints();        

        //up Button
        upButton = new JButton("Up");
        loc.gridx = 62;
        loc.gridy = 1;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(10,10,10,10);
        add(upButton, loc);

        //down Button
        downButton = new JButton("Down");
        loc.gridx = 62;
        loc.gridy = 3;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(10,10,10,10);
        add(downButton, loc);

        //left Button
        leftButton = new JButton("Left");
        loc.gridx = 61;
        loc.gridy = 2;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(10,10,10,10);
        add(leftButton, loc);

        //right Button
        rightButton = new JButton("Right");
        loc.gridx = 63;
        loc.gridy = 2;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(10,10,10,10);
        add(rightButton, loc);

        //help Button
        helpButton = new JButton("Help");
        loc.gridx = 1;
        loc.gridy = 21;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(5,5,5,5);
        add(helpButton, loc);

        //pickup Button
        pickupButton = new JButton("Pickup");
        loc.gridx = 2;
        loc.gridy = 21;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(5,5,5,5);
        add(pickupButton, loc);

        //drop Button
        dropButton = new JButton("Drop");
        loc.gridx = 3;
        loc.gridy = 21;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(5,5,5,5);
        add(dropButton, loc);

        //eat Button
        eatButton = new JButton("Eat");
        loc.gridx = 4;
        loc.gridy = 21;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(5,5,5,5);
        add(eatButton, loc);

        //read Button
        readButton = new JButton("Read");
        loc.gridx = 5;
        loc.gridy = 21;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(5,5,5,5);
        add(readButton, loc);

        //look Button
        lookButton = new JButton("Look");
        loc.gridx = 6;
        loc.gridy = 21;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(5,5,5,5);
        add(lookButton, loc);

        //list Button
        listButton = new JButton("List");
        loc.gridx = 7;
        loc.gridy = 21;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(5,5,5,5);
        add(listButton, loc);

        //map Button
        mapButton = new JButton("Map");
        loc.gridx = 8;
        loc.gridy = 21;
        loc.anchor = GridBagConstraints.CENTER;
        loc.insets = new Insets(5,5,5,5);
        add(mapButton, loc);

        // set up File menu
        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("Quit");
        newGameItem = new JMenuItem("New Game");
        fileMenu.add(newGameItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        setJMenuBar(menus);
        menus.add(fileMenu);

        // Register Action Listeners
        upButton.addActionListener(this);
        downButton.addActionListener(this);
        leftButton.addActionListener(this);
        rightButton.addActionListener(this);
        helpButton.addActionListener(this);
        pickupButton.addActionListener(this);
        dropButton.addActionListener(this);
        eatButton.addActionListener(this);
        readButton.addActionListener(this);
        lookButton.addActionListener(this);
        listButton.addActionListener(this);
        mapButton.addActionListener(this);
        newGameItem.addActionListener(this);
        quitItem.addActionListener(this);

        results.append(adventureGame.getMessage());
    }

    /*****************************************************************
     * This method is called when any button is clicked.  The proper
     * internal method is called as needed.
     * 
     * Source for auto scroll line:
     * http://stackoverflow.com/questions/1627028/how-to-set-auto-scrolling-of-jtextarea-in-java-gui
     * 
     * @param e the event that was fired
     ****************************************************************/       
    public void actionPerformed(ActionEvent e){

        // extract the button that was clicked
        JComponent buttonPressed = (JComponent) e.getSource();

        if (buttonPressed == upButton)
            adventureGame.move("Up");

        if (buttonPressed == downButton)
            adventureGame.move("Down");

        if (buttonPressed == leftButton)
            adventureGame.move("Left");

        if (buttonPressed == rightButton)
            adventureGame.move("Right");

        if (buttonPressed == helpButton)
            adventureGame.help();

        if (buttonPressed == pickupButton){
            String toPickup = JOptionPane.showInputDialog(null,"Pickup?", "Item name");
            if(toPickup != null)
                adventureGame.pickup(toPickup);
            else
                adventureGame.setCurrentMessage("");

        }

        if (buttonPressed == dropButton){
            String toDrop = JOptionPane.showInputDialog(null, "Drop?", "Item name");
            if(toDrop != null)
                adventureGame.drop(toDrop);
            else
                adventureGame.setCurrentMessage("");

        }

        if (buttonPressed == eatButton){
            String toEat = JOptionPane.showInputDialog(null, "Eat?", "Item name");
            if(toEat != null)
                adventureGame.eat(toEat);
            else
                adventureGame.setCurrentMessage("");

        }

        if (buttonPressed == readButton){
            String toRead = JOptionPane.showInputDialog(null, "Read?", "Item name");
            if(toRead != null)
                adventureGame.read(toRead);
            else
                adventureGame.setCurrentMessage("");

        }

        if (buttonPressed == lookButton)
            adventureGame.look();

        if (buttonPressed == listButton)
            adventureGame.list();

        if (buttonPressed == mapButton)
            adventureGame.map();

        results.append(adventureGame.getMessage());
        
        //Menu Buttons
        if (buttonPressed == quitItem)
            System.exit(1);

        if (buttonPressed == newGameItem)
            newGame();
         
        if(adventureGame.gameOver() == true){
            gameOver();
            results.append(adventureGame.getMessage());
        }
            
        //Makes text auto scroll as more text is added. 
        //(Source:http://stackoverflow.com/questions/1627028/how-to-set-auto-scrolling-of-jtextarea-in-java-gui)
        results.setCaretPosition(results.getDocument().getLength());    
    }

    /*****************************************************************
     * Start a new game
     * 
     * Clear Text Area
     * Source: http://stackoverflow.com/questions/15798532/how-to-clear-jtextarea
     ****************************************************************/ 
    private void newGame(){

        adventureGame = new Game();
        
        //Clears TextArea
        //Souce: http://stackoverflow.com/questions/15798532/how-to-clear-jtextarea
        results.setText(null);
        
        results.append(adventureGame.getMessage());

        upButton.setEnabled(true);
        downButton.setEnabled(true);
        leftButton.setEnabled(true);
        rightButton.setEnabled(true);
        helpButton.setEnabled(true);
        pickupButton.setEnabled(true);
        dropButton.setEnabled(true);
        eatButton.setEnabled(true);
        readButton.setEnabled(true);
        lookButton.setEnabled(true);
        listButton.setEnabled(true);
        mapButton.setEnabled(true);
        newGameItem.setEnabled(true);
        quitItem.setEnabled(true);

    }

    /*****************************************************************
     * This method is called when the GUI determines the game is over.
     * Disable all buttons but not menu items. 
     ****************************************************************/   
    private void gameOver(){
        upButton.setEnabled(false);
        downButton.setEnabled(false);
        leftButton.setEnabled(false);
        rightButton.setEnabled(false);
        helpButton.setEnabled(false);
        pickupButton.setEnabled(false);
        dropButton.setEnabled(false);
        eatButton.setEnabled(false);
        readButton.setEnabled(false);
        lookButton.setEnabled(false);
        listButton.setEnabled(false);
        mapButton.setEnabled(false);

        //FIXME: Add JOption Window
    }
}