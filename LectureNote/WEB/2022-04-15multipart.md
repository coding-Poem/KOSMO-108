Content type

```
✔ media-type(MIME type) 
✔ charset
✔ boundary

```

2022-04-15
---------------------------------

jsp 

1. 페이지 이동

```
	<jsp:forward
	<jsp:include
	<%@ include
	RequestDispacher.forward()
	response.sendRedirect()
	location.href
	history.go()
	<a href=""
```

2. 데이터 이동 

```
	request.getParameter();
	request.getAttribute(java.lang.String)
```

3. 파일 업로드 

```
	POST, multipart/form-data
form , method 
텍스트 : key=value&key=value : application/x-www-form-urlencoded
바이너리 : 파일데이터 : multipart/form-data
```


> **GET**

```
	application/x-www-form-urlencoded	: key=value
	multipart/form-data
```

> **POST**

```
	application/x-www-form-urlencoded	: key=value
	multipart/form-data	: 파일 업로드 할 때 
```  
