package vip.fairy.xml.ch.ch11.JacksonDemo.v7;/*
{
   "firstName": "John",
   "lastName": "Doe",
   "age": 42,
   "address":
   {
      "street": "400 Some Street",
      "city": "Beverly Hills",
      "state": "CA",
      "zipcode": 90210
   },
   "phoneNumbers":
   [
      {
         "type": "home",
         "number": "310 555-1234"
      },
      {
         "type": "fax",
         "number": "310 555-4567"
      }
   ]
}
*/

public class Person {

  private String firstName;
  private String lastName;
  private int age;
  private Address address;
  private PhoneNumber[] phoneNumbers;

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

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public PhoneNumber[] getPhoneNumbers() {
    return phoneNumbers;
  }

  public void setPhoneNumbers(PhoneNumber[] phoneNumbers) {
    this.phoneNumbers = phoneNumbers;
  }

  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer();
    sb.append("firstName = " + firstName + "\n");
    sb.append("lastName = " + lastName + "\n");
    sb.append("age = " + age + "\n");
    sb.append("address\n");
    sb.append("   street = " + address.getStreet() +
        "\n");
    sb.append("   city = " + address.getCity() + "\n");
    sb.append("   state = " + address.getState() + "\n");
    sb.append("   zipcode = " + address.getZipcode() +
        "\n");
    sb.append("phoneNumbers\n");
    for (int i = 0; i < phoneNumbers.length; i++) {
      sb.append("   type = " +
          phoneNumbers[i].getType() + "\n");
      sb.append("   number = " +
          phoneNumbers[i].getNumber() + "\n");
    }
    return sb.toString();
  }

  public static class Address {

    private String street, city, state;
    private int zipcode;

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    public String getCity() {
      return city;
    }

    public void setCity(String city) {
      this.city = city;
    }

    public String getState() {
      return state;
    }

    public void setState(String state) {
      this.state = state;
    }

    public int getZipcode() {
      return zipcode;
    }
  }

  public static class PhoneNumber {

    private String type, number;

    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getNumber() {
      return number;
    }

    public void setNumber(String number) {
      this.number = number;
    }
  }
}
