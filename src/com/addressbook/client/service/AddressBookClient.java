package com.addressbook.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.joda.time.DateTime;

import com.addressbook.response.model.AddressDetails;
import com.addressbook.response.model.ContactNumberDetails;
import com.addressbook.response.model.EmailAddressDetails;
import com.addressbook.response.model.PersonDetails;
import com.addressbook.service.response.AddressBookResponse;
import com.addressbook.service.response.ErrorMessages;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

/**
 * Client for AddressBookResource
 * 
 * @author Vrushali
 *
 */
public class AddressBookClient {

	public static final String URI = "http://localhost:8080";
	public static final String RESOURCE_PATH = "/AddressBookServer";

	/**
	 * Test method for testing add addressbook record service call
	 */
	public void testGetAddressBookRecord(UUID uuid) {
		ClientConfig config = new DefaultClientConfig();
		Client c = Client.create(config);

		WebResource resource = c.resource(UriBuilder.fromUri(URI).build());
		ClientResponse response = resource.path(RESOURCE_PATH).path("/getAddressBookRecordById").path(uuid.toString())
				.get(ClientResponse.class);

		System.out.println("Status Code : " + response.getStatus());

		if (response.getStatus() == 200) {
			AddressBookResponse addressBookResponse = response.getEntity(AddressBookResponse.class);
			System.out.println("Record successfully created");
			System.out.println(addressBookResponse.getPersonDetails().get(0).getFirstName());
		} else if (response.getStatus() == 400 || response.getStatus() == 500) {
			AddressBookResponse addressBookResponse = response.getEntity(AddressBookResponse.class);
			if (addressBookResponse.getErrorMessages() != null && addressBookResponse.getErrorMessages().size() > 0) {
				for (ErrorMessages errorMessage : addressBookResponse.getErrorMessages()) {
					System.out.println("Error details");
					System.out.println("Error Messsage : " + errorMessage.getErrorMessage().getMessage());
				}
			}
		}
	}

	/**
	 * Test method for testing add addressbook record service call
	 */
	public PersonDetails testAddAddressBookRecord() {
		PersonDetails personDetails = makePersonDetails();
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client c = Client.create(config);

		WebResource resource = c.resource(UriBuilder.fromUri(URI).build());
		ClientResponse response = resource.path(RESOURCE_PATH).path("/addAddressBookRecord").entity(personDetails)
				.type(MediaType.APPLICATION_JSON).post(ClientResponse.class);

		System.out.println("Status Code : " + response.getStatus());

		//response.getResponseDate();
		AddressBookResponse addressBookResponse = response.getEntity(AddressBookResponse.class);
		if (response.getStatus() == 201) {
			System.out.println("Record successfully created");
			return addressBookResponse.getPersonDetails().get(0);
		} else if (response.getStatus() == 400 || response.getStatus() == 500) {
			if (addressBookResponse.getErrorMessages() != null && addressBookResponse.getErrorMessages().size() > 0) {
				for (ErrorMessages errorMessage : addressBookResponse.getErrorMessages()) {
					System.out.println("Error details");
					System.out.println("Error Messsage : " + errorMessage.getErrorMessage().getMessage());
				}
			}
		}
		return null;
	}

	/**
	 * Test method for testing add addressbook record service call
	 */
	public PersonDetails testUpdateAddressBookRecord(PersonDetails personDetails) {
		ClientConfig config = new DefaultClientConfig();
		config.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client c = Client.create(config);

		WebResource resource = c.resource(UriBuilder.fromUri(URI).build());
		ClientResponse response = resource.path(RESOURCE_PATH).path("/updateContactInformation").entity(personDetails)
				.type(MediaType.APPLICATION_JSON).put(ClientResponse.class);

		System.out.println("Status Code : " + response.getStatus());

		response.getResponseDate();
		AddressBookResponse addressBookResponse = response.getEntity(AddressBookResponse.class);
		if (response.getStatus() == 200) {
			System.out.println("Record successfully updated");
			return addressBookResponse.getPersonDetails().get(0);
		} else if (response.getStatus() == 400 || response.getStatus() == 500) {
			if (addressBookResponse.getErrorMessages() != null && addressBookResponse.getErrorMessages().size() > 0) {
				for (ErrorMessages errorMessage : addressBookResponse.getErrorMessages()) {
					System.out.println("Error details");
					System.out.println("Error Messsage : " + errorMessage.getErrorMessage().getMessage());
				}
			}
		}
		return null;
	}

