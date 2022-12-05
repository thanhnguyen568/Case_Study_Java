package validate.regex;

public interface CustomizeRegex {
    String REGEX_CODE_VILLA = "SVVL-[0-9]{4}";
    String REGEX_CODE_HOUSE = "SVHO-[0-9]{4}";
    String REGEX_CODE_ROOM = "SVRO-[0-9]{4}";
    String REGEX_NAME_SERVICE = "^Villa|House|Room";
    String REGEX_RENTAL_TYPE = "Hour|Day|Month|Year";
    String REGEX_ROOM_STAND = "^[A-Z][a-z]*$";
    String REGEX_FREE_SERVICE = "[A-Z][a-z]+(\\s[A-Z][a-z]+)*$";

    String REGEX_BIRTH_DAY = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
    String REGEX_NAME = "^[A-Z][a-z]+(\\s[A-Z][a-z]*)*$";
    String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    String REGEX_GENDER = "Male|Female|Unknown";
    String REGEX_PHONE = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
    String REGEX_LEVEL = "Intermediate|College|University|AfterUniversity";
    String REGEX_POSITION = "Receptionist|Staff|Experts|Monitoring|Manage|Director";
    String REGEX_CUSTOMER_TYPE = "Member|Silver|Gold|Platinum|Diamond";
}
