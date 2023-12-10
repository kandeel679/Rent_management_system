from flask import Flask, request, jsonify
from flask_cors import CORS
import Database as db
from Machine_learning_model import Model
app = Flask(__name__)
CORS(app)


@app.route('/')
def home():
    return jsonify({"server":"on"})

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
