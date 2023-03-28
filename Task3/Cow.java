package Task3;

public class Cow implements Comparable<Cow> {
	
	public int code;
	private int neccesarySpace;
	private double foodConsumption;
    private double milkProduced;
    
    public Cow(int code, int neccesarySpace, double foodConsumption, double milkProduced) {
    	this.code = code;
        this.neccesarySpace = neccesarySpace;
    	this.foodConsumption = foodConsumption;
        this.milkProduced = milkProduced;
    }
        
    public int getCode() {
		return code;
	}

	public int getNeccesarySpace() {
		return neccesarySpace;
	}

    public double getFoodConsumption() {
        return foodConsumption;
    }
    
    public double getMilkProduced() {
        return milkProduced;
    }
    
    @Override
    public int compareTo(Cow other) {
        double myRatio = milkProduced / neccesarySpace;
        double otherRatio = other.milkProduced / other.neccesarySpace;
        return Double.compare(otherRatio, myRatio);
    }

}