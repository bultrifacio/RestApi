# RestAPI

## Table of contents

* Introduction
* What does the project do?
* Prerequisites
* Getting Started
* Author


## Introduction

This RestAPI has been developed for Theam. The objective of the project is to manage customer data from a small shop.

## What does the project do?

* A user can only:
    + List all customers in the database.
    + Get full customer information, including a photo URL.
    + Create a new customer:
        + A customer should have at least name, surname, id and a photo field.
        + Name, surname and id are required fields.
        + Image uploads should be able to be managed.
        + The customer should have a reference to the user who created it.
        + Update an existing customer.
        + The customer should hold a reference to the last user who modified it.
        + Delete an existing customer.
+ An admin can also:
    + Manage users:
        + Create users.
        + Delete users.
        + Update users.
        + List users.
        + Change admin status. 

## Prerequisites

- Java 8
- Spring Boot 1.5.14
- H2 Database

## Getting Started

You need Java, and IDE like STS, Postman for test the API and Git.
First of all, clone the repository.
```
git clone https://github.com/bultrifacio/RestApi.git
cd RestApi
```
Then open the project with the IDE. You can see the directories of the src, they are distribuited in five packages, controllers, model, repositories, security and services. Also under the resources directory we have the data.sql with the sql for populate our database. In the development of this project I used several tutorials and guides, but the most important is this https://spring.io/guides/tutorials/bookmarks/ . You can use it for understand the code and improve it.

## Author

* **Juan Carlos Arroyo Herrera** - jcah20022@gmail.com - GitHub: **bultrifacio**
