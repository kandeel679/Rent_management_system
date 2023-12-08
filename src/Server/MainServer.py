from flask import Flask, request, jsonify
from flask_cors import CORS
import Database as db

app = Flask(__name__)
CORS(app)


@app.route('/')
def home():
    return jsonify({"server":"on"})

@app.route('/register',methods = ["POST"])
def register():
    data = request.get_json()
    username = data.get('username')
    email = data.get('email')
    password = data.get('password')
    res = db.insert(username,password,email)
    
    return jsonify({'status': 200, 'message': 'User registered successfully'})


if __name__ == '__main__':
    app.run(debug=True)
