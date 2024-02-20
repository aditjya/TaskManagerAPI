<h1>Task Managemer Api</h1>
<h2>Technologies Used</h2>
<p>1.Java<br>
2.SpringBoot<br>
3.MySQL
</p>
<div class="box">
  <h3>Authentication Procedure</h3>
<P> The application follows industry best practices for authentication and authorization, incorporating role-based access control, HTTP basic authentication, and stateless session management.
</P>
<p><b>1. UserDetailsService Bean -</b>
  The UserDetailsService bean is responsible for providing user details during the authentication process. The implementation, UserDetailsServiceImpl, typically retrieves user information from the DataBase.</p>
<p></p>
<p><b>2. SecurityFilterChain Bean -</b>
  This bean configures the security settings for HTTP requests. It defines rules for different paths and HTTP methods, specifying required roles, permitting access, and enforcing basic authentication. The session management is set to be stateless..</p>
<p></p>
<p><b>PasswordEncoder Bean -</b>
  The PasswordEncoder bean defines the password encoder used for hashing and verifying passwords. In this case, it utilizes the BCryptPasswordEncoder.</p>
<p></p>
<p><b>4. AuthenticationProvider Bean -</b>
  The AuthenticationProvider bean configures an instance of DaoAuthenticationProvider. It associates the user details service and password encoder, making it responsible for authenticating users, verifying credentials, and loading user details.</p></div>
<p></p>
<p><b>Authentication Flow</b><br>
When a user attempts to access a secured resource, the SecurityFilterChain intercepts the request.<br>
The DaoAuthenticationProvider uses the configured UserDetailsService to load user details based on the provided username.<br>
The password provided by the user is hashed using the configured PasswordEncoder, and the hashed value is compared to the stored password hash.<br>
If the credentials match, the user is authenticated, and access is granted according to the defined roles and access rules.</p>
<h4><b>Available EndPoints</b></h4>
## Get All Tasks
- **Endpoint:** `GET /api/tasks`
- **Permission Required:** ROLE_ADMIN
- **Description:** Retrieve a list of all tasks.
- **Returns:** List of Task objects.

## Get Task by ID
- **Endpoint:** `GET /api/tasks/{id}`
- **Permission Required:** ROLE_USER
- **Description:** Retrieve a specific task by its ID.
- **Parameters:**
  - `{id}`: ID of the task to retrieve.
- **Returns:** Task object.
- **Error Response:**
  - 404 Not Found: If the task with the specified ID is not found.

## Create Task
- **Endpoint:** `POST /api/tasks`
- **Permission Required:** ROLE_USER
- **Description:** Create a new task.
- **Request Body:** Task object.
- **Returns:** Created Task object.
- **Error Response:**
  - 400 Bad Request: If the required fields (title and description) are not provided.

## Update Task
- **Endpoint:** `PUT /api/tasks/{id}`
- **Permission Required:** ROLE_USER
- **Description:** Update an existing task.
- **Parameters:**
  - `{id}`: ID of the task to update.
- **Request Body:** Updated Task object.
- **Returns:** Updated Task object.
- **Error Response:**
  - 404 Not Found: If the task with the specified ID is not found.

## Delete Task
- **Endpoint:** `DELETE /api/tasks/{id}`
- **Permission Required:** ROLE_USER
- **Description:** Delete a task by its ID.
- **Parameters:**
  - `{id}`: ID of the task to delete.
- **Returns:** No content.
- **Error Response:**
  - 404 Not Found: If the task with the specified ID is not found.

# UserController API

## User Sign-Up
- **Endpoint:** `POST /signup`
- **Description:** Register a new user.
- **Request Body:** User object.
- **Returns:** Created User object.
- **Error Response:**
  - None.
