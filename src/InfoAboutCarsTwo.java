import java.util.Scanner;

class Cars {
    String model;
    String reg_num;
    int year;
    double probeg;
    double price;
}

public class InfoAboutCarsTwo {
    static Scanner sc;

    public static Cars[] fillCars(int count) {
        Cars[] cars = new Cars[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Enter info about " + (i + 1) + " car:");

            cars[i] = new Cars();
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
        return cars;
    }

    public static void printCars(Cars[] cars) {
        for (int i = 0; i < cars.length; i++) {
            System.out.println("model= " + cars[i].model +
                    " reg_num= " + cars[i].reg_num +
                    " year= " + cars[i].year +
                    " probeg= " + cars[i].probeg +
                    " price= " + cars[i].price);
        }
    }

    public static void printCar(Cars car) {
        System.out.println("model= " + car.model +
                " reg_num= " + car.reg_num +
                " year= " + car.year +
                " probeg= " + car.probeg +
                " price= " + car.price);
    }

    public static int findCheapestCar(Cars[] cars) {
        int nommin = 0;
        double min = cars[nommin].price;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].price < min) {
                min = cars[i].price;
                nommin = i;
            }
        }
        return nommin;
    }

    public static Cars[] sortYear(Cars[]cars) {
        for (int i = 0; i < cars.length; i++) {
            for (int j = i + 1; j < cars.length; j++) {
                if (cars[j].year > cars[i].year) {
                    Cars rab = cars[j];
                    cars[j] = cars[i];
                    cars[i] = rab;
                }
            }
        }
        return cars;
    }

    public static Cars findReg_num(Cars[] cars, String reg_numF) {
        int nomS = -1;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].reg_num.equals(reg_numF)) {
                nomS = i;
            }
        }
        if (nomS != -1) {
            return cars[nomS];
        } else {
            return null;
        }
    }

    public static Cars changeCar(Cars car) {
        System.out.println("Enter index: ");
        System.out.println("1-model, 2-reg_num, 3-year, 4-probeg, 5-price");
        int indexPole = sc.nextInt();
        sc.nextLine();
        switch (indexPole) {
            case 1: {
                System.out.println("Enter new model: ");
                String newModel = sc.nextLine();
                car.model = newModel;
                break;
            }
            case 2: {
                System.out.println("Enter new reg number: ");
                String newReg_num = sc.nextLine();
                car.reg_num = newReg_num;
                break;
            }
            case 3: {
                System.out.println("Enter new year: ");
                int newYear = sc.nextInt();
                car.year = newYear;
                break;
            }
            case 4: {
                System.out.println("Enter new probeg: ");
                double newProbeg = sc.nextDouble();
                car.probeg = newProbeg;
                break;
            }
            case 5: {
                System.out.println("Enter new price: ");
                double newPrice = sc.nextDouble();
                car.price = newPrice;
                break;
            }
            default: {
                System.out.println("There is no field with this index");
            }
        }
        return car;
    }
        public static void main(String[] args) {
            System.out.println("Count => ");
            sc = new Scanner(System.in);
            int count = sc.nextInt();
            sc.nextLine();
            Cars[]cars = fillCars(count);
            printCars(cars);
            int nommin = findCheapestCar(cars);
            System.out.println("Cheapest car:");
            printCar(cars[nommin]);
            System.out.println("Sort by Year:");
            printCars(sortYear(cars));
            System.out.println("Search reg number: ");
            String reg_numF = sc.nextLine();
            Cars carFind = findReg_num(cars, reg_numF);
            if (carFind != null){
                changeCar(carFind);
                System.out.println("New info about car:");
                printCar(carFind);
            } 
            else{ 
                System.out.println("Nothing found"); 
            } 
    }
}

