package models;

public class KeywordTermAggregation {
    String reportGeneratedAt;
    String searchTerm;
    Float exactMatchSearchVolume;

    public KeywordTermAggregation() {
    }

    public Float getExactMatchSearchVolume() {
        return exactMatchSearchVolume;
    }

    public void setExactMatchSearchVolume(Float exactMatchSearchVolume) {
        this.exactMatchSearchVolume = exactMatchSearchVolume;
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
                ", exactMatchSearchVolume='" + exactMatchSearchVolume + '\'' +
                '}';
    }
}
