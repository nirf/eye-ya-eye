package models;

public class KeywordTermData {
    KeywordTermAggregation keywordTermAggregation;
    Keywords keywords;

    public KeywordTermData() {
    }

    public KeywordTermData(KeywordTermAggregation keywordTermAggregation, Keywords keywords) {
        this.keywordTermAggregation = keywordTermAggregation;
        this.keywords = keywords;
    }

    public KeywordTermAggregation getKeywordTermAggregation() {
        return keywordTermAggregation;
    }

    public void setKeywordTermAggregation(KeywordTermAggregation keywordTermAggregation) {
        this.keywordTermAggregation = keywordTermAggregation;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "KeywordTermData{" +
                "keywordTermAggregation=" + keywordTermAggregation +
                ", keywords=" + keywords +
                '}';
    }
}
