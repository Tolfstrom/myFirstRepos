package textbased;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "roomMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoomMap {

    @XmlElement
    List<Room> roomMap = new ArrayList<>();

    public RoomMap() {

    }

    public List<Room> getRoomMap() {
        return roomMap;
    }

    public void removeAllRooms() {
        roomMap.removeAll(roomMap);

    }

    public void setRoomMap(List<Room> roomMap) {
        this.roomMap = roomMap;
    }

    public void addRoom(Room room) {
        roomMap.add(room);

    }

    public Room findRoom(Object obj) throws RoomNotFoundException {

        for (int i = 0; i < roomMap.size(); i++) {
            if (roomMap.get(i).equals(obj)) {
                return roomMap.get(i);
            }

        }
        throw new RoomNotFoundException();

    }

    public int getSize() {
        return roomMap.size();
    }

//    public Room findRoom(Room room){
//        
//    }
}
