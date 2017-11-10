import java.util.ArrayList;
/************************************************************
 * It is responsible for keeping track of the player’s 
 * items and the current location.  The game maintains a
 * current message that a GUI is responsible for displaying.
 *
 * 
 * @author (Dylan Kernohan) 
 * @version (12-2-2015)
 ************************************************************/
public class Game
{
    // instance variables
    private Room currentRoom;   // Players current Locaton
    private Room entrance;
    private Room westTowerRoom1;
    private Room eastTowerRoom1;
    private Room centralTowerRoom2;
    private Room westTowerRoom2;
    private Room eastTowerRoom2;
    private Room trophyRoom;
    private Room goblinRoom;
    private Room dragonRoom;
    private Room trollRoom;

    private Item shield;
    private Item paint;
    private Item hammer;
    private Item potion;
    private Item boulder;
    private Item rock;
    private Item boots;
    private Item sword;
    private Item lantern;
    private Item rupee;
    private Item gem;
    private Item crystal;
    private Item note1;
    private Item note2;
    private Item note3;

    private ArrayList<Item> inventory;

    private String currentMessage;

    boolean isPoisoned;
    boolean gotSword;   // Checks to make sure the player can only get the sword once

    /****************************************************
     * Constructor for objects of class Game
     */
    public Game()
    {
        boolean isPoisoned = false;
        boolean gotSword = false;  
        createRooms();
        inventory = new ArrayList<Item>();
        currentRoom = entrance;
        setWelcomeMessage();
    }

    //Accessor Methods
    /****************************************************
     * @return currentMessage - games message 
     *****************************************************/
    public String getMessage()
    {
        return "----------------------------------------------------------------------------------------------------------------------------\n " + currentMessage + "\n"; 
    }

