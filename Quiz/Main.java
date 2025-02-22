import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Quiz quiz = new Quiz();
        Question q1 = new Question("Choose the correct answer: ", 4, 2);
        Question q2 = new Question("Now type something", 2, 1);
        String ans1[] = {"a", "b", "c", "d"};
        String ans2[] = {"yes", "no"};
        q1.setAnswers(ans1, 2);
        q2.setAnswers(ans2, 1);
        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.answerQuiz(s);
    }
}