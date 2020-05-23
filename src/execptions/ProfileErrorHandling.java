package execptions;


import DatabaseConnection.DBUserQueries;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class ProfileErrorHandling {

    private DBUserQueries userQueries;

    public ProfileErrorHandling() {


    }


    public boolean mobileNumberIsNotNumbers(String mobileNumber) {
        boolean mobileError = false;
        if (mobileNumber.length() >= 10) {
            char firstElement = mobileNumber.charAt(0);
            char secondElement = mobileNumber.charAt(1);
            char thirdElement = mobileNumber.charAt(2);
            char fourthElement = mobileNumber.charAt(3);

            if (mobileNumber.length() == 13) {
                if (firstElement == '0' && secondElement == '0' && thirdElement == '4' && fourthElement == '6') {
                    mobileError = false;
                }
            } else if (mobileNumber.length() == 10) {
                if (firstElement == '0' && secondElement == '7') {
                    mobileError = false;
                }
            } else {
                mobileError = true;
            }
        } else {
            mobileError = true;
        }
        return mobileError;
    }

    public boolean passwordLength(String password) {
        boolean passwordError = false;
        if (password.length() < 8) {
            passwordError = true;
        }
        return passwordError;
    }

    public boolean cvcChecker(String cvc) {
        boolean cvcMessage = false;
        if (cvc.length() != 3)
            cvcMessage = true;
        return cvcMessage;
    }

    public boolean cardNumberChecker(String cardNumber) {
        boolean cardNumberChecker = false;
        if (cardNumber.length() != 16)
            cardNumberChecker = true;
        return cardNumberChecker;
    }

    public boolean comboBoxes(ComboBox box) {
        if (box.getSelectionModel().isEmpty())
            return true;
        return false;
    }

    public boolean datePChecker(DatePicker date) {
        if (date.getValue() == null)
            return true;
        return false;
    }

}


