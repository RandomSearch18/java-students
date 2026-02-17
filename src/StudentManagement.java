import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter student name: ");
		String name = scanner.nextLine();
		System.out.print("Student ID: #");
		int id = scanner.nextInt();
		System.out.println("Enter exam marks, ending with a blank line");
		ArrayList<Double> marks = new ArrayList<Double>();
		scanner.nextLine(); // the first line we receive is always an empty line for some reason
		String line;
		while (true) {
			System.out.print("> ");
			line = scanner.nextLine();
			if (line.isEmpty()) break;
			try {
				Double mark = Double.parseDouble(line);				
				marks.add(new Double(mark));
			} catch(NumberFormatException e) {
				System.out.println("Ignored invalid number!");
			}
		}
		double[] marksArray = marks.stream().mapToDouble(i -> i).toArray();
		Student student = new Student(name, id, marksArray);
		System.out.println("Student created successfully");
		System.out.println();
		
		// Ask user if they want to update student ID
		while (true) {
			System.out.print("Update student ID? (Yes/No) ");
			line = scanner.nextLine().toLowerCase();
			if (line.equals("yes")) {
				System.out.print("Student ID: #");
				int newId = scanner.nextInt();
				student.setId(newId);
				System.out.println("Updated ID");
				break;
			} else if (line.equals("no")) {
				break;
			} else {
				System.out.println("Please enter 'Yes' or 'No'");
				continue;
			}
		}
		System.out.println();
		scanner.close();
		
//		Student student = new Student("Tom", 1122, new double[]{30.0, 40.0, 50.0});
////		double[] marks = {30.0, 40.0, 50.0};
////		Student student = new Student("Tom", 1122, marks);
//		
		System.out.printf("Name: %s\n", student.getName());
		System.out.printf("ID: %d\n", student.getId());
		System.out.printf("Mean marks: %.2f\n", student.getMeanExamMarks());
	}

}
