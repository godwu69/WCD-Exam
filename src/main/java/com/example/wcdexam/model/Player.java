package com.example.wcdexam.model;

public class Player {
    private int id;
    private String name;
    private int age;
    private String indexName;
    private float indexValue;

    // Constructor, getters, and setters
    public Player(int id, String name, int age, String indexName, float indexValue) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.indexName = indexName;
        this.indexValue = indexValue;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getIndexName() { return indexName; }
    public float getIndexValue() { return indexValue; }
}
