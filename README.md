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

**🧪 How to Run the Project**
1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/your-repo-name.git
   cd your-repo-name
   
Configure your database

Create a MySQL database (e.g., xyz)

Create the required table (mytable):
SQL
CREATE TABLE mytable (
  eid INT PRIMARY KEY,
  ename VARCHAR(50),
  eaddress VARCHAR(100),
  esalary INT,
  username VARCHAR(30),
  password VARCHAR(20)
);

Update DB credentials in your ConnectionFactory class

Compile and run the application

Using terminal:
bash
javac Main.java
java Main
Or run from your IDE

📌 Sample Validation Rules

Field	    Rule
eid	      1 to 999
ename	    2 to 50 characters
eaddress	5 to 100 characters
esalary	  Greater than 0 and ≤ 100000
username	6 to 30 characters
password	8 to 20 characters

🤝 Contributing
Feel free to fork this repo, raise issues, or contribute improvements via pull requests.

📄 License
This project is open-source and available under the MIT License.
