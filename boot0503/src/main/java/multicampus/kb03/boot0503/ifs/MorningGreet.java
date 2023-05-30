package multicampus.kb03.boot0503.ifs;

import org.springframework.stereotype.Component;

@Component
public class MorningGreet implements Greet {
	
	@Override
	public String greeting() {
		return "Good Morning!";
	}
}
