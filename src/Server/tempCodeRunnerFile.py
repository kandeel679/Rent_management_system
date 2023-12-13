


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

