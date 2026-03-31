// ================= BASE CLASS =================
class User {
    String name;
    String phone;
    String location;

    public User(String name, String phone, String location) {
        this.name = name;
        this.phone = phone;
        this.location = location;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Phone: " + phone + ", Location: " + location);
    }
}

// ================= RIDE USER =================
class RideUser extends User {
    String vehicleType;

    public RideUser(String name, String phone, String location, String vehicleType) {
        super(name, phone, location);
        this.vehicleType = vehicleType;
    }

    public void displayRide() {
        System.out.println(name + " booked a ride using " + vehicleType);
    }
}

// ================= FOOD USER =================
class FoodUser extends User {
    String favoriteFood;

    public FoodUser(String name, String phone, String location, String favoriteFood) {
        super(name, phone, location);
        this.favoriteFood = favoriteFood;
    }

    public void orderFood() {
        System.out.println(name + " ordered favorite food: " + favoriteFood);
    }
}

// ================= PARCEL USER =================
class ParcelUser extends User {
    double parcelWeight;

    public ParcelUser(String name, String phone, String location, double parcelWeight) {
        super(name, phone, location);
        this.parcelWeight = parcelWeight;
    }

    public void sendParcel() {
        System.out.println(name + " is sending parcel of weight: " + parcelWeight + " kg");
    }
}

// ================= MAIN CLASS =================
public class MultiBookingApp {
    public static void main(String[] args) {

        // Ride Booking
        RideUser rideUser = new RideUser("Gg", "1320924232", "Chennai", "Bike");
        rideUser.displayInfo();
        rideUser.displayRide();

        System.out.println("--------------------");

        // Food Delivery
        FoodUser foodUser = new FoodUser("Dhepp", "8823423428", "vellore", "Pizza");
        foodUser.displayInfo();
        foodUser.orderFood();

        System.out.println("--------------------");

        // Parcel Delivery
        ParcelUser parcelUser = new ParcelUser("Dd", "7232342344", "Hyderabad", 2.5);
        parcelUser.displayInfo();
        parcelUser.sendParcel();
    }
}