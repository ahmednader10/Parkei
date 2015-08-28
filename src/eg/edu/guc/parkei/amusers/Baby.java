package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.drinks.Drink;
import eg.edu.guc.parkei.drinks.Juice;

import eg.edu.guc.parkei.exceptions.CannotDrinkException;
import eg.edu.guc.parkei.exceptions.WrongAgeException;




public class Baby extends Amuser {
	public Baby() {
		super();
	}
	public Baby(String name, int age, int height) throws WrongAgeException {
		super(name, age, height);
		
	}
	public boolean buyDrink(Drink d) throws CannotDrinkException, WrongAgeException {
		if (d instanceof Juice) {
			throw new CannotDrinkException("drink not suitable");
		}
		this.drink(d);
		return true;
	}
	
	


}
