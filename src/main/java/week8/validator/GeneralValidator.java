package week8.validator;

public class GeneralValidator {

    public boolean isValidEmail(String email) {
        return email != null && email.contains("gmail");
    }

    public boolean isValidPass(String pass) {
        return pass != null && pass.length() > 7;
    }
}
