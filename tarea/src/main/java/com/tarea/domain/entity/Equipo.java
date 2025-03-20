package com.tarea.domain.entity;

import java.io.Serializable;

public class Equipo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String yearFoundation;
    private String coach;

    public Equipo() {}

    public Equipo(int id, String name, String yearFoundation, String coach) {
        this.id = id;
        this.name = name;
        this.yearFoundation = yearFoundation;
        this.coach = coach;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getYearFoundation() { return yearFoundation; }
    public String getCoach() { return coach; }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearFoundation='" + yearFoundation + '\'' +
                ", coach='" + coach + '\'' +
                '}';
    }
}
