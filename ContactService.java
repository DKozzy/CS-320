//Roger Fisher 8/8/2025

package ContactService;

import java.util.HashMap;

// This class manages a collection of contacts
// It handles adding, deleting, and updating contact information
public class ContactService {

    // HashMap stores all contacts - contactId is the key, Contact object is the value
    // This allows fast lookup, addition, and removal of contacts
    private HashMap<String, Contact> contacts = new HashMap<>();

    // Add a new contact to the service
    // Throws error if contact is null or ID already exists
    public void addContact(Contact contact) {
        // Check if the contact is null or already exists
        if (contact == null || contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact is null or already exists.");
        }
        // Add the contact to our HashMap using the contactId as the key
        contacts.put(contact.getContactId(), contact);
    }

    // Remove a contact from the service using their ID
    // Throws error if the contact ID doesn't exist
    public void deleteContact(String contactId) {
        // Check if contact exists before trying to delete
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found.");
        }
        // Remove the contact from our HashMap
        contacts.remove(contactId);
    }

    // Update Methods - these find the contact and change specific information

    // Update a contact's first name
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = getContactById(contactId); // Find the contact first
        contact.setFirstName(newFirstName);          // Update their first name
    }

    // Update a contact's last name
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = getContactById(contactId); // Find the contact first
        contact.setLastName(newLastName);            // Update their last name
    }

    // Update a contact's phone number
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = getContactById(contactId); // Find the contact first
        contact.setPhone(newPhone);                  // Update their phone number
    }

    // Update a contact's address
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = getContactById(contactId); // Find the contact first
        contact.setAddress(newAddress);              // Update their address
    }

    // Helper method to find a contact by their ID
    // This is used by all the update methods above
    // Throws error if the contact doesn't exist
    private Contact getContactById(String contactId) {
        Contact contact = contacts.get(contactId); // Look up contact in HashMap
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        return contact; // Return the found contact
    }
}