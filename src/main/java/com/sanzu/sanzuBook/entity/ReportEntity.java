package com.sanzu.sanzuBook.entity;

public class ReportEntity {
    private Integer id;
    private String whistleblower;
    private String ReportedPerson;
    private String at_create;
    private String context;
    private String reason;
    private boolean isDeal;

    public ReportEntity() {
    }

    public boolean isDeal() {
        return isDeal;
    }

    public void setDeal(boolean deal) {
        isDeal = deal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhistleblower() {
        return whistleblower;
    }

    public void setWhistleblower(String whistleblower) {
        this.whistleblower = whistleblower;
    }

    public String getReportedPerson() {
        return ReportedPerson;
    }

    public void setReportedPerson(String reportedPerson) {
        ReportedPerson = reportedPerson;
    }

    public String getAt_create() {
        return at_create;
    }

    public void setAt_create(String at_create) {
        this.at_create = at_create;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "ReportEntity{" +
                "id=" + id +
                ", whistleblower='" + whistleblower + '\'' +
                ", ReportedPerson='" + ReportedPerson + '\'' +
                ", at_create='" + at_create + '\'' +
                ", context='" + context + '\'' +
                ", reason='" + reason + '\'' +
                ", isDeal=" + isDeal +
                '}';
    }
}
