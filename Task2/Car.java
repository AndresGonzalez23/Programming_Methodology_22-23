package Task2;

public class Car {
    private String model;
    private String fuel_Type;
    private double number_Seat;
    private String transmision;
    private double tank_Capacity;
    private double fuel_Consumption;
    private boolean completed;
    private double consumptionOnTrip;

    public Car(String model, String fuel_Type, double number_Seat, String transmision, double tank_Capacity, double fuel_Consumption) {
        this.model = model;
        this.fuel_Type = fuel_Type;
        this.number_Seat = number_Seat;
        this.transmision = transmision;
        this.tank_Capacity = tank_Capacity;
        this.fuel_Consumption = fuel_Consumption;
        this.completed = false;
        this.consumptionOnTrip = 999;
    }

    public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public double getConsumptionOnTrip() {
		return consumptionOnTrip;
	}

	public void setConsumptionOnTrip(double consumptionOnTrip) {
		this.consumptionOnTrip = consumptionOnTrip;
	}

	public String getModel() {
		return model;
	}

	public String getFuel_Type() {
		return fuel_Type;
	}

	public double getNumber_Seat() {
		return number_Seat;
	}

	public String getTransmision() {
		return transmision;
	}

	public double getTank_Capacity() {
		return tank_Capacity;
	}

	public double getFuel_Consumption() {
		return fuel_Consumption;
	}

}