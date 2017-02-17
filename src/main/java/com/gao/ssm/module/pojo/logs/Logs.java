package com.gao.ssm.module.pojo.logs;

import com.gao.ssm.module.tools.DateUtil;

import java.util.Date;

public class Logs {

    private String logId;

    private String logTitle;

    private String logSummary;

    private String logContent;

    private Date logCreated;
    private String logCreatedStr;

    private Date logUpdate;
    private String logUpdateStr;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle == null ? null : logTitle.trim();
    }

    public String getLogSummary() {
        return logSummary;
    }

    public void setLogSummary(String logSummary) {
        this.logSummary = logSummary == null ? null : logSummary.trim();
    }

    public String getLogContent() {
        return logContent;
    }

    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    public Date getLogCreated() {
        return logCreated;
    }

    public void setLogCreated(Date logCreated) {
        this.logCreated = logCreated;
    }

    public Date getLogUpdate() {
        return logUpdate;
    }

    public void setLogUpdate(Date logUpdate) {
        this.logUpdate = logUpdate;
    }

    public String getLogCreatedStr() {
        return logCreatedStr;
    }

    public void setLogCreatedStr(Date logCreated,String pattern) {
        this.logCreatedStr = DateUtil.format(logCreated,pattern);
    }

    public String getLogUpdateStr() {
        return logUpdateStr;
    }

    public void setLogUpdateStr(Date logCreated,String pattern) {
        this.logUpdateStr = DateUtil.format(logCreated,pattern);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Logs logs = (Logs) o;

        if (!logId.equals(logs.logId)) return false;
        return logTitle.equals(logs.logTitle);
    }

    @Override
    public int hashCode() {
        int result = logId.hashCode();
        result = 31 * result + logTitle.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "logId='" + logId + '\'' +
                ", logTitle='" + logTitle + '\'' +
                ", logSummary='" + logSummary + '\'' +
                ", logContent='" + logContent + '\'' +
                ", logCreated=" + logCreated +
                ", logCreatedStr='" + logCreatedStr + '\'' +
                ", logUpdate=" + logUpdate +
                ", logUpdateStr='" + logUpdateStr + '\'' +
                '}';
    }
}