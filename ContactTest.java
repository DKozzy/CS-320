// Roger Fisher 8/8/2025

package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// This class tests the Contact class to ensure it meets all requirements
// Tests cover validation rules, field limits, and both constructor and setter behavior
public class ContactTest {

    // Test that a contact can be created successfully with valid data
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Contact ID validation tests - testing the 10 character limit and null handling

    // Test that creating a contact with null ID throws an exception
    @Test
    public void testNullContactId() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test that creating a contact with ID over 10 characters throws an exception
    @Test
    public void testTooLongContactId() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    // Test that creating a contact with exactly 10 character ID works
    @Test
    public void testContactIdMaxLength() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
    }

    // First name validation tests - testing the 10 character limit and null handling

    // Test that creating a contact with null first name throws an exception
    @Test
    public void testNullFirstName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", null, "Doe", "1234567890", "123 Main St"));
    }

    // Test that creating a contact with first name over 10 characters throws an exception
    @Test
    public void testTooLongFirstName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "FirstnameXXX", "Doe", "1234567890", "123 Main St"));
    }

    // Test that creating a contact with exactly 10 character first name works
    @Test
    public void testFirstNameMaxLength() {
        Contact contact = new Contact("123", "ABCDEFGHIJ", "Doe", "1234567890", "123 Main St");
        assertEquals("ABCDEFGHIJ", contact.getFirstName());
    }

    // Last name validation tests - testing the 10 character limit and null handling

    // Test that creating a contact with null last name throws an exception
    @Test
    public void testNullLastName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", null, "1234567890", "123 Main St"));
    }

    // Test that creating a contact with last name over 10 characters throws an exception
    @Test
    public void testTooLongLastName() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "LastnameXXX", "1234567890", "123 Main St"));
    }

    // Test that creating a contact with exactly 10 character last name works
    @Test
    public void testLastNameMaxLength() {
        Contact contact = new Contact("123", "John", "ABCDEFGHIJ", "1234567890", "123 Main St");
        assertEquals("ABCDEFGHIJ", contact.getLastName());
    }

    // Phone number validation tests - testing the exactly 10 digits requirement

    // Test that creating a contact with null phone throws an exception
    @Test
    public void testNullPhone() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", null, "123 Main St"));
    }

    // Test that creating a contact with phone shorter than 10 digits throws an exception
    @Test
    public void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "1234", "123 Main St"));
    }

    // Test that creating a contact with phone longer than 10 digits throws an exception
    @Test
    public void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "123456789012", "123 Main St"));
    }

    // Test that creating a contact with exactly 10 digit phone works
    @Test
    public void testPhoneExactLength() {
        Contact contact = new Contact("123", "John", "Doe", "0123456789", "123 Main St");
        assertEquals("0123456789", contact.getPhone());
    }

    // Test that phone with letters throws an exception (digits only required)
    @Test
    public void testPhoneWithLetters() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "12345abcde", "123 Main St"));
    }

    // Test that phone with symbols throws an exception (digits only required)
    @Test
    public void testPhoneWithSymbols() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "123-456-789", "123 Main St"));
    }

    // Address validation tests - testing the 30 character limit and null handling

    // Test that creating a contact with null address throws an exception
    @Test
    public void testNullAddress() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "1234567890", null));
    }

    // Test that creating a contact with address over 30 characters throws an exception
    @Test
    public void testTooLongAddress() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "1234567890", "1234567890123456789012345678901"));
    }

    // Test that creating a contact with exactly 30 character address works
    @Test
    public void testAddressMaxLength() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123456789012345678901234567890");
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }

    // Setter method tests for firstName - testing updates after object creation

    // Test that updating first name with valid data works
    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    // Test that updating first name to null throws an exception
    @Test
    public void testSetFirstNameNull() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    // Test that updating first name to over 10 characters throws an exception
    @Test
    public void testSetFirstNameTooLong() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("FirstnameXXX"));
    }

    // Test that updating first name to exactly 10 characters works
    @Test
    public void testSetFirstNameMaxLength() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("ABCDEFGHIJ");
        assertEquals("ABCDEFGHIJ", contact.getFirstName());
    }

    // Setter method tests for lastName - testing updates after object creation

    // Test that updating last name with valid data works
    @Test
    public void testSetLastName() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    // Test that updating last name to null throws an exception
    @Test
    public void testSetLastNameNull() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    // Test that updating last name to over 10 characters throws an exception
    @Test
    public void testSetLastNameTooLong() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LastnameXXX"));
    }

    // Test that updating last name to exactly 10 characters works
    @Test
    public void testSetLastNameMaxLength() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("ABCDEFGHIJ");
        assertEquals("ABCDEFGHIJ", contact.getLastName());
    }

    // Setter method tests for phone - testing updates after object creation

    // Test that updating phone with valid data works
    @Test
    public void testSetPhone() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());
    }

    // Test that updating phone to null throws an exception
    @Test
    public void testSetPhoneNull() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    // Test that updating phone to under 10 digits throws an exception
    @Test
    public void testSetPhoneTooShort() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345"));
    }

    // Test that updating phone to over 10 digits throws an exception
    @Test
    public void testSetPhoneTooLong() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123456789012"));
    }

    // Test that updating phone with letters throws an exception
    @Test
    public void testSetPhoneWithLetters() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345abcde"));
    }

    // Setter method tests for address - testing updates after object creation

    // Test that updating address with valid data works
    @Test
    public void testSetAddress() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    // Test that updating address to null throws an exception
    @Test
    public void testSetAddressNull() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    // Test that updating address to over 30 characters throws an exception
    @Test
    public void testSetAddressTooLong() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        String longAddress = "1234567890123456789012345678901";
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(longAddress));
    }

    // Test that updating address to exactly 30 characters works
    @Test
    public void testSetAddressMaxLength() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        String maxAddress = "123456789012345678901234567890";
        contact.setAddress(maxAddress);
        assertEquals(maxAddress, contact.getAddress());
    }

    // ADDITIONAL TESTS FOR COVERAGE BOOST - These are safe additions that won't break existing functionality

    // Test empty string values (valid since not null and within limits)
    @Test
    public void testEmptyStringValues() {
        Contact contact = new Contact("", "", "", "0000000000", "");
        assertEquals("", contact.getContactId());
        assertEquals("", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("0000000000", contact.getPhone());
        assertEquals("", contact.getAddress());
    }

    // Test additional phone validation patterns
    @Test
    public void testPhoneValidationExtended() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "123abc7890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("123", "John", "Doe", "123 456 789", "123 Main St"));
    }

    // Test setter with empty strings (should work)
    @Test
    public void testSettersWithEmptyStrings() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("");
        contact.setLastName("");
        contact.setAddress("");
        
        assertEquals("", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("", contact.getAddress());
    }

    // Test phone setter with additional invalid formats
    @Test
    public void testSetPhoneAdditionalFormats() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(""));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123-456-7890"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123 456 7890"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("(123)456789"));
    }

    // Test single character values at minimum boundary
    @Test
    public void testSingleCharacterValues() {
        Contact contact = new Contact("1", "A", "B", "1234567890", "C");
        assertEquals("1", contact.getContactId());
        assertEquals("A", contact.getFirstName());
        assertEquals("B", contact.getLastName());
        assertEquals("C", contact.getAddress());
    }

    // Test setter updates with single characters
    @Test
    public void testSettersSingleChar() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("X");
        contact.setLastName("Y");
        contact.setAddress("Z");
        
        assertEquals("X", contact.getFirstName());
        assertEquals("Y", contact.getLastName());
        assertEquals("Z", contact.getAddress());
    }
}