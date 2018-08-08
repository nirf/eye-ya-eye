package models;

import java.util.List;

public class TermGroups {
    List<TermGroup> termGroupList;

    public TermGroups() {
    }

    public TermGroups(List<TermGroup> termGroupList) {
        this.termGroupList = termGroupList;
    }

    public List<TermGroup> getTermGroupList() {
        return termGroupList;
    }

    public void setTermGroupList(List<TermGroup> termGroupList) {
        this.termGroupList = termGroupList;
    }

    @Override
    public String toString() {
        return "TermGroups{" +
                "termGroupList=" + termGroupList +
                '}';
    }
}
