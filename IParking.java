package hw2;

import java.util.ArrayList;
import java.util.Scanner;

public interface IParking {

    void printParkingAvailabilitySequentialy();

    boolean parkCar(int carType);

    static IParams inputParams() {
        int bigPSpace, mediumPSpace, smallPSpace;
        ArrayList<Integer> parkingPlan = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("请设置停车系统拥有的大车位：（输入一个整数并回车）");
        bigPSpace = sc.nextInt();
        System.out.println("请设置停车系统拥有的中车位：（输入一个整数并回车）");
        mediumPSpace = sc.nextInt();
        System.out.println("请设置停车系统拥有的小车位：（输入一个整数并回车）");
        smallPSpace = sc.nextInt();
        System.out.println("请依次输入想停的车（1/2/3），每输入一辆车，按回车；结束请输入0。");
        while(true) {
            int nextCar = sc.nextInt();
            if(nextCar == 1 || nextCar == 2 || nextCar == 3) {
                parkingPlan.add(nextCar);
            }
            else if(nextCar == 0) {
                break;
            }
        }
        return new IParams() {
            @Override
            public int getBigPSpace() {
                return bigPSpace;
            }

            @Override
            public int getMediumPSpace() {
                return mediumPSpace;
            }

            @Override
            public int getSmallPSpace() {
                return smallPSpace;
            }

            @Override
            public ArrayList<Integer> getParkingPlan() {
                return parkingPlan;
            }
        };
    }

}
