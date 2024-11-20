-- Users table (for all user types)
CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Email VARCHAR(255) UNIQUE NOT NULL,
    PasswordHash VARCHAR(255) NOT NULL,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    PhoneNumber VARCHAR(20),
    UserType ENUM('Customer', 'Barber', 'Manager', 'Admin') NOT NULL,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Shops table
CREATE TABLE Shops (
    ShopID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Address VARCHAR(255) NOT NULL,
    PhoneNumber VARCHAR(20),
    Email VARCHAR(255),
    ManagerID INT,
    FOREIGN KEY (ManagerID) REFERENCES Users(UserID)
);

-- Barbers table
CREATE TABLE Barbers (
    BarberID INT PRIMARY KEY,
    ShopID INT,
    Specialties TEXT,
    YearsOfExperience INT,
    FOREIGN KEY (BarberID) REFERENCES Users(UserID),
    FOREIGN KEY (ShopID) REFERENCES Shops(ShopID)
);

-- Services table
CREATE TABLE Services (
    ServiceID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Description TEXT,
    Duration INT NOT NULL, -- in minutes
    Price DECIMAL(10, 2) NOT NULL
);

-- Appointments table
CREATE TABLE Appointments (
    AppointmentID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    BarberID INT,
    ServiceID INT,
    ShopID INT,
    AppointmentDateTime DATETIME NOT NULL,
    Status ENUM('Scheduled', 'Completed', 'Cancelled') DEFAULT 'Scheduled',
    FOREIGN KEY (CustomerID) REFERENCES Users(UserID),
    FOREIGN KEY (BarberID) REFERENCES Barbers(BarberID),
    FOREIGN KEY (ServiceID) REFERENCES Services(ServiceID),
    FOREIGN KEY (ShopID) REFERENCES Shops(ShopID)
);

-- Reviews table
CREATE TABLE Reviews (
    ReviewID INT PRIMARY KEY AUTO_INCREMENT,
    AppointmentID INT,
    Rating INT CHECK (Rating BETWEEN 1 AND 5),
    Comment TEXT,
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (AppointmentID) REFERENCES Appointments(AppointmentID)
);

-- BarberSchedule table
CREATE TABLE BarberSchedule (
    ScheduleID INT PRIMARY KEY AUTO_INCREMENT,
    BarberID INT,
    DayOfWeek INT CHECK (DayOfWeek BETWEEN 0 AND 6),
    StartTime TIME,
    EndTime TIME,
    FOREIGN KEY (BarberID) REFERENCES Barbers(BarberID)
);

-- Inventory table
CREATE TABLE Inventory (
    ItemID INT PRIMARY KEY AUTO_INCREMENT,
    ShopID INT,
    Name VARCHAR(100) NOT NULL,
    Description TEXT,
    Quantity INT NOT NULL,
    ReorderThreshold INT,
    FOREIGN KEY (ShopID) REFERENCES Shops(ShopID)
);

-- Create indexes for frequently accessed columns
CREATE INDEX idx_appointments_datetime ON Appointments(AppointmentDateTime);
CREATE INDEX idx_users_email ON Users(Email);
CREATE INDEX idx_barbers_shop ON Barbers(ShopID);
