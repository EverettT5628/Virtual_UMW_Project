/**
 * Class for InvalidCommand objects, implements UserInputCommand. Contains a carryOut() method.
 * Part of a collection of command's that implement the UserInputCommand interface.
 * field contains a string which holds the invalid command that the user typed in.
 */
public class InvalidCommand implements UserInputCommand{
    String invalidCommand;

    /**
     * Constructor for InvalidCommand.
     * @param invalidCommand command to be put into the invalidCommand string.
     */
    public InvalidCommand(String invalidCommand)
    {
        this.invalidCommand = invalidCommand;
    }

    /**
     * creates a string that will tell the user that they have input an invalid command, then restates where they are including all the commands they can input.
     * @return returns a string that tells the user that they have put in an invalid command. Then the string holds where they are and all available options they can take.
     */
    public String carryOut()
    {
        TourStatus Tour = TourStatus.getInstance();
        String temp = "Not a vaild command! \n";

        temp += Tour.getCurrentLocation().describeLocation() + "\n";
        temp += "The available commands are backpack, pickup (item), drop (item), move (with the proper cardinal direction), and q for quit.";

        return temp;
    }
}
