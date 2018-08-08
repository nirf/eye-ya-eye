package models;

public class TermData {
    SearchTermData searchTermData;
    KeywordTermData keywordTermData;

    public TermData() {
    }

    public TermData(SearchTermData searchTermData, KeywordTermData keywordTermData) {
        this.searchTermData = searchTermData;
        this.keywordTermData = keywordTermData;
    }

    public SearchTermData getSearchTermData() {
        return searchTermData;
    }

    public void setSearchTermData(SearchTermData searchTermData) {
        this.searchTermData = searchTermData;
    }

    public KeywordTermData getKeywordTermData() {
        return keywordTermData;
    }

    public void setKeywordTermData(KeywordTermData keywordTermData) {
        this.keywordTermData = keywordTermData;
    }

    @Override
    public String toString() {
        return "TermData{" +
                "searchTermData=" + searchTermData +
                ", keywordTermData=" + keywordTermData +
                '}';
    }
}
