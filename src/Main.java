import java.time.Period;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static String get_year_end(int years) {
        if (years % 10 == 1 && years % 100 != 11) return "год";
        else if (years % 10 >= 2 && years % 10 <= 4 && (years % 100 < 10 || years % 100 >= 20)) return "года";
        else return "лет";
    }

    private static String get_month_end(int months) {
        if (months % 10 == 1 && months % 100 != 11) return "месяц";
        else if (months % 10 >= 2 && months % 10 <= 4 && (months % 100 < 10 || months % 100 >= 20)) return "месяца";
        else return "месяцев";
    }

    private static String get_day_end(int days) {
        if (days % 10 == 1 && days % 100 != 11) return "день";
        else if (days % 10 >= 2 && days % 10 <= 4 && (days % 100 < 10 || days % 100 >= 20)) return "дня";
        else return "дней";
    }

    public static void main(String[] args) {
        try {
            System.out.println("Введите Фамилию, Имя и " +
                    "Отчество через пробел.\nНапример: Иванов Иван Иванович");
            Scanner input = new Scanner(System.in);
            String username = input.nextLine();
            String [] divided_username = username.split(" ");

            if ((divided_username.length == 3) && (username.matches("[\\p{L}| ]+"))) {
                System.out.println("Введите дату, месяц и год по образцу: 01.09.1992");
                String date = input.nextLine();
                String [] divided_date = date.split("\\.");

                if (divided_date.length != 3) {
                    System.out.print("Неправильный формат даты");
                    System.exit(0);
                }

                System.out.print(divided_username[0] + " " + divided_username[1].charAt(0) + "." + divided_username[2].charAt(0) + ".");

                if (divided_username[2].charAt(divided_username[2].length() - 1) == 'а') {
                    System.out.print(" Пол: Ж, ");
                } else if (divided_username[2].charAt(divided_username[2].length() - 1) == 'ч') {
                    System.out.print(" Пол: М, ");
                } else {
                    System.out.print(" Определить не удалось ");
                }

                LocalDate birthday = LocalDate.of(Integer.parseInt(divided_date[2]),
                        Integer.parseInt(divided_date[1]), Integer.parseInt(divided_date[0]));
                LocalDate now = LocalDate.now();
                Period period = Period.between(birthday, now);

                String years = Integer.toString(period.getYears());
                String months = Integer.toString(period.getMonths());
                String days = Integer.toString(period.getDays());

                String name_year = get_year_end(period.getYears());
                String name_month = get_month_end(period.getMonths());
                String name_day = get_day_end(period.getDays());

                System.out.println(years + " " + name_year + " " + months + " " +
                        name_month + " " + days + " " + name_day);
            } else {
                System.out.print("Неправильный формат ФИО");
            }
        } catch (OutOfMemoryError error) {
            System.out.print("Лимит памяти исчерпан");
        } catch (RuntimeException error) {
            System.out.print("Ошибка при обработке");
        }
    }
}