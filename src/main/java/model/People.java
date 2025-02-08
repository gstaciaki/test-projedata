package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class People {
    private String name;
    private LocalDate birthdayDate;

    public People(String name, LocalDate birthdayDate) {
        this.name = name;
        this.birthdayDate = birthdayDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public String getFormatedBirthdayDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return birthdayDate.format(formatter);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthdayDate(LocalDate birthdayDate) {
        this.birthdayDate = birthdayDate;
    }
}