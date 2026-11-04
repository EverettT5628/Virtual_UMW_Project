/**
 * Class for DropCommand objects, implements UserInputCommand. Contains a carryOut() method.
 * Part of a collection of command's that implement the UserInputCommand interface.
 * Field contains a String, itemName, holds the name of the item you want to drop.
 */
public class DropCommand implements UserInputCommand{
    String itemName;

    /**
     * DropCommand constructor, fills itemName.
     * @param itemName String to be put into itemName.
     */
    public DropCommand(String itemName)
    {
        this.itemName = itemName;
    }

    /**
     * Creates a string holding the name of the item and the name of the place where the item was dropped.
     * Removes the item from backpack, and puts it into the current locations items arraylist.
     * @return returns a string holding the name of the item dropped and the name of the place it was dropped.
     */
    public String carryOut()
    {
        String temp = "The ";
        TourStatus Tour = TourStatus.getInstance();

        temp += itemName + " has been dropped in " + Tour.getCurrentLocation().getName() + "\n";

        if(Tour.dropItemFromBackpack(itemName) == null)
        {
            temp = "You have no such item... \n";
        }

        temp += Tour.getCurrentLocation().describeLocation();

        return temp;
    }
}
