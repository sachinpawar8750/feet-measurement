package com.app.quantitymeasurement.repository;

import com.app.quantitymeasurement.entity.QuantityMeasurementEntity;

import java.util.List;

/**
 * Repository interface for QuantityMeasurementEntity data access operations.
 * Designed per Interface Segregation Principle to allow different implementations
 * (in-memory cache, database, etc.) without affecting the service layer.
 */
public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> findAll();
}
