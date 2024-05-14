public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat("Барсик");
        barsik.swim(1);
        barsik.run(200);
        barsik.run(201);

        Dog bobik = new Dog("Бобик");
        bobik.swim(7);
        bobik.swim(11);
        bobik.run(500);
        bobik.run(501);

        System.out.println("Создано животных: " + Animal.count +
                "\nСоздано котов: " + Cat.count +
                "\nСоздано собак: " + Dog.count);

        Bowl.addMoreFood(10);
        System.out.println(Bowl.amountOfFood);

        System.out.println(barsik.satiety);
        barsik.eatFromABowl(10);
        System.out.println(barsik.satiety);
        System.out.println(Bowl.amountOfFood);
        Bowl.addMoreFood(10);
        Cat[] arrayOfCats = new Cat[5];
        arrayOfCats[0] = new Cat("Борис");
        arrayOfCats[1] = new Cat("Семен");
        arrayOfCats[2] = new Cat("Пал Палыч");
        arrayOfCats[3] = new Cat("Рыжий");
        arrayOfCats[4] = new Cat("Турбо");
        System.out.println("Сейчас в миске: " + Bowl.amountOfFood + " единиц еды");
        for(int i = 0; i < arrayOfCats.length; i++) {
            System.out.println("Кот " + arrayOfCats[i].name + " подошел к миске c едой(" + Bowl.amountOfFood + ")");
            arrayOfCats[i].eatFromABowl(i + 1);
        }
        for(int i = 0; i < arrayOfCats.length; i++) {
            System.out.println("Сытость кота " + arrayOfCats[i].name + " " + arrayOfCats[i].satiety);
        }



    }
}
