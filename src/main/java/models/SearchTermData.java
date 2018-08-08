package models;

public class SearchTermData {

    SearchTermAggregation searchTermAggregation;
    Listings listings;

    public SearchTermData() {
    }

    public SearchTermData(SearchTermAggregation searchTermAggregation, Listings listings) {
        this.searchTermAggregation = searchTermAggregation;
        this.listings = listings;
    }

    public SearchTermAggregation getSearchTermAggregation() {
        return searchTermAggregation;
    }

    public void setSearchTermAggregation(SearchTermAggregation searchTermAggregation) {
        this.searchTermAggregation = searchTermAggregation;
    }

    public Listings getListings() {
        return listings;
    }

    public void setListings(Listings listings) {
        this.listings = listings;
    }

    @Override
    public String toString() {
        return "SearchTermData{" +
                "searchTermAggregation=" + searchTermAggregation +
                ", listings=" + listings +
                '}';
    }
}
