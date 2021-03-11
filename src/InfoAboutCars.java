import java.util.Scanner;

class Car {
    String model;
    String reg_num;
    int year;
    double probeg;
    double price;

    @Override

    public String toString() {
        return "Car" +
                "model= " + model +
                " reg_num= " + reg_num +
                " year= " + year +
                " probeg= " + probeg +
                " price= " + price;
    }
}

public class InfoAboutCars {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Count");
        int count = sc.nextInt();
        sc.nextLine();
        Car[] cars = new Car[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter info about " + (i + 1) + " car:");

            cars[i] = new Car();
            System.out.println("Model => ");
            cars[i].model = sc.nextLine();

            System.out.println("Reg number => ");
            cars[i].reg_num = sc.nextLine();

            System.out.println("Year => ");
            cars[i].year = sc.nextInt();

            System.out.println("Probeg => ");
            cars[i].probeg = sc.nextDouble();

            System.out.println("Price => ");
            cars[i].price = sc.nextDouble();
            sc.nextLine();
        }
        System.out.println("\n cars characterictics: ");
        for (int i = 0; i < count; i++) {
            System.out.println(cars[i]);
        }


        int nommin = 0;
        double min = cars[nommin].price;
        for (int i = 0; i < count; i++)
            if (cars[i].price < min) {
                min = cars[i].price;
                nommin = i;
            }
        System.out.println("\n Сheapest car :");
        System.out.println("\t" + cars[nommin].model + "\t" + cars[nommin].price + " million rub");

        for (int i = 0; i < cars.length; i++) {
            for (int j = i+1; j < cars.length; j++) {
                if (cars[j].year > cars[i].year) {
                    Car rab = cars[j];
                    cars[j] = cars[i];
                    cars[i] = rab;
                }
            }
        }
        System.out.println("\n Sort by year: ");
        for (int i = 0; i < count; i++) {
            System.out.println(cars[i]);
        }
        System.out.println("reg_numFind => ");
        String reg_numF = sc.nextLine();
        int indexS = -1;
        for (int i = 0; i < count; i++) {
            if (cars[i].reg_num.equals(reg_numF)) {
                System.out.println(cars[i]);
                indexS = i;
            }
        }
        if (indexS != -1) {
            System.out.println("Enter index: ");
            System.out.println("1-model, 2-reg_num, 3-year, 4-probeg, 5-price");
            int indexPole = sc.nextInt();
            sc.nextLine();
            switch (indexPole) {
                case 1: {
                    System.out.println("Enter new model: ");
                    String newModel = sc.nextLine();
                    cars[indexS].model = newModel;
                    System.out.println(cars[indexS]);
                    break;
                }
                case 2: {
                    System.out.println("Enter new reg number: ");
                    String newReg_num = sc.nextLine();
                    cars[indexS].reg_num = newReg_num;
                    System.out.println(cars[indexS]);
                    break;
                }
                case 3: {
                    System.out.println("Enter new year: ");
                    int newYear = sc.nextInt();
                    cars[indexS].year = newYear;
                    System.out.println(cars[indexS]);
                    break;
                }
                case 4: {
                    System.out.println("Enter new probeg: ");
                    double newProbeg = sc.nextDouble();
                    cars[indexS].probeg = newProbeg;
                    System.out.println(cars[indexS]);
                    break;
                }
                case 5: {
                    System.out.println("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    cars[indexS].price = newPrice;
                    System.out.println(cars[indexS]);
                    break;
                }
                default: {
                    System.out.println("There is no field with this index");
                }
            }
        } else {
            System.out.println("Nothing found");
        }
    }
}

