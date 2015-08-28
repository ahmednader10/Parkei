package eg.edu.guc.parkei.tests;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

import eg.edu.guc.parkei.utilities.DrinkEffects;
import eg.edu.guc.parkei.amusers.Adult;
import eg.edu.guc.parkei.amusers.Amuser;
import eg.edu.guc.parkei.amusers.Baby;
import eg.edu.guc.parkei.amusers.Kid;
import eg.edu.guc.parkei.amusers.Senior;
import eg.edu.guc.parkei.drinks.Drink;
import eg.edu.guc.parkei.drinks.Juice;
import eg.edu.guc.parkei.drinks.Milk;
import eg.edu.guc.parkei.exceptions.CannotDrinkException;

import eg.edu.guc.parkei.exceptions.WrongAgeException;

import static org.junit.Assert.*;

public class DrinkTest {

	@org.junit.Test(timeout = 1000)
	public void testBabyBuyMilk() throws WrongAgeException,
			CannotDrinkException {
		Baby baby = new Baby("lolo", 2, 30);
		Milk nestle = new Milk(100);
		assertTrue("Babies can buy milk !!", baby.buyDrink(nestle));
	}

	@org.junit.Test(timeout = 1000)
	public void testKidBuyMilk() throws WrongAgeException, CannotDrinkException {
		Kid kid = new Kid("soso", 5, 30);
		Milk nestle = new Milk(100);
		assertTrue("Kids can buy milk !!", kid.buyDrink(nestle));
	}

	@org.junit.Test(timeout = 1000)
	public void testAdultBuyMilk() throws WrongAgeException,
			CannotDrinkException {
		Adult adult = new Adult("7mada", 20, 30);
		Milk nestle = new Milk(100);
		assertTrue("Adults can buy milk !!", adult.buyDrink(nestle));
	}

	@org.junit.Test(timeout = 1000)
	public void testSeniorBuyMilk() throws WrongAgeException,
			CannotDrinkException {
		Senior senior = new Senior("geddo", 70, 30);
		Milk nestle = new Milk(100);
		assertTrue("Seniors can buy milk !!", senior.buyDrink(nestle));
	}

	@org.junit.Test(timeout = 1000)
	public void testAdultBuyJuice() throws WrongAgeException,
			CannotDrinkException {
		Adult adult = new Adult("7mada", 20, 30);
		Juice paradise = new Juice(100);
		assertTrue("Adults can buy juice !!", adult.buyDrink(paradise));
	}

	@org.junit.Test(timeout = 1000)
	public void testSeniorBuyJuice() throws WrongAgeException,
			CannotDrinkException {
		Senior senior = new Senior("geddo", 70, 30);
		Juice paradise = new Juice(100);
		assertTrue("Seniors can buy juice !!", senior.buyDrink(paradise));
	}

	@org.junit.Test(timeout = 1000)
	public void testMilkEffect() throws WrongAgeException, CannotDrinkException {
		Baby baby = new Baby("lolo", 2, 30);
		Milk nestle = new Milk(100);
		baby.buyDrink(nestle);
		assertTrue("Amusers should be fresh after drinking milk!!", baby
				.getdEffects().contains(DrinkEffects.FRESH));
	}

	@org.junit.Test(timeout = 1000)
	public void testJuiceEffect() throws WrongAgeException,
			CannotDrinkException {
		Adult adult = new Adult("koko", 20, 30);
		Juice paradise = new Juice(100);
		adult.buyDrink(paradise);
		assertTrue("Amusers should be fresh after drinking milk!!", adult
				.getdEffects().contains(DrinkEffects.ENERGIZED));
	}

	@org.junit.Test(timeout = 1000)
	public void testGetVolume() {
		Juice paradise = new Juice(100);
		assertEquals("volume should be 100 as expected from construction", 100,
				paradise.getVolume());
	}

	@org.junit.Test(timeout = 1000)
	public void testVolumeEncapsulation() throws NoSuchFieldException {
		Field field = Drink.class.getDeclaredField("volume");
		assertEquals("Instance variables should be private", 2,
				field.getModifiers());
	}

	@org.junit.Test(timeout = 1000)
	public void testDrinkSetVolume() {
		Juice paradise = new Juice(100);
		paradise.setVolume(200);
		assertEquals("Volume should be 200 as expected from setting volume",
				200, paradise.getVolume());
	}

	@org.junit.Test(timeout = 1000)
	public void testInheritance() {
		assertEquals("Class Milk should inheret from Drink",
				Milk.class.getSuperclass(), Drink.class);

	}

	@org.junit.Test(timeout = 1000)
	public void testInheritance2() {
		assertEquals("Class Juice should inheret from Worker",
				Juice.class.getSuperclass(), Drink.class);

	}

	@Test(expected = CannotDrinkException.class)
	public void testBabyException() throws CannotDrinkException,
			WrongAgeException {
		Baby baby = new Baby("lolo", 2, 30);
		Juice paradise = new Juice(100);
		baby.buyDrink(paradise);
	}

	@Test(expected = CannotDrinkException.class)
	public void testKidException() throws CannotDrinkException,
			WrongAgeException {
		Kid kid = new Kid("momo", 5, 30);
		Juice paradise = new Juice(100);
		kid.buyDrink(paradise);
	}

	@org.junit.Test(timeout = 1000)
	public void testKidCanBuyJuice() throws CannotDrinkException,
			WrongAgeException {
		Kid kid = new Kid("momo", 7, 30);
		Juice paradise = new Juice(100);
		assertTrue("Kids that are 6 years old and above can buy Juice",
				kid.buyDrink(paradise));
	}

	@org.junit.Test(timeout = 1000)
	public void testAbstraction() {
		assertTrue(Modifier.isAbstract(Drink.class.getModifiers()));
	}

	@org.junit.Test(timeout = 1000)
	public void testAbstractMethod() throws NoSuchMethodException {
		assertTrue(Modifier.isAbstract(Amuser.class.getMethod("buyDrink",
				Drink.class).getModifiers()));
	}

}
