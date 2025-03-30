public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
    
    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        
        ComplexNumber num = (ComplexNumber) anObject;
        return Double.compare(re, num.re) == 0 && Double.compare(im, num.im) == 0; 
    }

    @Override
    public int hashCode() {
        int res = Double.hashCode(re) * 31;
        res = res + Double.hashCode(im);
        return res;
    }

    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(1.4242, 2.3737);
        ComplexNumber num2 = new ComplexNumber(1.4242,2.3737);
        ComplexNumber num3 = new ComplexNumber(1.4342,56.789);
        System.out.println("equals num1 & num2 true // " + num1.equals(num2));
        System.out.println("equals num2 & num1 true // " + num2.equals(num1));
        System.out.println("equals num2 & num3 false // " + num2.equals(num3));
        System.out.println("equals num3 & num1 false // " + num3.equals(num1));
        System.out.println("hash num1 & num2 true // " + (num1.hashCode() == num2.hashCode()));
        System.out.println("hash num2 & num1 true // " + (num2.hashCode() == num1.hashCode()));
        System.out.println("hash num3 & num1 false // " + (num3.hashCode() == num1.hashCode()));
        System.out.println("hash num3 & num2 false // " + (num3.hashCode() == num2.hashCode()));
    }
}