/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbased;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author User
 */
public class CurrentRoomToXml {

    public CurrentRoomToXml() {

    }

    public static void saveObject(String filename, Room currentRoom) {

        try {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(Room.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(currentRoom, file);
//DEBUG>>   jaxbMarshaller.marshal(backpack, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static Room loadObject(String filename) {
        try {

            File file = new File(filename);

            JAXBContext jaxbContext = JAXBContext.newInstance(Room.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Room room = (Room) jaxbUnmarshaller.unmarshal(file);

            return room;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
