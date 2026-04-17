# 🗄️ Hibernate Java — Entity Mapping Examples

A hands-on reference repository demonstrating all four core **Hibernate ORM entity relationships** in Java. Each module is a self-contained project with its own configuration, entities, and working examples.

---

## 📁 Project Structure

```
HIBERNATE-JAVA/
├── OneToOne/       # One-to-one entity mapping
├── OneToMany/      # One-to-many entity mapping
├── ManyToOne/      # Many-to-one entity mapping
└── ManyToMany/     # Many-to-many entity mapping
```

---

## 🔗 Mapping Types Covered

### 1. `OneToOne`
A single entity is associated with exactly one other entity.

**Example:** A `User` has one `UserProfile`.

```java
@Entity
public class User {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private UserProfile profile;
}
```

---

### 2. `OneToMany`
One entity is associated with multiple instances of another entity.

**Example:** A `Department` has many `Employees`.

```java
@Entity
public class Department {
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
}
```

---

### 3. `ManyToOne`
Multiple instances of one entity are associated with a single instance of another.

**Example:** Many `Employees` belong to one `Department`.

```java
@Entity
public class Employee {
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
```

---

### 4. `ManyToMany`
Multiple instances of one entity are associated with multiple instances of another.

**Example:** `Students` enroll in many `Courses`, and `Courses` have many `Students`.

```java
@Entity
public class Student {
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
```

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java | Core language |
| Hibernate ORM | Object-relational mapping |
| MySQL | Relational database |
| Maven | Build & dependency management |
| `hibernate.cfg.xml` | Session factory configuration |

---

## ⚙️ Setup & Configuration

### Prerequisites
- Java 8+
- Maven
- MySQL running locally

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/adityaraut649/HIBERNATE-JAVA.git
   cd HIBERNATE-JAVA
   ```

2. **Navigate to a module**
   ```bash
   cd OneToOne   # or OneToMany, ManyToOne, ManyToMany
   ```

3. **Update `hibernate.cfg.xml`** with your DB credentials
   ```xml
   <property name="connection.url">jdbc:mysql://localhost:3306/your_db</property>
   <property name="connection.username">your_username</property>
   <property name="connection.password">your_password</property>
   <property name="dialect">org.hibernate.dialect.MySQLDialect</property>
   ```

4. **Run the project**
   ```bash
   mvn compile exec:java
   ```

---

## 📚 Key Concepts

- **`cascade`** — Propagates operations (persist, merge, delete) from parent to child entities.
- **`mappedBy`** — Marks the non-owning side of a bidirectional relationship.
- **`@JoinColumn`** — Specifies the foreign key column in the owning entity's table.
- **`@JoinTable`** — Defines the intermediate join table used in Many-to-Many relationships.
- **`FetchType.LAZY` vs `EAGER`** — Controls when related entities are loaded from the database.

---

## 👤 Author

**Aditya Raut**  
[GitHub](https://github.com/adityaraut649) · [LinkedIn](https://linkedin.com/in/adityaraut649)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
