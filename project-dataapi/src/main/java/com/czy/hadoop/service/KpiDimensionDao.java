package com.czy.hadoop.service;

import com.beifeng.ae.model.KpiDimension;

public interface KpiDimensionDao {
    public KpiDimension getKpiDimension(KpiDimension kpi);

    public KpiDimension getKpiDimension(String name);

    public KpiDimension getKpiDimension(int id);
}