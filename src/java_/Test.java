package java_;


public class Test {
    public static void main(String[] args) {
        // testperson p = new testperson("ali", "ali@gmail.com", "321", "aly", "bsko", "bostan", 200.2, "010666666");
        // Register r = new Register(p);
        // r.sendData();
    //     Signin s = new Signin("ali", "321");
    //     testperson p1 = s.SIGN_IN();
    //     System.out.println(p1);
            RentPredictionModel r = new RentPredictionModel(600,2017,2);
            r.Predict();
    }
}
