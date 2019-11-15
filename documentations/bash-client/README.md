# User Model Project Bash client

## Overview
This is a Bash client script for accessing User Model Project service.

The script uses cURL underneath for making all REST calls.

## Usage

```shell
# Make sure the script has executable rights
$ chmod u+x 

# Print the list of operations available on the service
$ ./ -h

# Print the service description
$ ./ --about

# Print detailed information about specific operation
$ ./ <operationId> -h

# Make GET request
./ --host http://<hostname>:<port> --accept xml <operationId> <queryParam1>=<value1> <header_key1>:<header_value2>

# Make GET request using arbitrary curl options (must be passed before <operationId>) to an SSL service using username:password
 -k -sS --tlsv1.2 --host https://<hostname> -u <user>:<password> --accept xml <operationId> <queryParam1>=<value1> <header_key1>:<header_value2>

# Make POST request
$ echo '<body_content>' |  --host <hostname> --content-type json <operationId> -

# Make POST request with simple JSON content, e.g.:
# {
#   "key1": "value1",
#   "key2": "value2",
#   "key3": 23
# }
$ echo '<body_content>' |  --host <hostname> --content-type json <operationId> key1==value1 key2=value2 key3:=23 -

# Preview the cURL command without actually executing it
$  --host http://<hostname>:<port> --dry-run <operationid>

```

## Docker image
You can easily create a Docker image containing a preconfigured environment
for using the REST Bash client including working autocompletion and short
welcome message with basic instructions, using the generated Dockerfile:

```shell
docker build -t my-rest-client .
docker run -it my-rest-client
```

By default you will be logged into a Zsh environment which has much more
advanced auto completion, but you can switch to Bash, where basic autocompletion
is also available.

## Shell completion

### Bash
The generated bash-completion script can be either directly loaded to the current Bash session using:

```shell
source .bash-completion
```

Alternatively, the script can be copied to the `/etc/bash-completion.d` (or on OSX with Homebrew to `/usr/local/etc/bash-completion.d`):

```shell
sudo cp .bash-completion /etc/bash-completion.d/
```

#### OS X
On OSX you might need to install bash-completion using Homebrew:
```shell
brew install bash-completion
```
and add the following to the `~/.bashrc`:

```shell
if [ -f $(brew --prefix)/etc/bash_completion ]; then
  . $(brew --prefix)/etc/bash_completion
fi
```

### Zsh
In Zsh, the generated `_` Zsh completion file must be copied to one of the folders under `$FPATH` variable.


## Documentation for API Endpoints

