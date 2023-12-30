
# Medication Reminder Application.

Medication Reminder API Readme

## Introduction

The Medication Reminder API is a backend service that allows users to set medication reminders and receive automated SMS reminders about taking their prescribed medicine. The API is developed using Spring Boot as the backend framework, MySQL as the database, and utilizes HTML, CSS, and JavaScript for data representation on the frontend. The application is designed to be user-friendly and is particularly suitable for senior citizens who need assistance in managing their medication schedules.

## Features

**Medication Reminder Management:** Users can set reminders for their medications by providing details such as Medicine Name, User Details, Frequency of dosage, Dosage Amount, Duration to take the medicine, and Stock availability.

**Automated SMS Reminders:** The API integrates with Twilio service to send automated SMS reminders to users according to the specified frequency and dosage timings. This ensures that users are reminded to take their medication at the right time.

**Low Stock Alerts:** The application tracks the stock of the medicine and sends an SMS alert to the user when the stock goes below 10. This helps users to refill their medicine on time, preventing any interruptions in their medication routine.

**SOLID Principle:** The project is carefully segregated and adheres to the SOLID design principles, promoting maintainability and extensibility of the codebase.

**ACID Property:** For data integrity and consistency, certain transactions are executed following the ACID property of MySQL, ensuring that all operations are completed successfully or rolled back in case of failure.

**Future Scope:** The project has future scope to add new functionalities such as triggering SMS reminders to drink water or serving as a to-do list, making it a versatile tool for users' well-being.

## Technologies Used::

**Spring Boot:** Backend framework for building robust and scalable APIs.

**MySQL:** Database management system to store medication and user data.

**HTML, CSS, and JavaScript:** Frontend technologies for data representation and user interaction.

**Maven:** Dependency management tool for Java projects.

**JPA Repository:** For database interactions and data access.

**Lombok:** Reduces boilerplate code in Java classes.

**Spring Web:** Enables building web applications using Spring.

**Twilio Service:** Integration for automated SMS reminders.

## Setup Instructions::

To set up the Medication Reminder API on your local environment, follow these steps:

1. Clone the repository from GitHub.
2. Configure MySQL Database.
   Create a new MySQL database and user for the API.
   Update the database configuration in the application.properties file.
3. Build the Project.
4. Run the Application:
5. Access the Application:
   Open your web browser and go to http://localhost:8080 to interact with the API's frontend (if implemented).
   The API endpoints can be accessed using tools like Postman for testing and integration purposes.

**Here are some snapshots:**

New Medication 1:
![New Medication1](https://github.com/vivekRaj1309/medicinereminder/assets/138140687/18b4ebf6-4b31-4d9b-93c7-a913c476c0f5)
New Medication 2:
![New Medication2](https://github.com/vivekRaj1309/medicinereminder/assets/138140687/47749de8-46e6-49d2-b61c-7427018810b8)
View Medications:
![View Medication](https://github.com/vivekRaj1309/medicinereminder/assets/138140687/1d90df32-dfe0-411e-81f4-de43dda8988b)
Delete Medication:
![Delete Medication1](https://github.com/vivekRaj1309/medicinereminder/assets/138140687/0a96b194-bb98-4178-b2e2-6305a516cd2e)
Delete Medication Confirmation:
![Delete Medication2](https://github.com/vivekRaj1309/medicinereminder/assets/138140687/3eed52d4-691f-4961-bb0f-096c61c4f280)
Updated Medication:
![Updated Medication Reminder](https://github.com/vivekRaj1309/medicinereminder/assets/138140687/c1f0a6ea-6ff3-4972-9353-133328a026a5)
SMS reminders:
![SMS](https://github.com/vivekRaj1309/medicinereminder/assets/138140687/e0e270dc-cce7-4281-8e40-645f5acae435)

