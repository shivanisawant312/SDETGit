package StepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CreateAppointment;
import pageObjects.EditAppointment;
import pageObjects.SchedulingBookView;
import pageObjects.ViewCancelAppointment;

public class AppointmentStepDefination {

    WebDriver driver = POMLoginStepDefination.driver;

    SchedulingBookView bookView;
    EditAppointment editPage;
    ViewCancelAppointment listPage;

    // ----- BookView Scheduling -----
    @When("user selects option {string} at time {string} from slot")
    public void user_selects_option_at_time_from_slot(String option, String slotTime) {
        if (bookView == null) bookView = new SchedulingBookView(driver);
        bookView.selectOptionAtTime(slotTime, option);
    }

    // ----- Patient Selection -----
    @When("user selects existing patient {string}")
    public void user_selects_existing_patient(String patientName) {
        if (bookView == null) bookView = new SchedulingBookView(driver);
        bookView.searchAndSelectPatient(patientName);
    }

    @When("user adds new patient {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void user_adds_new_patient(String patientID, String title, String firstName, String middleName,
                                      String lastName, String gender, String dob, String age,
                                      String mobile, String regType) {
        if (bookView == null) bookView = new SchedulingBookView(driver);
        bookView.addNewPatient(patientID, title, firstName, middleName, lastName, gender, dob, age, mobile, regType);
        bookView.savePatient();
    }

    // ----- Exam/Appointment Details -----
    @When("user fills appointment details {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void user_fills_appointment_details(String category, String examName, String examDate,
                                               String startTime, String endTime, String modality,
                                               String status, String radiologist1, String radiologist2) {
        if (bookView == null) bookView = new SchedulingBookView(driver);
        bookView.fillAppointmentDetails(category, examName, examDate, startTime, endTime, modality,
                                        status, radiologist1, radiologist2);
        bookView.saveExamDetails();
    }

    @Then("appointment should be created successfully")
    public void appointment_should_be_created_successfully() {
        Assert.assertTrue(bookView.isAppointmentSaved());
    }

    // ----- View Appointment -----
    @When("user navigates to Appointment List")
    public void user_navigates_to_appointment_list() {
        listPage = new ViewCancelAppointment(driver);
        listPage.openAppointmentList();
    }

    @Then("user should see the list of scheduled appointments")
    public void user_should_see_list() {
        Assert.assertTrue(listPage.isListDisplayed());
    }

    // ----- Edit Appointment -----
    @Given("user searches for appointment of {string}")
    public void user_searches_for_appointment_of(String name) {
        listPage = new ViewCancelAppointment(driver);
        listPage.openAppointmentList();
        listPage.searchAppointment(name);
    }

    @When("user opens appointment for editing")
    public void user_opens_appointment_for_editing() {
        editPage = new EditAppointment(driver);
        editPage.openEditForm();
    }

    @When("user updates patient details {string} {string} {string}")
    public void user_updates_patient_details(String age, String mobile, String regType) {
        editPage.updateDetails(age, mobile, regType);
    }

    @Then("updated appointment should be displayed")
    public void updated_appointment_should_be_displayed() {
        Assert.assertTrue(editPage.isUpdated());
    }

    // ----- Cancel Appointment -----
    @When("user cancels the appointment")
    public void user_cancels_the_appointment() {
        listPage.cancelAppointment();
    }
 //-----app sss-----
    @Then("appointment status should be {string}")
    public void appointment_status_should_be(String expected) {
        Assert.assertEquals(listPage.getStatus(), expected);
    }
}
