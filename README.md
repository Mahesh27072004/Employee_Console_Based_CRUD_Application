# Java Console-Based CRUD Application using JDBC (MVC Architecture)

**🛠 Description**  
This is a Java-based backend application that performs complete CRUD (Create, Read, Update, Delete) operations using JDBC (Java Database Connectivity). The project follows the MVC (Model-View-Controller) pattern for better separation of concerns.

The application interacts with a relational database (e.g., MySQL) through a text-based user interface (console). It is designed for learning backend development, JDBC operations, and Java architectural patterns.

---

**📂 Project Structure**
├── dto/ # DTO classes (e.g., Employee) 

├── dao/ # Data Access Layer 

├── service/ # Business Logic Layer 

├── controller/ # Controls application flow (entry point) 

├── connectionFactory/ # JDBC connection utility

---

**✅ Features**
- **Create:** Add new employee records with validation
- **Read:** View all records or specific entries
- **Update:** Modify existing employee data
- **Delete:** Remove records safely by ID
- **Input Validation:** Ensures integrity before database insertions
- **Rollback Support:** Reverts failed transactions
- **MVC Architecture:** Clean separation of concerns
- **DTO Usage:** Encapsulates and transfers data efficiently

---

**🧑‍💻 Technologies Used**
- Java (JDK 8+)
- JDBC
- MySQL / Any RDBMS
- Eclipse / IntelliJ IDEA
- Maven (optional)

---

## ⚙️ Configure Your Database

1. **Create a MySQL database** (e.g., `xyz`)
2. **Create the required table** by executing:

   ```sql
   CREATE TABLE mytable (
     eid INT PRIMARY KEY,
     ename VARCHAR(50),
     eaddress VARCHAR(100),
     esalary INT,
     username VARCHAR(30),
     password VARCHAR(20)
   );
Update DB credentials in your ConnectionFactory class (url, username, password)

▶️ Compile and Run the Application
🖥️ Using Terminal
javac Main.java
java Main
💡 Or run from your IDE (Eclipse, IntelliJ, etc.)

📌 Validation Rules

Field      | Rule
-----------|-----------------------------------------
eid        | Must be between 1 and 999
ename      | Length between 2 and 50 characters
eaddress   | Length between 5 and 100 characters
esalary    | Greater than 0 and less than or equal to 100000
username   | Length between 6 and 30 characters
password   | Length between 8 and 20 characters

🤝 Contributing
Feel free to fork this repo, raise issues, or contribute improvements via pull requests.

📄 License
This project is open-source and available under the MIT License.
