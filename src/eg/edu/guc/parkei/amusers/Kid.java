package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.drinks.Drink;
import eg.edu.guc.parkei.drinks.Juice;

import eg.edu.guc.parkei.exceptions.CannotDrinkException;
import eg.edu.guc.parkei.exceptions.WrongAgeException;



public class Kid extends Amuser {
	public Kid() {
		super();
	}
	public Kid(String name, int age, int height) throws WrongAgeException {
		super(name, age, height);
		
	}
	public boolean buyDrink(Drink d) throws CannotDrinkException, WrongAgeException {
		if (d instanceof Juice && this .getAge() < 6) {
			throw new CannotDrinkException("drink not suitable");
		}
		this.drink(d);
		return true;
		
	}
	
}
