import joblib
import pandas as ps
import numpy as np
import matplotlib.pyplot as plt
from sklearn import linear_model


df = ps.read_csv("Daegu_Real_Estate_data.csv")
# plt.scatter(df["SalePrice"],df[['YearBuilt']])
# plt.show()
reg = linear_model.LinearRegression()
reg.fit(df[['YearBuilt',"Size(sqf)","Floor"]],df['SalePrice'])

# x = reg.predict([[2006,600,4]])
# print(x[0])
joblib.dump(reg, 'rentAmountmodel.joblib')
