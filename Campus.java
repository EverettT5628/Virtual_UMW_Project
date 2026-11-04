import java.util.Hashtable;

/**
 * Class for Campus objects. Campus objects have a name, a hashtable of locations and their names, a starting location, and a filename for if you would like to have the doors and locations filled from a file.
 */
public class Campus {

    String campusName;
    Hashtable<String, Location> locations;
    Location startingLocation;
    String filename;

    /**
     * Constructor that fills variables with empty values.
     */
    public Campus()
    {
        campusName = "";
        locations = new Hashtable<>();
        startingLocation = null;
        filename = "";
    }

    /**
     * Constructor that fills in the name of the campus. But leaves all other variables empty.
     * @param name the name you would like for the campus.
     */
    public Campus(String name)
    {
        campusName = name;
        locations = new Hashtable<>();
        startingLocation = null;
        filename = "";
    }

    /**
     * Adds a location to the hashtable locations.
     * @param location new location to add to the hashtable.
     */
    public void addLocation(Location location)
    {
        locations.put(location.getName(),location);
    }

    /**
     * getter for the location. Searches through locations hashtable for the name, index, and returns the object.
     * @param name name of the location to find.
     * @return returns the location of the given name.
     */
    public Location getLocation(String name)
    {
        return locations.get(name);
    }

    /**
     * setter for the name of the campus.
     * @param n new value to replace the old value of campusName.
     */
    public void setCampusName(String n)
    {
        campusName = n;
    }

    /**
     * setter for the startingLocation variable.
     * @param start new value to replace the old value of startingLocation.
     */
    public void setStartingLocation(Location start)
    {
        startingLocation = start;
    }

    /**
     * getter for the startingLocation variable.
     * @return returns the startingLocation value.
     */
    public Location getStartingLocation()
    {
        return startingLocation;
    }

    /**
     * setter for the filename.
     * @param f new value to replace the old value of filename.
     */
    public void setFilename(String f)
    {
        filename = f;
    }

    /**
     * getter for the filename variable.
     * @return returns the filename variable.
     */
    public String getFilename()
    {
        return filename;
    }

}
