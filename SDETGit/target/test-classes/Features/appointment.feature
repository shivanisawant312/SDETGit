Feature: Appointment Management in RIS

  @Schedule
  Scenario Outline: Schedule Appointment
    Given user is on login page
    When user enters valid "<username>" and "<password>"
    And clicks on Login Button
    Then User is navigated to Home Page

    # Navigate to BookView and schedule an appointment
    When user selects option "Schedule Appointment" at time "<slotTime>" from slot

    # Create appointment details
    When user selects date "<date>"
    And user chooses category "<category>"
    And user selects a time slot "<timeSlot>"
    And user clicks on "<option>"

    # Patient selection
    When user selects patient option "<patientOption>"
      # patientOption = existing / new
    When user enters patient details "<patientName>" "<age>" "<mobile>" "<regType>" 
      # For new patient, all mandatory fields will be added in Step Definition

    # Exam / Appointment details
    When user fills appointment details "<examCategory>" "<examName>" "<examDate>" "<startTime>" "<endTime>" "<modality>" "<status>" "<radiologist1>" "<radiologist2>"
    Then appointment should be created successfully

    And Close the browser

  @Edit
  Scenario Outline: Edit / Reschedule Appointment
    Given user is on login page
    When user enters valid "<username>" and "<password>"
    And clicks on Login Button
    Then User is navigated to Home Page

    Given user searches for appointment of "<patientName>"
    When user opens appointment for editing
    And user updates patient details "<newAge>" "<newMobile>" "<newRegType>"
    Then updated appointment should be displayed

    And Close the browser

  @Cancel
  Scenario Outline: Cancel Appointment
    Given user is on login page
    When user enters valid "<username>" and "<password>"
    And clicks on Login Button
    Then User is navigated to Home Page

    Given user searches for appointment of "<patientName>"
    When user cancels the appointment
    Then appointment status should be "Cancelled"

    And Close the browser

  Examples:
    | username  | password | slotTime | date       | category   | timeSlot  | option    | patientOption | patientName | age | mobile     | regType     | examCategory | examName | examDate   | startTime | endTime  | modality | status | radiologist1 | radiologist2 | newAge | newMobile  | newRegType |
    | admin     | admin1   | 10:00 AM | 2025-12-01 | General    | 10:00 AM  | Open Slot | existing      | John Doe    | 30  | 9876543210 | Outpatient | General      | X-Ray    | 2025-12-01 | 10:00 AM  | 10:30 AM | CR       | Scheduled | Dr. A       | Dr. B       | 31     | 9876501234 | Outpatient |
    | shivaniii | admin1   | 11:00 AM | 2025-12-02 | Cardiology | 11:00 AM  | Open Slot | new           | Alice Smith | 28  |
