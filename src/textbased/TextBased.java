package textbased;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextBased {

    private RoomMap roomMap = new RoomMap();
    private Backpack backpack = new Backpack();
    private Room hallwayMainA;
    private Room hallwayMainB;
    private Room hallwayMainC;
    private Room hallwayMainD;
    private Room hallwayMainE;
    private Room hallwayMainF;
    private Room hallwayMainG;
    private Room hallwayLowerWestA;
    private Room hallwayLowerWestB;
    private Room hallwayUpperWestA;
    private Room hallwayUpperWestB;
    private Room hallwayLowerEastA;
    private Room hallwayLowerEastB;
    private Room hallwayLowerEastC;
    private Room hallwayLowerEastD;
    private Room hallwayUpperEastA;
    private Room hallwayUpperEastB;
    private Room hallwayUpperEastC;
    private Room hallwayUpperEastD;
    private Room kitchen;
    private Room pantry;
    private Room westLibrary;
    private Room eastLibrary;
    private Room eastDiningroom;
    private Room westDiningroom;
    private Room yard;
    private Room westYard;
    private Room eastYard;
    private Room lounge;
    private Room study;
    private Room secretRoom;
    private Room masterBed;
    private Room servantBedA;
    private Room servantBedB;
    private Room servantBedC;
    private Room westWC;
    private Room eastWC;
    private Room boiler;

    private Item knife;
    private Item shovel;
    private Item food;
    private Item silverware;
    private Item goldKey;
    private Item book;

    private Obstacle debris;
    private Obstacle bookshelf;
    private Obstacle oakDoor;

    public Room currentRoom;
    public String northOfCurrentRoom = "";
    public String eastOfCurrentRoom = "";
    public String westOfCurrentRoom = "";
    public String southOfCurrentRoom = "";

    String aaa = "You are traveling by carriage to the nearest town away from the manor house where";
    String bbb = "you live. The master of the house has fallen ill and her husband has implored you";
    String ccc = "to fetch the doctor of Innsmouth, six leagues away. You have been traveling at full";
    String ddd = "speed for the last four and a half leagues and have been making good time.";

    String eee = "At a particularly sharp turn you suddenly feel the world heave as you realize the carriage";
    String fff = "is tipping over. There is a terrible crash and everything goes black for a moment. When you";
    String ggg = "come to and manage to crawl out from the wreckage you find the driver and one of the horses";
    String hhh = "have broken their necks and the second horse is nowhere to be found. You look around in";
    String iii = "bewilderment and spot a light shining through the treeline.";

    String jjj = "You start towards the light and as you emerge from the bosket you find yourself outside a";
    String kkk = "walled manor house much like the one where you work. The large gate in the wall is open";
    String lll = "but you see no guards or servants around.";

    String mmm = "You decide that the situation warrants a possible faux-pas and step under the gate to simply";
    String nnn = "walk up to the house and knock on the door.";

    String ooo = "Just as you walk through the massive oak gates, they shut behind you with a thunderous boom.";
    String ppp = "Startled you spin around to see who closed it but find no one. You rush back, push and pull";
    String qqq = "on the gates with all your might to no avail. The gate will not budge.";

    String rrr = "You are trapped.";

    String sss = "                ----------------------------------------------------------";

//    public void commands() {
//        String cmdLook = "";
//        String cmdNorth = "";
//        String cmdWest = "";
//        String cmdEast = "";
//        String cmdSouth = "";
//    }
    public TextBased(Boolean previousGame) {

        //  Map initialization
        //      Creating rooms
        hallwayMainA = new Room(1, "Main Hallway A", Descriptions.ROOM_HALLWAY_MAIN_A_LONG, Descriptions.ROOM_HALLWAY_MAIN_A_LONG_WITH_HINT, 3, 6);
        hallwayMainB = new Room(2, "Main Hallway B", Descriptions.ROOM_HALLWAY_MAIN_B_LONG, Descriptions.ROOM_HALLWAY_MAIN_B_LONG_WITH_HINT, 3, 5);
        hallwayMainC = new Room(3, "Main Hallway C", Descriptions.ROOM_HALLWAY_MAIN_C_LONG, Descriptions.ROOM_HALLWAY_MAIN_C_LONG_WITH_HINT, 3, 4);
        hallwayMainD = new Room(4, "Main Hallway D", Descriptions.ROOM_HALLWAY_MAIN_D_LONG, Descriptions.ROOM_HALLWAY_MAIN_D_LONG_WITH_HINT, 3, 3);
        hallwayMainE = new Room(5, "Main Hallway E", Descriptions.ROOM_HALLWAY_MAIN_E_LONG, Descriptions.ROOM_HALLWAY_MAIN_E_LONG_WITH_HINT, 3, 2);
        hallwayMainF = new Room(6, "Main Hallway F", Descriptions.ROOM_HALLWAY_MAIN_F_LONG, Descriptions.ROOM_HALLWAY_MAIN_F_LONG_WITH_HINT, 3, 1);
        hallwayMainG = new Room(7, "Main Hallway G", Descriptions.ROOM_HALLWAY_MAIN_G_LONG, Descriptions.ROOM_HALLWAY_MAIN_G_LONG_WITH_HINT, 3, 0);

        hallwayLowerWestA = new Room(8, "Lower West Hallway A", Descriptions.ROOM_HALLWAY_LOWER_WEST_A_LONG, Descriptions.ROOM_HALLWAY_LOWER_WEST_A_LONG_WITH_HINT, 2, 5);
        hallwayLowerWestB = new Room(9, "Lower West Hallway B", Descriptions.ROOM_HALLWAY_LOWER_WEST_B_LONG, Descriptions.ROOM_HALLWAY_LOWER_WEST_B_LONG_WITH_HINT, 1, 5);

        hallwayUpperWestA = new Room(10, "Hallway", Descriptions.ROOM_HALLWAY_UPPER_WEST_A_LONG, Descriptions.ROOM_HALLWAY_UPPER_WEST_A_LONG_WITH_HINT, 2, 0);
        hallwayUpperWestB = new Room(11, "Hallway", Descriptions.ROOM_HALLWAY_UPPER_WEST_B_LONG, Descriptions.ROOM_HALLWAY_UPPER_WEST_B_LONG_WITH_HINT, 1, 0);

        hallwayLowerEastA = new Room(12, "Hallway", Descriptions.ROOM_HALLWAY_LOWER_EAST_A_LONG, Descriptions.ROOM_HALLWAY_LOWER_EAST_A_LONG_WITH_HINT, 4, 5);
        hallwayLowerEastB = new Room(13, "Hallway", Descriptions.ROOM_HALLWAY_LOWER_EAST_B_LONG, Descriptions.ROOM_HALLWAY_LOWER_EAST_B_LONG_WITH_HINT, 5, 5);
        hallwayLowerEastC = new Room(14, "Hallway", Descriptions.ROOM_HALLWAY_LOWER_EAST_C_LONG, Descriptions.ROOM_HALLWAY_LOWER_EAST_C_LONG_WITH_HINT, 6, 5);
        hallwayLowerEastD = new Room(15, "Hallway", Descriptions.ROOM_HALLWAY_LOWER_EAST_D_LONG, Descriptions.ROOM_HALLWAY_LOWER_EAST_D_LONG_WITH_HINT, 7, 5);

        hallwayUpperEastA = new Room(16, "Hallway", Descriptions.ROOM_HALLWAY_UPPER_EAST_A_LONG, Descriptions.ROOM_HALLWAY_UPPER_EAST_A_LONG_WITH_HINT, 4, 2);
        hallwayUpperEastB = new Room(17, "Hallway", Descriptions.ROOM_HALLWAY_UPPER_EAST_B_LONG, Descriptions.ROOM_HALLWAY_UPPER_EAST_B_LONG_WITH_HINT, 5, 2);
        hallwayUpperEastC = new Room(18, "Hallway", Descriptions.ROOM_HALLWAY_UPPER_EAST_C_LONG, Descriptions.ROOM_HALLWAY_UPPER_EAST_C_LONG_WITH_HINT, 6, 2);
        hallwayUpperEastD = new Room(19, "Hallway", Descriptions.ROOM_HALLWAY_UPPER_EAST_D_LONG, Descriptions.ROOM_HALLWAY_UPPER_EAST_D_LONG_WITH_HINT, 7, 2);

        kitchen = new Room(20, "Kitchen", Descriptions.ROOM_KITCHEN_LONG, Descriptions.ROOM_KITCHEN_LONG_WITH_HINT, 1, 4);
        pantry = new Room(21, "Pantry", Descriptions.ROOM_PANTRY_LONG, Descriptions.ROOM_PANTRY_LONG_WITH_HINT, 0, 4);

        westLibrary = new Room(22, "West Library", Descriptions.ROOM_WEST_LIBRARY_LONG, Descriptions.ROOM_WEST_LIBRARY_LONG_WITH_HINT, 5, 1);
        eastLibrary = new Room(23, "East Library", Descriptions.ROOM_EAST_LIBRARY_LONG, Descriptions.ROOM_EAST_LIBRARY_LONG, 6, 1);

        yard = new Room(24, "Yard", Descriptions.ROOM_YARD_LONG, Descriptions.ROOM_YARD_LONG_WITH_HINT, 3, 7);
        westYard = new Room(25, "West yard", Descriptions.ROOM_WESTYARD_LONG, Descriptions.ROOM_WESTYARD_LONG_WITH_HINT, 2, 7);
        eastYard = new Room(26, "East Yard", Descriptions.ROOM_EASTYARD_LONG, Descriptions.ROOM_EASTYARD_LONG_WITH_HINT, 4, 7);

        lounge = new Room(27, "Lounge", Descriptions.ROOM_LOUNGE_LONG, Descriptions.ROOM_LOUNGE_LONG_WITH_HINT, 2, 2);
        study = new Room(28, "Study", Descriptions.ROOM_STUDY_LONG, Descriptions.ROOM_STUDY_LONG_WITH_HINT, 7, 1);
        secretRoom = new Room(29, "Secret Room", Descriptions.ROOM_SECRET_ROOM_LONG, Descriptions.ROOM_SECRET_ROOM_LONG_WITH_HINT, 6, 0);

        westDiningroom = new Room(30, "West Dining Room", Descriptions.ROOM_WEST_DININGROOM_LONG, Descriptions.ROOM_WEST_DININGROOM_LONG, 1, 3);
        eastDiningroom = new Room(31, "East Dining Room", Descriptions.ROOM_EAST_DININGROOM_LONG, Descriptions.ROOM_EAST_DININGROOM_LONG_WITH_HINT, 2, 3);

        masterBed = new Room(32, "Master Bedroom", Descriptions.ROOM_MASTERBED_LONG, Descriptions.ROOM_MASTERBED_LONG_WITH_HINT, 1, 1);
        servantBedA = new Room(33, "Servants quarters A", Descriptions.ROOM_SERVANTBED_A_LONG, Descriptions.ROOM_SERVANTBED_A_LONG_WITH_HINT, 5, 6);
        servantBedB = new Room(34, "Servants quarters B", Descriptions.ROOM_SERVANTBED_B_LONG, Descriptions.ROOM_SERVANTBED_B_LONG_WITH_HINT, 7, 4);
        servantBedC = new Room(35, "Servants quarters C", Descriptions.ROOM_SERVANTBED_C_LONG, Descriptions.ROOM_SERVANTBED_C_LONG_WITH_HINT, 7, 6);
        westWC = new Room(36, "West WC", Descriptions.ROOM_WESTWC_LONG, Descriptions.ROOM_WESTWC_LONG_WITH_HINT, 0, 0);
        eastWC = new Room(37, "East WC", Descriptions.ROOM_EASTWC_LONG, Descriptions.ROOM_EASTWC_LONG_WITH_HINT, 5, 4);
        boiler = new Room(38, "Boiler room", Descriptions.ROOM_BOILER_LONG, Descriptions.ROOM_BOILER_LONG_WITH_HINT, 1, 6);

        //      Creating Items
        knife = new Item("KNIFE", Descriptions.ITEM_KNIFE, "N/A");
        silverware = new Item("SILVERWARE", Descriptions.ITEM_SILVERWARE, "N/A");
        shovel = new Item("SHOVEL", Descriptions.ITEM_SHOVEL, "N/A");
        food = new Item("FOOD", Descriptions.ITEM_FOOD, "N/A");
        goldKey = new Item("GOLD KEY", Descriptions.ITEM_GOLD_KEY, "N/A");
        book = new Item("BOOK", Descriptions.ITEM_BOOK, "N/A");

        //      Creating Obstacles
        debris = new Obstacle("DEBRIS", Descriptions.OBSTACLE_DEBRIS_DESCRIPTION, Descriptions.OBSTACLE_DEBRIS_REMOVE, "SHOVEL");
        bookshelf = new Obstacle("BOOKSHELF", Descriptions.OBSTACLE_BOOKSHELF_DESCRIPTION, Descriptions.OBSTACLE_BOOKSHELF_REMOVE, "BOOK");
        oakDoor = new Obstacle("OAK DOOR", Descriptions.OBSTACLE_OAKDOOR_DESCRIPTION, Descriptions.OBSTACLE_OAKDOOR_REMOVE, "GOLD KEY");

//      adding rooms to map
        roomMap.addRoom(hallwayMainA);
        roomMap.addRoom(hallwayMainB);
        roomMap.addRoom(hallwayMainC);
        roomMap.addRoom(hallwayMainD);
        roomMap.addRoom(hallwayMainE);
        roomMap.addRoom(hallwayMainF);
        roomMap.addRoom(hallwayMainG); //7

        roomMap.addRoom(hallwayLowerWestA);
        roomMap.addRoom(hallwayLowerWestB);
        roomMap.addRoom(hallwayUpperWestA);
        roomMap.addRoom(hallwayUpperWestB); //11

        roomMap.addRoom(hallwayLowerEastA);
        roomMap.addRoom(hallwayLowerEastB);
        roomMap.addRoom(hallwayLowerEastC);
        roomMap.addRoom(hallwayLowerEastD);
        roomMap.addRoom(hallwayUpperEastA);
        roomMap.addRoom(hallwayUpperEastB);
        roomMap.addRoom(hallwayUpperEastC);
        roomMap.addRoom(hallwayUpperEastD); //19

        roomMap.addRoom(kitchen);
        roomMap.addRoom(pantry); //21

        roomMap.addRoom(lounge); //22

        roomMap.addRoom(masterBed);
        roomMap.addRoom(servantBedA);
        roomMap.addRoom(servantBedB);
        roomMap.addRoom(servantBedC); //26

        roomMap.addRoom(study); //27

        roomMap.addRoom(westLibrary);
        roomMap.addRoom(eastLibrary); //29

        roomMap.addRoom(yard);
        roomMap.addRoom(westYard);
        roomMap.addRoom(eastYard); //32

        roomMap.addRoom(eastDiningroom);
        roomMap.addRoom(westDiningroom); //34

        roomMap.addRoom(secretRoom);
        roomMap.addRoom(eastWC);
        roomMap.addRoom(westWC); //37
        roomMap.addRoom(boiler);//38

        //      adding items to rooms
        kitchen.addItemToRoom(knife);
        kitchen.addItemToRoom(silverware);
        eastYard.addItemToRoom(shovel);
        pantry.addItemToRoom(food);
        servantBedB.addItemToRoom(goldKey);
        masterBed.addItemToRoom(book);

        //      placing obstacles
        yard.addObstacleToRoom(debris, "NORTH");
        yard.setHasObstacle(true);
        yard.setObstacleDescription(Descriptions.ROOM_YARD_OBSTACLE);
        
        eastLibrary.addObstacleToRoom(bookshelf, "NORTH");
        eastLibrary.setHasObstacle(true);
        eastLibrary.setObstacleDescription(Descriptions.OBSTACLE_BOOKSHELF_DESCRIPTION);
        
        hallwayUpperWestB.addObstacleToRoom(oakDoor, "SOUTH");
        hallwayUpperWestB.setHasObstacle(true);
        hallwayUpperWestB.setObstacleDescription(Descriptions.OBSTACLE_OAKDOOR_DESCRIPTION);
        

        //  Game initialization
        //      Setting default start position
        yard.setHasPlayer(true);
        currentRoom = yard;

        //      loading progress from previous run
        if (previousGame) {
            yard.setHasPlayer(false);
            currentRoom = CurrentRoomToXml.loadObject("currentRoom.xml");
            BackpackToXml.loadObject("backpack.xml", backpack);
            AllRoomsToXml.loadObject("allRooms.xml", roomMap);

        }

        //      adding player input scanner
        String playerInput;
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        //      First message to player. UI starts here.
        System.out.println("                -----------------------| Welcome! |-----------------------");
        System.out.println("                                  If you are unsure of                   ");
        System.out.println("                where to start, type --> 'Help' <-- to see a detailed list");
        System.out.println("                                 of available commands.                  ");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        if (!previousGame) {

            try {
                printIntro(aaa);
                printIntro(bbb);
                printIntro(ccc);
                printIntro(ddd);
                System.out.println("");
                printIntro(eee);
                printIntro(fff);
                printIntro(ggg);
                printIntro(hhh);
                printIntro(iii);

                printIntro(jjj);
                printIntro(kkk);
                printIntro(lll);
                System.out.println("");
                printIntro(mmm);
                printIntro(nnn);
                System.out.println("");
                printIntro(ooo);
                printIntro(ppp);
                printIntro(qqq);
                System.out.println("");
                printIntro(rrr);
                System.out.println("");
                System.out.println("");
                System.out.println("");
                printIntro(sss);
            } catch (InterruptedException e) {

            }

        } else {
        }

        while (!exit) {

            do {

                try {
                    findExits(false, roomMap.findRoom(currentRoom));
                } catch (RoomNotFoundException ex) {
                }

                System.out.println("");
                printRoomDescription();
                System.out.println("What would you like to do? ");

                try {
                    playerInput = sc.nextLine().toUpperCase();
                    System.out.println("-----" + playerInput + "-----");

                    switch (playerInput) {
                        case "USE":
                            tryUse();
                            break;
                        case "LOOK":
                            currentRoom.setHint(true);
                            try {
                                findExits(true, roomMap.findRoom(currentRoom));
                            } catch (RoomNotFoundException ex) {
                            }
                            break;
                        case "DROP":
                            tryDropItem();
                            break;
                        case "EMPTY BAG":
                            emptyBag();
                            break;
                        case "INSPECT":
                            inspectItem();
                            break;
                        case "BAG":
                            backpack.printBackpackContents();
                            break;
                        case "TAKE":
                            tryPickUpItem();
                            break;
                        case "NORTH":
                            tryExit(playerInput);
                            break;
                        case "N":
                            tryExit("NORTH");
                            break;
                        case "LOOK NORTH":
                            lookInDirection(playerInput);
                            break;
                        case "WEST":
                            tryExit(playerInput);
                            break;
                        case "W":
                            tryExit("WEST");
                            break;
                        case "LOOK WEST":
                            lookInDirection(playerInput);
                            break;
                        case "EAST":
                            tryExit(playerInput);
                            break;
                        case "E":
                            tryExit("EAST");
                            break;
                        case "LOOK EAST":
                            lookInDirection(playerInput);
                            break;
                        case "SOUTH":
                            tryExit(playerInput);
                            break;
                        case "S":
                            tryExit("SOUTH");
                            break;
                        case "LOOK SOUTH":
                            lookInDirection(playerInput);
                            break;
                        case "HELP":
                            printHelpText();
                            break;
                        case "EXIT":

                            AllRoomsToXml.saveObject("allRooms.xml", roomMap);
                            BackpackToXml.saveObject("backpack.xml", backpack);
                            CurrentRoomToXml.saveObject("currentRoom.xml", currentRoom);
                            System.out.println("Goodbye!");
                            exit = true;
                            break;
                        default:
                            System.out.println("Possible commands are: 'Help', 'North', 'West', 'East', 'South', 'Look <direction>', 'Inspect', 'Use', 'Bag', 'Take', 'Drop', 'Empty bag' and 'Exit'");
                            break;
                    }

                } catch (InputMismatchException ime) {
                    System.out.println("Strange Input");
                    sc.nextLine();
                }

            } while (!exit);
        }

    }

    public void printIntro(String string) throws InterruptedException {

        for (int i = 0; i < string.length() + 1; i++) {

            System.out.print(string.substring(0, i) + "\r");
            Thread.sleep(25);

        }
        System.out.println("");

    }

    public void printHelpText() {
        System.out.println("--Possible commands--");
        System.out.println("'Look <direction>', 'Help', 'North', 'West', 'East', 'South', 'Inspect', 'Use', 'Bag', 'Take', 'Drop', 'Empty bag' and 'Exit'");
        System.out.println("--Look--");
        System.out.println("Lists possible exits and may uncover more information about your surroundings.");
        System.out.println("--Help--");
        System.out.println("Shows this list.");
        System.out.println("--North, West, East or South--");
        System.out.println("Will attempt to move you in that direction.");
        System.out.println("--Inspect--");
        System.out.println("Inspect an item in your bag.");
        System.out.println("--Use--");
        System.out.println("Attempt to use an item from your bag.");
        System.out.println("--Bag--");
        System.out.println("Lists all items in your bag.");
        System.out.println("--Take--");
        System.out.println("Attemp to pick something up from the room you are in.");
        System.out.println("--Drop--");
        System.out.println("Drop something from your bag.");
        System.out.println("--Empty bag--");
        System.out.println("Drop all items from your bag onto the floor of the current room.");
        System.out.println("--Exit--");
        System.out.println("Exit to main menu.");
    }

    public void lookInDirection(String direction) {
        switch (direction) {
            case "LOOK NORTH":
                if (!northOfCurrentRoom.equals("")) {
                    System.out.println("To the north lies the " + northOfCurrentRoom + ".");
                } else {
                    System.out.println("There is nothing to look at.");
                }
                break;
            case "LOOK WEST":
                if (!westOfCurrentRoom.equals("")) {
                    System.out.println("To the west lies the " + westOfCurrentRoom + ".");
                } else {
                    System.out.println("There is nothing to look at.");
                }
                break;
            case "LOOK EAST":
                if (!eastOfCurrentRoom.equals("")) {
                    System.out.println("To the east lies the " + eastOfCurrentRoom + ".");
                } else {
                    System.out.println("There is nothing to look at.");
                }
                break;
            case "LOOK SOUTH":
                if (!southOfCurrentRoom.equals("")) {
                    System.out.println("To the south lies the " + southOfCurrentRoom + ".");
                } else {
                    System.out.println("There is nothing to look at.");
                }
                break;
        }

    }

    public void printRoomDescription() {
        if (!currentRoom.getHint()) {
            System.out.println("You are in the " + currentRoom.getShortDescription() + ". " + currentRoom.getLongDescription());
            if (currentRoom.HasObstacle()) {
                System.out.println(currentRoom.getObstacleDescription() + currentRoom.getExitWithObstacle());
            } else {
                //Do nothing
            }

        } else {
            System.out.println("You are in the " + currentRoom.getShortDescription() + ". " + currentRoom.getLongDescriptionWithHint());
            if (currentRoom.HasObstacle()) {
                System.out.println(currentRoom.getObstacleDescription());
            } else {
                //Do nothing
            }
            if (!currentRoom.availableItemsIsEmpty()) {
                System.out.println("There are some items of interest here: ");
                currentRoom.printItemsInRoom();
            } else {
                //Do nothing
            }
        }

    }

    public void emptyBag() {
        if (backpack.backpackIsEmpty()) {
            System.out.println("There are no items to drop.");
        } else {
            for (int i = 0; i < backpack.getSize(); i++) {
                //System.out.println("DEBUG>>Adding: " + backpack.getItemFromBackpackIndex(i) + " to room.");
                currentRoom.addItemToRoom(backpack.getItemFromBackpackIndex(i));
            }
            for (int i = backpack.getSize() - 1; i > -1; i--) {
                //System.out.println("DEBUG>>Removing: " + backpack.getItemFromBackpackIndex(i) + " from bag.");
                backpack.removeItemFromBackpack(backpack.getItemFromBackpackIndex(i));
            }
            System.out.println("You empty all of the items in your bag on the floor of the " + currentRoom.getShortDescription());
        }
    }

    public void tryDropItem() {
        if (backpack.backpackIsEmpty()) {
            System.out.println("There are no items in your bag.");
        } else {
            boolean trying = true;
            String playerInput;
            Scanner sc = new Scanner(System.in);

            do {
                System.out.println("What do you want to drop?");
                playerInput = sc.nextLine().toUpperCase();
                System.out.println("-----" + playerInput + "-----");
                if (backpack.backpackContains(new Item(playerInput, "", ""))) {

                    try {
                        currentRoom.addItemToRoom(backpack.findItem(new Item(playerInput, "", "")));
                        backpack.removeItemFromBackpack(backpack.findItem(new Item(playerInput, "", "")));
                        System.out.println("You drop the " + playerInput);
                        trying = false;
                    } catch (RoomNotFoundException e) {
                        System.out.println("There is no item like that in your bag.");
                        trying = false;
                    }
                } else {
                    System.out.println("There is no " + playerInput + " in your bag.");
                    trying = false;
                }

            } while (trying);
        }

    }

    public void tryPickUpItem() {
        boolean trying = true;
        String playerInput;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("What do you want to pick up?");
            playerInput = sc.nextLine().toUpperCase();
            System.out.println("-----" + playerInput + "-----");
            if (currentRoom.roomContainsItem(new Item(playerInput, "", ""))) {

                try {
                    backpack.addItemToBackpack(currentRoom.findItem(new Item(playerInput, "", "")));
                    currentRoom.removeItemFromRoom(currentRoom.findItem(new Item(playerInput, "", "")));
                    System.out.println("You pick up the " + playerInput);
                    trying = false;
                } catch (RoomNotFoundException e) {
                    System.out.println("There is no item like that in here.");
                    trying = false;
                }
            } else {
                System.out.println("You can not take the " + playerInput + ".");
                trying = false;
            }
        } while (trying);
    }

    public void inspectItem() {
        if (backpack.backpackIsEmpty()) {
            System.out.println("There are no items in your bag.");
        } else {
            boolean trying = true;
            String playerInput;
            Scanner sc = new Scanner(System.in);

            do {
                System.out.println("What do you want to look at?");
                playerInput = sc.nextLine().toUpperCase();
                System.out.println("-----" + playerInput + "-----");
                if (backpack.backpackContains(new Item(playerInput, "", ""))) {
                    try {
                        System.out.println(backpack.findItem(new Item(playerInput, "", "")).getDescription());
                        trying = false;
                    } catch (RoomNotFoundException e) {
                        System.out.println("You don't carry a " + playerInput);
                        trying = false;
                    }
                } else {
                    System.out.println("There is no " + playerInput + " here.");
                    trying = false;
                }
            } while (trying);
        }
    }

    public void findExits(boolean playerAsks, Room currentRoom) throws RoomNotFoundException {

        northOfCurrentRoom = "";
        eastOfCurrentRoom = "";
        westOfCurrentRoom = "";
        southOfCurrentRoom = "";

        String[] array = new String[4];

        Room tryNorth = new Room(0, "", "", "", currentRoom.getPosX(), currentRoom.getPosY() - 1);
        Room tryWest = new Room(0, "", "", "", currentRoom.getPosX() - 1, currentRoom.getPosY());
        Room tryEast = new Room(0, "", "", "", currentRoom.getPosX() + 1, currentRoom.getPosY());
        Room trySouth = new Room(0, "", "", "", currentRoom.getPosX(), currentRoom.getPosY() + 1);

        Room currentSearch;

        try {
            currentSearch = roomMap.findRoom(tryNorth);
            northOfCurrentRoom = currentSearch.getShortDescription();
            //System.out.println("DEBUG>>kollar norr");
        } catch (RoomNotFoundException ex) {
        }
        try {
            currentSearch = roomMap.findRoom(tryWest);
            westOfCurrentRoom = currentSearch.getShortDescription();
            //System.out.println("DEBUG>>kollar väster");
        } catch (RoomNotFoundException ex) {
        }
        try {
            currentSearch = roomMap.findRoom(tryEast);
            eastOfCurrentRoom = currentSearch.getShortDescription();
            //System.out.println("DEBUG>>kollar öster");
        } catch (RoomNotFoundException ex) {
        }
        try {
            currentSearch = roomMap.findRoom(trySouth);
            southOfCurrentRoom = currentSearch.getShortDescription();
            //System.out.println("DEBUG>>kollar söder");
        } catch (RoomNotFoundException ex) {
        }

        if (playerAsks) {
            System.out.println("Available exits are: ");
            if (!northOfCurrentRoom.equals("")) {
                System.out.println("North");
            }
            if (!westOfCurrentRoom.equals("")) {
                System.out.println("West");
            }
            if (!eastOfCurrentRoom.equals("")) {
                System.out.println("East");
            }
            if (!southOfCurrentRoom.equals("")) {
                System.out.println("South");
            }
        }

        throw new RoomNotFoundException();
    }

    public void tryUse() {
        if (backpack.backpackIsEmpty()) {
            System.out.println("Your backpack is empty. No items to use.");
        } else {
            boolean trying = true;
            boolean trying2 = true;
            String playerInput;
            Scanner sc = new Scanner(System.in);
            Item toolToUse = new Item("", "", "");
            Obstacle obstacleToDestroy = new Obstacle("", "", "", "");

            do {
                System.out.println("What item do you want to use?");
                playerInput = sc.nextLine().toUpperCase();
                System.out.println("-----" + playerInput + "-----");
                if (backpack.backpackContains(new Item(playerInput, "", ""))) {
                    try {
                        toolToUse = backpack.findItem(new Item(playerInput, "", ""));
                    } catch (RoomNotFoundException e) {
                        System.out.println("This shouldn't happen. NotFound-check done earlier in block.");
                    }
                    do {
                        System.out.println("What do you want to use it with?");
                        playerInput = sc.nextLine().toUpperCase();
                        System.out.println("-----" + playerInput + "-----");
                        if (currentRoom.getAvailableObstacles().contains(new Obstacle(playerInput, "", "", ""))) {
                            try {
                                obstacleToDestroy = currentRoom.findObstacle(new Obstacle(playerInput, "", "", ""));
                            } catch (RoomNotFoundException ex) {
                                System.out.println("Couldn't set obstacleToDestroy-variable");
                            }
                            if (obstacleToDestroy.usedToolMatchesRequiredTool(toolToUse.getName())) {
                                System.out.println(obstacleToDestroy.getRemoveDescription());
                                currentRoom.removeObstacleFromRoom(obstacleToDestroy);
                                currentRoom.setExitWithObstacle("");
                                currentRoom.setHasObstacle(false);
                            } else {
                                System.out.println("You can not use this item to do that.");
                            }

                            trying = false;
                            trying2 = false;
                        } else {
                            System.out.println("There is no such thing here.");
                            trying = false;
                            trying2 = false;
                        }
                    } while (trying2);
                } else {
                    System.out.println("You do not carry a " + playerInput + ".");
                    trying = false;
                }

            } while (trying);

        }

    }

    public void tryExit(String directionToTry) {

        Room actualRoomNorthOfCurrentRoom = new Room(0, "", "", "", currentRoom.getPosX(), currentRoom.getPosY() - 1);
        Room actualRoomWestOfCurrentRoom = new Room(0, "", "", "", currentRoom.getPosX() - 1, currentRoom.getPosY());
        Room actualRoomEastOfCurrentRoom = new Room(0, "", "", "", currentRoom.getPosX() + 1, currentRoom.getPosY());
        Room actualRoomSouthOfCurrentRoom = new Room(0, "", "", "", currentRoom.getPosX(), currentRoom.getPosY() + 1);

        if (directionToTry.equals("NORTH")) {
            if (!northOfCurrentRoom.equals("")) {
                if (currentRoom.HasObstacle() && currentRoom.getExitWithObstacle().equals(directionToTry)) {
                    System.out.println(currentRoom.getObstacleDescription()+ currentRoom.getExitWithObstacle() +". You cannot go there.");
                } else {
                    currentRoom.setHasPlayer(false);
                    try {
                        currentRoom = roomMap.findRoom(actualRoomNorthOfCurrentRoom);
                    } catch (RoomNotFoundException ex) {
                    }
                    currentRoom.setHasPlayer(true);
                }
            } else {
                System.out.println("There is nothing there.");

            }
        }
        if (directionToTry.equals("WEST")) {
            if (!westOfCurrentRoom.equals("")) {
                if (currentRoom.HasObstacle() && currentRoom.getExitWithObstacle().equals(directionToTry)) {
                    System.out.println(currentRoom.getObstacleDescription() + "You cannot go there.");
                } else {
                    currentRoom.setHasPlayer(false);
                    try {
                        currentRoom = roomMap.findRoom(actualRoomWestOfCurrentRoom);
                    } catch (RoomNotFoundException ex) {
                    }
                    currentRoom.setHasPlayer(true);
                }
            } else {
                System.out.println("There is nothing there.");

            }
        }
        if (directionToTry.equals("EAST")) {
            if (!eastOfCurrentRoom.equals("")) {
                if (currentRoom.HasObstacle() && currentRoom.getExitWithObstacle().equals(directionToTry)) {
                    System.out.println(currentRoom.getObstacleDescription() + "You cannot go there.");
                } else {
                    currentRoom.setHasPlayer(false);
                    try {
                        currentRoom = roomMap.findRoom(actualRoomEastOfCurrentRoom);
                    } catch (RoomNotFoundException ex) {
                    }
                    currentRoom.setHasPlayer(true);
                }
            } else {
                System.out.println("There is nothing there.");

            }
        }
        if (directionToTry.equals("SOUTH")) {
            if (!southOfCurrentRoom.equals("")) {
                if (currentRoom.HasObstacle() && currentRoom.getExitWithObstacle().equals(directionToTry)) {
                    System.out.println(currentRoom.getObstacleDescription() + "You cannot go there.");
                } else {
                    currentRoom.setHasPlayer(false);
                    try {
                        currentRoom = roomMap.findRoom(actualRoomSouthOfCurrentRoom);
                    } catch (RoomNotFoundException ex) {
                    }
                    currentRoom.setHasPlayer(true);
                }
            } else {
                System.out.println("There is nothing there.");

            }
        }
    }

}
