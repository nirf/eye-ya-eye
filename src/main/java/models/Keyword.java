package models;

public class Keyword {
    String keyword;
    Float exactMatchSearchVolume;
    Float broadMatchSearchVolume;
    String dominantCategory;
    Float recommendedGiveaway;
    Float HSABid;
    Float exactPPCBid;
    Float broadPPCBid;
    Float relevancyScore;

    public Keyword(String keyword, Float exactMatchSearchVolume, Float broadMatchSearchVolume, String dominantCategory, Float recommendedGiveaway, Float HSABid, Float exactPPCBid, Float broadPPCBid, Float relevancyScore) {
        this.keyword = keyword;
        this.exactMatchSearchVolume = exactMatchSearchVolume;
        this.broadMatchSearchVolume = broadMatchSearchVolume;
        this.dominantCategory = dominantCategory;
        this.recommendedGiveaway = recommendedGiveaway;
        this.HSABid = HSABid;
        this.exactPPCBid = exactPPCBid;
        this.broadPPCBid = broadPPCBid;
        this.relevancyScore = relevancyScore;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Float getExactMatchSearchVolume() {
        return exactMatchSearchVolume;
    }

    public void setExactMatchSearchVolume(Float exactMatchSearchVolume) {
        this.exactMatchSearchVolume = exactMatchSearchVolume;
    }

    public Float getBroadMatchSearchVolume() {
        return broadMatchSearchVolume;
    }

    public void setBroadMatchSearchVolume(Float broadMatchSearchVolume) {
        this.broadMatchSearchVolume = broadMatchSearchVolume;
    }

    public String getDominantCategory() {
        return dominantCategory;
    }

    public void setDominantCategory(String dominantCategory) {
        this.dominantCategory = dominantCategory;
    }

    public Float getRecommendedGiveaway() {
        return recommendedGiveaway;
    }

    public void setRecommendedGiveaway(Float recommendedGiveaway) {
        this.recommendedGiveaway = recommendedGiveaway;
    }

    public Float getHSABid() {
        return HSABid;
    }

    public void setHSABid(Float HSABid) {
        this.HSABid = HSABid;
    }

    public Float getExactPPCBid() {
        return exactPPCBid;
    }

    public void setExactPPCBid(Float exactPPCBid) {
        this.exactPPCBid = exactPPCBid;
    }

    public Float getBroadPPCBid() {
        return broadPPCBid;
    }

    public void setBroadPPCBid(Float broadPPCBid) {
        this.broadPPCBid = broadPPCBid;
    }

    public Float getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Float relevancyScore) {
        this.relevancyScore = relevancyScore;
    }
}
