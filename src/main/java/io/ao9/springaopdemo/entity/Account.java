package io.ao9.springaopdemo.entity;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private String name;
    private String level;

    public Account() {
    }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", level='" + getLevel() + "'" +
            "}";
    }
}