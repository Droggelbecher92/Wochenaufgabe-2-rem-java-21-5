package model;

import java.util.UUID;

public class UUIDProduct {

    private String id;
    private String name;

    public UUIDProduct(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