All URIs are relative to **

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*AuthorControllerApi* | [**listAllAuthorsUsingGET**](docs/AuthorControllerApi.md#listallauthorsusingget) | **GET** /authors/authors | returns all Authors
*BookControllerApi* | [**listAllBooksUsingGET**](docs/BookControllerApi.md#listallbooksusingget) | **GET** /books/books | returns all Books
*DataControllerApi* | [**assignBookToAuthorUsingPOST**](docs/DataControllerApi.md#assignbooktoauthorusingpost) | **POST** /data/books/{bookid}/authors/{authorid} | Assign a book to an author
*DataControllerApi* | [**deleteBookByIdUsingDELETE**](docs/DataControllerApi.md#deletebookbyidusingdelete) | **DELETE** /data/books/{bookid} | Delete an existing book
*DataControllerApi* | [**updateBookUsingPUT**](docs/DataControllerApi.md#updatebookusingput) | **PUT** /data/books/{bookid} | Update an existing book
*DefaultApi* | [**userLogin**](docs/DefaultApi.md#userlogin) | **POST** /login | login
*LogoutEndpointApi* | [**logoutUsingGET**](docs/LogoutEndpointApi.md#logoutusingget) | **GET** /logout | logout
*LogoutEndpointApi* | [**logoutUsingGET1**](docs/LogoutEndpointApi.md#logoutusingget1) | **GET** /oauth/revoke-token | logout
*OpenEndpointApi* | [**addNewUserUsingPOST**](docs/OpenEndpointApi.md#addnewuserusingpost) | **POST** /createnewuser | addNewUser
*RolesEndpointsApi* | [**addNewRoleUsingPOST**](docs/RolesEndpointsApi.md#addnewroleusingpost) | **POST** /roles/role | addNewRole
*RolesEndpointsApi* | [**addNewRoleUsingPUT**](docs/RolesEndpointsApi.md#addnewroleusingput) | **PUT** /roles/role/{roleid} | addNewRole
*RolesEndpointsApi* | [**deleteRoleByIdUsingDELETE**](docs/RolesEndpointsApi.md#deleterolebyidusingdelete) | **DELETE** /roles/role/{id} | deleteRoleById
*RolesEndpointsApi* | [**getRoleByIdUsingGET**](docs/RolesEndpointsApi.md#getrolebyidusingget) | **GET** /roles/role/{roleId} | getRoleById
*RolesEndpointsApi* | [**getRoleByNameUsingGET**](docs/RolesEndpointsApi.md#getrolebynameusingget) | **GET** /roles/role/name/{roleName} | getRoleByName
*RolesEndpointsApi* | [**listRolesUsingGET**](docs/RolesEndpointsApi.md#listrolesusingget) | **GET** /roles/roles | listRoles
*UserEndpointsApi* | [**addNewUserUsingPOST1**](docs/UserEndpointsApi.md#addnewuserusingpost1) | **POST** /users/user | adds a user given in the request body
*UserEndpointsApi* | [**deleteUserByIdUsingDELETE**](docs/UserEndpointsApi.md#deleteuserbyidusingdelete) | **DELETE** /users/user/{id} | deleteUserById
*UserEndpointsApi* | [**deleteUserRoleByIdsUsingDELETE**](docs/UserEndpointsApi.md#deleteuserrolebyidsusingdelete) | **DELETE** /users/user/{userid}/role/{roleid} | deleteUserRoleByIds
*UserEndpointsApi* | [**getCurrentUserInfoUsingGET**](docs/UserEndpointsApi.md#getcurrentuserinfousingget) | **GET** /users/getuserinfo | getCurrentUserInfo
*UserEndpointsApi* | [**getCurrentUserNameUsingGET**](docs/UserEndpointsApi.md#getcurrentusernameusingget) | **GET** /users/getusername | getCurrentUserName
*UserEndpointsApi* | [**getNumUserEmailsUsingGET**](docs/UserEndpointsApi.md#getnumuseremailsusingget) | **GET** /users/user/email/count | getNumUserEmails
*UserEndpointsApi* | [**getUserByIdUsingGET**](docs/UserEndpointsApi.md#getuserbyidusingget) | **GET** /users/user/{userId} | Retrieve a user based of off user id
*UserEndpointsApi* | [**getUserByNameUsingGET**](docs/UserEndpointsApi.md#getuserbynameusingget) | **GET** /users/user/name/{userName} | returns the user based off of user name
*UserEndpointsApi* | [**getUserLikeNameUsingGET**](docs/UserEndpointsApi.md#getuserlikenameusingget) | **GET** /users/user/name/like/{userName} | returns all Users whose name contains the given substring with paging and sorting
*UserEndpointsApi* | [**listAllUsersUsingGET**](docs/UserEndpointsApi.md#listallusersusingget) | **GET** /users/users | returns all Users with paging and sorting
*UserEndpointsApi* | [**postUserRoleByIdsUsingPOST**](docs/UserEndpointsApi.md#postuserrolebyidsusingpost) | **POST** /users/user/{userid}/role/{roleid} | postUserRoleByIds
*UserEndpointsApi* | [**reallyListAllUsersUsingGET**](docs/UserEndpointsApi.md#reallylistallusersusingget) | **GET** /users/allusers | returns all Users without paging or sorting
*UserEndpointsApi* | [**updateUserUsingPUT**](docs/UserEndpointsApi.md#updateuserusingput) | **PUT** /users/user/{id} | updateUser
*UseremailEndpointsApi* | [**deleteUserEmailByIdUsingDELETE**](docs/UseremailEndpointsApi.md#deleteuseremailbyidusingdelete) | **DELETE** /useremails/useremail/{useremailid} | deleteUserEmailById
*UseremailEndpointsApi* | [**findUseremailByUserNameUsingGET**](docs/UseremailEndpointsApi.md#finduseremailbyusernameusingget) | **GET** /useremails/username/{userName} | findUseremailByUserName
*UseremailEndpointsApi* | [**getUserEmailByIdUsingGET**](docs/UseremailEndpointsApi.md#getuseremailbyidusingget) | **GET** /useremails/useremail/{useremailId} | getUserEmailById
*UseremailEndpointsApi* | [**listAllUseremailsUsingGET**](docs/UseremailEndpointsApi.md#listalluseremailsusingget) | **GET** /useremails/useremails | listAllUseremails
*UseremailEndpointsApi* | [**updateUserEmailUsingPUT**](docs/UseremailEndpointsApi.md#updateuseremailusingput) | **PUT** /useremails/useremail/{useremailid}/email/{emailaddress} | updateUserEmail


## Documentation For Models

 - [Author](docs/Author.md)
 - [Book](docs/Book.md)
 - [ErrorDetail](docs/ErrorDetail.md)
 - [Role](docs/Role.md)
 - [Section](docs/Section.md)
 - [TokenModel](docs/TokenModel.md)
 - [User](docs/User.md)
 - [UserMinimum](docs/UserMinimum.md)
 - [Useremail](docs/Useremail.md)
 - [Userroles](docs/Userroles.md)
 - [ValidationError](docs/ValidationError.md)
 - [Wrote](docs/Wrote.md)


## Documentation For Authorization

 All endpoints do not require authorization.

