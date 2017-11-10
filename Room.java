import java.util.ArrayList;
import java.util.HashMap;
/**************************************************
 * A class to maintain information about a Room.
 * 
 * @author (Dylan Kernohan) 
 * @version (11-30-2015)
 **************************************************/
public class Room
{
    // instance variables 
    private String roomDescription;
    private ArrayList<Item> itemsInRoom;
    private HashMap<String, Room> roomNeighbors;
    private int mapLocation;


    /**********************************************
     * Constructor for objects of class Room
     **********************************************/
    public Room(String roomDescription, int mapLocation)
    {
        // initialise instance variables
        this.roomDescription = roomDescription;
        itemsInRoom = new ArrayList<Item>();
        roomNeighbors = new HashMap<String, Room>();
        this.mapLocation = mapLocation;
    }

    /***********************************************
     * Second Constructor for objects of class Room
     ***********************************************/
    public Room(String roomDescription, Item pItem, int mapLocation)
    {
        // initialise instance variables
        this.roomDescription = roomDescription;
        itemsInRoom = new ArrayList<Item>();
        itemsInRoom.add(pItem);
        roomNeighbors = new HashMap<String, Room>();
        this.mapLocation = mapLocation;
    }

    
    /***********************************************
     * @return roomDescription - Description of the room
     ***********************************************/
    public String getRoomDescription()
    {
        return roomDescription;
    }

    /***********************************************
     * @return itemsInRoom - List of Items in the room
     ***********************************************/
    public ArrayList<Item> getItemsInRoom()
    {
        return itemsInRoom;
    }

    /***********************************************
     * @return mapLocation - Location of map Location
     ***********************************************/
    public int getMapLocation()
    {
        return mapLocation;
    }

    
    
    /***********************************************
     * sets the Room Description
     ***********************************************/
    public void setRoomDescription(String roomDescription)
    {
        this.roomDescription = roomDescription;
    }

    /***********************************************
     * Adds an item to the itemsInRoom ArrayList
     ***********************************************/
    public void addItem(Item pItem)
    {
        itemsInRoom.add(pItem);
    }

    
    /***********************************************
     * Checks to see if the room has itemName
     * 
     * return boolean
     ***********************************************/
    public Item hasItem(String itemName)
    {
        for(int i = 0; i<itemsInRoom.size(); i++){
            if (itemsInRoom.get(i).getItemName().equals(itemName))
                return itemsInRoom.get(i);
        }
        return null;
    }

    /***********************************************
     * Adds a neighbor to the pRoom
     ***********************************************/
    public void addNeighbor(String pDirection, Room pRoom)
    {
        roomNeighbors.put(pDirection, pRoom);
    }

    /***********************************************
     * @return Room - Room adjacent to current room
     ***********************************************/
    public Room getNeighbor(String pDirection)
    {
        return roomNeighbors.get(pDirection);
    }

    /***********************************************
     * Removes an item from the ArrayList itemsInRoom
     ***********************************************/
    public Item removeItem(Item pItem)
    {
        for(int i = 0; i<itemsInRoom.size(); i++){
            if (itemsInRoom.get(i) == pItem){
                Item tempItem = itemsInRoom.get(i);
                itemsInRoom.remove(i);
                return tempItem;
            }
        }
        return null;
    }

    /***********************************************
     * Sets the current message to the Current Room's
     * description and the items in that room's desc.
     ***********************************************/
    public String getLongDescription()
    {
        if (itemsInRoom.isEmpty()){
            return "You are " + roomDescription;
        }
        else{
            int i = 0;
            String longItemDescription = "";
            do{
                longItemDescription = longItemDescription + itemsInRoom.get(i).getItemDescription();
                i++;
                if (i<itemsInRoom.size()){
                    longItemDescription = longItemDescription + " and ";
                }
            }while(i<itemsInRoom.size());
            return "You are " + roomDescription + "\n\n You see " + longItemDescription  + "\n";
        }
    }
}
