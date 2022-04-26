### @WebServlet 애노테이션(annotation)

JDK 1.5버전부터 되는 자바에서 만든 기술이다. 애노테이션은 JDK 5.x부터 추가된 기능이다. 환경 설정 파일에 설정하지 않고 자바 코드에 직접 기술하
는 방법으로 '@'로 시작된다.

### 서블릿 아키텍처 및 핵심 API

![image](https://user-images.githubusercontent.com/81727895/165036117-d0bd32cd-74fb-46e6-bf50-bafecca02e36.png)


### HttpServlet API

![image](https://user-images.githubusercontent.com/81727895/165036180-553a0535-3c97-4bf5-b561-7ab7539998f6.png)

### HttpServlet 클래스(method)

|메소드|기능|
|--|--|
|getParameter(name)|문자열 name과 같은 이름을 가진 파라미터의 값을 가져온다.|
|getParameterValues(name)|문자열 name과 같은 이름을 가진 파라미터의 값을 배열 형태로 가져옴. checkbox, multiple list 등에 주로 사용된다.|
|getMethod()|현재 요청이 GET, POST 인지 가져 온다.|
|getRemoteAddr()|클라이언트의 IP 주소를 가져온다.|
|setCharacterEncoding|현재 JSP로 전달되는 내용을 지정하는 캐릭터셋을 변환한다. HTML FORM에서 한글 입력시 정상적으로 처리하려면 반드시 필요하다.|

### [Servlet 3.1 - Apache Tomcat 8.0.53](https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html)

> **javax.servlet.ServletRequest**

```java
public interface ServletRequest
```

|Modifier and Type|Method |and Description|
|--|--|--|
|java.lang.String|getParameter(java.lang.String names)|Returns the value of a request parameter as a String, or null if the parameter does not exist.|
|java.lang.String[]|getParameterValues(java.lang.String name)|Returns an array of String objects containing all of the values the given request parameter has, or null if the parameter does not exist.|
|java.lang.String|getRemoteAddr()|Returns the Internet Protocol (IP) address of the client or last proxy that sent the request.|
|void|setCharacterEncoding(java.lang.String env)|Overrides the name of the character encoding used in the body of this request.|

> **javax.servlet.HttpServletRequest**

```java
public interface HttpServletRequest
extends ServletRequest
```

|Modifier and Type|Method |and Description|
|--|--|--|
|java.lang.String|getMethod()|Returns the name of the HTTP method with which this request was made, for example, GET, POST, or PUT|


### HttpServletResponse 클래스 (method)

|메소드|기능|
|--|--|
|setContentType(type)|문자열 형태의 type에 지정된 MIME Type으로 ContentType을 설정한다.|
|setHeader(name, value)|문자열 name의 이름으로 문자열 value 값을 헤더로 설정한다.|
|setError(status, msg)|오류 코드를 설정하고 메시지를 보낸다.|
|sendRedirect(url)|클라이언트 요청을 다른 페이지로 보낸다.|


### [Servlet 3.1 - Apache Tomcat 8.0.53](https://tomcat.apache.org/tomcat-8.0-doc/servletapi/index.html)

> **javax.servlet.ServletResponse**

```java
public interface ServletResponse
```

|Modifier and Type|Method |and Description|
|--|--|--|
|void|setContentType(java.lang.String type)|Sets the content type of the response being sent to the client, if the response has not been committed yet.|

> **javax.servlet.http.HttpServletResponse**

```java
public interface HttpServletResponse
extends ServletResponse
```

|Modifier and Type|Method |and Description|
|--|--|--|
|void|setHeader(java.lang.String name, java.lang.String value)|Sets a response header with the given name and value.|
|void|sendRedirect(java.lang.String location)|Sends a temporary redirect response to the client using the specified redirect location URL.|




