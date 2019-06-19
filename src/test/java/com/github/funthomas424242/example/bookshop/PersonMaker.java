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

import com.natpryce.makeiteasy.Instantiator;
import com.natpryce.makeiteasy.Property;
import com.natpryce.makeiteasy.PropertyLookup;

import static com.natpryce.makeiteasy.Property.newProperty;

public class PersonMaker {
    public static final Property<Person,Integer> alter = newProperty();

    public static final Property<Person,String> PROP_VORNAME = newProperty();
    public static final Property<Person,String> PROP_NAME = newProperty();
    public static final Property<Person,Integer> PROP_GEBURTSJAHR = newProperty();
    public static final Property<Person,Integer> PROP_GEBURTSMONAT = newProperty();
    public static final Property<Person,Integer> PROP_GEBURTSTAG = newProperty();


    public static final Instantiator<Person> MUSTERMANN = new Instantiator<Person>() {
        @Override public Person instantiate(PropertyLookup<Person> lookup) {
            Person person = new Person(
                    lookup.valueOf(PROP_VORNAME, "Max"),
                    lookup.valueOf(PROP_NAME, "Mustermann"),
                    lookup.valueOf(PROP_GEBURTSJAHR, 1999),
                    lookup.valueOf(PROP_GEBURTSMONAT, 3),
                    lookup.valueOf(PROP_GEBURTSTAG, 2)
            );
            return person;
        }
    };

    public static final Instantiator<Person> MUSTERFRAU = new Instantiator<Person>() {
        @Override public Person instantiate(PropertyLookup<Person> lookup) {
            Person person = new Person(
                    lookup.valueOf(PROP_VORNAME, "Maxi"),
                    lookup.valueOf(PROP_NAME, "Musterfrau"),
                    lookup.valueOf(PROP_GEBURTSJAHR, 1990),
                    lookup.valueOf(PROP_GEBURTSMONAT, 5),
                    lookup.valueOf(PROP_GEBURTSTAG, 6)
            );
            person.berechneAlter();
            return person;
        }
    };
}
