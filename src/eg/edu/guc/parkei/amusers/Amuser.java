package eg.edu.guc.parkei.amusers;

import java.util.ArrayList;

import eg.edu.guc.parkei.drinks.Drink;
import eg.edu.guc.parkei.drinks.Juice;
import eg.edu.guc.parkei.drinks.Milk;

import eg.edu.guc.parkei.exceptions.CannotDrinkException;
import eg.edu.guc.parkei.exceptions.WrongAgeException;
import eg.edu.guc.parkei.exceptions.WrongTicketException;
import eg.edu.guc.parkei.park.rides.FunRide;
import eg.edu.guc.parkei.utilities.DrinkEffects;
import eg.edu.guc.parkei.utilities.Effect;
import eg.edu.guc.parkei.utilities.Ticket;

public abstract class Amuser implements Rider {
	private String name;
	private int age;
	private int height;
	private boolean riding;
	private FunRide location;
	private ArrayList<Effect> effects = new ArrayList<Effect>();
    private Ticket ticket;
    private ArrayList<DrinkEffects> dEffects = new ArrayList<DrinkEffects>();
	public Amuser() {

	}

	public Amuser(String name, int age, int height) throws WrongAgeException {
		this.name = name;
		
		this.height = height;
		if (this instanceof Baby && (age >= 4 || age <= 0)) {
			throw new WrongAgeException("Baby should be constructed");
		}
		if (this instanceof Adult && (age <= 14 || age > 60)) {
			throw new WrongAgeException("Adult should be constructed");
		}
		if (this instanceof Kid && (age < 4 || age > 14)) {
			throw new WrongAgeException("Kid should be constructed");
		}
		if (this instanceof Senior && (age <= 60)) {
			throw new WrongAgeException("Senior should be constructed");
		}
		this.age = age;

	}

	public final boolean isRiding() {
		return riding;
	}

	public boolean move(FunRide newLocation) {

		location = newLocation;
		return true;

	}
	public Ticket getTicket() {
		return ticket;
	}
		
	public void buyTicket(Ticket ticket)throws WrongTicketException {
		if (this instanceof Baby) {
			if (ticket != Ticket.Micro) {
				throw new WrongTicketException("wrong ticket");
			}
		}
		if (this instanceof Senior || this instanceof Kid) {
			if (ticket != Ticket.Mini) {
				throw new WrongTicketException("wrong ticket");	
			}
		}
		if (this instanceof Adult) {
			if (ticket != Ticket.Maxi) {
				throw new WrongTicketException("wrong ticket");
			}
		}
		this.ticket = ticket;
		
	}
	public abstract boolean buyDrink(Drink d) throws CannotDrinkException, WrongAgeException; 
		
		
	
	public void applyDrinkEffects(DrinkEffects d) {
		this.dEffects.add(d);
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public void drink(Drink d) throws CannotDrinkException, WrongAgeException {
		
			if (d instanceof Milk) {
				this.dEffects.add(DrinkEffects.FRESH);
			}
			if (d instanceof Juice) {
				this.dEffects.add(DrinkEffects.ENERGIZED);
			}
		
	}
	public ArrayList<DrinkEffects> getdEffects() {
		return dEffects;
	}
		
	public final void applyEffect(Effect effect) {
		effects.add(effect);
	}
	public final ArrayList<Effect> getEffects() {
		return effects;
	}
	public final void setEffects(ArrayList<Effect> x) {
		effects = x;
	}

	public final String getName() {
		return name;
	}

	public final int getAge() {
		return age;
	}

	public final FunRide getLocation() {
		return location;
	}

	public final int getHeight() {
		return height;
	}

	public final void setAge(int newAge) {
		age = newAge;
	}

	public final void setRiding(boolean x) {
		riding = x;

	}
	

	public final void setName(String newName) {
		name = newName;
	}

	public final void setLocation(FunRide newLocation) {
		location = newLocation;
	}

	public final void setHeight(int h) {
		height = h;
	}

}
