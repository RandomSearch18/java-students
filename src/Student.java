
public class Student {
	private String name;
	private int id;
	private double[] examMarks;
	private static String universityName = "Loughborough University";
	
	public Student(String name, int id, double[] examMarks) {
		this.name = name;
		this.id = id;
		this.examMarks = examMarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getMeanExamMarks() {
		double sum = 0;
		for (double mark: examMarks) {
			sum += mark;
		}
		return sum / examMarks.length;
	}
	
	public String getUniversityName() {
		return universityName;
	}
	
	public String toString() {
		String parts[] = new String[] {
				"Uni: " + universityName,
				"Name: " + name,
				"ID: " + id,
				"Avg Marks: " + getMeanExamMarks(),
		};
		return String.join(", ", parts);
	}
}
