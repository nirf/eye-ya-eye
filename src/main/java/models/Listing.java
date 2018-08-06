package models;

public class Listing {
    String index;
    String productName;
    String brand;
    Float price;
    String category;
    Float rank;
    Float sales;
    Float revenue;
    Float reviews;
    Float rating;
    String seller;
    String asin;
    String link;

    public Listing() {
    }

    public Listing(String index, String productName, String brand, Float price, String category, Float rank, Float sales, Float revenue, Float reviews, Float rating, String seller, String asin, String link) {
        this.index = index;
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.rank = rank;
        this.sales = sales;
        this.revenue = revenue;
        this.reviews = reviews;
        this.rating = rating;
        this.seller = seller;
        this.asin = asin;
        this.link = link;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getRank() {
        return rank;
    }

    public void setRank(Float rank) {
        this.rank = rank;
    }

    public Float getSales() {
        return sales;
    }

    public void setSales(Float sales) {
        this.sales = sales;
    }

    public Float getRevenue() {
        return revenue;
    }

    public void setRevenue(Float revenue) {
        this.revenue = revenue;
    }

    public Float getReviews() {
        return reviews;
    }

    public void setReviews(Float reviews) {
        this.reviews = reviews;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
