package com.github.funthomas424242.example.bookshop;

/*-
 * #%L
 * makeiteasy Example
 * %%
 * Copyright (C) 2018 - 2019 PIUG
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import com.natpryce.makeiteasy.Maker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

import static com.github.funthomas424242.example.bookshop.PersonMaker.*;
import static com.natpryce.makeiteasy.MakeItEasy.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    Person person;

    @BeforeEach
    void setUpTestfall() {
        person = new Person("Thomas", "Schubert",
                1968, 12, 25);
    }


    @Test
    void initAlterAufNull() {
        assertEquals(0, person.alter);
    }

    @Test
    void invalidInitializedMustermannAlterIs0() {
        Maker<Person> maxMaker = an(MUSTERMANN, with(PROP_NAME, "Verne"));
        Person max = make(maxMaker);
        assertEquals("Max", max.vorname);
        assertEquals("Verne", max.name);
        assertEquals(0, max.alter);
        max.berechneAlter();
        assertEquals(Period.between(max.geburtstag, LocalDate.now()).getYears(), max.alter);

    }
 @Test
    void invalidInitializedMusterfrauAlterIs0() {
        Maker<Person> maxiMaker = an(MUSTERFRAU, with(PROP_NAME, "Verne"), with(PROP_GEBURTSJAHR, 1991));
        Person maxi = make(maxiMaker);
        assertEquals("Maxi", maxi.vorname);
        assertEquals("Verne", maxi.name);
        final int alterHeute = Period.between(maxi.geburtstag, LocalDate.now()).getYears();

        // Beweis: war schon berechnet
        assertEquals(alterHeute, maxi.alter);
        // Beweis Neuberechnung führt zum gleichen Ergebnis
        maxi.berechneAlter();
        assertEquals(alterHeute, maxi.alter);

    }

    @Test
    void berechneAlterKorrekt() {
        final int alter = Period.between(person.geburtstag, LocalDate.now()).getYears();
        person.berechneAlter();
        assertEquals(alter, person.alter);
    }


}
