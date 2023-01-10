# Books in Library

This RESTful library API can perform various functions on Books that Exist/May exist in the Library.
This API performs CRUD operations on Book

# List of APIs
#### 1. Get List of All the books in Library
        /book/all
#### 2. Find book in library using book id
        /book/search/{bookId}
#### 3. Find book in library using book name
        /book/search/{bookName}
#### 4. Get List of All the books in Library with specific Issue Status
        /book/search/{bookStatus}
#### 5. Adds a Book to the Library
        /book/add
#### 6. Updates a Book information in the Library with provided BookRequest
        /book/update/{id}
#### 7. Deletes a Book information in the Library by Id
        /book/delete/{id}