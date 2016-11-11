package textbased;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Item {

    private String name;
    private String description;
    private String usableAt;

    public Item() {

    }

    public Item(String name, String description, String usableAt) {
        this.name = name.toUpperCase();
        this.description = description;
        this.usableAt = usableAt.toUpperCase();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public void setUsableAt(String usable) {
        this.usableAt = usable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUsableAt() {
        return usableAt;
    }

    @Override
    public String toString() {
        return "Item: " + name;
    }

    public boolean useItem(Room location, Item item) {
        //TODO: all logic
        return false;

    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
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
        final Item other = (Item) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
