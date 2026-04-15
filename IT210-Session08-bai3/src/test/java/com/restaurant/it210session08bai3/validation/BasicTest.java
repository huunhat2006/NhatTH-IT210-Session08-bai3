package com.restaurant.it210session08bai3.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicTest {

    @Test
    void testBasicAssertion() {
        assertTrue(true, "Basic test should pass");
    }

    @Test
    void testValidatorInstantiation() {
        MultipleOfTenThousandValidator validator = new MultipleOfTenThousandValidator();
        assertNotNull(validator, "Validator should be instantiable");
    }

    @Test
    void testValidatorLogic() {
        MultipleOfTenThousandValidator validator = new MultipleOfTenThousandValidator();
        validator.initialize(null);
        
        // Test the core logic
        assertTrue(validator.isValid(50000L, null), "50000 should be valid");
        assertFalse(validator.isValid(40000L, null), "40000 should be invalid");
    }
}
