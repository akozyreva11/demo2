package pro.sky.demo2.error;

public class QuestionErrorNotAll extends RuntimeException {
    public QuestionErrorNotAll() {
        super();
    }

    public QuestionErrorNotAll(String message) {
        super(message);
    }
}