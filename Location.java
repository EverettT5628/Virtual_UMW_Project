import java.util.ArrayList;


/**
 * Location class for the Location object. Objects have a name, description, a boolean for if they have been visited, and an ArrayList of doors that connect them to other Locations.
 * Includes an ArrayList of items in the location.
 */
public class Location {

    private String name;
    private String description;
    private Boolean haveVisited;
    private ArrayList<Door> doors;
    private ArrayList<Item> items;
    /**
     * Constructor for Location objects. Fills variables with empty values, leaves the haveVisited value as false.
     */
    public Location()
    {
        name = "";
        description = "";
        haveVisited = false;
        doors = new ArrayList<>();
        items = new ArrayList<>();
    }

    /**
     * Constructor for the Location objects. Fills varialbes with the given values, with the exception for doors, items, and haveVisited.
     * @param n value for the name of the location.
     * @param desc the description of the location.
     */
    public Location(String n, String desc)
    {
        name = n;
        description = desc;
        haveVisited = false;
        doors = new ArrayList<>();
        items = new ArrayList<>();
    }

    /**
     * getter for the name variable.
     * @return returns the name variable.
     */
    public String getName()
    {
        return name;
    }

    /**
     * getter for the description variable.
     * @return returns the description variable.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * getter for the haveVisited variable.
     * @return returns the value of haveVisited.
     */
    public boolean getHaveVisited()
    {
        return haveVisited;
    }

    /**
     * setter for the name variable.
     * @param n new value to replace the old value of name.
     */
    public void setName(String n)
    {
        name = n;
    }

    /**
     * setter for the description variable.
     * @param d new value to replace the old value of description.
     */
    public void setDescription(String d)
    {
        description = d;
    }

    /**
     * setter for the haveVisited variable.
     * @param v new value to replace the old value of haveVisited.
     */
    public void setHaveVisited(boolean v)
    {
        haveVisited = v;
    }

    /**
     * describes all doors attached to a location.
     * @return returns a string describing the amount of doors and their directions.
     */
    public String describeDoors()
    {
        String temp = "";

        for(Door d : doors)
        {
            temp += d.getDirection() + " ";
        }

        return "There are " + doors.size() + " doors going " + temp;
    }

    /**
     * Creates a string that describes the location and the items within that location.
     * @return
     */
    public String describeLocation()
    {
        String temp = "";
        String temp2 = "";
        String tempr = "";
        for(Door d : doors)
        {
            temp += " " + d.getDirection();
        }
        temp2 = getItemsInLocation();
        tempr += "You are at " + name;
        if(haveVisited == false)
        {
            tempr += "\n" + description.trim();
            haveVisited = true;
        }

        tempr += "\n" + "The directions you can head to are" + temp + ".\nThere are these items available to pickup: \n" + temp2;

        return tempr;
    }

    /**
     * Searches through a locations doors ArrayList to find the direction and then returns the enteringLocation of that door object.
     * @param dir value of the direction of which door you would like to enter
     * @return returns the enteringLocation object from the door found, or returns null if not found.
     */
    public Location leaveLocation(String dir)
    {
        for(Door d : doors)
        {
            if(d.getDirection().equals(dir))
            {
                return d.getEntering();
            }
        }
        return null;
    }

    /**
     * Adds a door to the doors ArrayList.
     * @param door new door to be added to the doors ArrayList.
     */
    public void addDoor(Door door)
    {
        doors.add(door);
    }

    /**
     * Adds an item to the items ArrayList.
     * @param item new item to be added to the items ArrayList.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     *  removes an item from the items ArrayList. Parses through checking Items until it finds the matching item to remove.
     * @param item Item object to be removed from items
     */
    public void removeItem(Item item)
    {
        for(int i=0; i < items.size(); i++)
        {
            if(items.get(i) == item)
            {
                items.remove(i);
            }
        }
    }

    /**
     * Finds the item from items with the given name.
     * @param name name of the item you want found.
     * @return returns the item or null if it was not found.
     */
    public Item getItemNamed(String name)
    {
        for(int i=0; i < items.size(); i++)
        {
            if(items.get(i).getName().equalsIgnoreCase(name))
            {
                return items.get(i);
            }
        }
        return null;
    }

    /**
     * creates a String of all the items in the location.
     * @return String holding a list of all the items in the location.
     */
    public String getItemsInLocation()
    {
        String temp = "";
        for(Item i : items)
        {
            temp += i.getName() + "\n";
        }
        return temp;
    }

}
