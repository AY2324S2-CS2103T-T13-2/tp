package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.ReminderSettings;
import seedu.address.model.company.Company;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Company> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' Reminder settings
     */
    ReminderSettings getReminderSettings();

    /**
     * Sets the user prefs' Reminder settings
     */
    void setReminderSettings(ReminderSettings reminderSettings);

    /**
     * Returns the user prefs' reminder status
     */
    boolean getReminderStatus();

    /**
     * Returns the user prefs' intern book file path.
     */
    Path getInternBookFilePath();

    /**
     * Sets the user prefs' intern book file path.
     */
    void setInternBookFilePath(Path internBookFilePath);

    /**
     * Replaces intern book data with the data in {@code internBook}.
     */
    void setInternBook(ReadOnlyInternBook internBook);

    /** Returns the InternBook */
    ReadOnlyInternBook getInternBook();

    /**
     * Returns true if a company with the same identity as {@code company} exists in the intern book.
     */
    boolean hasCompany(Company company);

    /**
     * Deletes the given company.
     * The company must exist in the intern book.
     */
    void deleteCompany(Company target);

    /**
     * Adds the given company.
     * {@code company} must not already exist in the intern book.
     */
    void addCompany(Company company);

    /**
     * Replaces the given company {@code target} with {@code editedCompany}.
     * {@code target} must exist in the intern book.
     * The company identity of {@code editedCompany} must not be the same as another existing company
     * in the intern book.
     */
    void setCompany(Company target, Company editedCompany);

    /** Returns an unmodifiable view of the filtered company list */
    ObservableList<Company> getFilteredCompanyList();

    /** Returns an unmodifiable view of the filtered list of companies for reminders */
    ObservableList<Company> getFilteredCompaniesRemindersList();

    /**
     * Updates the filter of the filtered company list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredCompanyList(Predicate<Company> predicate);

    /**
     * Sorts the list of companies alphabetically
     */
    void sortCompanyListByName();

    /**
     * Sorts the list of companies in ascending order of startDate
     */
    void sortCompanyListByStartDate();

    /**
     * Sorts the list of companies in ascending order of endDate
     */
    void sortCompanyListByEndDate();

    /**
     * Marks the given company as applied.
     */
    void markCompany(Company target);

    /**
     * Unmarks the given company as applied.
     */
    void unmarkCompany(Company target);

    boolean isCompanyMarked(Company target);
}
