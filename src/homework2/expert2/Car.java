package homework2.expert2;

public class Car {
    private final int price;

    public Car(int price) {
        this.price = price;
    }

    public void printPrice() throws Exception {
        if (this.price < 0) {
            System.out.println("Неизвестна мне");
            throw new Exception();
        } else {
            System.out.println(this.price);
        }
    }
}
