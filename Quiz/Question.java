public class Question {
    public static final int MIN_DESC_LENGTH = 10;
    private String description;
    private int answersCount = 0;
    private String answers[];
    private int correctAnswer;
    public Question(String desc, int ansCount, int corrAnswer){
        if(ansCount < 1){
            throw new RuntimeException("At least 1 answer required!");
        }
        this.description = desc;
        this.answersCount = ansCount;
        this.answers = new String[ansCount];
        this.correctAnswer = corrAnswer;
    }
    public String getDescription(){
        return this.description;
    }
    public int getAnswerCount(){
        return this.answersCount;
    }
    public void setAnswers(String[] ans, int corrAnswer){
        if(this.answers.length < ans.length){
            this.answers = new String[ans.length];
            this.answersCount = ans.length;
            this.correctAnswer = corrAnswer;
        }
        for(int i=0;i<ans.length;++i){
            this.answers[i] = ans[i];
        }
    }
    public void setDescription(String desc) {
        if (desc.length() < MIN_DESC_LENGTH) {
            throw new RuntimeException("Not enough symbols in the description!");
        }
        this.description = desc;
    }
    public void visualizeQuestion(){
        System.out.println(this.description);
        for(int i=0;i<this.answers.length;++i){
            System.out.println(Integer.toString(i+1) + ". " + this.answers[i]);
        }
    }
    private void printCorrectAnswer(){
        System.out.println("Correct Answer!");
    }
    private void printIncorrectAnswer(){
        System.out.println("Incorrect!");
    }
    public boolean answer(int key){
        if(key == this.correctAnswer){
            this.printCorrectAnswer();
            return true;
        }
        this.printIncorrectAnswer();
        return false;
    }

}
