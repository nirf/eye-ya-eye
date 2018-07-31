package models;

public class SearchTermAggregation {
    String exportDate;
    String exportTime;
    String searchTerm;
    Float averageSales;
    Float averageSalesRank;
    Float averagePrice;
    Float averageReviews;

    public SearchTermAggregation(String exportDate, String exportTime, String searchTerm, Float averageSales, Float averageSalesRank, Float averagePrice, Float averageReviews) {
        this.exportDate = exportDate;
        this.exportTime = exportTime;
        this.searchTerm = searchTerm;
        this.averageSales = averageSales;
        this.averageSalesRank = averageSalesRank;
        this.averagePrice = averagePrice;
        this.averageReviews = averageReviews;
    }

    public String getExportDate() {
        return exportDate;
    }

    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }

    public String getExportTime() {
        return exportTime;
    }

    public void setExportTime(String exportTime) {
        this.exportTime = exportTime;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Float getAverageSales() {
        return averageSales;
    }

    public void setAverageSales(Float averageSales) {
        this.averageSales = averageSales;
    }

    public Float getAverageSalesRank() {
        return averageSalesRank;
    }

    public void setAverageSalesRank(Float averageSalesRank) {
        this.averageSalesRank = averageSalesRank;
    }

    public Float getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Float averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Float getAverageReviews() {
        return averageReviews;
    }

    public void setAverageReviews(Float averageReviews) {
        this.averageReviews = averageReviews;
    }
}
