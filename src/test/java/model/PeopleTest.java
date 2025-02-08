package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class PeopleTest {
    private People people;
    private LocalDate birthdayDate;

    @BeforeEach
    public void setUp() {
        birthdayDate = LocalDate.of(1990, 5, 15);
        people = new People("João", birthdayDate);
    }

    @Test
    public void shouldGetPeopleName() {
        assertEquals("João", people.getName());
    }

    @Test
    public void shouldGetPeopleBirthdayDate() {
        assertEquals(birthdayDate, people.getBirthdayDate());
    }

    @Test
    public void shouldSetPeopleName() {
        people.setName("Maria");
        assertEquals("Maria", people.getName());
    }

    @Test
    public void shouldSetBirthdayDate() {
        LocalDate novaBirthdayDate = LocalDate.of(2000, 10, 20);
        people.setBirthdayDate(novaBirthdayDate);

        assertEquals(novaBirthdayDate, people.getBirthdayDate());
    }

    @Test
    void shouldReturnFormatedStringDate() {
        assertEquals("15/05/1990", people.getFormatedBirthdayDate());
    }
}