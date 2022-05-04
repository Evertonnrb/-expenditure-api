package com.expenditure.domain.enuns;

public enum Category {
    FOOD("food"),
    HOUSING("housing"),
    HEALTH("health"),
    LEISURE("leisure"),
    STUDY("study"),
    OTHER("other");

    Category(String category) {
        this.category = category;
    }

    private String category;

    public String getCategory() {
        return category;
    }


}
