package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class AnimalTests {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void getFamilyIsCorrect() {
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        assertThat("Некорректный перечень семейств",
                new Animal().getFamily(),
                equalTo(expectedString)
        );
    }

    @Test
    public void getFoodThrowsException() {
        try {
            new Animal().getFood("");
        } catch (Exception e) {
            assertThat("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                    e.getMessage(),
                    equalTo("Неизвестный вид животного, используйте значение Травоядное или Хищник")
            );
        }
    }
}
