package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in the intern book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Tag {

    public static final String MESSAGE_CONSTRAINTS = "Tags names should be alphanumeric and '/' characters only. "
                                                        + "And it can contain spaces between words.";
    public static final String VALIDATION_REGEX = "\\b\\p{Alnum}+(?:[/ ]*\\p{Alnum}+)*\\b";
    public static final String DUPLICATE_TAG = "There should not be duplicate tags.";

    private final String tagName;

    /**
     * Constructs a {@code Tag}.
     *
     * @param tagName A valid tag name.
     */
    public Tag(String tagName) {
        requireNonNull(tagName);
        checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        this.tagName = tagName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Tag)) {
            return false;
        }

        Tag otherTag = (Tag) other;
        return tagName.equalsIgnoreCase(otherTag.tagName);
    }

    @Override
    public int hashCode() {
        return tagName.toLowerCase().hashCode();
    }

    /**
     * Returns the tag name.
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + capitalise() + ']';
    }

    /**
     * Capitalises the first letter of each word in the tag name.
     */
    public String capitalise() {
        String[] words = tagName.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word.substring(0, 1).toUpperCase()
                    + word.substring(1).toLowerCase() + " ");
        }
        return result.toString().trim();
    }
}
