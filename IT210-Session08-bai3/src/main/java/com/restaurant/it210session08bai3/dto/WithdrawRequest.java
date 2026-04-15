package com.restaurant.it210session08bai3.dto;

import com.restaurant.it210session08bai3.validation.MultipleOfTenThousand;
import jakarta.validation.constraints.NotNull;

public class WithdrawRequest {

    @NotNull(message = "Số tiền không được để trống")
    @MultipleOfTenThousand
    private Long withdrawAmount;

    public Long getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Long withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}