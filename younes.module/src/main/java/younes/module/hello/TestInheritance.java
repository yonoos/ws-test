package younes.module.hello;

import fr.jee.api.MyStartupable;

public class TestInheritance implements MyStartupable {

	@Override
	public boolean run() {
		System.out.println("je suis dans mon module");
		return false;
	}

}
