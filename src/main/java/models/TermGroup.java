package models;

public class TermGroup {
    String keywordScountFilePath;
    String searchTermFilePath;
    String term;

    public TermGroup() {
    }

    public TermGroup(String keywordScountFilePath, String searchTermFilePath, String term) {
        this.keywordScountFilePath = keywordScountFilePath;
        this.searchTermFilePath = searchTermFilePath;
        this.term = term;
    }

    public String getKeywordScountFilePath() {
        return keywordScountFilePath;
    }

    public void setKeywordScountFilePath(String keywordScountFilePath) {
        this.keywordScountFilePath = keywordScountFilePath;
    }

    public String getSearchTermFilePath() {
        return searchTermFilePath;
    }

    public void setSearchTermFilePath(String searchTermFilePath) {
        this.searchTermFilePath = searchTermFilePath;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "TermGroup{" +
                "keywordScountFilePath='" + keywordScountFilePath + '\'' +
                ", searchTermFilePath='" + searchTermFilePath + '\'' +
                ", term='" + term + '\'' +
                '}' + "\n";
    }
}
