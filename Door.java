/**
 *  This Class covers the Door objects, which take in two locations as an entering and a leaving variable. Doors also include a direction for where you may go.
 *
 */

public class Door {

    String direction;
    Location leavingLocation;
    Location enteringLocation;

    /**
     * Door constructor, instantiates variables with empty values.
     */
    public Door()
    {
        direction = "";
        leavingLocation = null;
        enteringLocation = null;
    }

    /**
     * Door constructor, instantiates variables with given values.
     * @param dir direction.
     * @param leave location object that is being left.
     * @param enter location object that is being entered.
     */
    public Door(String dir, Location leave, Location enter)
    {
        direction = dir;
        leavingLocation = leave;
        enteringLocation = enter;
    }

    /**
     * Describes the direction you can go and the location you can enter.
     * @return returns a string of the direction you can go to and where you can enter.
     */
    public String describe()
    {
        return "You can go " + direction + " to get to " + enteringLocation.getName();
    }

    /**
     * getter for the leavingLocation variable.
     * @return returns the leavingLocation variable.
     */
    public Location getLeaving()
    {
        return leavingLocation;
    }

    /**
     * getter for the enteringLocation variable.
     * @return returns the leavingLocation variable.
     */
    public Location getEntering()
    {
        return enteringLocation;
    }

    /**
     * getter for the direction variable.
     * @return returns the direction variable.
     */
    public String getDirection()
    {
        return direction;
    }

    /**
     * setter for the leavingLocation variable.
     * @param leaving new value to replace the old value of leavingLocation.
     */
    public void setLeaving(Location leaving)
    {
        leavingLocation = leaving;
    }

    /**
     * setter for the enteringLocation variable.
     * @param enter new value to replace the old value of enteringLocation.
     */
    public void setEntering(Location enter)
    {
        enteringLocation = enter;
    }

    /**
     * setter for the dir variable.
     * @param dir new value to replace the old value of dir.
     */
    public void setDirection(String dir)
    {
        direction = dir;
    }
}
