package org.smartregister.path.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jason Rogena - jrogena@ona.io on 15/06/2017.
 */

public class Tally implements Serializable {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private Hia2Indicator indicator;
    @JsonProperty
    private long id;
    @JsonProperty
    private String value;
    @JsonProperty
    private String providerId;
    @JsonProperty
    private Date updatedAt;


    @JsonProperty
    private Date createdAt;

    public Tally() {
    }

    public Hia2Indicator getIndicator() {
        return indicator;
    }

    public void setIndicator(Hia2Indicator indicator) {
        this.indicator = indicator;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ReportHia2Indicator getReportHia2Indicator() throws Exception {
        ReportHia2Indicator reportHia2Indicator = new ReportHia2Indicator();
        reportHia2Indicator.setValue(value);
        reportHia2Indicator.setProviderId(providerId);
        reportHia2Indicator.setCreatedAt(createdAt != null ? DATE_FORMAT.format(createdAt) : null);
        reportHia2Indicator.setUpdatedAt(updatedAt != null ? DATE_FORMAT.format(updatedAt) : null);
        reportHia2Indicator.setHia2Indicator(indicator);
        return reportHia2Indicator;
    }

    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof Tally) {
            Tally tally = (Tally) o;
            if (getIndicator().getDhisId().equals(tally.getIndicator().getDhisId())) {
                return true;
            }
        }
        return false;
    }
}
