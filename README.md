# The Coupon_Management is a RESTful API for managing different types of discount on coupons ( product-wise,cart-wise,  Buy X Get Y) for an e-commerce platform. The system is built using Java, Spring Boot with MySQL Database.
# Features:
Types of Coupon-
1)ProductWise Coupons
2)CartWise Coupons
3)Buy X Get Y Coupons

# Operation with Coupon:
1)Create a new coupon
2)Get all coupns
3)Get coupon by id
4)Update coupons
5)Delete coupons

# Operation with Product:
1)Create a new product
2)Get all product
3)Get product by id
4)Update product
5)Delete product

# Technologies Used
1)Java : Java 1.8
2)Framework: Spring Boot
3)Database: MySQL (or H2 for development)
4)JPA : For ORM and database interaction
5)Maven: For dependency management and project build
6)IDE :Spring tool suit
7)API platform:Postman

# API Endpoints for coupon
1)POST /coupon/save_coupons – Create a new coupon
GET /coupon/get_allcoupons – Get all coupons
GET /coupon/getcoupon_ById/{id} – Get a specific coupon by ID
PUT /coupon/updatecoupons_ById/{id} – Update a coupon by ID
DELETE /coupon/delete_coupons/{id} – Delete a coupon by ID

# API Endpoints for Product
1)POST /product/save_products – Create a new product
GET /product/get_allproduct – Get all product
GET /product/get_product_Byid/{id} – Get a specific product by ID
PUT /product/update_product_Byid/{id} – Update a coupon by ID
DELETE /product/delete_product/{id} – Delete a coupon by ID

# Troubleshooting
Error: could not execute statement [Unknown column 'coupon_type' in 'field list']
Make sure your database schema is up to date with the correct column definitions (coupon_type should exist in the coupon table).

Error: Incorrect table definition; there can be only one auto column and it must be defined as a key
Ensure only the id column is auto-incrementing, and it is defined as the primary key.

Error:GenerationTarget encountered exception accepting command :  [Duplicate foreign key constraint name 'FK4dk3kwbu3jpiq1xxbmkasv9n3']

# Assumptions
The coupon types are defined as product-wise,cart-wise,  Buy X Get Y, and these types are extended through inheritance.
The database is assumed to be MySQL or H2 for development.
Coupons can be applied to both cart totals and individual products, with certain conditions (minimum purchase amount, usage limit).

# Limitations
The current implementation assumes basic coupon application logic (only one coupon can be applied at a time).
If buy 2 coupon of type X then you will get 1
Future improvements may include handling multiple coupon applications or more complex rules for applying coupons.

