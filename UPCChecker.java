

public class UPCChecker implements IUPCChecker{


    /**
     * Checks if the given UPC number is a valid UPC number( 13 digits, uses the math as  follows:
     * digits in even positions are added and then mutlipiled by 3. Then take the digits in odd positions
     * and add those up and the sum of that is added to the above number which has been multipled by 3.
     * then we divide that number by 10 to get the remainder and then subtract the remainder by 10 to validate
     * using the check digit( last digit in the code);
     * @param upc the UPC number to validate
     * @return true is the number if a valid UPC number is given, otherwise returns false.
     */
    @Override
    public boolean check(String upc) {
        if(upc.length() == 13) {

            int convert = 0;
            String str = "0";
            int sum = 0;
            int count = 0;

            for (int i = 0; i <= upc.length() - 1; i++) // loops through the upc of string type.
            {
                str = upc.substring(i, i + 1); // uses substring to get each character.
                convert = Integer.parseInt(str); // then the variable above is parsed to become an int.

                if (count == 1) // enter if count is one
                {
                    sum += convert; // adding all the digits in the even position
                    count--; // this count variable is used to get the alternate digit positions.

                } else {
                    count++;
                }
            }


            int sum_multiplied = sum * 3;
            int count2 = 0;
            int sum2 = 0;
            int convert2 = 0;
            int last_odd_digit = 0;
            for (int i = 0; i <= upc.length() - 1; i++) // loops through the upc of string type.
            {
                str = upc.substring(i, i + 1); // uses substring to get each character.
                convert2 = Integer.parseInt(str); // then the variable above is parsed to become an int.

                if (i == upc.length() - 1) last_odd_digit++; // this is to leave out the last digit as the
                // last digit is the check digit.

                if (last_odd_digit == 0) { // incremented the last_odd_digit so it won't enter this loop
                    // therefore being left out.

                    if (count2 == 0) // enter if count2 is zero
                    {

                        sum2 += convert2; // adding all the digits in the odd position
                        count2++; // this count2 variable is used to get the alternate digit positions.

                    } else {
                        count2--;
                    }
                }
            }


            int sum_of_sums = sum_multiplied + sum2;


            int remainder = sum_of_sums % 10;

            if (remainder > 0) {
                int subtract = 10 - remainder;
                System.out.println(subtract);
                return true;
            }
        }


        return false;
    }
}
