
/**
 * A class to maintain information about an item
 * 
 * @author (Dylan Kernohan) 
 * @version (11-30-2015)
 */
public class Item
{
    // instance variables 
    private String itemName;
    private String itemDescription;
    private String noteMessage;
    private int itemWeight;
    private boolean edible;
    private boolean readable;
    
    

    /**********************************************
     * Constructor for objects of class Item
     **********************************************/
    public Item(String itemName, String itemDescription, int itemWeight, boolean edible, boolean readable, String noteMessage)
    {
        // initialise instance variables
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
        this.edible = edible;
        this.readable = readable;
        this.noteMessage = noteMessage;
    }
    
    /**********************************************
     * Second Constructor for objects of class Item
     **********************************************/
    public Item(String itemName, String itemDescription, int itemWeight, boolean edible, boolean readable )
    {
        // initialise instance variables
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemWeight = itemWeight;
        this.edible = edible;
        this.readable = readable;
    }
    
    
    
    
    /************************************************
     * @return itemName - Name of item 
     ************************************************/
    public String getItemName()
    {
        return itemName;
    }
    
    /************************************************
     * @return itemDescription - Description of item 
     ************************************************/
    public String getItemDescription()
    {
        return itemDescription;
    }
    
    /************************************************
     * @return itemWeight - Weight of item 
     ************************************************/
    public int getItemWeight()
    {
        return itemWeight;
    }
    
    /************************************************
     * @return noteMessage - The message in the note 
     ************************************************/
    public String getNoteMessage()
    {
        return noteMessage;
    }
    
    
    
    /************************************************
     * Sets the itemName 
     * 
     * @param itemName
     ************************************************/
    public void setItemName(String itemName)
    {
        this.itemName = itemName;
    }
    
    /************************************************
     * Sets the itemDescription 
     * 
     * @param itemDescription
     ************************************************/
    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }
    
    /************************************************
     * Sets the itemWeight 
     * 
     * @param itemWeight
     ************************************************/
    public void setItemWeight(int itemWeight)
    {
        this.itemWeight = itemWeight;
    }
    
    /************************************************
     * Sets the noteMessage 
     * 
     * @param noteMessage
     ************************************************/
    public void setItemWeight(String noteMessage)
    {
        this.noteMessage = noteMessage;
    }
    
    
    
    
    /************************************************
     * @return edible - whether the item is edible 
     ************************************************/
    public boolean isEdible()
    {
        return edible;
    }
    
    /************************************************
     * @return readable - whether the item is readable 
     ************************************************/
    public boolean isReadable()
    {
        return readable;
    }
}
