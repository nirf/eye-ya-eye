package models;

public class KeywordTermAggregation {
    String reportGeneratedAt;
    String searchTerm;

    public KeywordTermAggregation() {
    }

    public KeywordTermAggregation(String reportGeneratedAt, String searchTerm) {
        this.reportGeneratedAt = reportGeneratedAt;
        this.searchTerm = searchTerm;
    }

    public String getReportGeneratedAt() {
        return reportGeneratedAt;
    }

    public void setReportGeneratedAt(String reportGeneratedAt) {
        this.reportGeneratedAt = reportGeneratedAt;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public String toString() {
        return "KeywordTermAggregation{" +
                "reportGeneratedAt='" + reportGeneratedAt + '\'' +
                ", searchTerm='" + searchTerm + '\'' +
                '}';
    }
}
