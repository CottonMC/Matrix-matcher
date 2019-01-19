package io.github.cottonmc.advancements.matrix;

import io.github.cottonmc.advancements.data.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    private Matrix<Integer, String> matrix;

    @BeforeEach
    void setUp() {
        RawMatrix<Integer, String> rawMatrix = new RawMatrix<>();
        Element<String> test = new Element<>("test");
        test.addVariant("test");
        rawMatrix.addElement(test,1);
        matrix = rawMatrix.build();
    }

    @Test
    @DisplayName("can match for a specific position")
    void test(){
        assertTrue(matrix.matches(1,"test"));
    }

    @Test
    @DisplayName("correct element in wrong position fails")
    void test2(){
        assertFalse(matrix.matches(2,"test"));
    }

    @Test
    @DisplayName("wrong element in an existing position fails")
    void test3(){
        assertFalse(matrix.matches(1,"test2"));
    }
}