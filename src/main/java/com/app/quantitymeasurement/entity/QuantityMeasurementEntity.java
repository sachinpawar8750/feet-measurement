package com.app.quantitymeasurement.entity;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String operationType;
    private String operand1Value;
    private String operand1Unit;
    private String operand2Value;
    private String operand2Unit;
    private String resultValue;
    private String resultUnit;
    private String errorMessage;
    private boolean isError;

    public QuantityMeasurementEntity(String operationType,
                                     String operand1Value, String operand1Unit,
                                     String resultValue, String resultUnit) {
        this.operationType = operationType;
        this.operand1Value = operand1Value;
        this.operand1Unit = operand1Unit;
        this.resultValue = resultValue;
        this.resultUnit = resultUnit;
        this.isError = false;
    }

    public QuantityMeasurementEntity(String operationType,
                                     String operand1Value, String operand1Unit,
                                     String operand2Value, String operand2Unit,
                                     String resultValue, String resultUnit) {
        this.operationType = operationType;
        this.operand1Value = operand1Value;
        this.operand1Unit = operand1Unit;
        this.operand2Value = operand2Value;
        this.operand2Unit = operand2Unit;
        this.resultValue = resultValue;
        this.resultUnit = resultUnit;
        this.isError = false;
    }

    public QuantityMeasurementEntity(String operationType, String errorMessage) {
        this.operationType = operationType;
        this.errorMessage = errorMessage;
        this.isError = true;
    }

    public String getOperationType() { return operationType; }
    public String getOperand1Value() { return operand1Value; }
    public String getOperand1Unit() { return operand1Unit; }
    public String getOperand2Value() { return operand2Value; }
    public String getOperand2Unit() { return operand2Unit; }
    public String getResultValue() { return resultValue; }
    public String getResultUnit() { return resultUnit; }
    public String getErrorMessage() { return errorMessage; }
    public boolean isError() { return isError; }

    @Override
    public String toString() {
        if (isError) {
            return String.format("Entity[op=%s, ERROR=%s]", operationType, errorMessage);
        }
        return String.format("Entity[op=%s, %s %s op %s %s => %s %s]",
                operationType, operand1Value, operand1Unit,
                operand2Value, operand2Unit, resultValue, resultUnit);
    }
}
