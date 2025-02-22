import java.util.Vector;
import java.util.Scanner;
public class Quiz {
    private Vector<Question> questions;
    public Quiz(){
        this.questions = new Vector<>();
    }
    public void addQuestion(Question q){
        this.questions.add(q);
    }
    public void removeQuestion(int index){
        if(index < 0 || index >= questions.size()){
            throw new ArrayIndexOutOfBoundsException("Invalid index!");
        }
        questions.remove(index);
    }
    public void removeAllQuestion(){
        this.questions.removeAllElements();
    }
    public void printQuiz(){
        for(Question q:this.questions){
            q.visualizeQuestion();
        }
    }
    public void answerQuiz(Scanner scanner){
        int countCorrectAnswers = 0;
        for(Question q:this.questions){
            q.visualizeQuestion();
            int x = scanner.nextInt();
            if(q.answer(x)){
                countCorrectAnswers++;
            }
        }
        System.out.println("Correct answers: " + Integer.toString(countCorrectAnswers));
        System.out.println("Your success rate: " + Double.toString((double)countCorrectAnswers / this.questions.size() * 100) + "%");
    }
    public int getQuizSize(){
        return this.questions.size();
    }
}
