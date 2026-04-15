package com.restaurant.it210session08bai3.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfTenThousandValidator
        implements ConstraintValidator<MultipleOfTenThousand, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        if (value < 50000) {
            return false;
        }

        if (value % 10000 != 0) {
            return false;
        }

        return true;
    }
}

//PHẦN 1 — PHÂN TÍCH & THIẾT KẾ
//1. Input / Output
//Input:
//withdrawAmount: kiểu Long (hoặc Integer)
//Có thể nhận:null
//số âm
//số không chia hết cho 10.000
//Output:
//Hợp lệ → pass validation
//Không hợp lệ → trả message lỗi
//2. Giải pháp
//không viết if-else trong Controller
//Tạo Custom Annotation:
//@MultipleOfTenThousand
//→ Gắn vào DTO
//→ Spring tự validate khi có @Valid