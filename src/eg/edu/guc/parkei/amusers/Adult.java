package eg.edu.guc.parkei.amusers;

import eg.edu.guc.parkei.drinks.Drink;

import eg.edu.guc.parkei.exceptions.CannotDrinkException;
import eg.edu.guc.parkei.exceptions.WrongAgeException;





public class Adult extends Amuser {
	public Adult() {
		super();
	}
	public Adult(String name, int age, int height) throws WrongAgeException {
		super(name, age, height);
		
	}
	public boolean buyDrink(Drink d) throws CannotDrinkException, WrongAgeException {
		this.drink(d);
		return true;
	}
	
}
