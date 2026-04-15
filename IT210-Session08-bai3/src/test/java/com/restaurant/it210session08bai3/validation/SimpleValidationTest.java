package com.restaurant.it210session08bai3.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleValidationTest {

    @Test
    void testBasicValidation() {
        // Test the validator directly without the full validation framework
        MultipleOfTenThousandValidator validator = new MultipleOfTenThousandValidator();
        
        // Initialize the validator with default annotation values
        validator.initialize(null);
        
        // Test valid cases
        assertTrue(validator.isValid(50000L, null), "50000 should be valid");
        assertTrue(validator.isValid(100000L, null), "100000 should be valid");
        assertTrue(validator.isValid(150000L, null), "150000 should be valid");
        
        // Test invalid cases
        assertFalse(validator.isValid(40000L, null), "40000 should be invalid");
        assertFalse(validator.isValid(55000L, null), "55000 should be invalid");
        assertFalse(validator.isValid(90000L, null), "90000 should be invalid");
        assertFalse(validator.isValid(-50000L, null), "-50000 should be invalid");
        
        // Test null case (should be valid according to Bean Validation best practices)
        assertTrue(validator.isValid(null, null), "null should be valid");
    }
}
