import java.util.*; 
class base_to_base
{ 
    static String toDecimal (int n, String x)
    {
        double fV = 0;
        long dN;
        char dC;
        String rS = (x.indexOf('.') < 0)? x + ".0" : x;
        int iP = rS.indexOf('.');
        for (int i = iP - 1; i > -1; i--)
        {
            dC = rS.charAt(i);
            dN = (Character.isLetter(dC))? (Character.isUpperCase(dC))? dC - 55 : dC - 61 : dC - 48;
            fV += dN * (long)Math.pow(n,iP-1-i);
        }
        for (int i = iP + 1; i < rS.length(); i++)
        {
            dC = rS.charAt(i);
            dN = (Character.isLetter(dC))? (Character.isUpperCase(dC))? dC - 55 : dC - 61 : dC - 48;
            fV += dN * Math.pow(n,iP-i);
        }
        return (x.indexOf('.') < 0)? String.valueOf((long)fV) : String.valueOf(fV);
    }
    static String fromDecimal (int n, String x)
    {
        String fV = "";   
        long pI = (long)Double.parseDouble(x), iN;
        while (pI > 0)
        {
            iN = pI % n;
            fV = (iN < 10)? Long.toString(iN) + fV : (iN < 36)? (char)(iN + 55) + fV : (char)(iN + 61) + fV;
            pI = (pI - iN) / n;
        }
        int dN;
        if(x.indexOf('.') > -1)
        {
            fV += ".";
            double pD = Double.parseDouble(x) - (long)Double.parseDouble(x);
            int D = 0;
            while (pD != 0 && D < 5)
            {
                pD *= n;
                dN = (int)pD;
                fV =  (dN < 10)? fV + Long.toString(dN) : (dN < 36)? fV + (char)(dN + 55) : fV + (char)(dN + 61);
                pD -= (int)pD;
                D++;
            }
        }
        return fV;
    }
    public static void main (String[] args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("[NOTE: Bases need to be natural numbers below 63.]");
        System.out.print("Enter Input Base: ");
        int nI = sc.nextInt();
        System.out.print("Enter Number: ");
        String x = sc.next();
        System.out.print("Enter Output Base: ");
        int nO = sc.nextInt();
        sc.close();
        System.out.println((nI > 0 && nI < 63 && nO > 0 && nO < 63)? (nI != nO)? "Result: " + fromDecimal(nO,toDecimal(nI,x)) : "\n Input Base and Output Base cannot be the same." : "Invalid Output Base!");
    }
}