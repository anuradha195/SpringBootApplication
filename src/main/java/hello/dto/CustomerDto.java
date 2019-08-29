package hello.dto;


public class CustomerDto {

    //TODO: Fill with data corresponding to Customer entity
    private Long id;
    private String firstName;
    private String lastName;

    public CustomerDto(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public CustomerDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
