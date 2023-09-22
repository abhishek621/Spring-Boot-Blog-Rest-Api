# Spring-Boot-Blog-Rest-Api
A Simple Spring Boot Rest Api Created for Blog website

TodoController : 

GET
/api/todos/{id}

PUT
/api/todos/{id}

DELETE
/api/todos/{id}

PUT
/api/todos/{id}/unComplete

PUT
/api/todos/{id}/complete

GET
/api/todos

POST
/api/todos

TagController : 

GET
/api/tags/{id}

PUT
/api/tags/{id}

DELETE
/api/tags/{id}

GET
/api/tags

POST
/api/tags

CommentController : 

GET
/api/posts/{postId}/comments/{id}

PUT
/api/posts/{postId}/comments/{id}

DELETE
/api/posts/{postId}/comments/{id}

GET
/api/posts/{postId}/comments

POST
/api/posts/{postId}/comments

PostController : 

GET
/api/posts/{id}

PUT
/api/posts/{id}

DELETE
/api/posts/{id}

GET
/api/posts

POST
/api/posts

GET
/api/posts/tag/{id}

GET
/api/posts/category/{id}

PhotoController : 

GET
/api/photos/{id}

PUT
/api/photos/{id}

DELETE
/api/photos/{id}

GET
/api/photos

POST
/api/photos

CategoryController : 

GET
/api/categories/{id}

PUT
/api/categories/{id}

DELETE
/api/categories/{id}

GET
/api/categories

POST
/api/categories

AlbumController : 

GET
/api/albums/{id}

PUT
/api/albums/{id}

DELETE
/api/albums/{id}

GET
/api/albums

POST
/api/albums

GET
/api/albums/{id}/photos

UserController : 

GET
/api/users/{username}/posts

GET
/api/users/{username}/albums
