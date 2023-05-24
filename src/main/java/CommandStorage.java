import java.util.ArrayList;
import java.util.List;

public class CommandStorage {

	private List<String> invalidCommands = new ArrayList<>();

	public CommandStorage() {
	}

	public void storeInvalidCommands(String command) {
		invalidCommands.add(command);
	}

	public List<String> getInvalidCommands() {
		return invalidCommands;
	}

}
