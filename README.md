# FT TEKNOLOJI PRACTICIUM API

## Run the app

    ./mvnw spring-boot:run

# REST API

The REST API to the example app is described below.

## Post Requests

### Request

`POST /add-user/`
`name: String, surname: String, email: String, telephoneNumber:integer`

    {
      "name":"",
      "surname":"",
      "email":"",
      "telephoneNumber":
    }
    
### Request

`POST /add-product/`
`productName: String, expireDate: String(yyyy-mm-dd), telephoneNumber:integer`

    {
      "productName":"",
      "expireDate":"yyyy-mm-dd",
      "price":
    }
    
### Request

`POST /add-comment/`
`productComment: String, commentDate: String(yyyy-mm-dd), productId:integer, userId:integer`

    {
      "productComment":"",
      "commentDate":"yyyy-mm-dd",
      "productId":,
      "userId":
    }
 

## Get Requests

### Request

`GET /all-user/`

### Response

    [
        {
            "name": "",
            "surname": "",
            "email": "",
            "telephoneNumber": 
        }
    ]
    
### Request

`GET /all-product/`

### Response

    [
        {
            "productName": "",
            "expireDate": "yyyy-mm-dd",
            "price": 
        }
    ]
        
### Request

`GET /all-comment/`

### Response

    [
        {
            "productComment": "",
            "commentDate": "yyyy-mm-dd",
            "productId": ,
            "userId": 
        }
    ]
        
    
### Request

`GET /comment-by-date?productId=&startDate=&endDate=`
`productId: integer, startDate: yyyy-mm-dd`

### Response

    [
        {
            "productComment": "",
            "commentDate": "yyyy-mm-dd",
            "productId": ,
            "userId": 
        }
    ]
    
### Request

`GET /user-comment?userId=`
`userId: integer`

### Response

    [
        {
            "productComment": "",
            "commentDate": "yyyy-mm-dd",
            "productId": ,
            "userId": 
        }
    ]


### Request

`GET /user-comment-by-date?userId=&startDate=&endDate=`
`userId: integer, startDate: yyyy-mm-dd, endDate: yyyy-mm-dd`

### Response

    [
        {
            "productComment": "",
            "commentDate": "yyyy-mm-dd",
            "productId": ,
            "userId": 
        }
    ]
    
    
### Request

`GET /expired-product`

### Response

    [
        {
            "productComment": "",
            "commentDate": "yyyy-mm-dd",
            "productId": ,
            "userId": 
        }
    ]
    
    
### Request

`GET /unexpired-product`

### Response

    [
        {
            "productComment": "",
            "commentDate": "yyyy-mm-dd",
            "productId": ,
            "userId": 
        }
    ]
