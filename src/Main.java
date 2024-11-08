import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Введите Фамилию, Имя и " +
                    "Отчество через пробел.\n" + "Например: Иванов Иван Иванович");
            Scanner input = new Scanner(System.in);
            String username = input.nextLine();
            String [] divided_username = username.split(" ");
            if ((divided_username.length == 3) && (username.matches("[\\p{L}| ]+")))
            {
                System.out.println("Введите дату, месяц и год по образцу: 01.09.1992");
                String date = input.nextLine();
                String [] divided_date = date.split("\\.");
                if (divided_date.length !=3){System.out.print("Неправильный формат даты"); System.exit(0);}
                System.out.print(divided_username[0] + " " + divided_username[1].charAt(0)
                        + "." + divided_username[2].charAt(0) + ".");
                if (divided_username[2].charAt(divided_username[2].length() - 1) == 'а') {System.out.print(" Пол: Ж, ");}
                else if (divided_username[2].matches("[\\p{L}| ]+")){System.out.print(" Пол: М, ");}
                else {System.out.print("Определить не удалость");}
                LocalDate birthday = LocalDate.of(Integer.parseInt(divided_date[2]),Integer.parseInt(divided_date[1]), Integer.parseInt(divided_date[0]));
                LocalDate now = LocalDate.now();
                Period period = Period.between(birthday, now); // Вычисляем разницу
                String name_year, name_month, name_day;
                String years = Integer.toString(period.getYears()), months = Integer.toString(period.getMonths()), days = Integer.toString(period.getDays());
                if (((Character.getNumericValue(years.charAt(years.length() - 1)) < 5) && (Character.getNumericValue(years.charAt(years.length() - 1)) != 0) && (Character.getNumericValue(years.charAt(years.length() - 1)) != 1))  && ((years.length() == 1)  || (Character.getNumericValue(years.charAt(years.length() - 2)) > 1))){name_year = "года";}
                else if ((Character.getNumericValue(years.charAt(years.length() - 1)) == 1) && (Character.getNumericValue(years.charAt(years.length() - 2)) > 1)) {name_year = "год";}
                else{name_year = "лет";}
                if ((Character.getNumericValue(months.charAt(months.length() - 1)) < 5) && (Character.getNumericValue(months.charAt(months.length() - 1)) != 0) && (Character.getNumericValue(months.charAt(months.length() - 1)) != 1)) {name_month = "месяца";}
                else if ((Character.getNumericValue(months.charAt(months.length() - 1)) == 1)  && (months.length() == 1)) {name_month = "месяц";}
                else{name_month = "месяцев";}
                if ((Character.getNumericValue(days.charAt(days.length() - 1)) == 1) && (Character.getNumericValue(days.length() - 2) > 1)) {name_day = "день";}
                else if ((Character.getNumericValue(days.charAt(days.length() - 1)) < 5) && (Character.getNumericValue(days.charAt(days.length() - 1)) != 0) && (Character.getNumericValue(days.length() - 2) > 1)) {name_day = "дня";}
                else if (Character.getNumericValue(days.charAt(days.length() - 1)) >= 5) {name_day = "дней";}
                else {name_day = "день";}
                System.out.println(years + " " +  name_year + " " +months + " " +  name_month + " " + days + " " + name_day);
            }
            else
            {
                System.out.print("Неправильный формат ФИО");
            }
        }
        catch (OutOfMemoryError error)
        {
            System.out.print("Лимит памяти исчерпан");
        }
        catch (RuntimeException error)
        {
            System.out.print("Ошибка при обработке");
        }
    }
}