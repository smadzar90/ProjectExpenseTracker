package org.example.model;

import java.util.HashSet;
import java.util.Set;

public class Category {
    private Long id;
    private String name;
    private String description;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
