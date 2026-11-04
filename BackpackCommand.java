/**
 * Class for BackpackCommand objects, implements UserInputCommand. Contains a carryOut() method.
 * Part of a collection of command's that implement the UserInputCommand interface.
 */

public class BackpackCommand implements UserInputCommand{

    /**
     * BackpackCommand constructor. Empty.
     */
    public BackpackCommand()
    {

    }

    /**
     * Cobbles together a string of all the items in the user's backpack.
     * @return String containing the items in the backpack.
     */
    public String carryOut()
    {
        String temp = "";
        TourStatus Tour = TourStatus.getInstance();
        temp += Tour.listBackpackItems() + "\n";

        temp += Tour.getCurrentLocation().describeLocation();

        return temp;
    }
}
