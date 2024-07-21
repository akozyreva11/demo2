package pro.sky.demo2.question;

import java.util.Objects;

public class Question {
    private String answer;
    private String question;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question() {
        super();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question question1)) return false;

        return Objects.equals(getQuestion(), question1.getQuestion()) && Objects.equals(getAnswer(), question1.getAnswer());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(getQuestion());
        result = 31 * result + Objects.hashCode(getAnswer());
        return result;
    }

}