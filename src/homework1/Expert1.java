package homework1;

import java.util.regex.Pattern;

public class Expert1 {
    public static void main(String[] args) {
        //Экспертный уровень
        //Задача №1
        //Создать метод маскирования персональных данных, который:
        //Телефон (до/после маскирования): 79991113344 / 7999***3344
        //Email (до/после маскирования): test@yandex.ru / tes*@******.ru, my_mail@gmail.com / my_mai*@*****.com
        //Фио (до/после маскирования): Иванов Иван Иванович / И****в Иван И.
        //
        //Входящие параметры: String text
        //Возвращаемый результат: String
        //
        //Примеры возможного текста:
        //<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client> - "<client>(Какие то данные)<data>7999***3344;tes*@******.ru;И****в Иван И.</data></client>"
        //<client>(Какие то данные)<data></data></client> - вернет тоже (никаких ошибок)
        //<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client> - "<client>(Какие то данные)<data>И****в Иван И.;7999***3344</data></client>"

        //Используемые технологии: String.find, String.replaceAll, String.split, String.join, String.contains, String.substring
        //Регулярные выражения, класс StringBuilder

        String input = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client>";
        System.out.println(maskPersonalData(input));
    }

    public static String maskPersonalData(String input) {
        String[] inputArray = input.split("<data>|</data>");

        if (inputArray[1].length() != 0) {
            String[] dataArray = inputArray[1].split(";");

            for(int i = 0; i < dataArray.length; i++) {
                if (Pattern.matches("\\d{11}", dataArray[i])) {
                    dataArray[i] = maskPhoneNumber(dataArray[i]);
                } else if (Pattern.matches("\\w+@\\w+\\.\\w+", dataArray[i])) {
                    dataArray[i] = maskEmailAddress(dataArray[i]);
                } else if (Pattern.matches("[а-яА-Я]+\\s[а-яА-Я]+\\s[а-яА-Я]+", dataArray[i])) {
                    dataArray[i] = maskFullName(dataArray[i]);
                }
            }
            inputArray[1] = String.join(";", dataArray);
        }
        String output = inputArray[0] + "<data>" + inputArray[1] + "</data>" + inputArray[2];
        return(output);
    }

    private static String maskPhoneNumber (String number) {
        return new StringBuilder(number).replace(4, 7, "***").toString();
    }

    private static String maskEmailAddress(String email) {
        String[] array = email.split("[@.]");
        array[0] = array[0].substring(0, array[0].length() - 1) + "*";
        array[1] = array[1].replaceAll(".", "*");
        String result = array[0] + "@" + array[1] + "." + array[2];
        return result;
    }

    private static String maskFullName(String fullName) {
        String[] array = fullName.split(" ");
        array[0] = array[0].charAt(0) + array[0].substring(1, array[0].length() - 1).replaceAll(".", "*") + array[0].substring(array[0].length() - 1);
        array[2] = array[2].charAt(0) + ".";
        String result = String.join(" ", array);
        return result;
    }
}
