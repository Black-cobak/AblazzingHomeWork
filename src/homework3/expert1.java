package homework3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class expert1 {
    public static void main(String[] args) {

        Map<Integer, Map<String, String[]>> data = GeneratorExpertHomework.getData();
        Set<String> resultSet = new HashSet<>();

        for (Map.Entry<Integer, Map<String, String[]>> entry : data.entrySet()) {
            for (Map.Entry<String, String[]> entry1 : entry.getValue().entrySet()) {
                for (String number : entry1.getValue()) {
                    if (number.matches("М\\d{3}АВ\\d{2,3}")) {
                        resultSet.add(number);
                    }
                }
            }
        }
        System.out.println(resultSet.size());
    }
}
