/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbased;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author User
 */
public class BackpackToXml {

    public BackpackToXml() {

    }

    public static void saveObject(String filename, Backpack backpack) {

        try {
            File file = new File(filename);
            JAXBContext jaxbContext = JAXBContext.newInstance(Backpack.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(backpack, file);
//DEBUG>>   jaxbMarshaller.marshal(backpack, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void loadObject(String filename, Backpack backpack) {
        try {

            File file = new File(filename);
            
            JAXBContext jaxbContext = JAXBContext.newInstance(Backpack.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            
            Backpack bag = (Backpack) jaxbUnmarshaller.unmarshal(file);

            for (Item item : bag.getBackpack()) {
                backpack.addItemToBackpack(item);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

}
