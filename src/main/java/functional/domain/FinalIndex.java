package functional.domain;

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
}
