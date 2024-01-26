# restful-web-services
This is a SpringBoot project.

## Authors

- [@BumbleBee2811](https://github.com/BumbleBee2811)


## Technologies Used
- Java
- SpringBoot
- JPA
- H2 database
## API Reference

#### Hello World Controller

```http
  GET /hello-world
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | `none` | Simple Hello World Controller which returns a string |

```http
  GET /hello-world-bean
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | `none` | Simple Hello World Controller which returns a json object |


```http
  GET /hello-world/path-variable/{name}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | Simple Hello World Controller which takes name as parameter and returns json object |

```http
  GET /hello-world-internationalized
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `none` | `none` | Simple Hello World Controller which uses internationalization to display good morning message in different languages |

#### Get item

```http
  GET /api/items/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### add(num1, num2)

Takes two numbers and returns the sum.

#### Hello World Controller

