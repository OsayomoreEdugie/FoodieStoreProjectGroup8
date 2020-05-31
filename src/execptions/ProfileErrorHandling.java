package execptions;


import DatabaseConnection.DBUserQueries;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class ProfileErrorHandling {

    private DBUserQueries userQueries;

    public ProfileErrorHandling() {


    }


    public boolean mobileNumber(String mobile) {
        boolean mobileError = false;
        if (mobile.length() >= 10) {
            char first = mobile.charAt(0);
            char second = mobile.charAt(1);
            char third = mobile.charAt(2);
            char fourth = mobile.charAt(3);

            if (mobile.length() == 13) {
                if (first == '0' && second == '0' && third == '4' && fourth == '6') {
                    mobileError = false;
                }
            } else if (mobile.length() == 10) {
                if (first == '0' && second == '7') {
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