    //Helper Methods
    /****************************************************
     * this private helper method instantiates the 
     * Rooms and Items.  Identify all of the room neighbors.
     *****************************************************/
    private void createRooms()
    {
        // FIXME: Consider making weight a final constant?
        //Items 
        shield = new Item("shield", "a flame resistant shield", 25, false, false);
        paint = new Item("paint", "a jar of gold paint", 5, true, false);   //if eaten, game over (lose)
        hammer = new Item("hammer", "a beefy hammer", 30, false, false);
        potion = new Item("potion", "a mysterious potion", 5, true, false); //if eaten, game over (lose)
        boulder = new Item("boulder", "a massive boulder", 300, false, false);
        rock = new Item("rock", "a small rock from the boulder", 5, false, false);
        boots = new Item("boots", "a pair of swift boots that will allow the user to move faster", 2, false, false);
        sword = new Item("sword", "a mighty sword", 20, false, false);
        lantern = new Item("lantern", "an old, dusty lantern", 5, false, false);
        rupee = new Item("rupee", "a shimmering green rupee", 2, false, false);
        gem = new Item("gem", "a shiny blue gem", 2, false, false);
        crystal = new Item("crystal", "a glimmering red crystal", 2, false, false);

        note1 = new Item("note1", "a folded up piece of paper (note 1)", 1, false, true,
            "In the top left room lies a Goblin. He is a very curious fellow who loves his shiny\n"+
            "\ttreasures. He will try almost anything if interested.\n");

        note2 = new Item("note2", "a folded up piece of paper (note 2)", 1, false, true,
            "In the highest room rests a dangerous Dragon. One will need to be fully equipped to\n"+
            "\ttake it on.\n");

        note3 = new Item("note3", "a folded up piece of paper (note 3)", 1, false, true, 
            "In the top right room sits a massive Troll. His brain is the size of a peanut and he moves\n"+
            "\tincredibly slow.\n");

        //Rooms Descriptions
        entrance = new Room("in a grand entranceway. Behind you lies the locked door to leave the\n" +
            "castle and three pedestals. Above the archway is something etched into the\n" +
            "stone that says, “You must venture into the castle and collect the 3 jewels.\n" +
            "You may only use what you find”. There is a path leading Left, Right, and Up.\n", 1016);

        westTowerRoom1 = new Room("in a small room at the base of the west tower. The room is littered with\n"+
            "various junk. Maybe there is something valuable to pick up. To the Right\n"+
            "is the Entrance, Up takes you higher in the west tower.\n", lantern, 985);
        westTowerRoom1.addItem(note1);

        eastTowerRoom1 = new Room("in a small room at the base of the east tower. The room is littered with\n"+
            "various junk. Maybe there is something valuable to pick up. To the Left is\n"+
            "the Entrance, Up takes you higher in the east tower.\n", paint, 1047);
        eastTowerRoom1.addItem(note3);

        centralTowerRoom2 = new Room("above the Entrance. There is a giant boulder blocking the stairs Up, so\n"+
            "you can only go Left, Right, or Down.\n", boulder, 586);
        centralTowerRoom2.addItem(note2);

        westTowerRoom2 = new Room("in an old alchemy lab. There are remains of old potions and enchanted\n"+
            "objects. Keep your eyes open for something good. You can move Up,\n"+
            "Down or Right\n", boots, 556);
        westTowerRoom2.addItem(potion);

        eastTowerRoom2 = new Room("in an old weaponry. You may be able to pick up something useful. You\n"+
            "can move Up, Down, or Left.\n", 617);
        eastTowerRoom2.addItem(hammer);
        eastTowerRoom2.addItem(shield);

        trophyRoom = new Room("in a grand room. Light fills in all over, shining on a pedestal in the\n"+
            "middle. A sword in stuck in the pedestal. It appears you need to place 2\n"+
            "jewels to obtain the sword. You can only move Up or Down\n", 374);
        trophyRoom.addItem(sword);

        goblinRoom = new Room("in a large room. In the center stands a giant goblin. Behind the goblin\n"+
            "shines a green object. There must be a way to get it. You can only move\n"+
            "Down\n", 122);

        dragonRoom = new Room("in a large room. In the center rests a great Dragon. Behind the Dragon\n"+
            "shines a red object. There must be a way to get it. You can only move\n"+
            "Down\n", 51);

        trollRoom = new Room("in a large room. In the center stands a giant Troll. Behind the Troll shines\n"+
            "a blue object. There must be a way to get it. You can only move Down\n", 196);

        //Room Neighbors
        entrance.addNeighbor("Left", westTowerRoom1);
        entrance.addNeighbor("Right", eastTowerRoom1);
        entrance.addNeighbor("Up", centralTowerRoom2);

        westTowerRoom1.addNeighbor("Right", entrance);
        westTowerRoom1.addNeighbor("Up", westTowerRoom2);

        eastTowerRoom1.addNeighbor("Left", entrance);
        eastTowerRoom1.addNeighbor("Up", eastTowerRoom2);

        centralTowerRoom2.addNeighbor("Right", eastTowerRoom2);
        centralTowerRoom2.addNeighbor("Left", westTowerRoom2);
        centralTowerRoom2.addNeighbor("Up", trophyRoom);
        centralTowerRoom2.addNeighbor("Down", entrance);

        westTowerRoom2.addNeighbor("Right", centralTowerRoom2);
        westTowerRoom2.addNeighbor("Up", goblinRoom);
        westTowerRoom2.addNeighbor("Down", westTowerRoom1);

        eastTowerRoom2.addNeighbor("Left", centralTowerRoom2);
        eastTowerRoom2.addNeighbor("Down", eastTowerRoom1);
        eastTowerRoom2.addNeighbor("Up", trollRoom);

        trophyRoom.addNeighbor("Down", centralTowerRoom2);
        trophyRoom.addNeighbor("Up", dragonRoom);

        goblinRoom.addNeighbor("Down", westTowerRoom2);

        dragonRoom.addNeighbor("Down", trophyRoom);

        trollRoom.addNeighbor("Down", eastTowerRoom2);
    }

