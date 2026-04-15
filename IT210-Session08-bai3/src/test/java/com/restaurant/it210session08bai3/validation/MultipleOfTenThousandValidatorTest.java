package com.restaurant.it210session08bai3.validation;

import com.restaurant.it210session08bai3.dto.WithdrawRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MultipleOfTenThousandValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testValidWithdrawalAmount() {
        WithdrawRequest request = new WithdrawRequest(50000L, "123456789", "VCB");
        
        Set<ConstraintViolation<WithdrawRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty(), "50000 should be valid");
    }

    @Test
    void testValidMultipleOfTenThousand() {
        WithdrawRequest request = new WithdrawRequest(150000L, "123456789", "VCB");
        
        Set<ConstraintViolation<WithdrawRequest>> violations = validator.validate(request);
        assertTrue(violations.isEmpty(), "150000 should be valid");
    }

    @Test
    void testInvalidAmountBelowMinimum() {
        WithdrawRequest request = new WithdrawRequest(40000L, "123456789", "VCB");
        
        Set<ConstraintViolation<WithdrawRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "40000 should be invalid");
        
        ConstraintViolation<WithdrawRequest> violation = violations.iterator().next();
        assertTrue(violation.getMessage().contains("50.000"));
    }

    @Test
    void testInvalidNotMultipleOfTenThousand() {
        WithdrawRequest request = new WithdrawRequest(55000L, "123456789", "VCB");
        
        Set<ConstraintViolation<WithdrawRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "55000 should be invalid");
        
        ConstraintViolation<WithdrawRequest> violation = violations.iterator().next();
        assertTrue(violation.getMessage().contains("bội số"));
    }

    @Test
    void testNullAmount() {
        WithdrawRequest request = new WithdrawRequest(null, "123456789", "VCB");
        
        Set<ConstraintViolation<WithdrawRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "null amount should be invalid");
        
        ConstraintViolation<WithdrawRequest> violation = violations.iterator().next();
        assertTrue(violation.getMessage().contains("không được để trống"));
    }

    @Test
    void testNegativeAmount() {
        WithdrawRequest request = new WithdrawRequest(-50000L, "123456789", "VCB");
        
        Set<ConstraintViolation<WithdrawRequest>> violations = validator.validate(request);
        assertFalse(violations.isEmpty(), "negative amount should be invalid");
    }

    @Test
    void testEdgeCases() {
        // Test exactly 100000 (valid)
        WithdrawRequest request1 = new WithdrawRequest(100000L, "123456789", "VCB");
        Set<ConstraintViolation<WithdrawRequest>> violations1 = validator.validate(request1);
        assertTrue(violations1.isEmpty(), "100000 should be valid");

        // Test 90000 (invalid - not multiple of 10000)
        WithdrawRequest request2 = new WithdrawRequest(90000L, "123456789", "VCB");
        Set<ConstraintViolation<WithdrawRequest>> violations2 = validator.validate(request2);
        assertFalse(violations2.isEmpty(), "90000 should be invalid");
    }
}
