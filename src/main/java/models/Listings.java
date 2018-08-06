package models;

import java.util.List;

public class Listings {
    private List<Listing> listings;

    public Listings() {
    }

    public Listings(List<Listing> listings) {
        this.listings = listings;
    }

    public List<Listing> getListings() {
        return listings;
    }

    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }
}
