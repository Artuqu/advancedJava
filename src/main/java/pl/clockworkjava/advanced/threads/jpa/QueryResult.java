package pl.clockworkjava.advanced.threads.jpa;

public class QueryResult {

    private String studentName;
    private String indexNumber;

    public QueryResult(String studentName, String indexNumber) {
        this.studentName = studentName;
        this.indexNumber = indexNumber;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "studentName='" + studentName + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                '}';
    }
}
