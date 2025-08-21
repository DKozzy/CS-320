// Roger Fisher 8/8/2025

package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// This class tests the ContactService class to ensure it properly manages contacts
// Tests cover adding, deleting, and updating contacts through the service
public class ContactServiceTest {

    private ContactService service;  // The service we're testing
    private Contact contact;         // A sample contact for testing

    // This method runs before each test to create fresh objects
    @BeforeEach
    public void setUp() {
        service = new ContactService();  // Create a new service for each test
        contact = new Contact("001", "Jane", "Doe", "5551234567", "456 Elm St");  // Create a sample contact
    }

    // Test that a contact can be added to the service and then updated
    // This tests both add functionality and that the contact is properly stored
    @Test
    public void testAddContact() {
        service.addContact(contact);                    // Add the contact to the service
        service.updateFirstName("001", "Janet");       // Try to update it (this proves it was added)
        assertEquals("Janet", contact.getFirstName());  // Verify the update worked
    }

    // Test that adding the same contact twice throws an exception
    @Test
    public void testAddDuplicateContactFails() {
        service.addContact(contact);  // Add the contact once
        // Try to add the same contact again - this should fail
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    // Test that adding a null contact throws an exception
    @Test
    public void testAddNullContactFails() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    // Test that a contact can be deleted from the service
    @Test
    public void testDeleteContact() {
        service.addContact(contact);      // First add the contact
        service.deleteContact("001");     // Then delete it
        // Try to update the deleted contact - this should fail because it's gone
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("001", "Smith"));
    }