	/**
	 * Test method for testing delete addressbook record service call
	 * 
	 * @param uuid
	 *            identifier to delete record for
	 */
	public void testDeleteAddressBookRecord(UUID uuid) {
		ClientConfig config = new DefaultClientConfig();
		Client c = Client.create(config);

		WebResource resource = c.resource(UriBuilder.fromUri(URI).build());
		ClientResponse response = resource.path(RESOURCE_PATH).path("/deleteAddressBookRecordById")
				.path(uuid.toString()).delete(ClientResponse.class);

		System.out.println("Status Code : " + response.getStatus());

		if (response.getStatus() == 200) {
			System.out.println("Record successfully deleted");
		} else if (response.getStatus() == 400 || response.getStatus() == 500) {
			AddressBookResponse addressBookResponse = response.getEntity(AddressBookResponse.class);
			if (addressBookResponse.getErrorMessages() != null && addressBookResponse.getErrorMessages().size() > 0) {
				for (ErrorMessages errorMessage : addressBookResponse.getErrorMessages()) {
					System.out.println("Error details");
					System.out.println("Error Messsage : " + errorMessage.getErrorMessage().getMessage());
				}
			}
		}
	}

	/**
	 * Builds {@link PersonDetails} object
	 * 
	 * @return {@link PersonDetails}
	 */
	private PersonDetails makePersonDetails() {
		PersonDetails personDetails = new PersonDetails();

		personDetails.setFirstName("Vrushali");
		personDetails.setLastName("Joshi");
		personDetails.setMiddleName("Ramdas");
		personDetails.setDateOfBirth(DateTime.now());
		personDetails.setContactNumberDetails(makeContactNumberList());
		personDetails.setEmailAddressDetails(makeEmailAddressList());
		personDetails.setAddressDetails(makeAddressList());
		return personDetails;
	}

	/**
	 * Builds list of addresses corresponding to the person object
	 * 
	 * @return {@link List<AddressDetails>}
	 */
	private List<AddressDetails> makeAddressList() {
		List<AddressDetails> addressDetails = new ArrayList<AddressDetails>();

		AddressDetails addressDetail = new AddressDetails();
		addressDetail.setApartmentNumber("8222");
		addressDetail.setCity("San Diego");
		addressDetail.setCountry("United States Of America");
		addressDetail.setState("California");
		addressDetail.setStreetAddress("9110 Judicial Drive");
		addressDetail.setZipCode(92122);

		addressDetails.add(addressDetail);
		return addressDetails;
	}

	/**
	 * Builds list of {@link EmailAddressDetails} objects corresponding to the
	 * person details object
	 * 
	 * @return {@link List<EmailAddressDetails>}
	 */
	private List<EmailAddressDetails> makeEmailAddressList() {
		List<EmailAddressDetails> emailAddressDetails = new ArrayList<EmailAddressDetails>();

		EmailAddressDetails emailAddressDetail = new EmailAddressDetails();
		emailAddressDetail.setEmailAddress("vrushalijoshi.cummins@gmail.com");

		emailAddressDetails.add(emailAddressDetail);
		return emailAddressDetails;
	}

	/**
	 * Builds list of {@link ContactNumberDetails} object corresponding to the
	 * person details object
	 * 
	 * @return {@link List<ContactNumberDetails>}
	 */
	private List<ContactNumberDetails> makeContactNumberList() {
		List<ContactNumberDetails> contactNumberDetails = new ArrayList<ContactNumberDetails>();

		ContactNumberDetails contactNumberDetail = new ContactNumberDetails();
		contactNumberDetail.setContactNumber(6083385607L);

		contactNumberDetails.add(contactNumberDetail);

		return contactNumberDetails;
	}

	public static void main(String[] args) {
		AddressBookClient addressBookClient = new AddressBookClient();

		// adds a new person details record
		PersonDetails personDetails = addressBookClient.testAddAddressBookRecord();
		System.out.println("Saved person record id " + personDetails.getId());

		// fetch the newly added person details record
		if (personDetails != null) {
			addressBookClient.testGetAddressBookRecord(personDetails.getId());
		}

		// update the person details record
		personDetails.getContactNumberDetails().get(0).setContactNumber(6863458761L);
		addressBookClient.testUpdateAddressBookRecord(personDetails);

		// fetch the updated person details record
		if (personDetails != null) {
			addressBookClient.testGetAddressBookRecord(personDetails.getId());
		}

		// delete the person details record
		addressBookClient.testDeleteAddressBookRecord(personDetails.getId());

		// fetch the person details record to verify if the record was
		// successfully deleted
		if (personDetails != null) {
			addressBookClient.testGetAddressBookRecord(personDetails.getId());
		}
	}
}
