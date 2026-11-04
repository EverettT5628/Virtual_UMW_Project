/**
 * Class for PickupCommand objects, implements UserInputCommand. Contains a carryOut() method.
 * Part of a collection of command's that implement the UserInputCommand interface.
 * Field contains the itemName variable, which holds the name of the item the user wants to pick up.
 */
public class PickupCommand implements UserInputCommand{
    String itemName;

    /**
     * Constructor that fills the itemName variable.
     * @param itemName name of the item to be put into itemName.
     */
    public PickupCommand(String itemName)
    {
        this.itemName = itemName;
    }

    /**
     * Creates a string that contains the name of the item being put in the backpack. Then puts the item in the backpack, removing the item from the location. Finally puts the current locations in the string.
     * @return returns a string that contains a phrase saying that the item was put in the backpack, and then the message of the item. Then finally the location and doors of the location.
     */
    public String carryOut()
    {
        String temp = "";
        TourStatus Tour = TourStatus.getInstance();

        if(Tour.getCurrentLocation().getItemNamed(itemName) != null)
        {
            temp += itemName + " was added to backpack! \n";
            temp += Tour.getCurrentLocation().getItemNamed(itemName).getMessage() + "\n";
            Tour.addToBackpack(Tour.getCurrentLocation().getItemNamed(itemName));
        }
        else
        {
            temp = "No such item!";
        }

        temp += Tour.getCurrentLocation().describeLocation();

        return temp;

    }
}
