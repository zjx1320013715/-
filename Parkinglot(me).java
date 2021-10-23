package hw2;

import java.util.ArrayList;

public class ParkingSystem implements IParking {

    int bigPSpace, mediumPSpace, smallPSpace;
    ArrayList<Boolean> availability = new ArrayList<>();

    ParkingSystem(int bigPSpace, int mediumPSpace, int smallPSpace) {
        this.bigPSpace = bigPSpace;
        this.mediumPSpace = mediumPSpace;
        this.smallPSpace = smallPSpace;
    }

    @Override
    public void printParkingAvailabilitySequentialy() {
        System.out.println(availability);
    }

    @Override
    public boolean parkCar(int carType) {
        if(carType == 1 && bigPSpace > 0) {
            bigPSpace--;
            return availability.add(true);
        }
        else if(carType == 2 && mediumPSpace > 0) {
            mediumPSpace--;
            return availability.add(true);
        }
        else if(carType == 3 && smallPSpace > 0) {
            smallPSpace--;
            return availability.add(true);
        }
        else {
            availability.add(false);
            return false;
        }
    }

    public static void main(String[] args) {
        IParams iParams = IParking.inputParams();
        ParkingSystem parkingSystem = new ParkingSystem(iParams.getBigPSpace(), iParams.getMediumPSpace(), iParams.getSmallPSpace());
        ArrayList<Integer> plan = iParams.getParkingPlan();
        for(int i = 0; i < plan.size(); i++) {
            parkingSystem.parkCar(plan.get(i));
        }
        parkingSystem.printParkingAvailabilitySequentialy();
    }
}
