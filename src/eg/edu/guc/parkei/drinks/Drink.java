package eg.edu.guc.parkei.drinks;

public abstract class Drink {
	private int volume;
	public Drink() {
		
	}
	public Drink(int v) {
		volume = v;
	}
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int v) {
		volume = v;
	}

}
