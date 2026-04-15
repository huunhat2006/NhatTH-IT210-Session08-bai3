package com.restaurant.it210session08bai3.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = MultipleOfTenThousandValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MultipleOfTenThousand {

    String message() default "Số tiền phải >= 50.000 và là bội số của 10.000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}