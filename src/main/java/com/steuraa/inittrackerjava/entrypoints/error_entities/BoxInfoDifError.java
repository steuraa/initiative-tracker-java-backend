package com.steuraa.inittrackerjava.entrypoints.error_entities;

public class BoxInfoDifError {
    private Integer gross;
    private Integer currentGross;

    private Integer net;
    private Integer currentNet;

    public BoxInfoDifError() {
    }

    public BoxInfoDifError(Integer gross, Integer currentGross, Integer net, Integer currentNet) {
        this.gross = gross;
        this.currentGross = currentGross;
        this.net = net;
        this.currentNet = currentNet;
    }

    public Integer getGross() {
        return gross;
    }

    public void setGross(Integer gross) {
        this.gross = gross;
    }

    public Integer getCurrentGross() {
        return currentGross;
    }

    public void setCurrentGross(Integer currentGross) {
        this.currentGross = currentGross;
    }

    public Integer getNet() {
        return net;
    }

    public void setNet(Integer net) {
        this.net = net;
    }

    public Integer getCurrentNet() {
        return currentNet;
    }

    public void setCurrentNet(Integer currentNet) {
        this.currentNet = currentNet;
    }
}
