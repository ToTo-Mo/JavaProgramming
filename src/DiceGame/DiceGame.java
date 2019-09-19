package DiceGame;
import java.util.Random;
import java.util.Scanner;

public class DiceGame {

	int diceFace;
	int userGuess;
	
	private void RollDice()
	{
		Random rand = new Random();
		
		rand.setSeed(System.currentTimeMillis());
//		diceFace = (int)Math.random() * 6 + 1;
		diceFace = rand.nextInt(7);
	}
	
	private int GetUserInput(String prompt)
	{
		int r;
		Scanner scan = new Scanner(System.in);
		
		System.out.print(prompt);
		r = scan.nextInt();
		
		return r;
	}
	
	private void CheckUserGuess()
	{
		if (diceFace == userGuess)
			System.out.println("�¾ҽ��ϴ�");
		else
		{
			System.out.println("Ʋ�ǽ��ϴ�");
			System.out.print("��� : " + diceFace);
		}
		
	}
	
	private void StartPlaying()
	{
		userGuess = GetUserInput("������ �Է��Ͻÿ� : ");
		RollDice();
		CheckUserGuess();
	}
	
	public void Program()
	{
		DiceGame dicegame = new DiceGame();
		dicegame.StartPlaying();
	}
}
