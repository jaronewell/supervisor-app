# supervisor-app

App runs on localhost:8081 with Java 11

Can be tested in local using the following endpoints

GET localhost:8081/api/supervisors

POST localhost:8081/api/submit

Sample Body:
{
    "firstName": "Tom",
    "lastName": "Gregory",
    "email": "tomgregory@gmail.com",
    "phoneNumber": "123-456-7890",
    "supervisor": 
    {
        "id": "5",
        "phone": "(964) 512-1445",
        "jurisdiction": "8",
        "identificationNumber": "93fd04ee-655a-47c2-832b-d83056d29e1e",
        "firstName": "Kieran",
        "lastName": "Torphy"
    }
}