    /****************************************************
     * this private helper method initializes the game’s 
     * message with a description of the game.
     *****************************************************/
    private void setWelcomeMessage()
    {
        currentMessage = ("The player must venture into a castle and claim the treasures Rupee, Gem, and Crystal\n"+
            "guarded by the three bosses Goblin, Troll, and Dragon respectively, using only items found in\n"+
            "the castle. The player will have to use the items correctly to get the item from the bosses. After\n"+
            "gathering the 3 items, the player drops them in the starting room to open the doorway out.\n");

    }

    /****************************************************
     * this private helper method checks the ArrayList 
     * for the requested Item name.
     * 
     * @return Item - return the item found
     * @param itemName - name of the item looking for
     *****************************************************/
    private Item checkForItem(String itemName)
    {
        for(int i = 0; i<inventory.size(); i++){
            if (inventory.get(i).getItemName().equals(itemName))
                return inventory.get(i);
        }
        return null;
    }

    /****************************************************
     * This private helper method provides the different
     * conditions that can happen in the drop method.
     *****************************************************/
    private void dropConditions(String itemName)
    {
        if(currentRoom == trophyRoom){
            if(gotSword == false && itemName.equals("gem") && currentRoom.hasItem("rupee") == rupee ||
            gotSword == false && itemName.equals("rupee") && currentRoom.hasItem("gem") == gem){
                currentMessage = "You dropped the second jewel onto the pedistal, freeing the sword!" ;
                currentRoom.setRoomDescription("in a grand room. Light fills in all over, shining on an empty pedestal.");
                gotSword = true;
            }
            
            if(gotSword == false && itemName.equals("rupee") || gotSword == false && itemName.equals("gem")){
                currentMessage = "You dropped the first jewel onto the pedistal.";
            }
        }

        else if(currentRoom == trollRoom){

            if(itemName.equals("rock")){
                currentMessage = "You dropped ... then kicked the rock. It bounces off the wall\n" +
                "distracting the dumb, slow Troll.";
            }

            if(itemName.equals("boots") && currentRoom.hasItem("rock") == rock){
                currentMessage = "You dropped the swift boots, then jumped into them. With the Troll\n" +
                "distracted, you run super fast past him towards the Gem.";
                currentRoom.setRoomDescription("in a large room. The Troll is playing with the rock.");
                currentRoom.removeItem(boots);
                currentRoom.removeItem(rock);
                trollRoom.addItem(gem);
            }
        }

        else if(currentRoom == goblinRoom){

            if(itemName.equals("paint")){
                currentMessage = "You dropped the gold paint on the ground making a big mess.";
            }

            if(itemName.equals("potion") && currentRoom.hasItem("paint") == paint){
                currentMessage = "You dropped the potion into the gold paint on the ground.\n" +
                "The Goblin is interested and drinks the gold potion, and he dies!\n" +
                "Good thing you did not drink it!";
                currentRoom.setRoomDescription("in a large room. The Goblin lies dead on the floor.");
                currentRoom.removeItem(potion);
                currentRoom.removeItem(paint);
                goblinRoom.addItem(rupee);
            }
        }

        else if(currentRoom == dragonRoom){

            if(itemName.equals("shield")){
                currentMessage = "You dropped the shield. It landed perfectly propped up.\n" +
                "You get behind the shield and dodge a fire attack from the Dragon.";
            }

            if(itemName.equals("sword") && currentRoom.hasItem("shield") == shield){
                currentMessage = "You casually drop the sword on the Dragon's foot. He screams\n" +
                "and jumps out of the way revealing the Crystal.";
                currentRoom.setRoomDescription("in a large room. The Dragon lays crying in the corner.");
                currentRoom.removeItem(sword);
                currentRoom.removeItem(shield);
                dragonRoom.addItem(crystal);
            }
        }

        else if(currentRoom == centralTowerRoom2 && itemName.equals("hammer")){
            currentMessage = "You dropped the beefy hammer onto the boulder. It broke apart\n"+
            "into many smaller rocks.";
            centralTowerRoom2.setRoomDescription("above the Entrance. Small rocks fill the floor where the boulder was.\n"+
                "You can now go Up, Left, or Right.\n");
            currentRoom.removeItem(boulder);
            currentRoom.addItem(rock);
        }
        
        else if (currentRoom == entrance && itemName.equals("rupee") || currentRoom == entrance && itemName.equals("gem") ||
                    currentRoom == entrance && itemName.equals("crystal")){
            currentMessage = "You dropped the " + itemName + " onto one of the 3 pedestals.";
        }

        else{
            currentMessage = "You dropped the " + itemName + ".";
        }
    }

