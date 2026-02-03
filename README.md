Appointment Organizer Plus+
A professional-grade desktop GUI application designed to streamline customer relationship management and appointment scheduling. This system leverages a MySQL backend to provide a persistent, scalable solution for maintaining complex business schedules across multiple time zones.

🛠 Tech Stack
Language: Java 17

GUI Framework: JavaFX 17.0.2

Database: MySQL (Connector/J 8.0.25)

Architecture: MVC (Model-View-Controller)

IDE: IntelliJ IDEA 2021.2.2

🚀 Key Features
Secure Access Control: Implements a localized login system requiring database-authenticated credentials.

Comprehensive CRUD Engine: Robust interfaces for adding, modifying, and deleting both Customer profiles and their associated Appointments.

Dynamic Scheduling Views: Built-in filtering capabilities allowing users to toggle between weekly and monthly appointment views.

Business Intelligence Reporting: * Location Performance: Generates totals of appointments categorized by location and month.

Strategic Insights: Custom reporting functions designed to provide organizational snapshots of customer activity.

🌐 Technical Challenges & Solutions
1. Multi-Region Time Zone Management
Challenge: The application must be usable by clients in different geographical regions (e.g., EST, GMT, MST) while maintaining a consistent schedule in the database. Solution:

Database Normalization: All appointment timestamps are converted to UTC (Coordinated Universal Time) before being stored in the MySQL database.

Dynamic Conversion: I utilized the Java ZonedDateTime and ZoneId classes to detect the user's local system time at login. All database records are converted from UTC to the user's local time on the fly for display in the UI.

Business Logic: Implemented a validation layer that checks appointment times against a "Company EST" schedule (8am - 10pm EST), regardless of the user's local time zone.

2. Localization (i18n) & Internationalization
Challenge: The application required seamless switching between English and French based on the user's system language settings. Solution:

Resource Bundles: Leveraged java.util.ResourceBundle to separate UI string literals from the code logic. Created parallel .properties files for English and French.

Locale Detection: The application automatically initializes the Locale.getDefault() method at launch. If the system language is French, the login form and error messages automatically render in French.

3. Functional Interface Implementation
Challenge: Reducing boilerplate code for repetitive UI tasks and improving code maintainability. Solution:

Lambdas: Defined custom functional interfaces to handle alert message generation. This simplified the controller logic and improved code readability by replacing verbose anonymous inner classes with concise lambda expressions.

📁 Project Structure
src/: Contains the FXML layouts, Java controllers, and Data Access Objects (DAO).

JavaDocs/: Full technical documentation for the application's classes and methods.

Database ERD.pdf: Detailed Entity Relationship Diagram showing the database schema and relational mapping.

⚙️ Installation & Usage
Clone the Repository:

Bash
git clone https://github.com/HughMorris01/C195_Java_Scheduler_App.git
Database Configuration: Ensure a MySQL instance is running and update the connection parameters in the source code to point to your specific database host.

Authentication: Launch the application and enter valid user credentials to access the management dashboard.
