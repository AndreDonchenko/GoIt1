package ua.goit.andre.ee10;

import com.google.gson.annotations.Expose;

/**
 * Created by Andre on 25.08.2016.
 */
public class Person {
    @Expose
    private String name;

    @Expose
    private String surname;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
