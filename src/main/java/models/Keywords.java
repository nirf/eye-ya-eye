package models;

import java.util.List;

public class Keywords {
    List<Keyword> kewords;

    public Keywords() {
    }

    public Keywords(List<Keyword> kewords) {
        this.kewords = kewords;
    }

    public List<Keyword> getKewords() {
        return kewords;
    }

    public void setKewords(List<Keyword> kewords) {
        this.kewords = kewords;
    }
}

