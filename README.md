# Blog REST Application ✨

A comprehensive Blog REST API developed with Spring Boot, allowing users to create, manage, and interact with posts, comments, and categories. The API includes features for filtering, sorting, searching, and pagination, along with role-based access control using JWT authentication.

## Features

- **User Registration & Authentication**
    - JWT-based authentication
    - Role-based access control (e.g., ADMIN, USER)

- **Posts & Comments**
    - Users can create, update, delete, and view posts
    - Any user can comment on posts
    - Filter posts by user or category

- **Categories**
    - Posts can be organized into categories
    - Users can retrieve posts based on categories

- **Sorting, Searching & Pagination**
    - Search for posts by title or content
    - Sort posts by different fields (e.g., date, popularity)
    - Paginate through results

- **Exception Handling**
    - Custom exception handling with detailed error messages
    - Hibernate Validation for request payloads

- **Custom Response Handling**
    - Utilizes a custom `ApiResponse<T>` class for API responses instead of `ResponseEntity<T>`

- **File Service**
    - Handles file uploads related to posts

- **Database**
    - MySQL used as the database
    - Relationships implemented:
        - One-to-Many: A user can have multiple posts, and a post can have multiple comments
        - Many-to-Many: Posts can belong to multiple categories, and a category can have multiple posts

- **Architecture**
    - 3-layer architecture: Controller, Service, DAO layers
    - Data Transfer Objects (DTOs) for cleaner communication between layers

- **Documentation**
    - API is documented using **Swagger**

## Technologies Used

- **Backend**: Spring Boot
- **Security**: JWT Authentication, Role-based access control
- **Database**: MySQL
- **ORM**: Hibernate
- **Validation**: Hibernate Validator
- **Testing**: JUnit5
- **API Documentation**: Swagger
- **File Handling**: Custom File Service

## Installation

1. Clone the repository:
   ```bash
   https://github.com/SakibvHossain/Blogging_Application_Backend.git
   ```
2. Navigate to the project directory:
   ```bash
   cd blog-rest-api
   ```
3. Configure the database in `application.properties`:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/your-database
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```
   
## API Endpoints


| **Category**       | **Method** | **Endpoint**                                      | **Description**                                           | **Auth Required**          |
|---------------------|------------|--------------------------------------------------|-----------------------------------------------------------|----------------------------|
| **Authentication**  | POST       | `/api/auth/login`                                | Authenticate and receive JWT                              | No                         |
|                     | POST       | `/api/auth/register`                             | Register a new user                                       | No                         |
| **User**            | GET        | `/api/users/all`                                 | Get all users                                             | Yes (Admin)               |
|                     | PUT        | `/api/users/updateUser/{id}`                    | Update user                                               | Yes                       |
|                     | DELETE     | `/api/users/deleteUser/{id}`                    | Delete user                                               | Yes (Admin or User)       |
|                     | GET        | `/api/users/{id}`                                | Get specific User                                         | Yes (Admin)               |
|                     | PATCH      | `/api/users/update/specific/{id}`               | Update specific field                                     | Yes (Admin or User)       |
| **Posts**           | GET        | `/api/post/all?pageNumber=1&pageSize=3`         | Get all posts (with pagination, sorting, and searching)   | No                         |
|                     | POST       | `/api/user/{userID}/category/{categoryID}`      | Create a new post                                         | Yes                       |
|                     | PUT        | `/api/post/update/{id}`                         | Update a post                                             | Yes                       |
|                     | DELETE     | `/api/post/delete/{id}`                         | Delete a post                                             | Yes (Admin)               |
|                     | GET        | `/api/postBy/category/{id}?pageNumber=1&pageSize=2` | Get posts by category with pagination                     | No                         |
|                     | GET        | `/api/postBy/author/{id}`                       | Get posts by author                                       | No                         |
|                     | GET        | `/api/post/{id}`                                | Get post by ID                                            | No                         |
|                     | GET        | `/api/post/search/{title}`                      | Get post by title                                         | No                         |
|                     | PUT        | `/api/post/upload/image/{postID}`               | Update post image                                         | Yes                       |
| **Categories**      | GET        | `/api/category/all`                             | Get all categories                                        | No                         |
|                     | POST       | `/api/category/create`                          | Create a new category                                     | Yes (Admin)               |
|                     | PUT        | `/api/category/update/{id}`                     | Update a category                                         | Yes (Admin)               |
|                     | DELETE     | `/api/category/delete/{id}`                     | Delete a category                                         | Yes (Admin)               |
|                     | GET        | `/api/category/byId/{id}`                       | Get categories by ID                                      | No                         |
| **Comments**        | POST       | `/api/comment/add/post/{id}`                    | Add a comment to a post                                   | Yes                       |
|                     | DELETE     | `/api/comment/delete/{id}`                      | Delete a comment                                          | Yes                       |

---

### Contributing
Feel free to fork this repository, create a new branch, and submit a pull request. All contributions are welcome!

## 🤩 Don't forget to give ⭐ to this repository
<img src="https://forthebadge.com/images/badges/built-with-love.svg">
<img src="https://forthebadge.com/images/badges/made-with-java.svg">
