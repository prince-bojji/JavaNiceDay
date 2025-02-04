# Servlets

Servlets are server-side Java components that handle requests and responses in web applications, enabling dynamic content generation.

## Servlet Lifecycle Methods

Servlets follow a defined lifecycle managed by the web container.

- `init()`: Called when the servlet is first initialized; used for setup tasks.
- `service()`: Handles requests and dispatches them to `doGet()` or `doPost()` based on the HTTP method.
- `doGet()`: Processes HTTP GET requests.
- `doPost()`: Processes HTTP POST requests.
- `destroy()`: Called when the servlet is taken out of service; used for cleanup.

## Example: Basic Servlet

```java
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Servlet is initializing...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.getWriter().write("<h1>Hello, Jehan! Welcome to Servlets!</h1>");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is being destroyed...");
    }
}
```

## Handling HTTP Requests and Responses

- **HTTP Request**: Contains data from the client (headers, parameters, etc.).
- **HTTP Response**: The server's response sent back to the client.

### Key Methods:

- `HttpServletRequest.getParameter()`: Reads request parameters.
- `HttpServletResponse.getWriter()`: Writes output to the client.

## Example: Processing Form Data

```java
@WebServlet("/greet")
public class GreetingServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html");
        response.getWriter().write("<h1>Hello, " + name + "!</h1>");
    }
}
```

## Forwarding and Redirection

### Forwarding (RequestDispatcher)

The server forwards the request to another resource (JSP or servlet) without changing the URL.

#### Example: Forwarding a Request

```java
RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
dispatcher.forward(request, response);
```

### Redirection (HttpServletResponse.sendRedirect)

Redirects the client to a different URL and changes the browser's address bar.

#### Example: Redirecting a Request

```java
response.sendRedirect("https://www.example.com");
```