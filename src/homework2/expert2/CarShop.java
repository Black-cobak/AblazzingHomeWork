package homework2.expert2;

public class CarShop {
    private final Car car;

    public CarShop(Car car) {
        this.car = car;
    }

    public void sellCar() {
        System.out.println("Здравствуй клиент, цена этого авто:");
        try {
            car.printPrice();
            System.out.println("Хочешь купить авто?");
        } catch (Exception e) {
            System.out.println("Давайте посмотрим другое авто?");
        }
    }
}
