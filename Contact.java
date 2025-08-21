//Roger Fisher 8/8/2025

package ContactService;

// This class represents a contact person with their basic information
// The contact ID cannot be changed once the contact is created
public class Contact {
    
    // Fields to store contact information
    private final String contactId; // Unique ID - cannot be changed after creation
    private String firstName;       // Person's first name
    private String lastName;        // Person's last name
    private String phone;          // 10-digit phone number
    private String address;        // Home or business address

    // Constructor - creates a new contact with all required information
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        
        // Validate contact ID - must exist and be 10 characters or less
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null or longer than 10 characters.");
        }
        
        // Validate first name - must exist and be 10 characters or less
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null or longer than 10 characters.");
        }
        
        // Validate last name - must exist and be 10 characters or less
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null or longer than 10 characters.");
        }
        
        // Validate phone - must be exactly 10 digits (numbers only, no letters or symbols)
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        
        // Validate address - must exist and be 30 characters or less
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null or longer than 30 characters.");
        }

        // All validation passed - set the contact information
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter methods - these let you read the contact information
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods - these let you update the contact information (except ID)
    
    // Update the first name (with validation)
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null or longer than 10 characters.");
        }
        this.firstName = firstName;
    }

    // Update the last name (with validation)
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null or longer than 10 characters.");
        }
        this.lastName = lastName;
    }

    // Update the phone number (with validation)
    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits.");
        }
        this.phone = phone;
    }

    // Update the address (with validation)
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null or longer than 30 characters.");
        }
        this.address = address;
    }
}