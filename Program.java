import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в формате: 1Фамилия 2Имя 3Отчество 4дата_рождения 5номер_телефона 6пол");
        System.out.println("Фамилия имя отчество - буквы, дата рождения - строка формата dd.mm.yyyy, номертелефона - целое беззнаковое число без форматирования, пол - символ латиницей f или m");

        String inputData = scanner.nextLine();

        String[] data = inputData.split(" ");

        if (data.length != 6) {
            System.err.printf("Неверное количество данных(6)!Введенное количество данных %s.", data.length);
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String birthDateStr = data[3];
        String phoneNumberStr = data[4];
        String genderStr = data[5];

        LocalDate birthDate;
        try {
            birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            System.err.println("Неверный формат даты рождения");
            return;
        }

        long phoneNumber;

        try {
            phoneNumber = Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат номера телефона");
            return;
        }

        char gender;

        if (genderStr.length() != 1 || (genderStr.charAt(0) != 'f' && genderStr.charAt(0) != 'm')) {
            System.err.println("Неверный формат пола");
            return;
        } else {
            gender = genderStr.charAt(0);
        }

        DataStructure personalData = new DataStructure(surname, name, patronymic, birthDate, phoneNumber, gender);

        try {
            personalData.saveToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
