import java.util.*; 
class b2bv2
{
    static String toDecimal (int n, String x)
    {
        double fv = 0;
        int xn;
        char dc;
        if(x.indexOf('.') < 0)
        {
            for (int i = x.length() - 1; i > -1; i--)
            {
                dc = x.charAt(i);
                if (Character.isLetter(dc))
                xn = dc - 55;
                else
                xn = dc - 48;
                fv += xn * (int)Math.pow(n,x.length()-1-i);
            }
        }
        else
        {
            int ip = x.indexOf('.');
            for (int i = ip - 1; i > -1; i--)
            {
                dc = x.charAt(i);
                if (Character.isLetter(dc))
                xn = dc - 55;
                else
                xn = dc - 48;
                fv += xn * (int)Math.pow(n,ip-1-i);
            }
            for (int i = ip + 1; i < x.length(); i++)
            {
                dc = x.charAt(i);
                if (Character.isLetter(dc))
                xn = dc - 55;
                else
                xn = dc - 48;
                fv += xn * Math.pow(n,ip-i);
            }
        }
        return String.valueOf(fv);
    }
    static String fromDecimal (int n, String x)
    {
        String fv = "";   
        int pi = (int)Double.parseDouble(x);
        int in;
        while (pi > 0)
        {
            in = pi % n;
            if (in < 10)
            fv = Integer.toString(in) + fv;
            else
            fv = (char)(in + 55) + fv;
            pi = (pi - in) / n;
        }
        int dn;
        if(x.indexOf('.') > -1)
        {
            fv += ".";
            double pd = Double.parseDouble(x) - (int)Double.parseDouble(x);
            int dC = 0;
            while (pd != 0 && dC < 1)
            {
                pd *= n;
                dn = (int)pd;
                if (dn < 10)
                fv += Integer.toString(dn);
                else
                fv += (char)(dn + 55);
                pd -= (int)pd;
                dC++;
            }
        }
        return fv;
    }
    public static void main (String[] args)
    {
        Scanner sc = new Scanner (System.in);
        System.out.println("[NOTE: Bases need to be natural numbers below 37.]");
        System.out.print("Enter Input Base: ");
        int ni = sc.nextInt();
        System.out.print("Enter Number: ");
        String x = sc.next();
        System.out.print("Enter Output Base: ");
        int no = sc.nextInt();
        sc.close();
        if (ni != no)
        if (ni > 0 && ni < 37 && no > 0 && no < 37)
        System.out.print("Result: " + fromDecimal(no,toDecimal(ni,x)));
        else
        System.out.println("Invalid Output Base!");
        else
        System.out.println("\n Input Base and Output Base canxt be the same.");
    }
}