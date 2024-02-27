 import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

	static final int time = 10;
	static int score = 0;
	static int currentQuestionIndex = 0;
	static Timer timer;

	static String[] questions = { 
								" Which component is used to compile, debug and exeute the java program ?",
								" Which of the following is not a Java features?",
								" Which of the following is a valid declaration of a char? ?",
								" Which of the following are not java keyword ?",
								" Which of the following is a valid long literal?" 
	};

	static String[][] options = { 
								{ "a) JRE", "b) JDK", "c) JVM", "d) None" },
								{ "a) Dynamic", "b) Architecture Neutral ", "c) Use of pointers", "d) Object-oriented" },
								{ "a) char ch = '\\utea';", "b) char ca = 'tea';", "c) char cr = \\u0223;", "d) char cc = '\\itea';"},
								{ "a) Double", "b) switch", "c) then", "d) instanceof" },
								{ "a) ABH8097", "b) L990023", "c) 904423", "d) 0xnf029L" }
	};
	
	static String[] correctAnswer = { "b", "c", "a", "c", "d" };

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welecom to the Quiz !..");

//Start the quiz
		System.out.println("                $$$$$$$$$$----INSTRUCTION FOR THE GAME  -------$$$$$$$$$$ ");
		
		System.out.println();
		System.out.println("                [####-----Time Limite to answer the question is 15 seconds ---####]");
		
		System.out.println("                   [####-----You have only 15 seconds to give a answer -----####]");
		
		
		for (int i = 0; i < questions.length; i++) {
				currentQuestion(i, scanner);
		}

//Display the final score 

		System.out.println("\nQuiz Completed ! Your Final Score :" + score);
		System.out.println("Correct Answers : " + score + "/" + questions.length);
		System.out.println("Incorrect Answers : " + (questions.length - score));
		scanner.close();

	}

	public static void currentQuestion(int questionIndex, Scanner scanner) {

		System.out.println("\nQuetion " + (questionIndex + 1) + ": " + questions[questionIndex]);
		
		for (String i : options[questionIndex]) {

			System.out.println(i);
		}

		StartTimer(questionIndex, scanner);
	}

	public static void StartTimer(int questionIndex, Scanner scanner) {

		timer = new Timer();
		timer.schedule(new TimerTask() {

			int remainingSceconds = time;

			@Override
			public void run() {

				if (remainingSceconds == 0) {
					System.out.println();
					System.out.println("Time's Up !");
					System.out.println("--------------------------------------");
					hadleAnswer("", questionIndex, scanner);
				}

				remainingSceconds--;
			}
		}, 0, 1500);

		String userAnswer = scanner.nextLine();
		hadleAnswer(userAnswer.toLowerCase(), questionIndex, scanner);
	}

	public static void hadleAnswer(String userAnswer, int questionIndex, Scanner scanner) {

		timer.cancel();

		if (userAnswer.equals(correctAnswer[questionIndex])) {

			System.out.println("Correct !");
			score++;
		} else {
			System.out.println("Incorrect ! The correct answer is " + correctAnswer[questionIndex]);
		}

		System.out.println("You current score :" + score);

	}

} 