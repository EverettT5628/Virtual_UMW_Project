import java.util.ArrayList;

/**
 * Class for the TourStatus object, which has a campus object, and a current location object.
 * TourStatus is a singleton and has one instance throughout the whole program.
 */
public class TourStatus {
    private Campus campus;
    private Location currentLocation;
    private ArrayList<Item> backpack;
    private static TourStatus tourInstance;

    /**
     * Constructor for the TourStatus object, sets values to null.
     */
    private TourStatus()
    {
        campus = null;
        currentLocation = null;
        tourInstance = null;
        backpack = new ArrayList<>();
    }

    /**
     * creates a new instance of TourStatus if there isn't one, and returns it if there is an instance of TourStatus.
     * @return returns the TourStatus object.
     */
    public static TourStatus getInstance()
    {
        if(tourInstance == null)
        {
            tourInstance = new TourStatus();
            return tourInstance;
        }
        return tourInstance;
    }

    /**
     * setter for the campus variable
     * @param campus new value to replace the old value of campus.
     */
    public void setCampus(Campus campus)
    {
        this.campus = campus;
    }

    /**
     * setter for the currentLocation variable.
     * @param loc new value to replace the old value of currentLocation.
     */
    public void setCurrentLocation(Location loc)
    {
        currentLocation = loc;
    }

    /**
     * getter for the campus variable.
     * @return returns the campus variable.
     */
    public Campus getCampus()
    {
        return campus;
    }

    /**
     * getter for the currentLocation variable.
     * @return returns the currentLocation variable.
     */
    public Location getCurrentLocation()
    {
        return currentLocation;
    }

    /**
     * updateTourLocation takes in a direction and looks to see if it is a viable direction, then changes the currentLocation variable to the location tied to the given direction.
     * @param dir the direction the user wants to go to.
     */
    public void updateTourLocation(String dir)
    {
        if(dir.equalsIgnoreCase("n") || dir.equalsIgnoreCase("w") || dir.equalsIgnoreCase("e") || dir.equalsIgnoreCase("s"))
        {
            Location temp = currentLocation.leaveLocation(dir);
            if(temp != null)
                currentLocation = temp;
            else
                System.out.println("Not a valid direction...");
        }
        else
            System.out.println("Not a valid direction...");
    }

    /**
     * adds an item to the backpack ArrayList.
     * @param item item to be added into the backpack ArrayList.
     */
    public void addToBackpack(Item item)
    {
        backpack.add(item);
        currentLocation.removeItem(item);
    }

    /**
     * removes an Item object from the backpack ArrayList and puts it in the current location.
     * @param name name of the item being removed.
     * @return returns the Item as its being removed. Returns null if the item was not found.
     */
    public Item dropItemFromBackpack(String name)
    {
        for(int i =0; i < backpack.size(); i++)
        {
            if(backpack.get(i).getName().equalsIgnoreCase(name))
            {
                currentLocation.addItem(backpack.get(i));
                return backpack.remove(i);

            }
        }
        return null;
    }

    /**
     * picksup an item from the location, removing it from that location, and puts it in the backpack ArrayList.
     * @param name name of the item being searched to pickup.
     * @return returns the item being picked up, after it has been put in the backpack ArrayList.
     */
    public Item pickupItemFromLocation(String name)
    {
        Item temp = currentLocation.getItemNamed(name);
        backpack.add(temp);
        currentLocation.removeItem(temp);
        return temp;
    }

    /**
     * Lists all items in the backpack ArrayList.
     * @return returns a String of all the items in the backpack ArrayList.
     */
    public String listBackpackItems()
    {
        String temp ="Here are the items in your backpack: \n";

        if(backpack.isEmpty())
        {
            temp = "There are no items in your backpack... \n";
        }
        else
        {
            for (Item i : backpack) {
                temp += i.getName() + " ";
            }
        }
        return temp;
    }

}
