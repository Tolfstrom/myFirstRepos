package textbased;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Room {

    private int id;
    private String shortDescription;
    private String longDescription;
    private String longDescriptionWithHint;
    private String obstacleDescription;
    private int posX;
    private int posY;
    private boolean hasPlayer;
    private boolean hint;
    private List<Item> availableItems = new ArrayList<>();
    private List<Obstacle> availableObstacles = new ArrayList<>();
    private String exitWithObstacle;
    private boolean hasObstacle;

    public Room() {

    }

    public Room(int id, String shortDesc, String longDesc, String longHint, int x, int y) {
        this.id = id;
        this.shortDescription = shortDesc;
        this.longDescription = longDesc;
        this.longDescriptionWithHint = longHint;
        this.posX = x;
        this.posY = y;
        this.hint = false;
        this.hasObstacle = false;

    }

    public boolean isHasPlayer() {
        return hasPlayer;
    }

    public boolean isHint() {
        return hint;
    }

    public boolean isHasObstacle() {
        return hasObstacle;
    }

    public boolean HasObstacle() {
        return hasObstacle;
    }

    @XmlElement
    public void setHasObstacle(boolean hasObstacle) {
        this.hasObstacle = hasObstacle;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @XmlElement
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    @XmlElement
    public void setLongDescriptionWithHint(String longDescriptionWithHint) {
        this.longDescriptionWithHint = longDescriptionWithHint;
    }
    
    @XmlElement
    public void setObstacleDescription(String obstacleDescription){
        this.obstacleDescription = obstacleDescription;
    }

    @XmlElement
    public void setPosX(int posX) {
        this.posX = posX;
    }

    @XmlElement
    public void setPosY(int posY) {
        this.posY = posY;
    }

    @XmlElement
    public void setAvailableItems(List<Item> availableItems) {
        this.availableItems = availableItems;
    }

    @XmlElement
    public void setAvailableObstacles(List<Obstacle> availableObstacles) {
        this.availableObstacles = availableObstacles;
    }

    @XmlElement
    public void setExitWithObstacle(String exitWithObstacle) {
        this.exitWithObstacle = exitWithObstacle;
    }

    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public Item findItem(Object obj) throws RoomNotFoundException {

        for (int i = 0; i < availableItems.size(); i++) {
            if (availableItems.get(i).equals(obj)) {
                return availableItems.get(i);
            }
        }
        throw new RoomNotFoundException();
    }

    public Obstacle findObstacle(Object obstacleName) throws RoomNotFoundException {

        for (int i = 0; i < availableObstacles.size(); i++) {
            if (availableObstacles.get(i).equals(obstacleName)) {
                return availableObstacles.get(i);
            }
        }
        throw new RoomNotFoundException();
    }

    public boolean roomContainsItem(Item item) {
        return availableItems.contains(item);
    }

    public void removeItemFromRoom(Item item) {
        availableItems.remove(item);
    }

    public boolean availableItemsIsEmpty() {
        return availableItems.isEmpty();
    }

    public void addItemToRoom(Item newItem) {
        availableItems.add(newItem);
    }

    public void addObstacleToRoom(Obstacle newObstacle, String exitToPlaceObstacleAt) {
        availableObstacles.add(newObstacle);
        this.exitWithObstacle = exitToPlaceObstacleAt;
    }

    public boolean roomContainsObstacle(Obstacle obstacle) {
        return availableItems.contains(obstacle);
    }

    public void removeObstacleFromRoom(Obstacle obstacle) {
        availableItems.remove(obstacle);
    }

    public void printItemsInRoom() {
        Iterator<Item> it;
        it = availableItems.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public int getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getLongDescriptionWithHint() {
        return longDescriptionWithHint;
    }

    public String getObstacleDescription() {
        return obstacleDescription;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public boolean getHasPlayer() {
        return hasPlayer;
    }

    public String getExitWithObstacle() {
        return exitWithObstacle;
    }

    public List<Obstacle> getAvailableObstacles() {
        return availableObstacles;
    }

    @XmlElement
    public void setHasPlayer(boolean bool) {
        this.hasPlayer = bool;
    }

    @XmlElement
    public void setHint(boolean bool) {
        this.hint = bool;
    }

    public boolean getHint() {
        return hint;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (this.posX != other.posX) {
            return false;
        }
        if (this.posY != other.posY) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        return hash;
    }

}
