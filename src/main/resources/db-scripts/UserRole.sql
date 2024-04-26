-- Step 1: Create the user
CREATE USER mr WITH PASSWORD 'Abc@123';

-- Step 2: Create the database
CREATE DATABASE ecommerce;

-- Step 3: Grant privileges to the user
GRANT ALL PRIVILEGES ON DATABASE ecommerce TO mr;