    //Mutator Methods
    /****************************************************
     * Sets currentMessage. Used by GUI
     *****************************************************/
    public void setCurrentMessage(String message)
    {
        currentMessage = message;
    }

    /****************************************************
     * Update the games message with hints/suggestions
     *****************************************************/
    public void help()
    {
        currentMessage = "Need help? Try searching the rooms for items. \n" +
        "Keep your eye out for items you can read for more hints.\n" +
        "To use an item, drop it in the room you want to use it in.\n" +
        "Remember, you need to use 2 items per boss.";
    }

    /****************************************************
     * Update the games message the current rooms desc.
     *****************************************************/
    public void look()
    {
        currentMessage = currentRoom.getLongDescription();
    }

    /****************************************************
     * This method changes the players currentRoom
     * 
     * @param pDirection - Direction moving
     *****************************************************/
    public void move(String pDirection)
    {
        Room nextRoom = currentRoom.getNeighbor(pDirection);
        if (nextRoom == null){
            currentMessage = "You can't go in that direction";
        }
        else{
            if(currentRoom == eastTowerRoom1 && eastTowerRoom2.hasItem("lantern") == lantern && pDirection == "Up"||
            currentRoom == centralTowerRoom2 && eastTowerRoom2.hasItem("lantern") == lantern && pDirection == "Right"){
                currentRoom = nextRoom;
                currentMessage = currentRoom.getLongDescription();
            }
            
            else if(currentRoom == eastTowerRoom1 && checkForItem("lantern") == null && pDirection == "Up"||
            currentRoom == centralTowerRoom2 && checkForItem("lantern") == null && pDirection == "Right"){
                currentMessage = "It is pitch black. You cannot see anything therefore you turn around\n"+
                "and return to the previous room.";
            }
            
            else if(currentRoom == centralTowerRoom2 && currentRoom.hasItem("boulder") == boulder &&
            pDirection == "Up"){
                currentMessage = "You can't go that direction. The boulder blocks your way.";
            }
            
            else if(currentRoom == eastTowerRoom1 && eastTowerRoom2.hasItem("lantern") == lantern && pDirection == "Up"||
            currentRoom == centralTowerRoom2 && eastTowerRoom2.hasItem("lantern") == lantern && pDirection == "Right"){
                currentRoom = nextRoom;
                currentMessage = currentRoom.getLongDescription();
            }
            
            else{
                currentRoom = nextRoom;
                currentMessage = currentRoom.getLongDescription();
            }
        }     

    }

    /****************************************************
     * Update the games message with a list of all items 
     * the player is holding
     *****************************************************/
    public void list()
    {
        if(inventory.isEmpty()){
            currentMessage = "You are not holding any items.";
        }
        else{
            currentMessage = "You are holding:\n";
            for(int i = 0; i < inventory.size(); i++){
                currentMessage = currentMessage + "\t" + inventory.get(i).getItemDescription() + "\n";
            }
        }

    }

