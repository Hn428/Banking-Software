import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandStorageTest {
	CommandStorage commandStorage;

	@BeforeEach
	void setUp() {

		commandStorage = new CommandStorage();
	}

	@Test
	public void invalid_command_has_0_command_in_storage() {
		assertEquals(0, commandStorage.getInvalidCommands().size());

	}

	@Test
	public void invalid_command_has_1_command_in_storage() {
		commandStorage.storeInvalidCommands("creat Savings 12312345 5.6");
		assertEquals(1, commandStorage.getInvalidCommands().size());
	}

	@Test
	public void invalid_command_has_2_commands_in_storage() {
		commandStorage.storeInvalidCommands("creat Savings 12312345 5.6");
		commandStorage.storeInvalidCommands("deposit Checking 12345678 500");
		assertEquals(2, commandStorage.getInvalidCommands().size());
	}
}
