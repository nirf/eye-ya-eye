package models;

import java.util.List;

public class TermsData {
    List<TermData> termDataList;

    public TermsData() {
    }

    public TermsData(List<TermData> termDataList) {
        this.termDataList = termDataList;
    }

    public List<TermData> getTermDataList() {
        return termDataList;
    }

    public void setTermDataList(List<TermData> termDataList) {
        this.termDataList = termDataList;
    }

    @Override
    public String toString() {
        return "TermsData{" +
                "termDataList=" + termDataList +
                '}';
    }
}
