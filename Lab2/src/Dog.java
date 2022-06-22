/**
 * This is a class that simulates a dog a person might own.
 * @author Chiemi Mita
 * @since 2019-01-17
 */
public class Dog {
	enum Sex {male, female};
	private String name, breed;
	private int age;
	private Sex sexType;
	private static int numOfDogs=0;
	
	/**
	 * This is a constructor
	 * @param name the name of the dog
	 * @param breed the breed of the dog
	 * @param sexType the sex of the dog
	 * @param age the age of the dog
	 */
	public Dog (String name, String breed, Sex sexType, int age){
		this.name=name;
		this.breed=breed;
		this.sexType=sexType;
		if (age<0)
			this.age=0;
		else
			this.age=age;
		numOfDogs++;
	}
	/**
	 * This is a getter which gets the name of the dog
	 * @return a String name of the dog
	 */
	public String getName() {
		return name;
	}
	/**
	 * This is a setter which sets the name of the dog
	 * @param name the name to be set
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 * This is a getter which gets the breed of the dog
	 * @return a String breed of the dog
	 */
	public String getBreed() {
		return breed;
	}
	/**
	 * This is a setter which sets the breed of the dog
	 * @param breed the breed to be set
	 */
	public void setBreed(String breed) {
		this.breed=breed;
	}
	/**
	 * This is a getter which gets the age of the dog
	 * @return age of the dog
	 */
	public int getAge() {
		return age;
	}
	/**
	 * This is a setter which sets the age of the dog
	 * @param age the age to be set
	 */
	public void setAge(int age) {
		if (age<0)
			this.age=0;
		else
			this.age=age;
	}
	/**
	 * This is a getter which gets the sex of the dog
	 * @return sex of the dog
	 */
	public Sex getSex() {
		return sexType;
	}
	/**
	 * This is a setter which sets the sex of the dog
	 * @param sexType the sex of the dog
	 */
	public void setSex(Sex sexType) {
		this.sexType=sexType;
	}
	/**
	 * This is a method that computes the age of the Dog in human years
	 * @return age the age of the Dog in human years
	 */
	public int getHumanAge() {
		if (age<0)
			return 0;
		else
			return age*7;
	}
	/**
	 * This is a getter which gets the total number of Dogs
	 * @return numOfDogs the total number of Dogs
	 */
	public static int getTotalDogs() {
		return numOfDogs;
	}
	/**
	 * This is a method that resets the total number of Dogs back to 0.
	 */
	public static void resetTotalDogs() {
		numOfDogs = 0;
	}
	/**
	 * This is a method for printing out the summary about a dog
	 */
	public String toString() {
		String result = "Dog [name="+this.name+", breed="+this.breed+", sex="+this.sexType+", age="+this.age+"]";
		return result;
	}
	/**
	 * This is a method that 
	 * @param d the Dog to be mated
	 * @param name the name for the new Dog
	 * @return a new Dog if two dogs can be mated, null otherwise.
	 */
	public Dog mate (Dog d, String name) {
		if (this.sexType == d.sexType) {
			return null;
		}
		else {
			Dog puppy = new Dog (name, breed+" "+d.breed, Sex.male, 0);
			int num = (int) Math.round(Math.random());
			if (num==0) 
				puppy.sexType = Sex.male;
			else
				puppy.sexType =Sex.male;
			return puppy;
		}	
	}
}





