package org.oregami.entities;

import javax.persistence.Entity;

@Entity
public class ReleaseGroupType extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return this.name;
    }

    public ReleaseGroupType() {
    }

    public ReleaseGroupType(String name) {
        this.name = name;
    }
    
    private String description;

    public String getDescription() {
        return description;
    }

}
