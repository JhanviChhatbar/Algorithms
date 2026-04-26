import java.util.Arrays;

public class ParkingDilemma {

    public int carParkingRoof(int[] cars, int k) {
        Arrays.sort(cars);

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= cars.length - k; i++) {
            int length = cars[i + k - 1] - cars[i] + 1;
            minLength = Math.min(minLength, length);
        }

        return minLength;
    }

    public static void main(String[] args) {
        ParkingDilemma parkingDilemma = new ParkingDilemma();

        int[] cars = {6, 2, 12, 7};
        int k = 3;

        System.out.println(parkingDilemma.carParkingRoof(cars, k));
    }
}
