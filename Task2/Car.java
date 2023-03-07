package Task2;

public class Car /*implements Comparable<Car> */{
    private String model;
    private String fuel_Type;
    private double number_Seat;
    private String transmision;
    private double tank_Capacity;
    private double fuel_Consumption;

    public Car(String model, String fuel_Type, double number_Seat, String transmision, double tank_Capacity, double fuel_Consumption) {
        this.model = model;
        this.fuel_Type = fuel_Type;
        this.number_Seat = number_Seat;
        this.transmision = transmision;
        this.tank_Capacity = tank_Capacity;
        this.fuel_Consumption = fuel_Consumption;
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

	
	//Aqui decidir que variable del coche usaremos para comparar con el resto de coches a la hora de hacer el metodo de ordenacion
	
	
	/*@Override
    public int compareTo(Car otroCoche) {
        if (this.precio < otroCoche.getPrecio()) {
            return -1;
        } else if (this.precio > otroCoche.getPrecio()) {
            return 1;
        } else {
            return 0;
        }
    }*/
}
