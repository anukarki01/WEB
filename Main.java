class db{
    int counter = 0;
    void increment(){

        counter++;
    }
    void display(){

        System.out.println("counter:"+ counter);
    }
}

class client extends Thread{
   // db d = new db();
    db d;
    client (db d){
        this.d = d;
    }
    public void run(){
        for(int i = 0; i < 100000; i++){

            d.increment();
        }
    }
}

public class Main{

    public static void main(String[] args){
        db d = new db();
        client c = new client(d);
        client c1 = new client(d);
        client c2 = new client(d);
        client c3 = new client(d);
        client c4 = new client(d);
        c.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        try{
            c.join();
            c1.join();
            c2.join();
            c3.join();
            c4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        d.display();


    }
}