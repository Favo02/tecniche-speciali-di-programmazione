public class TestingFields implements ITestingFields {

    private Double[] d;
    private int the_answer = 42;

    public TestingFields(int n, double val) {
        d = new Double[n];
        for (int i = 0; i < n; i++)
            d[i] = i * val;
    }

    public void setAnswer(int a) {
        the_answer = a;
    }

    public String message() {
        return "The answer is " + the_answer;
    }
}
