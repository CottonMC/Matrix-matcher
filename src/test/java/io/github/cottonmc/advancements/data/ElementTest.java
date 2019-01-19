package io.github.cottonmc.advancements.data;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ElementTest {
    Element<String> element;

    @BeforeEach
    void setUp() {
        element = new Element<>("element");
        element.addVariant("variant1");
        element.addVariant("variant2");
    }

    @Test
    @DisplayName("An element that should be matched is valid")
    void test() {
        assertTrue(element.getmatcher().match("variant1"));
    }

    @Test
    @DisplayName("An element that should not be matched is invalid")
    void test2() {
        assertFalse(element.getmatcher().match("invalid"));
    }

    @Test
    @DisplayName("If we matched an element, than only that element can be valid")
    void onlyTheFirstmatchedElementISValid() {
        assertTrue(element.getmatcher().match("variant1"));
        assertFalse(element.getmatcher().match("variant2"));
    }
    @Test
    @DisplayName("If we matched an element, than that element can be matched again.")
    void test3() {
        assertTrue(element.getmatcher().match("variant1"));
        assertTrue(element.getmatcher().match("variant1"));
    }

    @Test
    @DisplayName("the element's name matches the matcher's name")
    void namesMatch() {
        assertEquals(element.getmatcher().getName(),element.getName());
    }
}