    // Test that trying to delete a contact that doesn't exist throws an exception
    @Test
    public void testDeleteNonexistentContactFails() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("999"));
    }

    // Update method tests - testing that each field can be updated through the service

    // Test that a contact's first name can be updated through the service
    @Test
    public void testUpdateFirstName() {
        service.addContact(contact);                    // Add the contact first
        service.updateFirstName("001", "Janet");       // Update the first name
        assertEquals("Janet", contact.getFirstName());  // Verify the change
    }

    // Test that a contact's last name can be updated through the service
    @Test
    public void testUpdateLastName() {
        service.addContact(contact);                   // Add the contact first
        service.updateLastName("001", "Smith");       // Update the last name
        assertEquals("Smith", contact.getLastName());  // Verify the change
    }

    // Test that a contact's phone can be updated through the service
    @Test
    public void testUpdatePhone() {
        service.addContact(contact);                // Add the contact first
        service.updatePhone("001", "9999999999");  // Update the phone
        assertEquals("9999999999", contact.getPhone());  // Verify the change
    }

    // Test that a contact's address can be updated through the service
    @Test
    public void testUpdateAddress() {
        service.addContact(contact);                   // Add the contact first
        service.updateAddress("001", "789 Oak Rd");   // Update the address
        assertEquals("789 Oak Rd", contact.getAddress());  // Verify the change
    }

    // Test that trying to update a contact that doesn't exist throws an exception
    @Test
    public void testUpdateNonexistentContactFails() {
        // Try to update a contact that was never added - should fail
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Ghost"));
    }

    // Validation tests - ensuring the service properly validates updates through Contact setters

    // Test that updating first name to something too long throws an exception
    @Test
    public void testUpdateFirstNameTooLongFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("001", "ThisNameIsTooLong"));
    }

    // Test that updating first name to null throws an exception
    @Test
    public void testUpdateFirstNameToNullFails() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("001", null));
    }

    // Test that updating last name to null or too long throws an exception
    @Test
    public void testUpdateLastNameNullOrTooLongFails() {
        service.addContact(contact);
        // Test null last name
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("001", null));
        // Test too long last name (11 characters)
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("001", "01234567890"));
    }

    // Test that updating phone to invalid lengths throws an exception
    @Test
    public void testUpdatePhoneInvalidLengthFails() {
        service.addContact(contact);
        // Test phone too short
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("001", "123"));
        // Test phone too long  
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("001", "123456789012"));
    }

    // Test that updating address to null or too long throws an exception
    @Test
    public void testUpdateAddressNullOrTooLongFails() {
        service.addContact(contact);
        // Test null address
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("001", null));
        // Test too long address (31 characters)
        String longAddress = "1234567890123456789012345678901";
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("001", longAddress));
    }

    // Boundary testing - testing updates right at the character limits

    // Test that updating first name to exactly 10 characters works
    @Test
    public void testUpdateFirstNameToMaxLength() {
        service.addContact(contact);
        service.updateFirstName("001", "ABCDEFGHIJ");   // Exactly 10 characters
        assertEquals("ABCDEFGHIJ", contact.getFirstName());
    }

    // Test that updating address to exactly 30 characters works
    @Test
    public void testUpdateAddressToMaxLength() {
        service.addContact(contact);
        String maxAddress = "123456789012345678901234567890";  // Exactly 30 characters
        service.updateAddress("001", maxAddress);
        assertEquals(maxAddress, contact.getAddress());
    }

    // ADDITIONAL TESTS FOR COVERAGE BOOST - Safe additions that won't break existing functionality

    // Test adding multiple different contacts
    @Test
    public void testAddMultipleContacts() {
        Contact contact2 = new Contact("002", "John", "Smith", "5559876543", "789 Oak Rd");
        service.addContact(contact);
        service.addContact(contact2);
        
        // Both should be accessible for updates
        service.updateFirstName("001", "Janet");
        service.updateLastName("002", "Johnson");
        
        assertEquals("Janet", contact.getFirstName());
        assertEquals("Johnson", contact2.getLastName());
    }

    // Test deleting one contact doesn't affect others
    @Test
    public void testDeleteOneOfMultiple() {
        Contact contact2 = new Contact("002", "John", "Smith", "5559876543", "789 Oak Rd");
        service.addContact(contact);
        service.addContact(contact2);
        
        service.deleteContact("001");
        
        // First should be gone, second should still work
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("001", "Test"));
        service.updateFirstName("002", "Johnny"); // This should work
        assertEquals("Johnny", contact2.getFirstName());
    }

    // Test all update methods fail for non-existent contact
    @Test
    public void testAllUpdateMethodsFailForNonexistent() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Test"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("999", "Test"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("999", "1234567890"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("999", "Test"));
    }

    // Test updating with empty strings (should work since they're valid in Contact)
    @Test
    public void testUpdateWithEmptyStrings() {
        service.addContact(contact);
        
        service.updateFirstName("001", "");
        service.updateLastName("001", "");
        service.updateAddress("001", "");
        
        assertEquals("", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("", contact.getAddress());
    }

    // Test updating with maximum length values
    @Test
    public void testUpdateWithMaxLengthValues() {
        service.addContact(contact);
        
        String maxFirstName = "ABCDEFGHIJ";  // 10 chars
        String maxLastName = "ZYXWVUTSRQ";   // 10 chars
        String maxAddress = "123456789012345678901234567890";  // 30 chars
        
        service.updateFirstName("001", maxFirstName);
        service.updateLastName("001", maxLastName);
        service.updateAddress("001", maxAddress);
        
        assertEquals(maxFirstName, contact.getFirstName());
        assertEquals(maxLastName, contact.getLastName());
        assertEquals(maxAddress, contact.getAddress());
    }

    // Test adding contact with duplicate ID but different contact object
    @Test
    public void testAddContactWithSameId() {
        service.addContact(contact);
        Contact duplicateId = new Contact("001", "Different", "Person", "1111111111", "Different Address");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicateId));
    }

    // Test phone update with additional invalid formats
    @Test
    public void testUpdatePhoneWithInvalidFormats() {
        service.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("001", ""));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("001", "123-456-7890"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("001", "abcdefghij"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("001", "123 456 789"));
    }

    // Test that last name can be updated to max length
    @Test
    public void testUpdateLastNameToMaxLength() {
        service.addContact(contact);
        service.updateLastName("001", "ABCDEFGHIJ");   // Exactly 10 characters
        assertEquals("ABCDEFGHIJ", contact.getLastName());
    }

    // Test phone update to max length (which is exactly 10 digits)
    @Test
    public void testUpdatePhoneToMaxLength() {
        service.addContact(contact);
        service.updatePhone("001", "9999999999");   // Exactly 10 digits
        assertEquals("9999999999", contact.getPhone());
    }
}