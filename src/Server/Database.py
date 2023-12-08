import sqlite3
import uuid
DATABASE_PATH = "C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\Server\\RMS.db"

# Uncomment the following lines to delete all records from the user table
# conn = sqlite3.connect(DATABASE_PATH)
# cur = conn.cursor()
# cur.execute('''DELETE FROM user''')
# conn.close()

def create_user_table():
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()

    # Creating the user table with id as the primary key
    cur.execute('''CREATE TABLE IF NOT EXISTS user (
                username TEXT,
                password TEXT,
                email TEXT
             )''')

    conn.commit()
    conn.close()


def insert(username,password,email):
    conn = sqlite3.connect(DATABASE_PATH)
    cur = conn.cursor()
    cur.execute('''INSERT OR IGNORE INTO user (username, email, password) VALUES (?,  ?, ?)''', (username, email, password))
    conn.commit()
    conn.close()


    

    
    
    
    
    
    
# delete_user_by_email("youssifk000@gmail.com")

# Create the user table if it doesn't exist
# delete()
# create_user_table()
