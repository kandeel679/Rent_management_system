import sqlite3
import uuid
DATABASE_PATH = "C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\Server\\RMS.db"
# DATABASE_PATH = "C:\\Users\\kandeel\\Desktop\\AAST\\term 3\\oop\\project\\Rent_management_system\\src\\Server\\RMS.db"

# Uncomment the following lines to delete all records from the user table
# conn = sqlite3.connect(DATABASE_PATH)
# cur = conn.cursor()
# cur.execute('''Drop TABLE user''')
# conn.close()


# conn = sqlite3.connect(DATABASE_PATH)
# cur = conn.cursor()
# cur.execute('''DELETE FROM user;''')
# conn.close()

def create_user_table():
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    cur.execute('''CREATE TABLE IF NOT EXISTS user (
                username TEXT PRIMARY KEY,
                password TEXT,
                email TEXT,
                balance Float,
                physical_add TEXT,
                phone_num TEXT,
                first_name TEXT,
                last_name TEXT
             )''')

    conn.commit()
    conn.close()


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

    




# insert("ahmed", "1234", "youssef@adf.com", 0.0, "asdf", "01066276067", " kandeel", "youssef")


    
# create_user_table()
    
    
    
    
    
