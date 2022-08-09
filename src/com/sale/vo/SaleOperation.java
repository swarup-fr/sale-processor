package com.sale.vo;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public enum SaleOperation implements BiFunction<BigDecimal, BigDecimal, BigDecimal> {
	
    ADD((a, b) -> a.add(b)),
    SUBTRACT((a, b) -> a.subtract(b)),
    MULTIPLY((a, b) -> a.multiply(b));
	
	private final BiFunction<BigDecimal, BigDecimal, BigDecimal> operation;
	
	SaleOperation(BiFunction<BigDecimal, BigDecimal, BigDecimal> operation) {
        this.operation = operation;
    }

	@Override
	public BigDecimal apply(BigDecimal a, BigDecimal b) {
		return operation.apply(a, b);
	}
	
}
