# DataControllerApi

All URIs are relative to **

Method | HTTP request | Description
------------- | ------------- | -------------
[**assignBookToAuthorUsingPOST**](DataControllerApi.md#assignBookToAuthorUsingPOST) | **POST** /data/books/{bookid}/authors/{authorid} | Assign a book to an author
[**deleteBookByIdUsingDELETE**](DataControllerApi.md#deleteBookByIdUsingDELETE) | **DELETE** /data/books/{bookid} | Delete an existing book
[**updateBookUsingPUT**](DataControllerApi.md#updateBookUsingPUT) | **PUT** /data/books/{bookid} | Update an existing book


## **assignBookToAuthorUsingPOST**

Assign a book to an author

### Example
```bash
 assignBookToAuthorUsingPOST authorid=value bookid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorid** | **integer** | authorid |
 **bookid** | **integer** | bookid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **deleteBookByIdUsingDELETE**

Delete an existing book

### Example
```bash
 deleteBookByIdUsingDELETE bookid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bookid** | **integer** | bookid |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not Applicable
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

## **updateBookUsingPUT**

Update an existing book

### Example
```bash
 updateBookUsingPUT bookid=value
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **bookid** | **integer** | bookid |
 **updateBook** | [**Book**](Book.md) | updateBook |

### Return type

**map**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

