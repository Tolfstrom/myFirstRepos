/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textbased;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
public class Obstacle {

    private String name;
    private String description;
    private String removeDescription;
    private String requiredTool;

    public Obstacle() {

    }

    public Obstacle(String name, String description, String removeDescription, String requiredTool) {
        this.name = name;
        this.description = description;
        this.removeDescription = removeDescription;
        this.requiredTool = requiredTool;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRemoveDescription(String removeDescription) {
        this.removeDescription = removeDescription;
    }

    public void setRequiredTool(String requiredTool) {
        this.requiredTool = requiredTool;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getRemoveDescription() {
        return this.removeDescription;
    }

    public String getRequiredTool() {
        return this.requiredTool;
    }

    public boolean usedToolMatchesRequiredTool(String usedTool) {
        if (!usedTool.equals(requiredTool)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Obstacle other = (Obstacle) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    


}
