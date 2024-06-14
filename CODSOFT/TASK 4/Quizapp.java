import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz {
    private String question;
    private String[] options;
    private int correctAnswer;
    private int timeLimit;

    public Quiz(String question, String[] options, int correctAnswer, int timeLimit) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.timeLimit = timeLimit;
    }

    public String getQuestion() {
        return this.question;
    }

    public String[] getOptions() {
        return this.options;
    }

    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public int getTimeLimit() {
        return this.timeLimit;
    }
}

public class Quizapp {
    public static void main(String[] args) {
        Quiz[] quizzes = new Quiz[] {
            new Quiz("Which planet is known as the Red Planet?", new String[] {"Neptune", "Earth", "Mars", "Venus"}, 2, 10),
            new Quiz("How many states are there in India?", new String[] {"30", "28", "29", "26"}, 1, 10),
            new Quiz("Which river is the longest in India", new String[] {"Ganga", "Godavri", "Yamuna", "Indus"}, 0, 10),
            new Quiz("Which Indian state has the highest population?", new String[] {"Mumbai", "Haryana", "Madhya Pradesh", "Uttar Pradesh"}, 3, 10),
        };

        int score = 0;
        for (Quiz quiz : quizzes) {
            System.out.println(quiz.getQuestion());
            for (int i = 0; i < quiz.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + quiz.getOptions()[i]);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                }
            }, quiz.getTimeLimit() * 1000);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your answer (1-" + quiz.getOptions().length + "): ");
            int answer = scanner.nextInt() - 1;

            if (answer == quiz.getCorrectAnswer()) {
                score++;
                System.out.println("Correct answer!");
            } else {
                System.out.println("Incorrect. The correct answer is " + quiz.getOptions()[quiz.getCorrectAnswer()]);
            }

            timer.cancel();
        }

        System.out.println("Quiz completed! Your final score is " + score + " out of " + quizzes.length);
    }
}