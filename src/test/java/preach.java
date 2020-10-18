

public class preach <E>{
    public static  <T> void display(T obj){
        System.out.println(obj);
    }
    public preach(E e1){
        System.out.println("Hello you are in preach class : "+e1);
        System.out.println("Welcome to preach "+e1);
    }

     public static void main(String args[]){
        display(1);
        display("Hello");
        display(7.1456);
        display(true);
        display(23);
        preach p1=new preach(70);
        preach p2=new preach("Hello Universe");
        preach p3=new preach("Believe in Yourself , I can do it");
        preach p4=new preach("1,00,000");
        preach p5=new preach(25.5);
    }




}
