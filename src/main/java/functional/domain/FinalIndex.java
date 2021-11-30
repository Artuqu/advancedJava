package functional.domain;

import java.util.Objects;

final public class FinalIndex {
    private String indexNumber;

    public FinalIndex(String indexNumber) {
        this.indexNumber=indexNumber;
    }

    public String getIndexNumber() {
        return indexNumber;
    }


    @Override
    public String toString() {
        return "FinalIndex{" +
                "indexNumber='" + indexNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinalIndex that = (FinalIndex) o;
        return indexNumber.equals(that.indexNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexNumber);
    }
}
