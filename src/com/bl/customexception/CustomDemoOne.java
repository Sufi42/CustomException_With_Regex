package com.bl.customexception;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvalidEmail extends Exception {
        public InvalidEmail(String str) {
            super(str);
        }

    }

    class InvalidMobileNo extends Exception {
        public InvalidMobileNo(String str) {
            super(str);

        }
    }


    public class CustomDemoOne {
        public static void main(String[] args) throws InvalidEmail, InvalidMobileNo {
            Scanner sc = new Scanner(System.in);

            String email = sc.next();
            String mobileNo = sc.next();
            String emailRegex = "^([a-zA-Z0-9-_+\\.]+)@([a-z0-9-]+)\\.([a-z]{2,8})(\\.[a-z]{2,7})?$";
            String mobileRegex = "^([0-9]{10})$";

            Pattern p = Pattern.compile(emailRegex);
            Matcher m = p.matcher(email);
            boolean b = m.matches();
            System.out.println(b);

            Pattern mobileNoCheck = Pattern.compile(mobileRegex);
            Matcher mobileC = mobileNoCheck.matcher(mobileNo);
            boolean l = mobileC.matches();
            System.out.println(l);

            if (b == false) {
                throw new InvalidEmail("Email is not correct");
            } else if (l == false) {
                throw new InvalidMobileNo("Mobile Number is Invalid");
            }
        }
    }