    /****************************************************
     * remove an item from the room and add to inventory
     * 
     *  @param itemName - name of item
     *****************************************************/
    public void pickup(String itemName)
    {
        Item tempItem = currentRoom.hasItem(itemName);
        if (tempItem == null){
            currentMessage = "The " + itemName + " is not in the room.";
        }
        else{
            if(tempItem.getItemWeight() < 50){
                if(itemName.equals("paint") && currentRoom == goblinRoom){
                    currentMessage = "The paint is too messy to pickup.\n"+
                    "If you are stuck. Remember each boss needs 2 items  to defeat.";
                }
                else if(itemName.equals("rock") && currentRoom == trollRoom){
                    currentMessage = "The rock is too far away to pickup.\n"+
                    "If you are stuck. Remember each boss needs 2 items  to defeat.";
                }
                else if(itemName.equals("shield") && currentRoom == dragonRoom){
                    currentMessage = "You will get hit by fire if you pickup the shield.\n" + 
                    "If you are stuck. Remember each boss needs 2 items  to defeat.";
                }
                else if(gotSword == false && itemName.equals("sword") && currentRoom == trophyRoom){
                    currentMessage = "The sword is stuck in the pedestal and can't be removed";
                }
                else{
                    currentRoom.removeItem(tempItem);
                    inventory.add(tempItem);
                    currentMessage = "You picked up the " + itemName + ".";
                }
            }
            else{
                currentMessage = "The " + itemName + " is too heavy to pickup";
            }
        }
    }

    /****************************************************
     * remove an item from inventory and add it to the room
     * 
     *  @param itemName - name of item
     *****************************************************/
    public void drop(String itemName)
    {
        Item tempItem = checkForItem(itemName);
        if(tempItem == null){
            currentMessage = "You do not have the " + itemName + ".";
        }
        else{
            inventory.remove(tempItem);
            currentMessage = "You dropped the " + itemName + ".";
            currentRoom.addItem(tempItem);
            dropConditions(itemName);
        }
    }

    /****************************************************
     * remove an item inventory and the player eats it.
     * 
     * @param itemName - name of item
     *****************************************************/
    public void eat(String itemName)
    {
        Item tempItem = checkForItem(itemName);
        if(tempItem == null){
            currentMessage = "You are not holding that item.";
        }
        else{
            if(tempItem.isEdible()){
                if(tempItem.getItemName().equals("paint") || tempItem.getItemName().equals("potion")){
                    inventory.remove(tempItem);
                    currentMessage = "You ate the " + tempItem.getItemName() + " and are now poisoned!";
                    isPoisoned = true;
                }
                else{
                    inventory.remove(tempItem);
                    currentMessage = "You ate the " + tempItem.getItemName() + ".";
                }
            }
            else{
                currentMessage = "That item is not edible.";
            }
        }
    }

    /****************************************************
     * Displays an ASCII map of the players location
     *****************************************************/
    public void map()
    {
        StringBuffer map = new StringBuffer
            ("\n                                              [        ]                                                   \n" +   
                "         [        ]                               |                                [        ]              \n" +   
                "             |                                    |                                     |                  \n" +     
                "             |                                [        ]                                |                   \n" +   
                "             |                                    |                                     |                   \n" +   
                "          [        ]--------------------[        ] ------------------- [        ]                \n" +   
                "             |                                    |                                     |                    \n" +
                "             |                                    |                                     |                     \n" +   
                "             |                                    |                                     |                     \n" +
                "         [        ] ------------------- [        ] ------------------- [        ]                 \n\n\n\n");


         
        map.replace(currentRoom.getMapLocation(), currentRoom.getMapLocation() + 2, "X");
        currentMessage = map.toString() + "Map: You are the 'X'";
        map.replace(currentRoom.getMapLocation(), currentRoom.getMapLocation() + 3, "   ");
    }

    /****************************************************
     * sets currentMessage to an Items Message
     * 
     *  @param itemName - name of item
     *****************************************************/
    public void read(String itemName)
    {
        Item tempItem = checkForItem(itemName);
        if(tempItem.isReadable()){
            currentMessage = itemName + " says:\n\t" + tempItem.getNoteMessage();
        }
        else{
            currentMessage = "This item is not readable";
        }
    }

    public boolean gameOver()
    {
        if(currentRoom == entrance && currentRoom.hasItem("rupee") != null && currentRoom.hasItem("gem") != null &&
        currentRoom.hasItem("crystal") != null){
            currentMessage = "You Win!";
            return true;
        }
        else if(isPoisoned == true){
            currentMessage = "Game Over!\n Try playing again. (File --> New Game)";
            return true;
        }

        return false;
    }

}
