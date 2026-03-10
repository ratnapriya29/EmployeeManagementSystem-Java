# System Design

## Components

### 1. Employee Class
Stores employee attributes:
- ID
- Name
- Department
- Position
- Salary
- Join Date

### 2. EmployeeManagementSystem
Main controller of the application.  
Handles user interaction and CRUD operations.

### 3. EmployeeFileHandler
Responsible for saving and loading employee data from files.

### 4. EmployeeReportGenerator
Generates statistical reports such as salary analysis.

## Data Structures Used

ArrayList  
- Stores employee objects sequentially.

HashMap  
- Provides fast lookup of employees by ID.

## Exception Handling

The system handles:
- Invalid salary input
- Duplicate employee IDs
- File read/write errors