
from flask import Flask, request, jsonify
from flask_cors import CORS
import joblib
import Database as db
from Machine_learning_model import Model
app = Flask(__name__)
CORS(app)


@app.route('/')
def home():
    return jsonify({"server":"on"})



#user
@app.route('/register', methods=["POST"])
def register():
    data = request.get_json()
    print("Received JSON data:", data)

    username = data.get('username')
    email = data.get('email')
    password = data.get('password')
    balance = data.get('balance')
    physical_add = data.get('physical_add')
    phone_num = data.get('phone_num')
    first_name = data.get('first_name')
    last_name = data.get('last_name')
    db.insert(username=username, password=password, email=email, balance=balance,
              physical_add=physical_add, phone_num=phone_num, first_name=first_name, last_name=last_name)

    return jsonify({'status': 200, 'message': data})

@app.route('/signin', methods=["POST"])
def signin():


    data = request.get_json()
    print("Received JSON data:", data)

    username = data.get('username')
    password = data.get('password')
    user_exists = db.CheckUser(username, password)
    print(user_exists)

    return jsonify({'':user_exists })

@app.route('/updatebalance',methods=["POST"])
def updatebalance():
    data = request.get_json()
    db.update_balance(data.get("username"),float(data.get("new_balance")))
    return jsonify({"status": "success", "message": "Apartment added successfully"})

@app.route('/getapartments',methods = ["GET"])
def getapartmetns():
    apartments = db.get_all_apartments()
    print(apartments)
    return jsonify({'':apartments})

@app.route('/getLandlordByusername' , methods = ["POST"])
def getLandlordByusername():
    data = request.get_json()
    res=db.get_user_by_username(data.get("username"))
    print(res)
    return jsonify({'':res}) 
    
    
#apartment
@app.route('/addapartment', methods=["POST"])
def add_apartment():
    try:
        data = request.get_json()
        apartmentID = data.get('apartmentID')
        apartmentType = data.get('apartmentType')
        location = data.get('location')
        area = data.get('area')
        year = data.get('year')
        floor = data.get('floor')
        apartmentOwnerUsername = data.get('apartmentOwnerUsername')
        rentamount = data.get('rentamount')
        depositamount = data.get('depositamount')
        PlacementDate = data.get('PlacementDate')
        db.insertApart(
            apartmentID, apartmentType, location, area, year, floor,
            apartmentOwnerUsername, rentamount, depositamount, PlacementDate
        )

        response = {"status": "success", "message": "Apartment added successfully"}
        return jsonify(response)

    except Exception as e:
        print("Error:", e)
        response = {"status": "error", "message": "Failed to add apartment"}
        return jsonify(response)

@app.route('/getmaxapratid',methods = ["GET"])
def getmaxapratid():
    newid=db.getmaxaprtid()
    return({'':newid})



#ai model
@app.route('/rent',methods = ["POST"])
def rent():
    data = request.get_json()
    print("Received JSON data:", data)
    year = int(data.get('year'))
    area = float(data.get('area'))
    floor = int(data.get('floor'))
    res = Model.Rentprediction(year,area,floor)
    return jsonify({'':res})




if __name__ == '__main__':
    app.run(debug=True)
