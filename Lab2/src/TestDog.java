import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDog {

	@Test
	void testConstuctor() {
		Dog fido = new Dog("Fido", "Mutt", Dog.Sex.male, 2);
		assertEquals("Fido", fido.getName());
		assertEquals("Mutt", fido.getBreed());
		assertEquals(Dog.Sex.male, fido.getSex());
		assertEquals(2, fido.getAge());
		
		Dog spot = new Dog("Spot", "Mutt", Dog.Sex.male, -15);
		assertEquals(0, spot.getAge());
	}
	
	@Test
	void testGetSetName() {
		Dog peaches = new Dog("Peaches", "Poodle", Dog.Sex.female, 5);
		assertEquals("Peaches", peaches.getName());
		peaches.setName("Peachy");
		assertEquals("Peachy", peaches.getName());
		peaches.setName("");
		assertEquals("", peaches.getName());
		peaches.setName("007");
		assertEquals("007", peaches.getName());
		peaches.setName(null);
		assertNull(peaches.getName());
	}
	@Test
	void testGetSetBreed() {
		Dog peaches = new Dog("Peaches", "Poodle", Dog.Sex.female, 5);
		assertEquals("Poodle", peaches.getBreed());
		peaches.setBreed("Toy Poodle");
		assertEquals("Toy Poodle", peaches.getBreed());
		peaches.setBreed("");
		assertEquals("", peaches.getBreed());
		peaches.setBreed("007");
		assertEquals("007", peaches.getBreed());
		peaches.setBreed(null);
		assertNull(peaches.getBreed());
	}
	@Test
	void testGetSetDog() {
		Dog peaches = new Dog("Peaches", "Poodle", Dog.Sex.female, 5);
		assertEquals(Dog.Sex.female, peaches.getSex());
		peaches.setSex(Dog.Sex.male);
		assertEquals(Dog.Sex.male, peaches.getSex());
		peaches.setSex(Dog.Sex.female);
		assertEquals(Dog.Sex.female, peaches.getSex());
		peaches.setSex(null);
		assertEquals(null, peaches.getSex());
	}
	@Test
	void testGetSetAge() {
		Dog peaches = new Dog("Peaches", "Poodle", Dog.Sex.female, 5);
		assertEquals(5, peaches.getAge());
		peaches.setAge(0);
		assertEquals(0, peaches.getAge());
		peaches.setAge(10);
		assertEquals(10, peaches.getAge());
		peaches.setAge(-1);
		assertEquals(0, peaches.getAge());
		peaches.setAge(123456789);
		assertEquals(123456789, peaches.getAge());
	}
	
	@Test
	void testGetSetTotalDogs() {
		Dog.resetTotalDogs();
		assertEquals(0, Dog.getTotalDogs());
		Dog fluffy = new Dog("Fluffy", "Boston Terrier", Dog.Sex.female, 2);
		assertEquals(1, Dog.getTotalDogs());
		Dog jax = new Dog("Jax", "Boston Terrier", Dog.Sex.male, 3);
		assertEquals(2, Dog.getTotalDogs());
		Dog puppy = fluffy.mate(jax, "Ace");
		assertEquals(3, Dog.getTotalDogs());
		Dog.resetTotalDogs();
		assertEquals(0, Dog.getTotalDogs());
	}
	
	@Test
	void testGetHumanYears() {
		Dog wishbone = new Dog("Wishbone", "Jack Russel", Dog.Sex.male, 0);
		assertEquals(0, wishbone.getHumanAge());
		wishbone.setAge(-1);
		assertEquals(0, wishbone.getHumanAge());
		wishbone.setAge(1);
		assertEquals(7, wishbone.getHumanAge());
		wishbone.setAge(2);
		assertEquals(14, wishbone.getHumanAge());
		wishbone.setAge(7);
		assertEquals(49, wishbone.getHumanAge());
	}
	@Test
	void testToString() {
		
		String result = "Dog [name=Parker, breed=Labrador, sex=male, age=5]";
		Dog parker = new Dog("Parker", "Labrador", Dog.Sex.male, 5);
		assertEquals(result, parker.toString());
		
		
	}
	@Test
	void testMate() {
		Dog.resetTotalDogs();
		
		Dog parker = new Dog("Parker", "Labrador", Dog.Sex.male, 5);
		Dog posey = new Dog("Posey", "Poodle", Dog.Sex.female, 4);
		Dog pongo = new Dog("Pongo", "Dalmatian", Dog.Sex.male, 2);
		Dog perdita = new Dog("Perdita", "Dalmatian", Dog.Sex.female, 2);
		
		assertNull(parker.mate(pongo, "Pansy"));
		assertNull(posey.mate(perdita, "Petunia"));
		
		Dog puppy = parker.mate(posey, "Patch");
		assertEquals("Patch", puppy.getName());
		assertEquals("Labrador Poodle", puppy.getBreed());
		assertEquals(0, puppy.getAge());
		boolean sex = puppy.getSex() == Dog.Sex.male || puppy.getSex() == Dog.Sex.female;
		assertTrue(sex);
		
		
		
	}
}
