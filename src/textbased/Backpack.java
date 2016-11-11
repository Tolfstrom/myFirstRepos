/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbased;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@XmlRootElement(name = "backpack")
@XmlAccessorType (XmlAccessType.FIELD)
public class Backpack {

    @XmlElement
    private List<Item> backpack = new ArrayList<>();

    public Backpack() {

    }

    public List<Item> getBackpack() {
        return backpack;
    }

    public Item getItemFromBackpackIndex(int i) {
        return backpack.get(i);
    }
    
    public void setBackpack(List<Item> backpack) {
        this.backpack = backpack;
    }

    public int getSize() {
        return backpack.size();
    }

    public boolean backpackIsEmpty() {
        return backpack.isEmpty();
    }

    public Item findItem(Object obj) throws RoomNotFoundException {

        for (int i = 0; i < backpack.size(); i++) {
            if (backpack.get(i).equals(obj)) {
                return backpack.get(i);
            }

        }
        throw new RoomNotFoundException();
    }

    public void printBackpackContents() {
        if (!backpack.isEmpty()) {
            for (int i = 0; i < backpack.size(); i++) {
                System.out.println("The content of your bag is: " + backpack.get(i));
            }
        } else {
            System.out.println("Your backpack is empty.");
        }
    }

    public void addItemToBackpack(Item item) {
        backpack.add(item);
    }

    public boolean backpackContains(Item item) {
        return backpack.contains(item);
    }

    public void removeItemFromBackpack(Item item) {
        if (backpack.contains(item)) {
            backpack.remove(item);
        } else {
            System.out.println("There's no " + item + " in your inventory.");
        }

    }
    
    public void removeItemAtIndex(int i){
        backpack.remove(i);
    }

}
