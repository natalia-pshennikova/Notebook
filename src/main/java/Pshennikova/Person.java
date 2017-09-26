package Pshennikova;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person extends Note {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private List<String> phones = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void addPhones(String... phones) {
        Collections.addAll(this.phones, phones);
    }

    @Override
    public boolean contains(String str) {
        String strLower = str.toLowerCase();

        if (super.contains(str)) {
            return true;
        } else {
            String firstNameLower = firstName.toLowerCase();
            if (firstNameLower.contains(strLower)) {
                return true;
            } else {
                String lastNameLower = lastName.toLowerCase();
                if (lastNameLower.contains(strLower)) {
                    return true;
                } else {
                    String addressLower = address.toLowerCase();
                    if (addressLower.contains(strLower)) {
                        return true;
                    } else {
                        String emailLower = email.toLowerCase();
                        if (emailLower.contains(strLower)) {
                            return true;
                        } else {
                            for (String p : phones) {
                                String pLower = p.toLowerCase();
                                if (pLower.contains(strLower)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phones=" + phones +
                ", text='" + getText() + '\'' +
                '}';
    }
}
