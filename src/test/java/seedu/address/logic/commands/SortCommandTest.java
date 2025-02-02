package seedu.address.logic.commands;


import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalEmployees.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

class SortCommandTest {

    private static final String SALARY_ATTR = "salary";
    private static final String NAME_ATTR = "name";
    private static final String OVERTIME_ATTR = "overtime hours";
    private static final String LEAVES_ATTR = "allocated leaves";
    private static final String INVALID_ATTR = "invalid attribute";
    private static final String NO_ATTR = "";
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    void execute_sortListSalary_success() {
        SortCommand sortCommand = new SortCommand(SALARY_ATTR);

        String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, SALARY_ATTR);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.updateSortedEmployeeList(SALARY_ATTR);

        assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
    }

    @Test
    void execute_sortListName_success() {
        SortCommand sortCommand = new SortCommand(NAME_ATTR);

        String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, NAME_ATTR);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.updateSortedEmployeeList(NAME_ATTR);

        assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
    }

    @Test
    void execute_sortListOvertime_success() {
        SortCommand sortCommand = new SortCommand(OVERTIME_ATTR);

        String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, OVERTIME_ATTR);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.updateSortedEmployeeList(OVERTIME_ATTR);

        assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
    }

    @Test
    void execute_sortListLeaves_success() {
        SortCommand sortCommand = new SortCommand(LEAVES_ATTR);

        String expectedMessage = String.format(SortCommand.MESSAGE_SUCCESS, LEAVES_ATTR);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.updateSortedEmployeeList(LEAVES_ATTR);

        assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
    }

    @Test
    void execute_invalidAttributeSortList_failure() {
        SortCommand sortCommand = new SortCommand(INVALID_ATTR);

        String expectedMessage = String.format(SortCommand.MESSAGE_WRONG_ATTR, INVALID_ATTR);

        assertCommandFailure(sortCommand, model, expectedMessage);
    }

    @Test
    void execute_missingAttributeSortList_failure() {
        SortCommand sortCommand = new SortCommand(NO_ATTR);

        String expectedMessage = SortCommand.MESSAGE_NO_ATTR;

        assertCommandFailure(sortCommand, model, expectedMessage);
    }
}
