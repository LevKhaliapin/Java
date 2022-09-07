

package com.company;

import java.util.List;

public class Programmer {
    private String name;
    private List<String> skills;

    public Programmer(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return name + ' ' + skills;
    }
}