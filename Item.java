/**
 * Class for Item objects. Item objects have a name and a message, both strings.
 */
public class Item {

    private String name;
    private String message;

    /**
     * Constructor for when an empty Item is needed.
     */
    public Item()
    {
        name = "";
        message = "";
    }

    /**
     * Constructor for Item objects.
     * @param n input for the Item's name.
     * @param m input for the Item's message.
     */
    public Item(String n, String m)
    {
        name = n;
        message = m;
    }

    /**
     * Getter that returns the name variable.
     * @return returns the String name variable.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Getter that returns the message variable.
     * @return returns the String message variable.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Setter that renames the name of the item.
     * @param name new String to be put into name.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Setter that renames the message of the item.
     * @param msg new String to be put into message.
     */
    public void setMessage(String msg)
    {
        message = msg;
    }
}
