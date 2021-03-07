# Challenge #2: Bootiful Calculator

## Usage

### Prerequisites

- JDK
- git
- Apache Maven

### Getting Started

- Clone the project.
- Build by using `mvn clean package`
- Run the application by using command `java -jar target/bootiful-calculator.jar`
- or `mvn clean spring-boot:run` to directly run the application without building.

## Endpoints

### *Calculate*
- **Method**: Post
- **Endpoint**: /bootiful-calculator/calculate

Request:

field | type | description |
------|------|-------------|
values| Array\<Number\> | A list of numbers, can be whole or decimal. |
operation | String | The operation to perform, possible values are: **add**, **sub**, **mul**, **div**. |
type | String | The type of the expected result, possible values are: **integer**, **decimal**, **safe**.  |
  
Example:
```json
POST /calculate
{
  "values": [2,5,81],
  "operation": "add",
  "type": "integer"
}
```

Response:
```json
HTTP 200
{
  "result": 88
}
```

or

```json
HTTP 400
{
  "error": "error reason"
}
```
