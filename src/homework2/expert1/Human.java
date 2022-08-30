package homework2.expert1;

public class Human {
    //Задача №1
    // Реализовать шаблон Builder для класса Human (атрибуты - возраст, имя, вес. Метод: инфо о человеке):
    // Для этого шаблона характерно:
    // 1. приватный конструктор,
    // 2. вложенный статический класс (HumanBuilder)
    // 3. статический метод builder(), который возврашает экземпляр типа HumanBuilder.
    // Во время инициализации HumanBuilder, создается объект класса Human, и записывается в приватный атрибут.
    // 4. Класс HumanBuilder имеет методы, которые имеют тоже самое название, что и атрибуты класса Human,
    // которые вызывают сеттеры у экземпляра класса Human.
    // 5. HumanBuilder имеет метод build, который возвращает готовый объект типа Human.
    // Ожидаемый результат
    // Human human = Human.builder().name("Петр").age(20).weight(80).build();
    // human.info()
    // Петр - возраст 20, вес 80

    private int age;
    private String name;
    private int weight;

    private Human() {

    }
    private int getAge() {
        return age;
    }
    private void setAge(int age) {
        this.age = age;
    }
    private String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
    private int getWeight() {
        return weight;
    }
    private void setWeight(int weight) {
        this.weight = weight;
    }

    public void info() {
        System.out.println(getName() + " - возраст " + getAge() + ", вес " + getWeight());
    }

    public static HumanBuilder builder() {
        return new HumanBuilder();
    }

    public static class HumanBuilder {

        private final Human human;

        public HumanBuilder() {
            this.human = new Human();
        }

        public Human build() {
            return this.human;
        }

        public HumanBuilder name(String name) {
            this.human.setName(name);
            return this;
        }

        public HumanBuilder age(int age) {
            this.human.setAge(age);
            return this;
        }

        public HumanBuilder weight(int weight) {
            this.human.setWeight(weight);
            return this;
        }
    }
}
