package homework2.expert2;

public class Main {
    public static void main(String[] args) {
        //Задача №2
        // Реализовать паттерн Decorator для класса Car (атрибут - стоимость, метод - вывести на экран стоимость).
        // Метод вывести на экран стоимость - выкидывает ошибку, если стоимость меньше 0
        // Для этого шаблона характерно:
        // 1. Класс основа (Car), и класс декоратор (CarShop), который принимает в себя класс основу
        // 2. Вызов всех методов происходит у декоратора
        // Необходимо вызвать у декоратора метод продать машину, который выведет на экран для машины со стоимость 5000
        // Здравствуй клиент, цена этого авто (Вызвано из объекта CarShop):
        // 5000 - (вызванно из объекта Car)
        // Хочешь купить авто? (Вызвано из объекта CarShop)

        // Если стоимость машины меньше нуля:
        // Здравствуй клиент, цена этого авто (Вызвано из объекта CarShop):
        // Неизвестна мне - (вызванно из объекта Car)
        // Давайте посмотрим другое авто? (Вызвано из объекта CarShop)

        Car car = new Car(5000);
        CarShop carShop = new CarShop(car);
        carShop.sellCar();
    }
}
