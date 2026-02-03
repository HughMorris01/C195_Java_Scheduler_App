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

🧠 Technical Challenges & Solutions
1. Database Connectivity & Resource Management
Challenge: Establishing a reliable connection to a remote MySQL database while ensuring that resources (connections, statements, and result sets) were properly closed to prevent memory leaks or connection exhaustion. Solution: Implemented the Data Access Object (DAO) pattern. I utilized a dedicated DBConnection utility class with static methods to manage the connection lifecycle and employed try-with-resources blocks to ensure all JDBC resources were automatically closed even if an exception occurred.

2. Time Zone Synchronization
Challenge: Managing appointment times for users in different geographical locations. The database stores times in UTC, but the application needs to display them in the user's local system time. Solution: Leveraged the java.time API (specifically ZonedDateTime and LocalDateTime). I implemented logic to convert user input from their local time zone to UTC before database persistence and performed the reverse conversion when fetching data for the UI.

3. Data Integrity & Validation
Challenge: Preventing logical errors, such as scheduling overlapping appointments for the same customer or entering invalid date ranges. Solution: Developed a validation engine within the controllers that checks for overlapping time slots by querying the database before a "Save" operation is finalized. I also utilized JavaFX Alert dialogs to provide immediate, descriptive feedback to the user when validation rules were triggered.

📁 Project Structure
src/: Contains the FXML layouts, Java controllers, and database access objects (DAO).

JavaDocs/: Full technical documentation for the application's classes and methods.

Database ERD.pdf: Detailed Entity Relationship Diagram showing the database schema and relational mapping.

⚙️ Installation & Usage
Clone the Repository:

Bash
git clone https://github.com/HughMorris01/[Repository-Name].git
Database Configuration: Ensure a MySQL instance is running and update the connection parameters in the source code to point to your specific database host.

Authentication: Launch the application and enter valid user credentials to access the management dashboard.
