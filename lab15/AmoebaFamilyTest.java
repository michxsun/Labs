import junit.framework.TestCase;


public class AmoebaFamilyTest extends TestCase {

	public void testHeight() {
		AmoebaFamily test = new AmoebaFamily("test");
		test.addChild("test", "mom");
		test.addChild("test", "dad");
		assertEquals(2, test.height());
		
		AmoebaFamily family = new AmoebaFamily("Amos McCoy");
		family.addChild("Amos McCoy", "mom/dad");
		family.addChild("Amos McCoy", "auntie");
		family.addChild("mom/dad", "me");
		family.addChild("mom/dad", "Fred");
		family.addChild("mom/dad", "Wilma");
		family.addChild("me", "Mike");
		family.addChild("me", "Homer");
		family.addChild("me", "Marge");
		family.addChild("Mike", "Bart");
		family.addChild("Mike", "Lisa");
		family.addChild("Marge", "Bill");
		family.addChild("Marge", "Hilary");
		assertEquals(5, family.height());
	}
}
