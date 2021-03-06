package io.zucchiniui.backend.scenario.rest;

import io.zucchiniui.backend.scenario.domain.ScenarioStatus;

public class UpdateScenarioRequest {

    private ScenarioStatus status;

    private Boolean reviewed;

    private String analyseResult;

    private String analyseAction;

    public ScenarioStatus getStatus() {
        return status;
    }

    public void setStatus(final ScenarioStatus status) {
        this.status = status;
    }

    public Boolean isReviewed() {
        return reviewed;
    }

    public void setReviewed(final Boolean reviewed) {
        this.reviewed = reviewed;
    }

    public Boolean getReviewed() {
        return reviewed;
    }

    public String getAnalyseResult() {
        return analyseResult;
    }

    public void setAnalyseResult(String analyseResult) {
        this.analyseResult = analyseResult;
    }

    public String getAnalyseAction() {
        return analyseAction;
    }

    public void setAnalyseAction(String analyseAction) {
        this.analyseAction = analyseAction;
    }
}
