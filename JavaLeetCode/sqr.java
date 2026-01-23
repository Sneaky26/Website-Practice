public class sqr {
    public static void main(String[] args) {
        int sqr = 400;
int formula = sqr;

while (formula * formula != sqr){
    formula = (formula + sqr / formula) / 2; // Newton-Raphson style
}

System.out.println(formula);
    }
}
