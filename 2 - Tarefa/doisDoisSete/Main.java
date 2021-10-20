
public class Main {
    public static void main(String[] args) {
        DuasPilhaDif pilhas = new DuasPilhaDif(10);

        pilhas.push1(1);
        pilhas.push1(2);
        pilhas.push1(3);
        pilhas.push1(4);
        pilhas.push1(5);

        pilhas.push2(6);
        pilhas.push2(7);
        pilhas.push2(8);
        pilhas.push2(9);


        pilhas.push2(10);
        pilhas.push2(10);

        pilhas.pop1();
        pilhas.pop2();


    }
}
