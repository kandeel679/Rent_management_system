import sqlite3
import uuid

DATABASE_PATH = "C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\Server\\RMS.db"
# DATABASE_PATH = "C:\\Users\\kandeel\\Desktop\\AAST\\term 3\\oop\\project\\Rent_management_system\\src\\Server\\RMS.db"

# Uncomment the following lines to delete all records from the user table
# conn = sqlite3.connect(DATABASE_PATH)
# cur = conn.cursor()
# cur.execute('''Drop TABLE Apartment''')
# conn.close()
# conn = sqlite3.connect(DATABASE_PATH)
# cur = conn.cursor()
# cur.execute('''Drop TABLE User''')
# conn.close()


# conn = sqlite3.connect(DATABASE_PATH)
# cur = conn.cursor()
# cur.execute('''DELETE FROM Apartment WHERE apartmentID = 8;''')
# conn.close()

def create_user_table():
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    cur.execute('''CREATE TABLE IF NOT EXISTS User (
                username TEXT PRIMARY KEY,
                password TEXT,
                email TEXT,
                balance Float,
                physical_add TEXT,
                phone_num TEXT,
                first_name TEXT,
                last_name TEXT,
                apartId INT,
                FOREIGN KEY (apartId) REFERENCES Apartment(apartmentID)
             )''')

    conn.commit()
    conn.close()
def create_Apartment_table():
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    cur.execute('''CREATE TABLE Apartment (
            apartmentID INT PRIMARY KEY,
            apartmentType TEXT,
            location VARCHAR(255),
            area DOUBLE,
            year INT,
            floor INT,
            apartmentOwnerUsername VARCHAR(255),
            rentamount DOUBLE,
            depositamount DOUBLE,
            PlacementDate DATE,
            istaken int,
            FOREIGN KEY (apartmentOwnerUsername) REFERENCES User(username)
            );'''
)

    conn.commit()
    conn.close()


#Apartment
def insertApart(apartmentID, apartmentType, location, area, year, floor,
                apartmentOwnerUsername, rentamount, depositamount, PlacementDate):
  
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    try:
        cur.execute('''
            INSERT INTO Apartment (
                apartmentID, apartmentType, location, area, year, floor,
                apartmentOwnerUsername, rentamount, depositamount, PlacementDate
            ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        ''', (
            apartmentID, apartmentType, location, area, year, floor,
            apartmentOwnerUsername, rentamount, depositamount, PlacementDate
        ))

        conn.commit()
        print("Apartment inserted successfully!")
    
    except Exception as e:
        print("Error:", e)
    
    finally:
        conn.close()
def remove_apartment_by_id(apartment_id):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()

    try:
        # Execute the DELETE statement
        cur.execute('''
            DELETE FROM Apartment
            WHERE apartmentID = ?;
        ''', (apartment_id,))

        # Commit the changes
        conn.commit()
        print(f"Apartment with ID {apartment_id} removed successfully.")

    except Exception as e:
        # Handle the exception (e.g., print an error message)
        print("Error:", e)

    finally:
        # Close the database connection
        conn.close()
def get_apartment_info_by_id(apartment_id):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()

    try:
        cur.execute('''
            SELECT * FROM Apartment
            WHERE apartmentID = ?;
        ''', (apartment_id,))

        result = cur.fetchone()

        if result:
            # res = ','.join(map(str, result))
            return list(result)
        else:
            print(f"No apartment found with ID {apartment_id}")
            return None

    except Exception as e:
        print("Error:", e)
        return None

    finally:
        conn.close()    
def get_all_apartments():
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()

    try:
        # Execute the SELECT statement to get all apartments
        cur.execute('''
            SELECT * FROM Apartment;
        ''')

        # Fetch all results
        results = cur.fetchall()

        if results:
            # Convert the results to a list of strings in the desired format
            columns = [column[0] for column in cur.description]
            apartments = ['_'.join(map(str, row)) for row in results]
            return apartments
        else:
            print("No apartments found in the database.")
            return None

    except Exception as e:
        # Handle the exception (e.g., print an error message)
        print("Error:", e)
        return None

    finally:
        # Close the database connection
        conn.close()
def getmaxaprtid():
    conn=sqlite3.connect(DATABASE_PATH)
    cur=conn.cursor()
    cur.execute('''SELECT max(apartmentID) from Apartment; ''')
    results = cur.fetchall()
    return results[0][0]+1
def setistaken(id):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    cur.execute('''
                UPDATE Apartment SET isTaken = 1 WHERE apartmentID = ?
                ''', (id,))  # Added a comma to create a tuple with a single element
    conn.commit()  # Corrected to call commit as a function
    conn.close()
def getistaken(id):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    cur.execute('''select isTaken from Apartment where apartmentID = ?''',(id,))
    
    res=cur.fetchone()    
    print(res[0])
    return res[0]
    conn.commit()  # Corrected to call commit as a function
    conn.close()
#User
def insert(username, password, email, balance, physical_add, phone_num, first_name, last_name):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()

    # Use INSERT OR REPLACE to insert a new user or replace an existing one
    cur.execute('''INSERT OR REPLACE INTO user (username, email, password, balance, physical_add, phone_num, first_name, last_name) 
                   VALUES (?, ?, ?, ?, ?, ?, ?, ?)''',
                (username, email, password, balance, physical_add, phone_num, first_name, last_name))


    conn.commit()
    conn.close()  
def CheckUser(username,password):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    cur.execute('''SELECT * FROM user WHERE username=? AND password=?''', (username, password))
    result = cur.fetchone()
    
    print(result)
    conn.commit()
    conn.close()
    return result
def update_balance(username, new_balance):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    try:

        update_sql = "UPDATE User SET balance = ? WHERE username = ?"

        cur.execute(update_sql, (new_balance, username))

        conn.commit()

        print(f"Balance for user {username} updated successfully.")

    except sqlite3.Error as e:
        print("SQLite error:", e)

    finally:
        conn.close()
def get_user_by_username(username):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    try:
        select_sql = '''SELECT * FROM User WHERE username = ?'''
        cur.execute(select_sql, (username,))

        user_data = cur.fetchone()
        print(user_data)
        if user_data:
            res = ','.join(map(str, user_data))
            return res
        else:
            print(f"No user found with username: {username}")
            return None

    except sqlite3.Error as e:
        print("SQLite error:", e)

    finally:
        if conn:
            conn.close()
def setApartIdbyusername(username,aprtId):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    
    #fix later 
    #   logical error  => landlord rent his own apratment 
    try:
        user_data = "UPDATE User SET apartId = ? WHERE username = ?"
        cur.execute(user_data, (aprtId, username))
        user_data = cur.fetchone()
        conn.commit()
    except sqlite3.Error as e:
        print("SQLite error:", e)

    finally:
        if conn:
            conn.close()
# create_user_table()
# create_Apartment_table()

# print(get_apartment_info_by_id(13))
# setApartIdbyusername("kandeel",10)

# setistaken(1)
# getistaken(1)
# Example usage

# print(getmaxaprtid())

# apartment_id_to_get_info = 1  # Replace with the actual ID you want to retrieve
# apartment_info = get_apartment_info_by_id(apartment_id_to_get_info)
# print(apartment_info)
# insertApart(1,"onebedroom","zahra2",400,2004,4,"kandeel",4000,5000,"2023-12-1")

# insert("kandeel", "joe123", "youssef@gmail.com", 0.0,"zahra2", "01066276067", " youssef", "kandeel")


    
# create_user_table()
    
    
    
    
    
