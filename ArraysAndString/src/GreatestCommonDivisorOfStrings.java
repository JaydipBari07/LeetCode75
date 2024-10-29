public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        StringBuilder res = new StringBuilder();
        int l1 = str1.length(), l2 = str2.length();
        int i = 0, j = 0;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        String gcd = null;
        String tempGcd = null;
        while (i < l1 && j < l2) {
            if (arr1[i] == arr2[j]) {
                if (i > 0 && arr1[i] == res.charAt(0)) {
                    tempGcd = res.toString();
                    if (!str1.replace(tempGcd, "").isEmpty()
                            || !str2.replace(tempGcd, "").isEmpty()) {
                        tempGcd = null;
                    }
                    gcd = tempGcd != null ? tempGcd : gcd;
                }
                res.append(arr1[i]);
                i += 1;
                j += 1;
            } else {
                break;
            }
        }
        tempGcd = res.toString();
        if (!str1.replace(tempGcd, "").isEmpty()
                || !str2.replace(tempGcd, "").isEmpty()) {
            tempGcd = null;
        }
        if (tempGcd != null) {
            gcd = tempGcd;
        }
        return gcd == null ? "" : gcd;
    }

    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }
}
