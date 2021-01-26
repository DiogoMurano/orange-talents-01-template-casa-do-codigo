package br.com.zup.bookstore.casadocodigo.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewBuyRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String complement;

    @NotBlank
    private String city;

    @NotNull
    private Long countryId;

    private Long stateId;

    @NotBlank
    private String telNumber;

    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "NewBuyRequest{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", complement='" + complement + '\'' +
                ", city='" + city + '\'' +
                ", countryId=" + countryId +
                ", stateId=" + stateId +
                ", telNumber='" + telNumber + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
