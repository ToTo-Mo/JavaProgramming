package Example;


interface Car{
    public void showInfo();
}

class PassengerCar implements Car{

    private int seats;
    public PassengerCar(){seats = 2;}
    public PassengerCar(int n ){seats = n;}
    
    public int Seats(){return seats;}
    public void Seats(int value){seats = value;}
    
    @Override
    public void showInfo() {
        // TODO Auto-generated method stub
        System.out.println("좌석 수 : " + seats);
    }
}

interface ITruck extends Car{
    public int getPayload();
    public void setPayload(int w);
}

class Truck implements ITruck{
    private int payload;

    public Truck() { payload = 100;}

    @Override
    public void showInfo() {
        System.out.println("적재 하중 : " + payload);
    }

    @Override
    public int getPayload() {
        return payload;
    }

    @Override
    public void setPayload(int w) {
        payload = w;
    }
}

class Pickup extends PassengerCar implements ITruck{

    @Override
    public int getPayload() {
        return 0;   
    }

    @Override
    public void setPayload(int w) {
        // TODO Auto-generated method stub

    }
    
}