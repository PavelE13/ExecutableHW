import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataStructure {
    private String surname;
    private String name;
    private String patronymic;
    private LocalDate birthDate;
    private long phoneNumber;
    private char gender;


    public DataStructure(String surname, String name, String patronymic, LocalDate birthDate, long phoneNumber, char gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public void saveToFile() throws IOException {
        String fileName = surname + ".txt";

        try (FileWriter writer = new FileWriter(new File(fileName), true)) {
            writer.write(surname + " " + name + " " + patronymic + " " + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " + phoneNumber + " " + gender + "\n");
        }
    }

}
