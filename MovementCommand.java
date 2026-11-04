/**
 * Class for MovementCommand objects, implements UserInputCommand. Contains a carryOut() method.
 * Part of a collection of command's that implement the UserInputCommand interface.
 * Field contains a string of the direction that the user wants to go.
 */
public class MovementCommand implements UserInputCommand{
    private String dir;

    /**
     * Constructor for MovementCommand. Fills the dir variable with the input given from the user.
     * @param dir direction of where the user wants to go, typically n,e,s,w.
     */
    public MovementCommand(String dir)
    {
        this.dir = dir;
    }

    /**
     * creates a string of where the user goes to. Also moves the user around the campus to a different location. Lists all items in the current location.
     * @return returns a string of where the user is, a description of the place if its the first time they've visited, and the items in that location.
     */
    public String carryOut()
    {
        String temp = "";
        TourStatus Tour = TourStatus.getInstance();
        Tour.updateTourLocation(dir);
        temp += "You are at " + Tour.getCurrentLocation().getName() + "\n";
        if (Tour.getCurrentLocation().getHaveVisited() == false)
        {
            temp += Tour.getCurrentLocation().getDescription().trim() + "\n";
            Tour.getCurrentLocation().setHaveVisited(true);
        }
        temp += Tour.getCurrentLocation().describeDoors() + "\n";
        temp += "There are some items... \n" + Tour.getCurrentLocation().getItemsInLocation();
        return temp;
    }
}
