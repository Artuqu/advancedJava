package pl.clockworkjava.advanced.threads.jpa;

public class QueryResult {

    private String studentName;
    private String indexNumber;
    private long count;

    public QueryResult(String studentName, long count) {
        this.studentName = studentName;
        this.count = count;
    }

    public QueryResult(String studentName, String indexNumber) {
        this.studentName = studentName;
        this.indexNumber = indexNumber;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "studentName='" + studentName + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", count=" + count +
                '}';
    }
}
