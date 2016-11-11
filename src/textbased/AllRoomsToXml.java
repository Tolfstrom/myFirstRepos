package textbased;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class AllRoomsToXml {

    public AllRoomsToXml() {

    }

    public static void saveObject(String filename, RoomMap roomMap) {

        try {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(RoomMap.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(roomMap, file);
//DEBUG>>   jaxbMarshaller.marshal(backpack, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void loadObject(String filename, RoomMap roomMap) {
        try {

            File file = new File(filename);

            JAXBContext jaxbContext = JAXBContext.newInstance(RoomMap.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            RoomMap rooms = (RoomMap) jaxbUnmarshaller.unmarshal(file);
            
            
            
            roomMap.removeAllRooms();
            for (Room room : rooms.getRoomMap()) {
                roomMap.addRoom(room);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
