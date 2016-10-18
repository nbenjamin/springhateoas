# springhateoas
This example provides a sample usage of spring hateaos with spring boot.

Currently has the following resource endpoints

[Get Account by accountId](http://localhost:8080/demo/accounts/100)
`http://localhost:8080/demo/accounts/100`
 Response
 ```json
 {
"id": 100,
"number": "289101",
"routingNumber": "987399399",
"type": "CHECKING",
"customer": {
  "id": 1,
  "firstName": "Ryan",
  "lastName": "Adam"
},
"_links": {
  "accounts": {
    "href": "http://localhost:8080/demo/accounts/100"
   },
  "customer": {
    "href": "http://localhost:8080/demo/customers/1"
   }
  }
}
```
[Get Customer by customerId](http://localhost:8080/demo/customers/1)
`http://localhost:8080/demo/customers/1`
Response
```json
{
"id": 1,
"firstName": "Ryan",
"lastName": "Adam",
"_links": {
  "customer": {
    "href": "http://localhost:8080/demo/customers/1"
  },
  "accounts": {
    "href": "http://localhost:8080/demo/accounts?customerId=1"
  }
}
}
```
 
###Build Information###
spring-hateoas (https://travis-ci.org/nbenjamin/springhateoas/builds)
