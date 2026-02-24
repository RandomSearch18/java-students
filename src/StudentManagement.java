import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class StudentManagement {
	static String studentsFile = "StudentsData.txt";

	public static void main(String[] args) throws IOException {
		CSVFormat fileFormat = CSVFormat.DEFAULT.builder()
				.setDelimiter(';')
				.setIgnoreSurroundingSpaces(true)
				.setHeader("name", "studentId", "mark1", "mark2", "mark3", "mark4")
				.get();
		Reader file = new FileReader(studentsFile);
		Iterable<CSVRecord> studentRecords = fileFormat.parse(file);
		ArrayList<Student> students = new ArrayList<Student>();
		for (CSVRecord record: studentRecords) {
			Student student = new Student(record.get("name"), Integer.parseInt(record.get("studentId")), new double[] {
					Double.parseDouble(record.get("mark1")),
					Double.parseDouble(record.get("mark2")),
					Double.parseDouble(record.get("mark3")),
					Double.parseDouble(record.get("mark4")),
			});
			students.add(student);
		}
		Student[] studentsArray = students.toArray(new Student[students.size()]);
		System.out.println(Arrays.toString(studentsArray));
	}

}
