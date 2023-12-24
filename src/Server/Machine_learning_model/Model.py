import joblib

PC = 'C:\\Users\\youss\\OneDrive\\Desktop\\AAST\\term 3\\oop_project\\Rent_management_system\\src\\Server\\Machine_learning_model\\rentAmountmodel.joblib'
LAP ='C:\\Users\\kandeel\\Desktop\\AAST\\term 3\\oop\\project\\Rent_management_system\\src\\Server\\Machine_learning_model\\rentAmountmodel.joblib'
class MyModel:
    def __init__(self, model_path=PC):
        self.model = joblib.load(model_path)

    def predict(self, input_data):
        return self.model.predict(input_data)

my_model = MyModel()


def Rentprediction(year,area,floor):
    prediction = my_model.predict([[year,area,floor]])
    return prediction[0]*(0.5/100)
# print(Rentprediction(2019,1000,3))
