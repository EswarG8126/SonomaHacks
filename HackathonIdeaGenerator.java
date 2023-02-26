import java.io.*;
import java.util.*;

public class HackathonIdeaGenerator {
	static ArrayList<String> ideas = new ArrayList<String>();

	public static void main(String[] args) {
		fileRead();
		for (int i = 0; i < 3; i++) {
			System.out.println("-------------------------------------------------------------------------");
		}
		System.out.print("\nHello! Welcome to the Hackathon Idea Generator.");
		String j = "0";
		Scanner scan = null;
		while (!j.equals("3")) {
			System.out.print("\n\n\n1 - Generate Idea\n2 - Add Idea\n3 - End Program\n");
			System.out.print("Please choose one of the options above by entering the matching number: ");
			scan = new Scanner(System.in);
			j = scan.nextLine();
			if (j.equals("1")) {
				System.out.print(generate());
			}
			if (j.equals("2")) {
				System.out.print("Enter the idea: ");
				String s = scan.nextLine();
				insert(s);
			}
			if (!j.equals("3") && !j.equals("2") && !j.equals("1")) {
				System.out.println("Invalid Number. Try Again.");
			}
		}
		scan.close();
		System.out.print("\nProgram Ended.\n");
		for (int i = 0; i < 3; i++) {
			System.out.println("-------------------------------------------------------------------------");
		}
	}

	public static void fileRead() {
		try {
			Scanner s = new Scanner(new File("Ideas.txt"));
			while (s.hasNextLine()) {
				ideas.add((int) (Math.random() * (ideas.size() / 2)), s.nextLine());
			}
			s.close();
		} catch (FileNotFoundException e) {
			System.out.print("Reading Ideas.txt failed.");
		}
	}

	public static void insert(String s) {
		ideas.add((int) (Math.random() * (ideas.size() / 2)), s);
		try {
			FileWriter fw = new FileWriter("Ideas.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter writer = new PrintWriter(bw);
			writer.println(s);
			writer.close();
			bw.close();
			fw.close();
			System.out.println("Idea successfully added.");
		} catch (IOException io) {
			System.out.print("Saving to Ideas.txt failed.");
		}
	}

	public static String generate() {
		return ideas.get((int) (Math.random() * ideas.size()));
	}
}