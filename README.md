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
- **API Documentation**: Swagger
- **File Handling**: Custom File Service

## Installation

1. Clone the repository:
   ```bash
   https://github.com/SakibvHossain/Blogging_Application_Backend.git
   ```
2. Navigate to the project directory:
   ```bash
   cd blog-app-apis
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


| **Category**        | **Method** | **Endpoint**                                     | **Description**                                           | **Auth Required**          |
|---------------------|------------|--------------------------------------------------|-----------------------------------------------------------|----------------------------|
| **Authentication**  | POST       | `/api/v1/auth/login`                             | Authenticate and receive JWT                              | No                         |
|                     | POST       | `/api/v1/auth/register`                          | Register a new user                                       | No                         |
| **User**            | GET        | `/api/users/`                                    | Get all users                                             | No                         |
|                     | PUT        | `/api/users/{uid}`                               | Update user                                               | Yes                        |
|                     | DELETE     | `/api/users/{uid}`                               | Delete user                                               | Yes (Admin)                |
|                     | GET        | `/api/users/{uid}`                               | Get specific User                                         | No                         |
|                     | POST       | `/api/users/`                                    | Create user                                               | Yes                        |
| **Posts**           | PUT        | `/api/posts/{postId}`                            | Update a post                                             | Yes                        |
|                     | DELETE     | `/api/posts/{postId}`                            | Delete a post                                             | Yes (Admin)                |
|                     | POST       | `/api/user/{userId}/category/{categoryId}/posts` | Create a new post                                         | Yes                        |
|                     | POST       | `/api/post/image/upload/{postId}`                | Update post image                                         | Yes                        |
|                     | GET        | `/api/user/{userId}/posts`                       | Get posts by author                                       | No                         |
|                     | GET        | `/api/posts`                                     | Get all posts                                             | No                         |
|                     | GET        | `/api/posts/search/{title}`                      | Get post by title                                         | No                         |
|                     | GET        | `/api/post/{postId}`                             | Get post by ID                                            | No                         |
|                     | GET        | `/api/post/image/{imageName}`                    | Get post image                                            | No                         |
|                     | GET        | `/api/category/{categoryId}/posts`               | Get post by category                                      | No                         |
| **Categories**      | GET        | `/api/categories/{id}`                           | Get categories by ID                                      | No                         |
|                     | PUT        | `/api/categories/{id}`                           | Update a category                                         | Yes                        |
|                     | DELETE     | `/api/categories/{id}`                           | Delete a category                                         | Yes                        |
|                     | GET        | `/api/categories/`                               | Get all categories                                        | No                         |
|                     | POST       | `/api/categories/`                               | Create a new category                                     | Yes                        |
| **Comments**        | POST       | `/api/post/{id}/comments`                        | Add a comment to a post                                   | Yes                        |
|                     | DELETE     | `/api/comments/{id}`                             | Delete a comment                                          | Yes                        |

---

### Contributing
Feel free to fork this repository, create a new branch, and submit a pull request. All contributions are welcome!

## 🤩 Don't forget to give ⭐ to this repository
<img src="https://forthebadge.com/images/badges/built-with-love.svg">
<img src="https://forthebadge.com/images/badges/made-with-java.svg">
