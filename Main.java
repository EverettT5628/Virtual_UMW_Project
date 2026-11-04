import java.io.File;
import java.util.Scanner;

/**
 * @author Everett
 */
public class Main
{

    public static void main(String[] args)
    {
        Scanner i = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);
        String input = "";
        UserInputCommand command;

        System.out.println("Please enter a file name: ");
        Campus UMW = setUpCampus(i);

        TourStatus Tour = TourStatus.getInstance();
        Tour.setCampus(UMW);
        Tour.setCurrentLocation(UMW.getStartingLocation());

        System.out.println("You are at " + Tour.getCurrentLocation().getName());
        System.out.println(Tour.getCurrentLocation().getDescription().trim());
        System.out.println(Tour.getCurrentLocation().describeDoors());
        System.out.println("There are some items...");
        System.out.println(Tour.getCurrentLocation().getItemsInLocation());
        Tour.getCampus().getStartingLocation().setHaveVisited(true);

        while(!input.equalsIgnoreCase("q"))
        {
            System.out.println("What would you like to do?: ");
            input = userInput.nextLine();
            if(input.equalsIgnoreCase("q"))
            {
                break;
            }

            command = parseInput(input);
            System.out.println(command.carryOut());

        }

        i.close();
        userInput.close();

    }

    /**
     * parseInput takes in the input of the user and makes checks to see which command the input should be sent to.
     * @param input the String to be checked and sent to certain commands
     * @return returns an object of a certain command that the input is supposed to represent.
     */
    static UserInputCommand parseInput(String input)
    {

        if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("e") || input.equalsIgnoreCase("s") || input.equalsIgnoreCase("w"))
        {
            MovementCommand move = new MovementCommand(input);
            return move;
        }

        else if(input.startsWith("drop") || input.startsWith("Drop"))
        {
            String itemName = input.substring(5).trim();
            DropCommand drop = new DropCommand(itemName);

            return drop;
        }

        else if(input.startsWith("pickup") || input.startsWith("Pickup"))
        {
            String itemName = input.substring(7).trim();
            PickupCommand pickup = new PickupCommand(itemName);

            return pickup;
        }

        else if(input.equalsIgnoreCase("backpack") || input.equalsIgnoreCase("back pack"))
        {
            BackpackCommand backpack = new BackpackCommand();
            return backpack;
        }

        else
        {
            InvalidCommand invalidcommand = new InvalidCommand(input);

            return invalidcommand;
        }

    }


    /**
     * setUpCampus takes in a scanner object that will be given a file name. Then the function will parse through the file, creating locations, doors, and items within certain locations, and finally the complete campus.
     * @param s the scanner object that will request the user to type in a file name
     * @return returns a fully fleshed out campus object of the file given.
     */
    static Campus setUpCampus(Scanner s)
    {
        Campus UMW = new Campus("UMW");
        Scanner reader = null;
        UMW.setFilename(s.nextLine());


        try
        {
            File file = new File(UMW.getFilename());
            reader = new Scanner(file);

            UMW.setCampusName(reader.nextLine().trim());
            reader.nextLine();
            reader.nextLine();

            String tempDesc = "";
            while(reader.hasNextLine())
            {
                String line  = reader.nextLine().trim();
                Location newLoc = new Location();

                if(line.equals("*****"))
                    break;

                newLoc.setName(line);

                while(reader.hasNextLine())
                {
                    String descLine = reader.nextLine().trim();
                    if(descLine.equals("+++"))
                        break;
                    tempDesc += " " + descLine;
                }
                newLoc.setDescription(tempDesc);
                UMW.addLocation(newLoc);
                if(UMW.getStartingLocation() == null)
                    UMW.setStartingLocation(newLoc);
                tempDesc = "";
            }

            reader.nextLine();

            while(reader.hasNextLine())
            {
                String leavingName = reader.nextLine().trim();
                String dir;
                String enteringName;

                if(leavingName.equals("*****"))
                    break;

                dir = reader.nextLine().trim();
                enteringName = reader.nextLine().trim();

                reader.nextLine();

                Location leaving = UMW.getLocation(leavingName);
                Location entering = UMW.getLocation(enteringName);

                Door door = new Door(dir, leaving, entering);
                leaving.addDoor(door);

            }

            reader.nextLine();

            while(reader.hasNextLine())
            {
                String itemName = reader.nextLine().trim();
                String location;
                String message;

                if(itemName.equals("*****"))
                {
                    break;
                }

                location = reader.nextLine().trim();
                message = reader.nextLine().trim();

                Item newItem = new Item(itemName, message);
                Location targetLoc = UMW.getLocation(location);

                targetLoc.addItem(newItem);
                reader.nextLine();

            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
        }
        finally
        {
            if(reader != null)
                reader.close();
        }
        return UMW;
    }
}