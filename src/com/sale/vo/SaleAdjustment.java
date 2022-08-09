package com.sale.vo;

public class SaleAdjustment extends Sale{

	private SaleOperation adjustmentOperation;

	public SaleOperation getAdjustmentOperation() {
		return adjustmentOperation;
	}

	public void setAdjustmentOperation(SaleOperation adjustmentOperation) {
		this.adjustmentOperation = adjustmentOperation;
	}
	
}
